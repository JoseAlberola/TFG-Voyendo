trace1 = {
    name: heatMap.textos,
    type: 'heatmap',
    x: heatMap.semanas,
    y: heatMap.dias,
    zmax: heatMap.valorMax,
    zmin: 0,
    z: heatMap.valores,
    inherit: false,
    text: heatMap.textos,
    colorbar: {title: 'vol(kL)'},
    hoverinfo: 'text',
    colorbar: {title: 'values'},
    colorscale: [['0', '#440154'], ['0.111111111111111', '#482878'], ['0.222222222222222', '#3E4A89'], ['0.333333333333333', '#31688E'], ['0.444444444444445', '#26828E'], ['0.555555555555556', '#1F9E89'], ['0.666666666666667', '#35B779'], ['0.777777777777778', '#6DCD59'], ['0.888888888888889', '#B4DE2C'], ['1', '#FDE725']]
};

data = [trace1];

layout = {
    title: 'Cantidad de reservas por día en los últimos 6 meses',
    xaxis: {
        title: '',
        mirror: true,
        ticklen: 0,
        showline: true,
        tickmode: 'array',
        ticktext: ejeXHeatMap.tickText,
        tickvals: ejeXHeatMap.tickVals
    },
    yaxis: {
        title: '',
        mirror: true,
        showline: true,
        tickmode: 'array',
        ticktext: ['Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'Sab', 'Dom'],
        tickvals: [1, 2, 3, 4, 5, 6, 7]
    },
    zaxis: {title: 'reservas'}
};

var config = {locale: 'es', responsive: true};

Plotly.newPlot('heatMap', data, layout, config);