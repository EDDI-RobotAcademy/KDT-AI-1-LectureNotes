<template>
    <v-container>
        <svg :width="width" :height="height">
            <path :d="path" stroke="blue" stroke-width="3" fill="none"/>
            <circle cx=100 cy=200 r=40 stroke=#412322 fill=#41B883></circle>

        </svg>
    </v-container>
</template>

<script>
import * as d3 from "d3"

export default {
    name: "D3PlotTestPage",
    data() {
        return {
            data: [90.9, 70, 90.2, 25, 10.2, 92],
            reg_data: [
                {date: "24-Apr-23", amount: 93.24},
                {date: "25-Apr-23", amount: 93.35},
                {date: "26-Apr-23", amount: 98.77},
                {date: "27-Apr-23", amount: 99.92},
                {date: "28-Apr-23", amount: 93.24},
                {date: "1-May-23", amount: 100.39},
                {date: "2-May-23", amount: 93.27},
                {date: "3-May-23", amount: 103.64},
                {date: "4-May-23", amount: 92.84},
                {date: "5-May-23", amount: 99.99},
            ],
            width: 400,
            height: 300,
            padding: 40,

        }
    },
    computed: {
        path() {
            return this.line(this.data)
        },
        line() {
            console.log("this.path(line)")
            return d3.line()
                .x((d, i) => this.xScale(i))
                .y((d) => this.yScale(d))
        },
        xScale() {
            return d3.scaleLinear()
                .range([this.padding, this.width - this.padding])
                .domain(d3.extent(this.data, (d, i) => i))
        },
        yScale() {
            return d3.scaleLinear()
                .range([this.height - this.padding, this.padding])
                .domain([0, 100])
        }
    },
    mounted: function () {
        const width = this.width
        const height = this.height
        const svg = d3.select("svg")
            .attr("width", width + 100)
            .attr("height", height + 100)
        const g = svg.append("g")

        const parseTime = d3.timeParse("%d-%b-%y")

        const x = d3.scaleTime()
            .domain(d3.extent(this.reg_data, (d) => {
                return parseTime(d.date)
            }))
            .rangeRound([0, width])

        const y = d3.scaleLinear()
            .domain(d3.extent(this.reg_data, (d) => {
                return d.amount
            }))
            .rangeRound([height, 0])

        const line = d3.line()
            .x((d) => {
                return x(parseTime(d.date))
            })
            .y((d) => {
                return y(d.amount)
            })

        g.append("g")
            .attr("transform", "translate(40, " + this.height + ")")
            .call(d3.axisBottom(x))

        g.append("g")
            .call(d3.axisLeft(y))
            .attr("transform", "translate(40, 0)")
            .append("text")
            .attr("fill", "#FF0000")
            .attr("transform", "rotate(-90)")
            .attr("y", 16)
            .attr("dy", "1em")
            .attr("text-anchor", "end")
            .text("Price: ($)")

        g.append("path")
            .datum(this.reg_data)
            .attr("stroke", "steelblue")
            .attr("stroke-width", 1.5)
            .attr("transform", "translate(40, 0)")
            .attr("fill", "none")
            .attr("d", line)


    }
}
</script>

<style scoped>

</style>