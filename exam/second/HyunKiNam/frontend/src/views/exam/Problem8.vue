<template lang="">
    <v-container>
    <div>
        <v-carousel :cycle="cycle" :interval="interval" :height="height" v-model="carouselModel">
            <v-carousel-item v-for="(picture, idx) in bannerPictures" :key="idx">
                <v-sheet :height="height" tile>
                    <v-row>
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
                { img: require("@/assets/downloadImage/Pororo.jpg") },
                { img: require("@/assets/downloadImage/lufy.jpg") },
                { img: require("@/assets/downloadImage/crong.jpg") },
                { img: require("@/assets/logo.png") },
                { img: require("@/assets/logo.svg") },
            ],
            cycle: true,
            interval: 2000,
            height: 500,
        }
    }
}
</script>
<style lang="">
    
</style>