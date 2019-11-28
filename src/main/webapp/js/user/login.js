$(function () {
    $(".login").click(function () {
        var userName = document.getElementById("userName");
        var userPwd = document.getElementById("userPwd");
        var oError = document.getElementById("error_box");
        var isError=true;
        if (userName.value.length > 20 || userName.value.length < 6) {
            oError.innerHTML = "用户名请输入6-20位字符";
            isError = false;
            return;
        } else if ((userName.value.charCodeAt(0) >= 48) && (userName.value.charCodeAt(0) <= 57)) {
            oError.innerHTML = "首字符必须为字母";
            isError = false;
            return;
        } else
            for (var i = 0; i < userName.value.charCodeAt(i); i++) {
                if ((userName.value.charCodeAt(i) < 48) || (userName.value.charCodeAt(i) > 57) && (userName.value.charCodeAt(i) < 97) || (userName.value.charCodeAt(i) > 122)) {
                    oError.innerHTML = "必须为字母跟数字组成";
                    isError = false;
                    return;
                }
            }
        if (userPwd.value.length > 20 || userPwd.value.length < 6) {
            oError.innerHTML = "密码请输入6-20位字符";
            isError = false;
            return;
        }
        if (isError) {
            $.ajax({
                
            })
        }


    });

});