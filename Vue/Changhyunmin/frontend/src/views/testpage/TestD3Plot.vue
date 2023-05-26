<template lang="">
    <v-container>
        <svg :width="width" :height="height">
        </svg>
    </v-container>
</template>

<script>
import * as d3 from "d3"
export default {
    data() {
        return {
            day_data:[
                {health_data:"1", amount:22},
                {health_data:"2", amount:65},
                {health_data:"3", amount:88},
                {health_data:"4", amount:70},
                {health_data:"5", amount:85},
                {health_data:"6", amount:77},
                {health_data:"7", amount:98}
            ],
            width: 800,
            height: 600,
            padding: 40,
        }
    },
    computed: {
        path() {
            return this.line(this.health_data)
        },
        line () {
            return d3.line()
                    .x((d, i)=>this.xScale(i))
                    .y((d)=> this.yScale(d))
        },
        xScale() {
            return d3.scaleLinear()
                    .range([this.padding, this.width - this.padding])
                    .domain(d3.extent(this.health_data, (d,i) =>i))
        },
        yScale() {
            return d3.scaleLinear()
                    .range([this.height - this.padding, this.padding])
                    .domain([0, 100])
        }
    },
    mounted() {
        const width = 600
        const height = 400
        const svg = d3.select("svg")
                    .attr("width",width + 100)
                    .attr("height",height + 100)
        const g = svg.append("g")
        const parseTime = d3.timeParse("%d")

        const x = d3.scaleTime()
                    .domain(d3.extent(this.day_data,(d)=> {
                        return parseTime(d.health_data)
                    }))
                    .rangeRound([0,width])
        const y = d3.scaleLinear()
                    .domain(d3.extent(this.day_data,(d)=> {
                        return d.amount
                    }))
                    .rangeRound([height,0])
        const line = d3.line()
                        .x((d)=> {
                            return x(parseTime(d.health_data))
                        })
                        .y((d)=> {
                            return y(d.amount)
                        })
        g.append("g")
            .attr("transform","translate(5," + height +")")
            .call(d3.axisBottom(x))

        g.append("g")
            .call(d3.axisLeft(y))
            .append("text")
            .attr("transform","translate(0," +  height + ")")
            .attr("fill","#000")
            .attr("transform","rotate(-90)")
            .attr("y",5)
            .attr("dy","0.71em")
            .attr("text-anchor","end")
            .text("momentum: (%)")
            
        g.append("path")
            .datum(this.day_data)
            .attr("fill","none")
            .attr("stroke","green")
            .attr("stroke-width", 1.5)
            .attr("d", line)
    },
}
</script>
<style scoped>

 
</style>