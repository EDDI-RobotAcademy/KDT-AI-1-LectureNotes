<template lang="">
    <v-container>
        <svg :width="width" :height="height">
        </svg>
    </v-container>
</template>
<script>
import * as d3 from "d3";
import { mapState, mapActions } from 'vuex';

const d3PlotModule = 'd3PlotModule'

export default {
    data() {
        return {
            width: 800,
            height: 500,
            padding: 40,
        }
    },
    mounted() {
        const svg = d3.select("svg")
            .attr("width", this.width + 100)
            .attr("height", this.height + 100)
        const g = svg.append("g")
        const parseTime = d3.timeParse("%d-%m-%y")

        const x = d3.scaleTime()
            .domain(d3.extent(this.momentumList, (d) => {
                return parseTime(d.date)
            }))
            .rangeRound([0, this.width])

        const y = d3.scaleLinear()
            .domain(d3.extent(this.momentumList, (d) => {
                return d.momentum
            }))
            .rangeRound([this.height, 0])

        const line = d3.line()
            .x((d) => {
                return x(parseTime(d.date))
            })
            .y((d) => {
                return y(d.momentum)
            })

        g.append("g")
            .attr("transform", "translate(40," + this.height + ")")
            .call(d3.axisBottom(x).ticks(d3.timeDay))
            .append("text")
            .attr("fill", "#000")
            .attr("x", 800)
            .attr("text-anchor", "start")
            .text("Day")

        g.append("g")
            .call(d3.axisLeft(y))
            .attr('transform', `translate(40, 0)`)
            .append("text")
            .attr("fill", "#000")
            .attr("transform", "rotate(-90)")
            .attr("y", 16)
            .attr("text-anchor", "end")
            .text("Price: ($)")

        g.append("path")
            .datum(this.momentumList)
            .attr('transform', `translate(40, 0)`)
            .attr("fill", "none")
            .attr("stroke", "steelblue")
            .attr("stroke-width", 1.5)
            .attr("d", line)
    },
    computed: {
        ...mapState(
            d3PlotModule, ['momentumList'])
    },
    methods: {
        ...mapActions(
            d3PlotModule, ['requestMomentumToSpring'])
    },
    created() {
        this.requestMomentumToSpring()
    }
}
</script>
<style lang="">
    
</style>