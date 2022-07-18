function crearNameTrace(i){
    if(i < servicios.length){
        return servicios[i].name;
    }else{
        return "";
    }
}

function crearFechasTrace(i){
    if(i < servicios.length){
        return servicios[i].fechas;
    }else{
        return [];
    }
}

function crearValoresTrace(i){
    if(i < servicios.length){
        return servicios[i].valores;
    }else{
        return [];
    }
}

var trace1 = {
    type: "bar",
    name: historialRevenueGraph.traces[0].name,
    x: historialRevenueGraph.traces[0].fechas,
    y: historialRevenueGraph.traces[0].valores,
    marker: {color: '#609ddf'}
}

var trace2 = {
    type: "scatter",
    mode: "lines+markers",
    name: historialRevenueGraph.traces[1].name,
    x: historialRevenueGraph.traces[1].fechas,
    y: historialRevenueGraph.traces[1].valores,
    line: {color: '#003D80'}
}

var data = [trace1, trace2];

var layout = {
    title: {
        text: 'Histórico de ingresos',
        size: 18
    },
    xaxis: {
        autorange: true,
        range: [historialRevenueGraph.inicioRango, historialRevenueGraph.finRango],
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
        rangeslider: {range: [historialRevenueGraph.inicioRango, historialRevenueGraph.finRango]},
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

var config = {locale: 'es', responsive: true};

Plotly.newPlot('historicalRevenueGraph', data, layout, config);