// ViewModel KnockOut
var vm = function () {
    console.log('ViewModel initiated...');
    //---Variáveis locais
    var self = this;
    self.TitlesSearch = ko.observable(); 
    self.titleSearch = ko.observable('');
    self.baseUri = ko.observable('http://192.168.160.58/netflix/api/Series');
    self.displayName = 'Series';
    self.error = ko.observable('');
    self.passingMessage = ko.observable('');
    self.records = ko.observableArray([]);
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
            self.records(data.Titles);
            self.currentPage(data.CurrentPage);
            self.hasNext(data.HasNext);
            self.hasPrevious(data.HasPrevious);
            self.pagesize(data.PageSize)
            self.totalPages(data.TotalPages);
            self.totalRecords(data.TotalTitles);
            $("#footer").removeClass('d-none');
            
        });
    };
    $('#search').keyup(function(){
        value = $("#search").val();
        if (value.length >= 2){
            $('#searchbtn').attr('disabled', false);  
        }
        else {
            $('#searchbtn').attr('disabled', true);  
        }
    });

    self.search = function(){
        console.log(self.titleSearch());
        $.ajax({
            url: 'http://192.168.160.58/netflix/api/Search/Series?name=' + self.titleSearch(),
            type: 'GET',
            dataType: 'json',

            success: function(data){
                if (data.length == 0){
                    self.records([]);
                    $("#NoResults").html("Sorry... we don't have that series!" + "<i style='padding-left:2%' class='fa fa-frown-o fa-2x' aria-hidden='true'></i>");
                    $("#NoResults").removeClass("d-none");
                    $("#reset").removeClass("d-none");
                }

                else{
                self.records(data);
                $("#NoResults").addClass("d-none");
                console.log("He added")
                $(".pagination").addClass("d-none");
                $("#span1").addClass("d-none");
                $("#span2").addClass("d-none");
                $("#reset").removeClass("d-none");
                self.TitlesSearch(self.records().length);
                $("#total_search").removeClass("d-none");
                }
            },

            error: function(){
                console.log("Error has occured");
            }
        });  
    }

    self.reset = function(){
        console.log("Resetting Search...")
        self.titleSearch('');
        $(".pagination").removeClass("d-none");
        $("#span1").removeClass("d-none");
        $("#span2").removeClass("d-none");
        $("#reset").addClass("d-none");
        $("#total_search").addClass("d-none");
        $('#searchbtn').attr('disabled', true);
        $("#NoResults").addClass("d-none");
        var page = getUrlParameter('page')
        if (page == undefined){
            self.activate(1);
        }
        else {
            self.activate(page)
        }
        
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
});