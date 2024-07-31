
// Lấy thẻ của thông báo
const notification = document.querySelector('.notification');

// Cho thông báo xuất hiện trong vòng 5 giây
setTimeout(() => {
	// Thêm class 'hidden' để ẩn thông báo
	notification.classList.add("hidden");
}, 5000);