$(document).ready(function(){
    $("select").change(function(){
        switch($("select").val()){        
            case "isl":
                $("#book_img").attr("src", 'Island-caruso-st-john-marcus-taylor-cover-2-1024x663.jpg');
                break;

            case "one":
                $("#book_img").attr("src", '9780811870191.jpg');
                break;

            case "":
                $("#book_img").attr("src", '');
                break;
        }
    })

    $("#tradebutton").on("click", function(){
        window.location = './feed.html';
    })
})