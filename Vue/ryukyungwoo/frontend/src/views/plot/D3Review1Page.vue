<template lang="">
    <v-container>
        <svg :width="width" :height="height">
            <path fill ="none" stroke="blue" stroke-width="3" :d="drawplot"/>
        </svg>
        <p>{{ data }}</p>
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
            padding: 40,
            xTiemScaleValue: [],
        }
    },
    computed: {
        drawplot () {
            return this.line(this.data)
        },
        line () {
            const d3parseTime = d3.timeParse("%Y-%m-%d")
            return d3.line()
                .x((d, i) => this.xScale(d3parseTime(d.date)))
                .y((d) => this.yScale(d.healthAmount))
        },
        xScale () {
            const d3parseTime = d3.timeParse("%Y-%m-%d")
            return d3.scaleTime()
                .range([this.padding, this.width - this.padding])
                //.domain(d3.extent(this.data, (d, i) => i))
                //.domain([(this.data[0].date), this.data[6].date])
                .domain(d3.extent(this.data, (d) => {
                    console.log('date: ' + d.date)
                    return d3parseTime(d.date)
                }))
        },
        yScale () {
            return d3.scaleLinear()
                .range([this.height - this.padding, this.padding])
                .domain([0, 100])
        },
    },
    async created() {
        // this.data = await this.requestOtherHealthDataToSpring()
        // console.log("data: " + JSON.stringify(this.data))

        // 2023-05-08
        const d3parseTime = d3.timeParse("%Y-%m-%d")
        console.log('formatted time parsing: ' + d3parseTime(this.data[0].date))
    },
    async mounted() {
        const width = 800
        const height = 500
        const svg = d3.select("svg")
            .attr("width", width + 100)
            .attr("height", height + 100)
        const g = svg.append("g")
        console.log(this.data.healthAmount)
        console.log(this.data.date)

        // const parseTime = d3.timeParse("%Y-%m-%d")
        // https://d3-wiki.readthedocs.io/zh_CN/master/Time-Formatting/
        // 날짜 속성 알려주는 사이트

        this.data = await this.requestOtherHealthDataToSpring()
        console.log("data: " + JSON.stringify(this.data))

        const d3parseTime = d3.timeParse("%Y-%m-%d")
        const xTimeScaleValue = this.data.map((d) => d.date)
        //const xTimeScaleValue = Object.keys(this.data).map(key => this.data[key].date)
        console.log('xTimeScaleValue: ' + xTimeScaleValue)
        console.log('JSON.stringify(xTimeScaleValue): ' + JSON.stringify(xTimeScaleValue))
        //console.log('typeof(xTiemScaleValue): ' + typeof(xTimeScaleValue))

        const x = d3.scaleTime()
            .domain([d3parseTime(xTimeScaleValue[0]), d3parseTime(xTimeScaleValue[6])])
            .rangeRound([0, width])

        const y = d3.scaleLinear()
            .domain(d3.extent(this.data, (d) => this.data.healthAmount))
            .rangeRound([height, 0])

        const line = d3.line()
            .x(d => x(this.data.date))
            .y(d => y(this.data.healthAmount))

        g.append("g")
            .attr("transform", "translate(40," + (height - 40) + ")")
            .call(d3.axisBottom(x).ticks(7))
            // 여기서 x축의 길이 지정
            // 날짜라고 표기해주려 했는데 짜만 나오고 짤림 아래에서 translate을 조정해봤지만
            // 글씨는 옮겨지지 않고 축만 옮겨짐
            // 날짜별로 처리하려면 ticks(d3.timeDay)
            .append("text")
            .attr("fill", "#000")
            .text("날짜")
            .attr("y", 26)
            .attr("x", 5)
            .attr("dy", "0.71em")

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

        g.append("g")
            .datum(this.data)
            .attr('transform', `translate(40, 0)`)
            .attr("fill", "none")
            .attr("stroke", "steelblue")
            .attr("stroke-width", 1.5)
            .attr("d", line)

        // this.data = await this.requestHealthDataToSpring()
    },
    methods: {
        ...mapActions(d3PlotModule, ['requestOtherHealthDataToSpring']),
    }
}
</script>

<style lang="">
</style>