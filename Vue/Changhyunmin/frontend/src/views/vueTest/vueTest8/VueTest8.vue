<!-- 8. 크로셀 기능을 활용해서 2초마다 바뀌는 메인 배너를 만들어봅시다. -->
<template lang="">
    <v-container>
        <div>
            <v-carousel :cycle="cycle" :interval="interval" :height="height"v-model="carouselModule">
                <v-carousel-item v-for="(picture, idx) in bannerPictures" :key="idx">
                    <v-sheet :height="height" tile>
                        <v-row class="fill-hight" align="center" justify="center">
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
    data() {
        return {
            carouselModel: false,
            bannerPictures: [
                { img: require("@/assets/downloadImg/FF7.jpg") },
                { img: require("@/assets/downloadImg/mario.jpg") },
                { img: require("@/assets/downloadImg/sonic.png") },
            ],
            cycle: true,
            interval: 2500,
            height: 600,

        }
    },    
}
</script>
<style>
    
</style>