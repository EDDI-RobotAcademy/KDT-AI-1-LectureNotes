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
    data() {
        return {
            carouselModel: false,
            bannerPictures: [
                { img: require("@/assets/downloadImg/apeach.jpg") },
                { img: require("@/assets/downloadImg/jjangGu.png") },
                { img: require("@/assets/downloadImg/mario_run.jpg") },
                { img: require("@/assets/downloadImg/peach_princess.jpg") },
            ],
            cycle: true,
            interval: 2500,
            height: 200,
        }
    }
}
</script>

<style lang="">
    
</style>

<!-- 
            cycle은 얼마나 떠 있을지 interval로 값을 줄 수 있음 
            높이값도 줄 수 있음
        -->
        <!-- 
            선생님도 검색해서 확인 하심 
            검색해서 사용해도 되는지 알 수 있도록 연습해보자
            item 검색해서 type이 any라고 나옴 이게 무슨 뜻이지?
        -->
        <!-- v-row justify 값을 주면 위치가 똑바로 지정되도록 해주는 것 -->
        <!-- contain으로 carousel 내부에 이미지를 배치하도록 한다? 맞나? -->
