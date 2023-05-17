<template lang="">
    <v-container>
        <p>{{receivedData}}</p>
        <svg :width="width" :height="height">
            <path fill="none" stroke="blue" stroke-width="3" :d="path"/>
        </svg>
    </v-container>
</template>

<script>
import axios from "axios"
import * as d3 from "d3"

 export default {
     data () {
         return {
             receivedData: [],
             width: 800,
             height: 500,
             padding: 40,
         }
     },
     computed: {
        path() { //computed에서는 너무 많은 작업을 하면 오류..?따로빼서 가져오는 것을 추천
            // this.receivedData = await axios.get("http://localhost:7777/d3problem/exercise") 
            //         .then((res)=>{
            //             console.log(res.data)
            //             //this.receivedData=res.data
            //             return res.data
            //         })

            return  this.line(this.receivedData)
             
         },
         line () {
             console.log('path()에서 불려짐: 넌 언제 그려지니 ?')
             return d3.line()
                     .x((d, i) => this.xScale(i))
                     .y((d) => {console.log(1); return this.yScale(d.exercise)})
         },
         xScale () {
             return d3.scaleLinear()
                     .range([this.padding, this.width - this.padding])
                     .domain([0, 6])
         },
         yScale () {
            console.log('yScale() 나 지금 그려짐 ?')
             return d3.scaleLinear()
                     .range([this.height - this.padding, this.padding])
                     .domain([0, 100])
         }
    }, 
    async created () { 
        this.receivedData = await axios.get("http://localhost:7777/d3problem/exercise") 
                    .then((res)=>{
                        console.log(res.data)
                        //this.receivedData=res.data
                        return res.data
                    })

    },   
    mounted () {
        const width = 800
        const height = 500
        const svg = d3.select("svg")
                    .attr("width", width + 100)
                    .attr("height", height + 100)
        const g = svg.append("g")
        
        g.append("g")
            .attr("transform", "translate(0," +  (height-40) + ")")
            .call(d3.axisBottom(this.xScale).ticks(7))
            .append("text")

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