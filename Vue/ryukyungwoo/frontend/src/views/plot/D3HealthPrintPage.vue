<template lang="">
    <v-container>
        <svg :width="width" :height="height">
            <path fill="none" stroke="blue" stroke-width="3" :d="drawPlot"/>
        </svg>
    </v-container>
</template>

<script>
import * as d3 from "d3"
import { mapActions, mapState } from "vuex"

const d3PlotModule = 'd3PlotModule'

export default {
    data () {
        return {
            width: 800,
            height: 500,
            padding: 40,
            data: [],
        }
    },
    computed: {
        drawPlot () {
            return this.line(this.data)
        },
        line () {
            return d3.line()
                    .x((d, i) => this.xScale(i))
                    .y((d) => this.yScale(d.healthAmount))
        },
        xScale () {
            return d3.scaleLinear()
                    .range([this.padding, this.width - this.padding])
                    .domain([0, 6])
        },
        yScale () {
            return d3.scaleLinear()
                    .range([this.height - this.padding, this.padding])
                    .domain([0, 100])
        },
        ...mapState(d3PlotModule, ['healthDataList']),
    },
    async created () {
        this.data = await this.requestHealthDataToSpring()
        console.log("healthDataList: " + JSON.stringify(this.data))
    },
    methods: {
        ...mapActions(d3PlotModule, ['requestHealthDataToSpring']),
    },
    mounted () {
        const width = 800
        const height = 500
        const svg = d3.select("svg")
                    .attr("width", width + 100)
                    .attr("height", height + 100)
        const g = svg.append("g")

        g.append("g")
            .attr("transform", "translate(0," +  (height - 40) + ")")
            .call(d3.axisBottom(this.xScale).ticks(7))
            .append("text")

        g.append("g")
            .call(d3.axisLeft(this.yScale))
            .attr('transform', `translate(40, 0)`)
            .append("text")
            .attr("fill", "#000")
            .attr("transform", "rotate(-90)")
            .attr("y", 16)
            .attr("dy", "0.71em")
            .attr("text-anchor", "end")
            .text("운동량(백분율)")

    }
}
</script>

<style lang="">
    
</style>