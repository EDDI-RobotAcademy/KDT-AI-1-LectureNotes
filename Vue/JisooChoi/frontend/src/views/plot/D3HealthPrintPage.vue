<template lang="">
    <v-container>
        <svg :width="width" :height="height">
            <!--
                fill(채우기), stroke(선 색), stroke-width(선 굵기), drawPlot(v-bind)
            -->
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
            padding: 40, // 패딩 값을 없애면 화면이 거의 사라진다.. 왜지?
            data: [],
        }
    },
    computed: {
        drawPlot () {
            return this.line(this.data)
        },
        line () {
            return d3.line()
                    /*
                        i는 인덱스, d는 데이터
                    */
                    .x((d, i) => this.xScale(i))
                    .y((d) => this.yScale(d.healthAmount))
        },
        xScale () {
            return d3.scaleLinear()
                    /*
                        range은 잘 모르겠으나, 없애면 왼쪽에 일자 형식으로 압축 되어버림
                        domain은 x축 눈금 선
                    */
                    .range([this.padding, this.width - this.padding])
                    .domain([0, 6])
        },
        yScale () {
            return d3.scaleLinear()
                    /*
                        range은 잘 모르겠으나, 없애면 위쪽에 일자 형식으로 압축 되어버림
                        domain은 y축 눈금 선
                    */
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
                    
        const g = svg.append("g") // g를 왜 넣는 거지 ? g를 없애면 x, y축 선이 사라짐

        // y축 눈금선
        g.append("g")
        .attr("transform", "translate(0," +  (height - 40) + ")")
            .call(d3.axisBottom(this.xScale).ticks(7))
            .append("text")

        // x축 눈금선
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