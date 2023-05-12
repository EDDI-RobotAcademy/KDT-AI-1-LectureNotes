<template lang="">
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
</template>
<script>
export default {
    data () {
        return {
            carouselModel: false,
            bannerPictures: [
                { img: require("@/assets/downloadImg/pikachu.png") },
                { img: require("@/assets/downloadImg/mario.png") },
                { img: require("@/assets/downloadImg/Charizard.jpg") },
                { img: require("@/assets/downloadImg/zelda.png") },
            ],
            cycle: true,
            interval: 2500,
            height: 300,
        }
    }
}
</script>
<style lang="">
    
</style>