// ViewModel KnockOut
var vm = function () {
    console.log('ViewModel initiated...');
    //---Variáveis locais
    var self = this;
    self.baseUri = ko.observable('http://192.168.160.58/netflix/api/titles/');
    self.error = ko.observable('');
    self.passingMessage = ko.observable('');
    //--- Data Record
    self.actors = ko.observableArray('');
    self.categories = ko.observableArray('');
    self.categories_string = ko.observable();
    self.countries = ko.observableArray('');
    self.dateAdded = ko.observable('');
    self.description = ko.observable('');
    self.directors = ko.observableArray('');
    self.duration = ko.observable('');
    self.id = ko.observable('');
    self.name = ko.observable('');
    self.rating = ko.observable('');
    self.rating_description = ko.observable('');
    self.releaseYear = ko.observable('');
    self.type = ko.observable('');
    //--- Page Events
    self.activate = function (id) {
        console.log('CALL: getTitle...');
        var composedUri = self.baseUri() + id;
        ajaxHelper(composedUri, 'GET').done(function (data) {
            console.log(data);
            self.actors(data.Actors);
            self.categories(data.Categories);
            self.categories_string(self.categories()[0]["Name"]);
            self.countries(data.Countries);
            self.dateAdded(data.DateAdded);
            self.description(data.Description);
            self.directors(data.Directors);
            self.id(data.Id);
            self.name(data.Name);
            self.rating(data.Rating);
            self.releaseYear(data.ReleaseYear);
            self.type(data.Type);
            $("#categories1").removeClass('d-none');
            $("#footer").removeClass("d-none");
            if (self.type()['Name'] == "Movie"){
                var hours = parseInt((parseInt(data.Duration) / 60))
                var minutes = parseFloat(data.Duration) % 60
                if (hours == 0){
                    self.duration(minutes.toString() + 'm');
                }
                else {
                    self.duration(hours.toString() + 'h' + minutes.toString() + 'm');
                }
            }
            else {
                self.duration(data.Duration);
            }
            var rating_url = 'http://192.168.160.58/netflix/api/Ratings/' + self.rating()['Id'] + '?page=1&pagesize=0';
            ajaxHelper(rating_url, 'GET').done(function(data){
                self.rating_description(data.Description);
                $('#tooltip').attr('title', self.rating_description());
            })
            console.log(rating_url);
        });
    }
    //--- Internal functions
    function ajaxHelper(uri, method, data) {
        self.error(''); // Clear error message
        return $.ajax({
            type: method,
            url: uri,
            dataType: 'json',
            contentType: 'application/json',
            data: data ? JSON.stringify(data) : null,
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("AJAX Call[" + uri + "] Fail...");
                self.error(errorThrown);
            }
        });

    }
    function getUrlParameter(sParam) {
        var sPageURL = window.location.search.substring(1),
            sURLVariables = sPageURL.split('&'),
            sParameterName,
            i;

        for (i = 0; i < sURLVariables.length; i++) {
            sParameterName = sURLVariables[i].split('=');

            if (sParameterName[0] === sParam) {
                return sParameterName[1] === undefined ? true : decodeURIComponent(sParameterName[1]);
            }
        }
    };
    //--- start ....
    var pg = getUrlParameter('id');
    console.log(pg);
    if (pg == undefined)
        self.activate(1);
    else {
        self.activate(pg);
    }
};

$(document).ready(function () {
    console.log("ready!");
    ko.applyBindings(new vm(), document.getElementById("htmlTop"));

    var typingTimer;                //timer identifier
    var doneTypingInterval = 1000;  //time in ms, 1.5 second for example
    var $input = $('#myInput');

    //on keyup, start the countdown
    $input.on('keyup', function () {
    clearTimeout(typingTimer);
    typingTimer = setTimeout(doneTyping, doneTypingInterval);
    });

    //on keydown, clear the countdown 
    $input.on('keydown', function () {
    clearTimeout(typingTimer);
    });

    //user is "finished typing," do something
    function doneTyping () {
        var input = $('#myInput').val();
        console.log(input);
        $.ajax({
            url: 'http://192.168.160.58/netflix/api/Search/Titles?name=' + input.toString(),
            type: 'GET',
            dataType: 'json',

            success: function(data){
                let result = data.map(a => a.Name);
                let ids = data.map(a => a.Id);
                console.log(result);
                console.log(ids);
                $("#categories1").addClass('d-none');
                $("#footer").addClass('d-none');
                string = '';
                if (result.length != 0){
                    for (var i = 0; i < result.length; i++){
                        string += "<a href='./titleDetails.html?id="+ ids[i] + "'>" + result[i] + '</a>' + '<br>';
                    }
                }
                    else {
                        string = "<h5>Sorry...we don't have the Title you searched for <i style='padding-left:2%' class='fa fa-frown-o fa-2x' aria-hidden='true'></i></h5>";
                    }
                $('#ModalLabel').text(result.length +"  Titles Searched");
                $('#TitlesSearched').html(string);
                $('#SearchModal').modal('show');
                $('#Close').on('click', function(){
                    $("#categories1").removeClass('d-none');
                    $("#footer").removeClass('d-none'); 
                })
                $('#close').on('click', function(){
                    $("#categories1").removeClass('d-none');
                    $("#footer").removeClass('d-none'); 
                })

                
            },
            error: function(){
                console.log("Error in database.");
            }
        });
        };

        $(window).keydown(function(event){
            if(event.keyCode == 13) {
              event.preventDefault();
              return false;
            }
      });
});
