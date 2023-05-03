<template lang="">
    <v-container>
        <svg :width="width" :height="height">
            <path fill ="none" stroke="blue" stroke-width="3" :d="drawplot"/>
        </svg>
        <p>운동량: {{ data }}</p>
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
            width: 800,
            height: 500,
            padding: 40
        }
    },
    computed: {
        drawplot() {
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
                .domain([0,6])
        },
        yScale() {
            return d3.scaleLinear()
                .range([this.height - this.padding, this.padding])
                .domain([0, 100])
        },
    },
    async created() {
        this.data = await this.requestHealthDataToSpring()
        // 현재 코드에서는 mounted에서 async 하면 뜨지 않음
        // created에서 async-await를 하면 뜸
        // 그래프인지 리스트인지 받아오기 힘든가봄
        console.log("data: " + JSON.stringify(this.data))
        // 데이터 잘 받아오고 있음 확인
    },
    mounted() {
        const width = 800
        const height = 500
        const svg = d3.select("svg")
            .attr("width", width + 100)
            .attr("height", height + 100)
        const g = svg.append("g")

        // const parseTime = d3.timeParse("%d-%b-%y")

        // const x = d3.scaleTime()
        //     .domain(d3.extent(this.reg_data, (d) => {
        //         return parseTime(d.date)
        //     }))
        //     .rangeRound([0, width])

        // const y = d3.scaleLinear()
        //     .domain(d3.extent(this.reg_data, (d) => {
        //         console.log(d)
        //         return d.amount
        //     }))
        //     .rangeRound([height, 0])

        const line = d3.line()
        //     .x((d) => {
        //         return x(parseTime(d.date))
        //     })
        //     .y((d) => {
        //         return y(d.amount)
        //     })

        g.append("g")
            .attr("transform", "translate(0," + (height - 40) + ")")
            .call(d3.axisBottom(this.xScale).ticks(7))
            // 여기서 x축의 길이 지정
            // 날짜라고 표기해주려 했는데 짜만 나오고 짤림 아래에서 translate을 조정해봤지만
            // 글씨는 옮겨지지 않고 축만 옮겨짐
            .append("text")
            .attr("fill", "#000")
            .text("날짜")

        g.append("g")
            .call(d3.axisLeft(this.yScale))
            .attr('transform', `translate(40, 0)`)
            .append("text")
            .attr("fill", "#000")
            .attr("transform", "rotate(-90)")
            .attr("y", 16)
            .attr("dy", "0.71em")
            .attr("text-anchor", "end")
            .text("운동량: (백분율)")

        // g.append("path")
        //     .datum(this.reg_data)
        //     .attr('transform', `translate(40, 0)`)
        //     .attr("fill", "none")
        //     .attr("stroke", "steelblue")
        //     .attr("stroke-width", 1.5)
        //     .attr("d", line)

        // this.data = await this.requestHealthDataToSpring()
    },
    methods: {
        ...mapActions(d3PlotModule, ['requestHealthDataToSpring'])
    }
}
</script>

<style lang="">
</style>