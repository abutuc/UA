$(document).ready(function () {
    var time = 2000;
    for (var i=1; i<7; i++){
        $("#div"+i).fadeIn(time);
    }
    $.ajax({
        url: 'http://192.168.160.58/netflix/api/Statistics',
        type: 'GET',
        dataType: 'json',

        success: function (data) {
            var totalTitles = data.Titles;
            console.log(totalTitles);
            var totalActors = data.Actors;
            console.log(totalActors);
            var totalCategories = data.Categories;
            console.log(totalCategories);
            var totalCountries = data.Countries;
            console.log(totalCountries);
            var totalDirectors = data.Directors;
            console.log(totalDirectors);
            $('#TotalTitles').html(totalTitles);
            $('#TotalActors').html(totalActors);
            $('#TotalCategories').html(totalCategories);
            $('#TotalCountries').html(totalCountries);
            $('#TotalDirectors').html(totalDirectors)

        },
        error: function () {
            console.log("Error in database.");
        }
    });


    $("#div1").on("click", function(){
        $.ajax({
            url: 'http://192.168.160.58/netflix/api/TitleTypes',
            type: 'GET',
            dataType: 'json',

            success: function(data){
                var Movies = data[0].Titles;
                var Series = data[1].Titles;
                $("#div1").css("padding-top", "0");
                $("#div1").html("<p style='font-size: 0.9em; margin-bottom: 0'>"+ Movies +"</p><p style='font-size: 0.9em; margin-bottom: 0'>Movies</p><hr style='margin:0;height:2px;border-width:0;color:gray;background-color:lightgreen'><p style='font-size: 0.9em; margin-bottom: 0'>" + Series + "</p><p style='font-size: 0.9em; margin-bottom: 0'>Series</p>");

            }
        })
    })
});