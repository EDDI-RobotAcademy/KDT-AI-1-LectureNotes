<template lang="">
    <v-container>
        <svg :width="width" :height="height">
            <path fill="none" stroke="blue" stroke-width="3" :d="drawPath"/>
        </svg>
    </v-container>
</template>

<script>
import * as d3 from "d3";
export default {
    data () {
        return {
            data: [3, 9, 20, 40, 12, 34],
            width: 500,
            height: 800,
            padding: 40,
        }
    },
    computed: {
        drawPath() {
            return this.line(this.data)
        },
        xScale () {
            return d3.scaleLinear()
                    // x축의 출력값의 범위가 40부터 300 사이라는 것
                    .range([40, (800-500)])
                    // x축의 입력값의 범위가 0부터 5까지라는 것
                    .domain(d3.extent(this.data, (d, i) => i))
        },
        yScale () {
            return d3.scaleLinear()
                    .range([(500-40), 800])
                    .domain([0, 100])
        },
        line () {
            return d3.line()
                .x((d, i) => this.xScale(i))
                .y((d) => this.yScale(d))
        },
    },
    mounted () {
        const width = 500
        const height = 800
        const svg = d3.select("svg")
                    .attr("width", width + 100)
                    .attr("height", height + 100)
        const g = svg.append("g")

        const x = d3.scaleLinear()
                    .domain(d3.extent(this.data, (i) => {
                        return i
                    })) 
                    .rangeRound([0, width])

        const y = d3.scaleLinear()
                    .domain(d3.extent(this.data, (d) => {
                        return d
                    }))    
                    .rangeRound([height, 0])  

        const line = d3.line()
                    .x((d) => {
                        return x(i)
                    })
                    .y((d) => {
                        return y(d)
                    })     

        g.append("g")
            .attr("transform", "translate(40," + height + ")" )
            .call(d3.axisBottom(x))

        g.append("g")
            .call(d3.axisLeft(y))
            .attr("transform", "translate(40,0)" )
            .append("text")
            .attr("fill", "#000")
            .attr("fransform", "rotate(-90)")
            .attr("y", 16)
            .attr("dy", "0.71em")
            .attr("text-anchor", "end")
            .text("Price: ($)")

        g.append("path")
            .datum(this.reg_data)
            .attr("transform", "translate(40,0)" )
            .attr("fill", "none")
            .attr("stroke", "steelblue")
            .attr("stroke-width", 1.5)
            .attr("d", line)
    }
}
</script>

<style lang="">
    
</style>