function crearNameTrace(i){
    if(i < servicios.length){
        console.log(servicios[i].name);
        return servicios[i].name;
    }else{
        return "";
    }
}

function crearFechasTrace(i){
    if(i < servicios.length){
        console.log(servicios[i].fechas);
        return servicios[i].fechas;
    }else{
        return [];
    }
}

function crearValoresTrace(i){
    if(i < servicios.length){
        console.log(servicios[i].valores);
        return servicios[i].valores;
    }else{
        return [];
    }
}

var trace1 = {
    type: "scatter",
    mode: "lines",
    name: crearNameTrace(0),
    x: crearFechasTrace(0),
    y: crearValoresTrace(0),
    line: {color: '#17BECF'}
}

var trace2 = {
    type: "scatter",
    mode: "lines",
    name: crearNameTrace(1),
    x: crearFechasTrace(1),
    y: crearValoresTrace(1),
    line: {color: '#7F7F7F'}
}

var trace3 = {
    type: "scatter",
    mode: "lines",
    name: crearNameTrace(2),
    x: crearFechasTrace(2),
    y: crearValoresTrace(2),
    line: {color: '#7F7F7F'}
}
var trace4 = {
    type: "scatter",
    mode: "lines",
    name: crearNameTrace(3),
    x: crearFechasTrace(3),
    y: crearValoresTrace(3),
    line: {color: '#7F7F7F'}
}
var trace5 = {
    type: "scatter",
    mode: "lines",
    name: crearNameTrace(4),
    x: crearFechasTrace(4),
    y: crearValoresTrace(4),
    line: {color: '#7F7F7F'}
}
var data = [trace1,trace2,trace3,trace4,trace5];

var layout = {
    title: {
        text: 'Histórico de reservas',
        size: 18
    },
    xaxis: {
        autorange: true,
        range: [historialAppointmentsGraph.inicioRango, historialAppointmentsGraph.finRango],
        rangeselector: {buttons: [
                {
                    count: 1,
                    label: '1m',
                    step: 'month',
                    stepmode: 'backward'
                },
                {
                    count: 6,
                    label: '6m',
                    step: 'month',
                    stepmode: 'backward'
                },
                {step: 'all'}
            ]},
        rangeslider: {range: [historialAppointmentsGraph.inicioRango, historialAppointmentsGraph.finRango]},
        type: 'date'
    },
    yaxis: {
        autorange: true,
        type: 'linear'
    },
    legend: {
        x: 0.5,
        xanchor: "center",
        y: -0.5,
        orientation: "h"
    }
};

var config = {locale: 'es'};

Plotly.newPlot('line', data, layout, config);