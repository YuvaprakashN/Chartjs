var ChartHelperClass = (function() {

    var getRandomColor = function() {
        var letters = '0123456789ABCDEF';
        var color = '#';
        for (var i = 0; i < 6; i++) {
            color += letters[Math.floor(Math.random() * 16)];
        }
        return color;
    }

    var loadGraph = function() {
        console.log("loadGraph");
        $.ajax({
            type: 'GET',
            url: '/barChart',
            dataType: 'json',

            success: function(data) {
                console.log("success: " + data);
                var barColors = [];
                for (let i = 1; i <= data.labels.length; i++) {
                    barColors[i - 1] = getRandomColor();
                }
                new Chart("barChart", {
                    type: "bar",
                    data: {
                        labels: data.labels,
                        datasets: [{
                            backgroundColor: barColors,
                            data: data.values
                        }]
                    },
                    options: {
                        legend: {
                            display: false
                        },
                        title: {
                            display: true,
                            text: "New Joiners count - bar chart"
                        }
                    }
                });


                 new Chart("pieChart", {
                                    type: "pie",
                                    data: {
                                        labels: data.labels,
                                        datasets: [{
                                            backgroundColor: barColors,
                                            data: data.values
                                        }]
                                    },
                                    options: {
                                        legend: {
                                            display: true,
                                        },
                                        title: {
                                            display: true,
                                            text: "New Joiners count - pie chart"
                                        },

                                    }
                                });
            },
            error: function(ex) {
                alert('Failed to retrieve data.' + ex);
            }
        });
    };
    var eventsInitilization = function() {


    };




    return {
        Load: function() {
            loadGraph();
        },

    }
})();




$(document).ready(function() {
    console.log("ready");
    ChartHelperClass.Load();
});