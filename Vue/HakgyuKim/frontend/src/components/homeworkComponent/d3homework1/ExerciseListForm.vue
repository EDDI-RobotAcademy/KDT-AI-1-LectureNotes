<template lang="">
    <v-container>
        <svg :width="width" :height="height"></svg>
    </v-container>
</template>
<script>

import * as d3 from "d3"
export default {
    props: {
        exerciseList: {
            type: Array
        }
    },
    data () {
        return {
            width: 800,
            height: 500,
            padding: 40,
        }
    },
    mounted () {
        const width = 800
        const height = 500
        const svg = d3.select("svg")
                    .attr("width", width + 100)
                    .attr("height", height + 100)
        const g = svg.append("g")
        const parseTime = d3.timeParse("%d-%b-%y")
        const x = d3.scaleTime()
                    .domain(d3.extent(this.exerciseList, (d) => {
                        console.log("date: " + d.date)
                        return parseTime(d.date)
                    }))
                    .rangeRound([0, width])
        const y = d3.scaleLinear()
                    .domain(d3.extent(this.exerciseList, (d) => {
                        console.log("amount: " + d.exerciseAmount)
                        return d.exerciseAmount
                    }))
                    .rangeRound([height, 0])
        const line = d3.line()
                        .x((d) => {
                            return x(parseTime(d.date))
                        })
                        .y((d) => {
                            return y(d.exerciseAmount)
                        })
        g.append("g")
            .attr("transform", "translate(40," +  height + ")")
            .call(d3.axisBottom(x).tickFormat(d3.timeFormat("%y-%b-%d")).ticks(d3.timeDay))
        g.append("g")
            .call(d3.axisLeft(y))
            .attr('transform', `translate(40, 0)`)
            .append("text")
            .attr("fill", "#000")
            .attr("transform", "rotate(-90)")
            .attr("y", 16)
            .attr("dy", "0.71em")
            .attr("text-anchor", "end")
            .text("Exercise Amount")
        g.append("path")
            .datum(this.exerciseList)
            .attr('transform', `translate(40, 0)`)
            .attr("fill", "none")
            .attr("stroke", "red")
            .attr("stroke-width", 1.5)
            .attr("d", line)
    }
}
</script>
<style lang="">
    
</style>