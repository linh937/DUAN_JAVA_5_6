// Lấy phần tử loader có class là "loader"
const loader = document.querySelector('.loader');


// Thiết lập sự kiện "load" trên window object
window.addEventListener('load', () => {
	// Thêm class "loading" vào phần tử body 
	document.body.classList.add('loading');
	// Sau 2000ms (2 giây), ẩn phần tử loader đi
	setTimeout(() => {
		loader.style.display = 'none';
	}, 5000);
});

