$(document).ready(function(){
    $("#goAddBook").on("click", function(){
        $("#addedbook").removeClass("d-none");
        window.location = "./depositarLivro2.html";
    })
})