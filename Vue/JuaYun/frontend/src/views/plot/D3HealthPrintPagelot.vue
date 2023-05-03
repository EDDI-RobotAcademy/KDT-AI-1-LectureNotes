<template lang="">
    <v-container>
        <svg :width="width" :height="height">
            <path fill="none" stroke="blue" stroke-width="3" :d="heathDataList"/>
        </svg>
    </v-container>
</template>

<script>

import * as d3 from "d3"
import { mapActions } from "vuex"

const d3PlotModule = 'd3PlotModule'

export default {
    data () {
        return {
            data: [], // 이부분은 정보를 넣을 때 확인해보기
            reg_data: [
                { date: "1", amount: 10 },
                { date: "2", amount: 20 },
                { date: "3", amount: 40 },
                { date: "4", amount: 50 },
                { date: "5", amount: 70 },
                { date: "6", amount: 80 },
                { date: "7", amount: 100 },
                // { date: "3-May-23", amount: 103.64 },
                // { date: "4-May-23", amount: 92.84 },
                // { date: "5-May-23", amount: 99.99 },
            ],
            width: 800,
            height: 500,
            padding: 40,
        }
    },
    computed: {
        path () {
            return this.line(this.data)
        },
        line () {
            console.log('path()에서 불려짐: 넌 언제 그려지니?') // 콘솔설정 후 mounted를 주석처리
            return d3.line()
                    .x((d, i) => this.xScale(i))
                    .y((d) => this.yScale(d) )
        },
        xScale () {
            return d3.scaleLinear()
                    .range([this.padding, this.width - this.padding])
                    .domain(d3.extent(this.data, (d, i) => i))
        },
        yScale () {
            return d3.scaleLinear()
                    .range([this.height - this.padding, this.padding])
                    .domain([0, 100])
        },
        ...mapState(d3PlotModule, ['heathDataList'])
    },
    mounted() {
        this.requestHealtDataToSpring()
    },
    methods: {
        ...mapActions(d3PlotModule, ['requestHealtDataToSpring'])
    },






    // 여기는 나중에 손봐야 할 부분
    mounted () {
        const width = 800
        const height = 500
        const svg = d3.select("svg")
                    .attr("width", width + 100)
                    .attr("height", height + 100)
        const g = svg.append("g")
        const parseTime = d3.timeParse("%d")
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
                        .x((d) => {
                            return x(parseTime(d.date))
                        })
                        .y((d) => {
                            return y(d.amount)
                        })

        g.append("g")    
            .attr("transform", "translate(40," +  height + ")")
            .call(d3.axisBottom(x))

        g.append("g")
            .call(d3.axisLeft(y))
            .attr('transform', `translate(40, 0)`) // price값이 나오지 않아 추가된 코드
            .append("text")
            .attr("fill", "#000")
            .attr("transform", "rotate(-90)")
            .attr("y", 16)
            .attr("dy", "0.71em")
            .attr("text-anchor", "end")
            .text("Price: ($)")

        g.append("path")
            .datum(this.reg_data)
            .attr('transform', `translate(40, 0)`) // price값이 나오지 않아 추가된 코드
            .attr("fill", "none")
            .attr("stroke", "steelblue")
            .attr("stroke-width", 1.5)
            .attr("d", line)
    }
}
</script>
<style lang="">
    
</style>