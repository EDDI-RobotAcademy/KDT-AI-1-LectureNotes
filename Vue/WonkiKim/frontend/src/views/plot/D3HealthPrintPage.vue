<template>
    <v-container>
        <svg :width="width" :height="height">
            <path :d="path" fill="none" stroke="blue"/>
        </svg>
        <v-btn @click="newData">new</v-btn>|
    </v-container>
</template>

<script>
import * as d3 from "d3";
import axiosInst from "@/utility/axiosInst";

export default {
    name: "D3HealthPrintPage",
    data() {
        return {
            healthList:[
            ],
            width: 800,
            height: 400,
            padding: 40,
        }
    },
    computed: {
        path() {
            return this.line(this.healthList)
        },
        line() {
            const svg = d3.select("svg")
            const g = svg.append('g')

            g.append('g')
                .attr("transform", "translate(0, " + (this.height - 40) + ")")
                .call(d3.axisBottom(this.xScale).ticks(this.healthList.length))
                .append("text")

            return d3.line()
                .x((d, i)=> this.xScale(i))
                .y((d=>this.yScale(d.healthAmount)))
        },
        xScale () {
            return d3.scaleLinear()
                .range([this.padding, this.width - this.padding])
                .domain([0, this.healthList.length])
        },
        yScale() {
            return d3.scaleLinear()
                .range([this.height - this.padding, this.padding])
                .domain([0, 100])
        }
    },

    async beforeMount() {
        this.healthList = await this.requestHealthDataToSpring()
        console.log(JSON.stringify(this.healthList))
    },
    mounted() {
        const svg = d3.select("svg")
            .attr("width", this.width+100)
            .attr("height", this.height+100)
        const g = svg.append('g')

        // g.append('g')
        //     .attr("transform", "translate(0, " + (this.height - 40) + ")")
        //     .call(d3.axisBottom(this.xScale).ticks(this.healthList.length))
        //     .append("text")

        g.append('g')
            .call(d3.axisLeft(this.yScale))
            .attr("transform", "translate(40, 0)")
            .append("text")
            .attr("fill", "#FF0000")
            .attr("transform", "rotate(-90)")
            .attr('y', 16)
            .attr('x', -30)
            .attr('dy', '1em')
            .attr("text-anchor", "end")
            .text("운동량")





    },
    methods: {
        async requestHealthDataToSpring() {
            return await axiosInst.get('/d3-test/get-health-info')
                .then((res) => {
                    return res.data
                })
        },
        async newData() {
            this.healthList = await this.requestHealthDataToSpring()
            console.log(JSON.stringify(this.healthList))
        },
    }
}
</script>

<style scoped>

</style>