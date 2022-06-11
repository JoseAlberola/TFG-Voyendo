var dataPieGender = [{
    values: [numeroHombres, numeroMujeres],
    labels: ['Hombres', 'Mujeres'],
    type: 'pie'
}];

var layoutPieGender = {
    title: {
        text: 'Clientes por género',
        size: 18,
        color: '#686868'
    },
    legend: {
        x: 0.5,
        xanchor: "center",
        y: 0,
        orientation: "h"
    }
};
Plotly.newPlot('pieGender', dataPieGender, layoutPieGender);

var dataPieAge = [{
    values: [totalClientesMenores25, totalClientesEntre26y45, totalClientesEntre46y65, totalclientesMayores65],
    labels: ['Menores 25', 'Entre 26-45', 'Entre 46-65', 'Mayores 65'],
    type: 'pie'
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
Plotly.newPlot('pieAge', dataPieAge, layoutPieAge);

var dataPieNumberAppointments = [{
    values: arrayValuesPieChartAppointmentsLabour,
    labels: arrayLabelsPieChartAppointmentsLabour,
    type: 'pie'
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
Plotly.newPlot('pieNumberAppointments', dataPieNumberAppointments, layoutPieNumberAppointments);