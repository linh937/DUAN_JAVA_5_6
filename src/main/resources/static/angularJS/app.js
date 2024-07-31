const app = angular.module("shopping-cart", []);

app.run(function($http, $rootScope) {
    $http.get(`/rest/security/authentication`).then(resp => {
        if (resp.data) {
            $auth = $rootScope.$auth = resp.data;
            console.log(resp.data)
            console.log($auth.token)
            console.log($auth.user.fullname)
            $http.defaults.headers.common["Authorization"] = $auth.token;

        }
    });
})

// var getAccountApiURL = 'http://localhost:8080/api/account';
// app.run(function($http, $rootScope) {
//     $http.get(getAccountApiURL)
//         .then(function(response) {
//             auth = $scope.account = response.data;
//         })
//         .catch(function(error) {
//             console.error('Error fetching account:', error);
//         });
// });


app.controller("shopping-cart-ctrl", function($scope, $http, $rootScope) {
    // QUAN LY GIO HANG
    $scope.cart = {
        items: [],
        add(id) {
            // alert(id)
            // them sp vao gio hang
            var item = this.items.find(item => item.id == id);
            if (item) {
                item.qty++;
                this.saveToLocalStorage();
            } else {
                $http.get(`/rest/products/${id}`).then(resp => {
                    resp.data.qty = 1;
                    this.items.push(resp.data);
                    this.saveToLocalStorage();
                })
            }
            swal("Thành Công!", "Đã thêm vào giỏ hàng!", "success");
        },
        remove(id) {
            // xoa sp trong gio hang (cho 1 sp)
            // alert(id)
            var index = this.items.findIndex(item => item.product_id == id);
            this.items.splice(index, 1);
            this.saveToLocalStorage();
            swal("Thành Công!", "Xóa sản phẩm thành công!", "success");
        },
        clear() {
            // xoa tat ca sp trong gio hang (cho tat ca)
            this.items = []
            this.saveToLocalStorage();
        },
        get count() {
            // tinh tong so luong co trong gio hang
            return this.items
                .map(item => item.qty)
                .reduce((total, qty) => total += qty, 0);
        },
        get amount() {
            // tong tien tat ca sp trong gio hang
            return this.items
                .map(item => item.product_price * item.qty) // tinh tong cua 1 sp
                .reduce((total, qty) => total += qty, 0);
        },
        saveToLocalStorage() {
            // luu gio hang vao local
            var json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart", json);
        },
        loadFromLocalStorage() {
            // lay va doc du lieu tu local
            var json = localStorage.getItem("cart");
            this.items = json ? JSON.parse(json) : [];
        }
    }

    $scope.cart.loadFromLocalStorage();

    // QUAN LY DON HANG
    $scope.order = {
        // entity order
        orders_id: null,
        fullname: "",
        email: "",
        phone: "",
        orders_time: new Date(),
        orders_address: "",
        voucher: null,
        status: null,

        get orderDetails() {
            return $scope.cart.items.map(item => {
                return {

                    product: { product_id: item.product_id },
                    quantity: item.qty,
                    price: item.product_price

                }
            });
        },

        purchase() {
            var order = angular.copy(this);

            $http.post("/rest/orders", order).then(resp => {
                swal("Thành Công!", "Thanh Toán Thành Công!", "success");
                $scope.cart.clear();

                location.href = "/order/detail/" + resp.data.orders_id;

            }).catch(error => {
                swal("Thất Bại!", "Thanh Toán Thất Bại!", "warring");
                console.log(error)
            })
        }
    }
})