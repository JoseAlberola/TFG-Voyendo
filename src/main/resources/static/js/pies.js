// var colorsPie = ["#0062cc", "#00d690", "#ffc700", "#ff2d00", "#00c5ff"]
var colorsPie = ["#003D80", "#0062cc", "#306DAF", "#609ddf", "#BFD8F2"]

var dataPieGender = [{
    values: [numeroHombres, numeroMujeres],
    labels: ['Hombres', 'Mujeres'],
    type: 'pie',
    marker: {
        colors: [colorsPie[0], colorsPie[1]]
    }
}];

var layoutPieGender = {
    title: {
        text: 'Clientes por género',
        size: 18,
    },
    legend: {
        x: 0.5,
        xanchor: "center",
        y: 0,
        orientation: "h",
    }
};
Plotly.newPlot('pieGender', dataPieGender, layoutPieGender, {responsive: true});

var dataPieAge = [{
    values: [totalClientesMenores25, totalClientesEntre26y45, totalClientesEntre46y65, totalclientesMayores65],
    labels: ['Menores 25', 'Entre 26-45', 'Entre 46-65', 'Mayores 65'],
    type: 'pie',
    marker: {
        colors: [colorsPie[0], colorsPie[1], colorsPie[2], colorsPie[3]]
    }
}];

var layoutPieAge = {
    title: {
        text: 'Clientes por edad',
        size: 18
    },
    legend: {
        x: 0.5,
        xanchor: "center",
        y: 0,
        orientation: "h"
    }
};
Plotly.newPlot('pieAge', dataPieAge, layoutPieAge, {responsive: true});

function getColoresPie(array){
    return colorsPie.slice(0, array.length)
}

var dataPieNumberAppointments = [{
    values: arrayValuesPieChartAppointmentsLabour,
    labels: arrayLabelsPieChartAppointmentsLabour,
    type: 'pie',
    marker: {
        colors: getColoresPie(arrayLabelsPieChartAppointmentsLabour)
    }
}];

var layoutPieNumberAppointments = {
    title: {
        text: 'Citas por servicio',
        size: 18
    },
    legend: {
        x: 0.5,
        xanchor: "center",
        y: 0,
        orientation: "h"
    }
};
Plotly.newPlot('pieNumberAppointments', dataPieNumberAppointments, layoutPieNumberAppointments, {responsive: true});

var dataPieClientesDelTotal = [{
    values: [clientesPropios, clientesTotales],
    labels: ['Propios', 'Totales'],
    type: 'pie',
    marker: {
        colors: [colorsPie[0], colorsPie[1]]
    }
}];

var layoutPieClientesDelTotal = {
    title: {
        text: 'Clientes cubiertos en tu zona',
        size: 18,
    },
    legend: {
        x: 0.5,
        xanchor: "center",
        y: 0,
        orientation: "h",
    }
};
Plotly.newPlot('pieClientesDelTotal', dataPieClientesDelTotal, layoutPieClientesDelTotal, {responsive: true});