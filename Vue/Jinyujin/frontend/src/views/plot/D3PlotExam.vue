<template lang="">
    <v-container>
        <svg :width="width" :height="height">
            <path fill ="none" stroke="blue" stroke-width="3" :d="path"/>
        </svg>
    </v-container>
</template>

<script>
import * as d3 from "d3"
import { mapActions } from "vuex"

const d3PlotModule = 'd3PlotModule'

export default {
    data() {
        return {
            data: [],
            reg_data: [
                { date: "24-Apr-23" , amount: 1 },
                { date: "25-Apr-23" },
                { date: "26-Apr-23" },
                { date: "27-Apr-23" },
                { date: "28-Apr-23" },
                { date: "1-May-23" },
                { date: "2-May-23", amount:100 },
            ],
            width: 800,
            height: 500,
            padding: 40
        }
    },
    computed: {
        path() {
            return this.line(this.data)
        },
        line() {
            return d3.line()
                .x((d, i) => this.xScale(i))
                .y((d) => this.yScale(d))
        },
         xScale() {
            return d3.scaleLinear()
                .range([this.padding, this.width - this.padding])
                // 범주 표현(앞에꺼부터 뒤에꺼까지)
                .domain(d3.extent(this.data, (d, i) => i))
        },
        yScale() {
            return d3.scaleLinear()
                .range([this.height - this.padding, this.padding])
                .domain([0, 100])
        },
    },
    async mounted() {
        const width = 800
        const height = 500
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
                console.log(d)
                return d.amount
            }))
            .rangeRound([height, 0])

        const line = d3.line()
        //     .x((d) => {
        //         return x(parseTime(d.date))
        //     })
        //     .y((d) => {
        //         return y(d.amount)
        //     })

        g.append("g")
            .attr("transform", "translate(40," + height + ")")
            .call(d3.axisBottom(x))

        g.append("g")
            .call(d3.axisLeft(y))
            .attr('transform', `translate(40, 0)`)
            .append("text")
            .attr("fill", "#000")
            .attr("transform", "rotate(-90)")
            .attr("y", 16)
            .attr("dy", "0.71em")
            .attr("text-anchor", "end")
            .text("운동량: (양)")

        g.append("path")
            .datum(this.reg_data)
            .attr('transform', `translate(40, 0)`)
            .attr("fill", "none")
            .attr("stroke", "steelblue")
            .attr("stroke-width", 1.5)
            .attr("d", line)

        this.data = await this.requestHealthDataToSpring()
    },
    methods: {
        ...mapActions(d3PlotModule, ['requestHealthDataToSpring'])
    }
}
</script>

<style lang="">
</style>