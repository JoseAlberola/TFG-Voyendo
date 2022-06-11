// Step 3
var svg = d3.select(".svgChart"),
    width = svg.attr("width"),
    height = svg.attr("height"),
    radius = 125;

// Step 1
var data = [{name: "Hombres", share: numeroHombres},
    {name: "Mujeres", share: numeroMujeres}];

var g = svg.append("g")
    .attr("transform", "translate(" + width / 2 + "," + height / 2 + ")");

// Step 4
var ordScale = d3.scaleOrdinal()
    .domain(data)
    .range(['#0062cc','#ffc300']);

// Step 5
var pie = d3.pie().value(function(d) {
    return d.share;
});

var arc = g.selectAll("arc")
    .data(pie(data))
    .enter();

// Step 6
var path = d3.arc()
    .outerRadius(radius)
    .innerRadius(0);

arc.append("path")
    .attr("d", path)
    .attr("fill", function(d) { return ordScale(d.data.name); });

// Step 7
var label = d3.arc()
    .outerRadius(radius)
    .innerRadius(0);

arc.append("text")
    .attr("transform", function(d) {
        return "translate(" + label.centroid(d) + ")";
    })
    .attr("text-anchor", "middle")
    .text(function(d){
        return d.data.name+" ("+d.data.share+"%)" ;
    })
    .style("font-size", "13")
    .style("font-weight", "500")