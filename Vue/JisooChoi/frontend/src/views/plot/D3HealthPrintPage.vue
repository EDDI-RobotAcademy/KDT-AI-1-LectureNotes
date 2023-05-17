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
// npm install d3 --save-dev
import * as d3 from "d3"
import { mapActions, mapState } from "vuex"

const d3PlotModule = 'd3PlotModule'

export default {
    // data : 사용하는 지역 변수 
    data () {
        return {
            // data : 그래프 상에서 표현하려고 하는 data 
            width: 800,
            height: 500,
            padding: 40, // 패딩 값을 없애면 화면이 거의 사라진다.. 왜지?
            data: [],
        }
    },
    computed: {
        drawPlot () {
            // ▲ 2번 째 -> ... -> 다시 7번 째
            console.log('drawPlot()')

            return this.line(this.data)
        },
        line () {
            // ▲ 3번 째
            console.log('line()')

            return d3.line()
                    /*
                        i는 인덱스, d는 데이터

                        이 부분에서 x, y축 눈금 선들이 먼저 그려지도록 mounted로 날아간다 !
                    */
                    .x((d, i) => this.xScale(i))
                    .y((d) => this.yScale(d.healthAmount))
        },
        xScale () {
            // ▲ 5번 째
            console.log('xScale()')

            return d3.scaleLinear()
                    /*
                        range은 잘 모르겠으나, 없애면 왼쪽에 일자 형식으로 압축 되어버림
                        domain은 x축 눈금 선
                    */
                    .range([this.padding, this.width - this.padding])
                    .domain([0, 6])
        },
        yScale () {
            // ▲ 6번 째
            console.log('yScale()')

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
    // ▲ 1번 째
    async created () {
        console.log('created()')

        this.data = await this.requestHealthDataToSpring()
        console.log("healthDataList: " + JSON.stringify(this.data))
    },
    methods: { // 메서드에는 콘솔 안 찍힘
        ...mapActions(d3PlotModule, ['requestHealthDataToSpring']),
    },

    // path가 먼저 그려지기 전에 아래 mounted를 통해 x, y 축 들이 먼저 생긴다.
    mounted () {
        // ▲ 4번 째
        console.log('mounted()')

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