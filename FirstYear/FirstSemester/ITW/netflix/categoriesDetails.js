// ViewModel KnockOut
var vm = function () {
    console.log('ViewModel initiated...');
    //---Variáveis locais
    var self = this;
    self.baseUri = ko.observable('http://192.168.160.58/netflix/api/Categories/');
    self.displayName = 'Category Details';
    self.error = ko.observable('');
    self.passingMessage = ko.observable('');
    //--- Data Record
    self.id = ko.observable(getUrlParameter('id'));
    self.TotalTitles = ko.observable(getUrlParameter('titles'));
    self.name = ko.observable('');
    self.records = ko.observableArray('')
    self.pageSize = ko.observable(20)
    self.nextPage = ko.computed(function(){
        return getUrlParameter('page') * 1 + 1
    });
    self.previousPage = ko.computed(function(){
        return getUrlParameter('page') * 1 - 1
    });
    self.lastPage = ko.computed(function(){
        return Math.ceil(self.TotalTitles() / self.pageSize())
    })
    //--- Page Events
    self.activate = function (page) {
        console.log('CALL: getTitle...');
        var composedUri = self.baseUri() + self.id() +'?page=' + page + '&pagesize=' + self.pageSize();
        ajaxHelper(composedUri, 'GET').done(function (data) {
            console.log(data);
            self.name(data.Name);
            self.records(data.Titles);
            $("#categories1").removeClass("d-none");
            $("#footer").removeClass("d-none");
        });
    };
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
    var pg = getUrlParameter('page');
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
            url: 'http://192.168.160.58/netflix/api/Search/Categories?name=' + input.toString(),
            type: 'GET',
            dataType: 'json',

            success: function(data){
                let result = data.map(a => a.Name);
                let ids = data.map(a => a.Id);
                let titles = data.map(a => a.Titles);
                console.log(result);
                console.log(ids);
                $("#categories1").addClass('d-none');
                $("#footer").addClass('d-none');
                string = '';
                if (result.length != 0){
                    for (var i = 0; i < result.length; i++){
                        string += "<a href='./categoryDetails.html?id="+ ids[i] + "&page=1&pagesize=20&titles=" + titles[i]  + "'>" + result[i] + '</a>' + '<br>';
                    }
                }
                    else {
                        string = "<h5>Sorry...we don't have the Category you searched for <i style='padding-left:2%' class='fa fa-frown-o fa-2x' aria-hidden='true'></i></h5>";
                    }
                $('#ModalLabel').text(result.length +"  Categories Searched");
                $('#CategoriesSearched').html(string);
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
