$(function(){


    alert("hello");
    var URL = "/test/testJs";
    $("#test").click(function () {
        // alert("hello");
        $.ajax({
            url: URL,
            async: false,
            cache: false,
            type: "post",
            dataType: 'json',
            success: function (data) {
                if (data.success){
                    alert("ok");
                }else{
                    alert("error");
                }

            }
        });

    });
});