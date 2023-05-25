<template lang="">
    <!-- 
        크로셀 기능을 활용해서 2초마다 바뀌는 메인 배너를 만들어봅시다.
    -->
    <v-container>
        <h2>크로셀 갤러리</h2>
        <div>
            <v-carousel :cycle="cycle" :interval="interval" :height="height" v-model="model">
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
    data() {
        return {
            carouselModel: false,
            bannerPictures: [
                { img: require('@/assets/downloadImg/mario.jpg') },
                { img: require('@/assets/downloadImg/mario_funch.jpg') },
                { img: require('@/assets/downloadImg/mario.jpg') },
                { img: require('@/assets/downloadImg/mario_funch.jpg') },
            ],
            cycle: true,
            interval: 2000,
            height: 200,
        }
    },
    
}
</script>

<style lang="">
    
</style>