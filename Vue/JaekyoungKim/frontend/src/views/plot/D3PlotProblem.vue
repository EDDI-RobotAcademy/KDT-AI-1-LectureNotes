<template lang="">
    <v-container>
        <svg :width="width" :height="height">
            <path fill="none" stroke="blue" stroke-width="3" :d="path"/>
        </svg>
            <v-layout justify-center>
                <v-dialog v-modle="dialog" persistent max-width="400">
                    <template v-slot:activator="{on}">
                        <v-btn color="primary" dark v-on="on">운동량 추이</v-btn>
                    </template>

                    <v-card>
                        <v-card-title class="headline">{{name}}
                        </v-card-title>
                        <v-card-text> 
                            <h2>운동량이 많은 날이 있지만 일정하지 않습니다. 
                                일정하게 운동을 한다면 더 좋을 것 같아요!
                            </h2>
                        </v-card-text>
                    </v-card>
                </v-dialog>
            </v-layout>

    </v-container>
</template>

<script>

import * as d3 from "d3"
export default {
    data () {
        return {
 
            reg_data: [
                { date: "24-Apr-23", amount: 30 },
                { date: "25-Apr-23", amount: 80 },
                { date: "26-Apr-23", amount: 58 },
                { date: "27-Apr-23", amount: 44 },
                { date: "28-Apr-23", amount: 72 },
                { date: "29-Apr-23", amount: 83 },
                { date: "30-Apr-23", amount: 64 },
            ],
            width: 800,
            height: 500,
            padding: 40,
      
        }
    },

    computed: {
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
  
            .attr('transform', `translate(40, 0)`)
            .append("text")
            .attr("fill", "#000")
       
            .attr("transform", "rotate(-90)")
          
            .attr("y", 16)
            .attr("dy", "0.71em")
            .attr("text-anchor", "end")
            .text("Exercise: (minute)")
        g.append("path")
            .datum(this.reg_data)
          
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