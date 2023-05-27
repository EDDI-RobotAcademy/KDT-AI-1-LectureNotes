<template lang="">
    <v-container>
        <div>
            <v-carousel :cycle="cycle" :interval="interval" :height="height" v-model="carouselModel">
            <v-carousel-item v-for="(myImg,idx) in banner" :key='idx'>
                <v-sheet :height="height" tile>
                    <v-row class="fill-height" align="center" justify="center">
                        <v-img :src="myImg.img" :height="height" contain/>
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
            carouselModel:false,
            banner:[
                {img:require("@/assets/img/cat.jpg")},
                {img:require("@/assets/img/fireflower.jpg")},
                {img:require("@/assets/img/tomato.jpg")}
            ],
            cycle:true,
            interval: 2000,
            height: 300,

        }
    },
    
}
</script>
<style lang="">
    
</style>