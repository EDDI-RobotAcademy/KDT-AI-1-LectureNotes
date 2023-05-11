<template>
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
    name: "CarouselTestPage",
    data() {
        return {
            bannerPictures: [
                {img: require("@/assets/downloadImg/java.png")},
                {img: require("@/assets/downloadImg/vue.png")},
                {img: require("@/assets/downloadImg/python.png")},
            ],
            carouselModel: false,
            cycle: true,
            interval: 2500,
            height: 200
        }
    }
}
</script>

<style scoped>

</style>