<template lang="">
    <v-container>
        <div>
            <v-carousel :cycle="cycle" :interval="interval" :height="height" v-model="carouselModel">
                <v-carousel-item v-for="(picture, idx) in bannerPictures" :key="idx">
                    <v-sheet :height="height" title>
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
                { img: require("@/assets/downloadImg/image.jpg") },
                { img: require("@/assets/downloadImg/image2.jpg") },
                { img: require("@/assets/downloadImg/image3.jpg") },
                { img: require("@/assets/downloadImg/image4.jpg") },
            ],
            cycle: true,
            interval: 2000,
            height: 200,
        }
    }
}
</script>

<style lang="">
    
</style>