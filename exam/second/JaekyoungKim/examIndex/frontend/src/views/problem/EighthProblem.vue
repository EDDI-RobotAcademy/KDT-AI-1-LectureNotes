<template lang="">
    <v-container>
        <div>
            <!--
                :cycle 값이 트루일때 사이클을 돌게 한다.
                :interval 사이클 시간 설정 하는 부분
                :height 사진 높이 설정하는 부분
                :src v-img에 들어가 사진의 주소를 바인드함

                v-for="(picture, idx) in bannerPictures" :key="idx"
               picture는 bannerPictures안의 반복할 것에 대한 명시적인 이름
               리스트의 수량 만큼 반복한다

        -->
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
                { img: require("@/assets/downloadImg/glass1.png") },
                { img: require("@/assets/downloadImg/glass2.png") },
                { img: require("@/assets/downloadImg/glass3.png") },
                { img: require("@/assets/downloadImg/glass4.jpg") },
                { img: require("@/assets/downloadImg/glass5.png") },
                { img: require("@/assets/downloadImg/glass6.jpg") },
                { img: require("@/assets/downloadImg/glass7.png") },
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