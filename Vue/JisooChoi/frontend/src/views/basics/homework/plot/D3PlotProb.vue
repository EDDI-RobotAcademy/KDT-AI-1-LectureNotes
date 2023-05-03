<template lang="">
    <!-- 
        서버에 일주전의 운동량이 기록되어 있습니다. (-> 백엔드에 기록)
        운동량은 100이 최대고 0이 최저입니다. (-> 백에서 랜덤 값으로 받아온다.)
        
        일주일(7일)간의 운동량을 알아서 기록해주는 장치가 있다 가정하겠습니다.
        이 장비가 서버에 데이터를 배치하였다 가정하고 시작합니다.
        (데이터는 여러분들 마음대로 배치해도 무방하며 랜덤으로 배치해도 됩니다)

        7일간의 데이터를 확보하여 화면에 뿌려주고
        현재 추이가 운동량이 올라가는지 떨어지는지 혹은 무난한지를 알려주세요.
    -->
    <div>
        <v-container>
            <svg :width="width" :height="height">
            <path fill="none" stroke="orange" stroke-width="3" :d="path"/>
        </svg>
        </v-container>
    </div>
</template>

<script>
import * as d3 from "d3"

export default {
    data() {
        return {
            data: [35, 50.5, 20, 80, 60.8, 75, 70.7], // 운동량
            reg_data: [ // 날짜
                { date: "1-May-23", amount: 0 },
                { date: "2-May-23", amount: 80 },
                { date: "3-May-23", amount: 85 },
                { date: "4-May-23", amount: 60 },
                { date: "5-May-23", amount: 70 },
                { date: "6-May-23", amount: 40 },
                { date: "7-May-23", amount: 80 },
                { date: "8-May-23", amount: 70 },
                { date: "9-May-23", amount: 100 },
            ],
            width: 800,
            height: 500,
            padding: 0,
        }
    },
    computed: {
        path () {
            return this.line(this.data)
        },
        line() {
            return d3.line()
                    .x((d, i) => this.xScale(i)) // i는 인덱스 
                    .y((d) => this.yScale(d)) // d는 데이터
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
                    .rangeRound([height, 0]) // 구간 설정하는 자리

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

        // y축
        g.append("g")
            .call(d3.axisLeft(y))
            .attr('transform', `translate(40, 0)`)
            .append("text")
            .attr("fill", "#000")
            .attr("transform", "rotate(-90)")
            .attr("y", 16)
            .attr("dy", "0.71em")
            .attr("text-anchor", "end")
            .text("운동량(최저:0 / 최고: 100)")

        // x축
        g.append("path")
            .datum(this.reg_data)
            .attr("fill", "none")
            .attr("stroke", "green")
            .attr("stroke-width", 1.5)
            .attr("d", line)
    }
}
</script>

<style lang="">
    
</style>