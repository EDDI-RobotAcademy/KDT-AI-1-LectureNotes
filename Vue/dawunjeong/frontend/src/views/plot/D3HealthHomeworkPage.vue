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
        ...mapState(d3PlotModule, ['healthDataList']),
        drawPlot () {
            return this.line(this.healthDataList)
        },
        line () {
            return d3.line()
                    .x((d) => this.xScale(new Date(d.date)))
                    .y((d) => this.yScale(d.healthAmount))
        },
        xScale () {
            return d3.scaleTime()
                    .range([this.padding, this.width - this.padding])
                    .domain(d3.extent(this.healthDataList, (d) => (new Date(d.date))))
                    // .domain(d3.extent(this.data, (d) => (new Date(d.date))))
                    
        },
        yScale () {
            return d3.scaleLinear()
                    .range([this.height - this.padding, this.padding])
                    .domain([0, 100])
        },
    },
    async created () {
        // this.data = await this.requestHealthDataListToSpring()
        const data = await this.requestHealthDataListToSpring()
        console.log("액션을 수행하자마자 받은 data: " + JSON.stringify(this.data))
        console.log("액션을 수행하자마자 받은 healthDataList: " + JSON.stringify(this.healthDataList))
    },
    methods: {
        ...mapActions(d3PlotModule, ['requestHealthDataListToSpring']),
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
            .call(d3.axisBottom(this.xScale)
                    .tickFormat(d3.timeFormat("%b %d"))
                    .ticks(d3.timeDay))
        
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