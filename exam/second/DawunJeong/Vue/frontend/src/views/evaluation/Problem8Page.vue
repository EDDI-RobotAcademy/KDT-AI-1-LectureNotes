<template lang="">
    <!--
        문제 8번: 
        크로셀 기능을 활용해서 2초마다 바뀌는 메인 배너를 만들어봅시다.
    -->
    <v-container>
        <div>
            <v-carousel :cycle="cycle" :interval="interval" :height="height" v-model="carouselModel">
                <v-carousel-item v-for="(picture, idx) in bannerPictures" :key="idx">
                    <v-sheet :height="height" tile>
                        <v-row class="fill-height" align="center" justify="center">
                            <v-img :src="picture.img" :height="height" contain/>
                        </v-row>
                    </v-sheet>
                </v-carousel-item>
            </v-carousel>
        </div>
    </v-container>
    </template>
    
    <script>
    export default {
        data () {
            return {
                carouselModel: false,
                bannerPictures: [
                    { img: require("@/assets/downloadImg/naruto.png")},
                    { img: require("@/assets/downloadImg/kakashi.png")},
                    { img: require("@/assets/downloadImg/sasuke.png")},
                ],
                cycle: true,
                interval: 2000,
                height: 600,
            }
        }
    }
    </script>
    
    <style lang="">
        
    </style>