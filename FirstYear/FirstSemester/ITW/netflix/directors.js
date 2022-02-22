// ViewModel KnockOut
var vm = function () {
    console.log('ViewModel initiated...');
    //---Variáveis locais
    var self = this;
    self.baseUri = ko.observable('http://192.168.160.58/netflix/api/Directors');
    self.displayName = 'Directors';
    self.error = ko.observable('');
    self.passingMessage = ko.observable('');
    self.records = ko.observableArray([]);
    self.descriptions = ko.observableArray([]);
    var urls = [];
    self.currentPage = ko.observable(1);
    self.pagesize = ko.observable(20);
    self.totalRecords = ko.observable(50);
    self.hasPrevious = ko.observable(false);
    self.hasNext = ko.observable(false);
    self.previousPage = ko.computed(function () {
        return self.currentPage() * 1 - 1;
    }, self);
    self.nextPage = ko.computed(function () {
        return self.currentPage() * 1 + 1;
    }, self);
    self.fromRecord = ko.computed(function () {
        return self.previousPage() * self.pagesize() + 1;
    }, self);
    self.toRecord = ko.computed(function () {
        return Math.min(self.currentPage() * self.pagesize(), self.totalRecords());
    }, self);
    self.totalPages = ko.observable(0);
    self.pageArray = function () {
        var list = [];
        var size = Math.min(self.totalPages(), 9);
        var step;
        if (size < 9 || self.currentPage() === 1)
            step = 0;
        else if (self.currentPage() >= self.totalPages() - 4)
            step = self.totalPages() - 9;
        else
            step = Math.max(self.currentPage() - 5, 0);

        for (var i = 1; i <= size; i++)
            list.push(i + step);
        return list;
    };
    //--- Page Events
    self.activate = function (id) {
        console.log('CALL: getTitle...');
        var composedUri = self.baseUri() + "?page=" + id + "&pageSize=" + self.pagesize();
        ajaxHelper(composedUri, 'GET').done(function (data) {
            console.log(data);
            self.records(data.Directors);
            self.currentPage(data.CurrentPage);
            self.hasNext(data.HasNext);
            self.hasPrevious(data.HasPrevious);
            self.pagesize(data.PageSize)
            self.totalPages(data.TotalPages);
            self.totalRecords(data.TotalDirectors);
            $("#footer").removeClass('d-none');
        });
        console.log('It got here');
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
    ko.applyBindings(new vm());

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
            url: 'http://192.168.160.58/netflix/api/Search/Directors?name=' + input.toString(),
            type: 'GET',
            dataType: 'json',

            success: function(data){
                let result = data.map(a => a.Name);
                let ids = data.map(a => a.Id);
                console.log(result);
                console.log(ids);
                $("#categories1").addClass('d-none');
                string = '';
                if (result.length != 0){
                    for (var i = 0; i < result.length; i++){
                        string += "<a href='./directorDetails.html?id="+ ids[i] + "'>" + result[i] + '</a>' + '<br>';
                    }
                }
                    else {
                        string = "<h5>Sorry...we don't have the Director you searched for <i style='padding-left:2%' class='fa fa-frown-o fa-2x' aria-hidden='true'></i></h5>";
                    }
                $('#ModalLabel').text(result.length +"  Directors Searched");
                $('#DirectorsSearched').html(string);
                $('#SearchModal').modal('show');
                $("#footer").addClass("d-none");
                $('#Close').on('click', function(){
                    $("#categories1").removeClass('d-none');
                    $("#footer").removeClass("d-none");
                })
                $('#close').on('click', function(){
                    $("#categories1").removeClass('d-none'); 
                    $("#footer").removeClass("d-none");
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
