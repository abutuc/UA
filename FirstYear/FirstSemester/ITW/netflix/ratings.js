// ViewModel KnockOut
var vm = function () {
    console.log('ViewModel initiated...');
    //---Variáveis locais
    var self = this;
    self.RatingsSearch = ko.observable();
    self.searchResults = ko.observableArray([]);
    self.ratings = ko.observableArray([]);
    self.ratingSearch = ko.observable();
    self.baseUri = ko.observable('http://192.168.160.58/netflix/api/Ratings');
    self.displayName = ko.observable('Ratings');
    self.error = ko.observable('');
    self.passingMessage = ko.observable('');
    self.records = ko.observableArray([]);
    self.totalRecords = ko.computed(function(){
        return self.records().length
    });
    self.hasPrevious = ko.observable(false);
    self.hasNext = ko.observable(false);
    //--- Page Events
    self.activate = function () {
        console.log('CALL: getTitle...');
        ajaxHelper(self.baseUri(), 'GET').done(function (data) {
            console.log(data);
            self.records(data);
            for (var i = 0; i < self.records().length; i++){
                self.ratings().push(self.records()[i]['Code']);
            }
            $("#footer").removeClass('d-none');
            $("#categories1").removeClass('d-none');
            
        });
    };
    $( "#search" ).autocomplete({
        source: self.ratings()
      });

    self.search = function(){
        console.log(self.ratingSearch());
        for (var i = 0; i < self.records().length; i++){
            if (self.records()[i]['Code'].toLowerCase().includes(self.ratingSearch().toLowerCase())){
                self.searchResults().push(self.records()[i]);
            }
        }
        if (self.searchResults().length != 0){
            self.records(self.searchResults());
            $("#reset").removeClass("d-none");
            $(".ui-helper-hidden-accessible").addClass("d-none");
        }
        else {
            self.records([]);
            $("#NoResults").html("Sorry... we don't have that rating!" + "<i style='padding-left:2%' class='fa fa-frown-o fa-2x' aria-hidden='true'></i>");
            $("#NoResults").removeClass("d-none");
            $("#reset").removeClass("d-none");
            $(".ui-helper-hidden-accessible").addClass("d-none");
        }
    }

    self.reset = function(){
        console.log("Resetting Search...")
        self.ratingSearch('');
        $("#reset").addClass("d-none");
        $("#NoResults").addClass("d-none");
        $("#footer").addClass('d-none');
        $(".ui-helper-hidden-accessible").addClass("d-none");
        self.activate(1);  
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
