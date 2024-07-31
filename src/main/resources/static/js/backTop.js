$(document).ready(function() {

    $(window).scroll(function() {
        if ($(this).scrollTop() > 100) { // cuộn trang quá 100px
            $('#totop').fadeIn(); // nút back top hiện ra nếu vượt quá 100px 
        } else {
            $('#totop').fadeOut(); // ngược lại
        }
    });

    // quay lại vị đầu trang
    $('#totop').click(function() {
        $('html, body').animate({
            scrollTop: 0
        }, 800);
        return false;
    });

});