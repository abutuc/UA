// ViewModel KnockOut
var vm = function () {
    console.log('ViewModel initiated...');
    //---Variáveis locais
    var self = this;
    self.baseUri = ko.observable('http://192.168.160.58/netflix/api/Ratings/');
    self.error = ko.observable('');
    self.passingMessage = ko.observable('');
    //--- Data Record
    self.id = ko.observable(getUrlParameter('id'));
    self.TotalTitles = ko.observable(getUrlParameter('titles'));
    self.name = ko.observable('');
    self.description = ko.observable('');
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
            self.name(data.Code);
            self.description(data.Description);
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
});
