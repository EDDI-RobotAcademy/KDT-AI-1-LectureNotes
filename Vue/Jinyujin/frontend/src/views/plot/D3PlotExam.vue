<template lang="">
    <v-container>
        <svg :width="width" :height="height">
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
            padding: 40
        }
    },
    // computed: {
    //     path() {
    //         return this.line(this.data)
    //     },
    //     line() {
    //         return d3.line()
    //             .x((d, i) => this.xScale(i))
    //             .y((d) => this.yScale(d))
    //     },
    //      xScale() {
    //         return d3.scaleTime()
    //             .range([this.padding, this.width - this.padding])
    //             .domain(d3.extent(this.data, (d, i) => i))
    //     },
    //     yScale() {
    //         return d3.scaleLinear()
    //             .range([this.height - this.padding, this.padding])
    //             .domain([0, 100])
    //     },
    // },
    created() {
        // 현재 코드에서는 mounted에서 async 하면 뜨지 않음
        // created에서 async-await를 하면 뜸
        // 그래프인지 리스트인지 받아오기 힘든가봄

        // 데이터 잘 받아오고 있음 확인
        // this.data = await this.requestHealthDataToSpring()
    },
    async mounted() {
        this.data = await this.requestHealthDataToSpring()
        // 이걸 created가 아니라 mounted에 옮기니 해결됨
        // created에서 됐으면 mounted에서 됐어야 하는거 아닌가?

        const width = 800
        const height = 500
       
        const parseTime = d3.timeParse("%Y-%m-%d")
        // https://d3-wiki.readthedocs.io/zh_CN/master/Time-Formatting/
        // 날짜 속성 알려주는 사이트

        // x축을 표현해주는 것 같음
        const x = d3.scaleTime()
            .domain(d3.extent(this.data, (d) => {
                return parseTime(d.date)
                // d를 적절하게 활용했어야 함
                // 이전에는 d를 써놓고 활용을 안해서 불이 꺼져있었음
                // 그리고 parseTime을 사용해야 함
                // new Date는 d3에서 쓰는게 아님
            }))
            .rangeRound([0, width])
            // 이건 반올림

        // y축을 표현해주는 것 같음
        const y = d3.scaleLinear()
            .domain(d3.extent(this.data, (d) => {
                return d.healthAmount
            }))
            .rangeRound([height, 0])

        const line = d3.line()
            .x((d) => {
                return x(parseTime(d.date))
                // 이거는 line에 내장되어 있는 x -> x좌표
            })
            .y((d) => {
                return y(d.healthAmount)
                // line에 내장되어 있는 y -> y좌표
            })

        const svg = d3.select("svg")
            .attr("width", width + 100)
            .attr("height", height + 100)

         const g = svg.append("g")
        // svg.append("g")를 사용하여 g 요소 생성하고 그걸 편하게 사용하기 위해 g에 대입시켜줌
        // d3에서 svg요소를 추가하는 메서드
        // "g"는 그룹요소
        // 아래에서 ""안에 들어가는 애들은 다 "g"의 속성들

        g.append("g")
            .attr("transform", "translate(40," + height + ")")
            .call(d3.axisBottom(x).ticks(d3.timeDay))
            // d3.call() 메서드는 scale() 메서드로 정의된 축을 지정하기 위해 사용
            // d3.axiosBottom()은 x축을 생성하고 그리기 위한 함수
            // 여기에 x축을 넣어서 범위를 확실하게 지정해준 것
            // 여기서 x축의 길이 지정
            // 날짜라고 표기해주려 했는데 짜만 나오고 짤림 아래에서 translate을 조정해봤지만
            // 글씨는 옮겨지지 않고 축만 옮겨짐
            // 날짜별로 처리하려면 ticks(d3.timeDay)
            .append("text")
            .attr("fill", "pink")
            .text("날짜")
            .attr("x", 800)
            .attr("y", 20)
            .attr("dy", "0.71em")

        g.append("g")
            .call(d3.axisLeft(y))
            .attr('transform', `translate(40, 0)`)
            .append("text")
            .attr("fill", "pink")
            .attr("transform", "rotate(-90)")
            .attr("y", 16)
            .attr("dy", "0.71em")
            .attr("text-anchor", "end")
            .text("운동량: (백분율)")

        g.append("path")
            .datum(this.data)
            .attr('transform', `translate(40, 0)`)
            .attr("fill", "none")
            .attr("stroke", "pink")
            .attr("stroke-width", 1.5)
            .attr("d", line)

        // this.data = await this.requestHealthDataToSpring()
    },
    methods: {
        ...mapActions(d3PlotModule, ['requestHealthDataToSpring']),
    }
}
</script>

<style lang="">
</style>