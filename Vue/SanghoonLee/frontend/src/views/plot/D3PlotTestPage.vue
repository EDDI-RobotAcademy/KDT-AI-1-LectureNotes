<template lang="">
    <v-container>
        <svg :width="width" :height="height">
            <!-- path()만 사용함 -->
            <path fill="none" stroke="blue" stroke-width="3" :d="path"/>
            <circle cx=100 cy=200 r=40 stroke=#412322 fill=#41B883></circle>
        </svg>
    </v-container>
</template>

<script>
// npm install d3 --save-dev
import * as d3 from "d3"

export default {
    data () {
        return {
            data: [90.9, 70, 90.2, 25, 10.2, 92],
            reg_data: [
                { date: "24-Apr-23", amount: 93.24 },
                { date: "25-Apr-23", amount: 93.35 },
                { date: "26-Apr-23", amount: 98.77 },
                { date: "27-Apr-23", amount: 99.92 },
                { date: "28-Apr-23", amount: 93.24 },
                { date: "1-May-23", amount: 100.39 },
                { date: "2-May-23", amount: 93.27 },
                { date: "3-May-23", amount: 103.64 },
                { date: "4-May-23", amount: 92.84 },
                { date: "5-May-23", amount: 99.99 },
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
            // x, y값을 표현할 때 d와 i가 존재하는 것을 볼 수 있음
            // 그리고 실제로 x는 xScale을 통해서 실행이됨
            console.log('path()에서 불려짐: 넌 언제 그려지니 ?')
            return d3.line()
                    // d는 실질적인 data를 의미함
                    // i는 해당 data의 index를 의미함
                    .x((d, i) => this.xScale(i))
                    .y((d) => this.yScale(d))
        },
        xScale () {
            // xScale은 쉽게 생각하자면 아래와 같습니다.
            // 데이터를 표현하는 폭이 40, 760의 범주를 가지고 있음
            // domain을 보면 this.data가 들어가서 d, i를 나누고 있음
            // 여기서 실제로 가지고 있는 데이터를 표현하는 화면의 비율에 맞게 스케일 작업을 진행
            return d3.scaleLinear()
                    .range([this.padding, this.width - this.padding])
                    .domain(d3.extent(this.data, (d, i) => i))
        },
        yScale () {
            return d3.scaleLinear()
                    .range([this.height - this.padding, this.padding])
                    .domain([0, 100])
        }
    },
    mounted () {
        const width = 800
        const height = 500
        const svg = d3.select("svg")
                    .attr("width", width + 100)
                    .attr("height", height + 100)
        const g = svg.append("g")

        const parseTime = d3.timeParse("%d-%b-%y")

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
            // transform은 평행 이동, 회전 변환 등등을 수행할 수 있음
            // translate(0, height)와 같으므로
            // 사실상 맨 처음 시작점을 왼쪽 하단으로 잡았다 보면 됨
            // height 값은 꼭대기가 0점이고 숫자가 커지면 아래로 내려감
            // 전체 화면에서 오른쪽으로 40만큼 수평이동 시켜서 왼쪽에 숫자를 출력할 구간을 확보함
            .attr("transform", "translate(40," +  height + ")")
            .call(d3.axisBottom(x))

        // https://observablehq.com/@d3/d3-line
        g.append("g")
            .call(d3.axisLeft(y))
            // 위에서도 40만큼 공간을 확보하므로 전체 구성이 깨지지 않으려면
            // 여기서도 40만큼 수평이동 시켜서 이상하지 않게 만들어야함
            .attr('transform', `translate(40, 0)`)
            .append("text")
            .attr("fill", "#000")
            // 여기서는 transform에 회전 변환을 적용함
            // -90도 회전시켜서 y축에 Price를 표현하였음 (기본값은 x축임)
            .attr("transform", "rotate(-90)")
            // y에 대해 16이기 때문에 회전 변환이 끝난 이후에 y축에 대해 16이 아니라
            // 회전하기 이전에 16에 대해 위의 회전 변환을 적용함
            .attr("y", 16)
            .attr("dy", "0.71em")
            .attr("text-anchor", "end")
            .text("Price: ($)")

        g.append("path")
            .datum(this.reg_data)
            // 위에서도 40만큼 공간을 확보하므로 전체 구성이 깨지지 않으려면
            // 여기서도 40만큼 수평이동 시켜서 그래프 전체의 윤곽이 흐트러지지 않게 구성함
            .attr('transform', `translate(40, 0)`)
            .attr("fill", "none")
            .attr("stroke", "steelblue")
            .attr("stroke-width", 1.5)
            .attr("d", line)
    }
}
</script>

<style lang="">
    
</style>