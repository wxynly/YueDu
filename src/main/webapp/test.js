// $(function() {
//     alert("hello");
//     var URL = "/test";
//     $("#test").click(function () {
//         alert("hello");
//         $.ajax({
//             url: URL,
//             async: false,
//             cache: false,
//             type: "post",
//             dataType: 'json',
//             data:{
//             },
//             success: function (data) {
//                 if (data.success){
//                     alert("ok");
//                 }else{
//                     alert("error");
//                 }
//
//             }
//         });
//
//     });
//
//
// });

$(document).ready(function(){


    alert("hello");
    var addCarURL = "/test";
    $("#test").click(function () {
        alert("hello");
        $.ajax({
            url: addCarURL,
            async: false,
            cache: false,
            type: "post",
            dataType: 'json',
            data:{
            },
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