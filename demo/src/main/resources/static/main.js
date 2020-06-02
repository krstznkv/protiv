var app = angular.module("TicketManagement", []);
app.controller("TicketController", function ($scope, $http) {


    $scope.tickets = [];
    $scope.requestForm = {
        from: "",
        to: "",
        date: "",
        adult: 0,
        children: 0,
        ret_date: ""
    };

    //HTTP POST/PUT methods for add/edit employee
    // Call: http://localhost:8080/employee
    $scope.submitTicket = function () {

        var method = "";
        var url = "";

        method = "POST";
        url = '/ticket/find';


        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.requestForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function (res) { // success
                $scope.tickets = res.data;
            },
            function (res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            });
    };
});

