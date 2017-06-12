/**
 * Created by Sony on 10-Jun-17.
 */
var myChart;
var myChartConfig;
var ctx;
var charType='pie';
window.onload = function() {
    ctx = document.getElementById("myChart").getContext('2d');
    var url = 'http://localhost:9999/donations/sumByFundation';
    var xhttp = new XMLHttpRequest();
    xhttp.addEventListener("load", function () {
        var ourData = JSON.parse(xhttp.responseText);
        myChartConfig = {
            type: charType,
            data: {
                labels: ourData.map(mapFundations),
                datasets: [{
                    label: 'Amount of $',
                    data: ourData.map(mapDonation),
                    backgroundColor: [
                        "#2d5fdb",
                        "#a6273f",
                        "#5db64d",
                        "#f1c40f",
                        "#e75628",
                        "#15dbdc",
                        "#dc3b3a",
                        "#dc35a5",
                        "#864ddc",
                        "#5e70dc",
                        "#025e39",
                        "#d3373a",
                        "#dc0a00"
                    ],

                    borderWidth: 2
                }]
            },
            options: {
                cutoutPercentage: 20,
                responsive: true,
                title: {
                    display: true,
                    position: "top",
                    text: "Top donations (in $)",
                    fontSize: 20,
                    fontStyle: "bold",
                    fontColor: "#dad4d1"
                },
                legend: {
                    display: true,
                    position: 'top',
                    labels: {
                        fontColor: "#dad4d1"
                    }
                }
            }

        }

        myChart = new Chart(ctx, myChartConfig);
    });
    xhttp.open("GET", url, true);
    xhttp.send();
}

function mapFundations(data){
    return data[0]
}

function mapDonation(data){
    return Math.round(data[1])
}

function getSelectValue()
{
    var selectedValue=document.getElementById("sel2").value;
    charType = selectedValue;
    console.log(charType);
    if (charType == 'pie' ) location.reload(false);
        else updateChart();
}

function updateChart(){
    myChart.destroy();
    ctx = document.getElementById("myChart").getContext('2d');
    myChartConfig.type=charType;
    myChart = new Chart(ctx, myChartConfig);
}

function saveFunction(){
    var selected=$('#sel3 :selected').val();
    var dType = "chart."+ selected;
    $("#myChart").get(0).toBlob(function(blob) {
        saveAs(blob, dType);
    });
}
