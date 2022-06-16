var trace1 = {
    type: "scatter",
    mode: "lines+markers",
    fill: "tonexty",
    name: historialNewCustomersGraph.trace.name,
    x: historialNewCustomersGraph.trace.fechas,
    y: historialNewCustomersGraph.trace.valores,
    line: {color: '#0062cc'}
}

var data = [trace1];

var layout = {
    title: {
        text: 'Histórico de nuevos clientes',
        size: 18
    },
    xaxis: {
        autorange: true,
        range: [historialNewCustomersGraph.inicioRango, historialNewCustomersGraph.finRango],
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
        rangeslider: {range: [historialNewCustomersGraph.inicioRango, historialNewCustomersGraph.finRango]},
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

Plotly.newPlot('historicalNewCustomersGraph', data, layout, config);