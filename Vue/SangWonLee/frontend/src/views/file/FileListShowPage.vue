<template lang="">
    <v-container>
        <v-row>
            <v-col v-for="(image, idx) in processedImages" :key="idx" cols="3">
                <!--
                    v-col은 v-row 내부에서 사용되며, 그리드의 열을 나타낸다.
                    cols = "1"은 열이 그리드의 1/12 너비를 차지하도록 한다.
                    Vuetify 그리드 시스템은 기본적으로 12개의 열로 구성되어있기 때문 
                    processedImages 배열을 반복해서 각 이미지를 생성한다.
                -->
                <v-img :src="image" aspect-ratio="1" class="grey lighten-2">
                    <!--
                        :src 속성에 image 변수로 바인딩 되어있어 이미지 소스를 지정

                    -->
                    <template v-slot:placeholder>
                        <!--
                            v-img 구성요소의 placeholder 슬롯에 컨텐츠를 삽입하는 코드이다.
                            placeholder 슬롯은 이미지가 로드되기 전에 표시되는 컨텐츠를 정의한다.
                            이 경우에 v-progress-circular가 표시된다.
                        -->
                        <v-row class="fill-height ma-0" align="center" justify="center">
                            <!--
                                v-row : 행 구성 요소
                                fill-height ma-0 : 행이 부모 컨테이너의 높이를 채우고, ma-0(마진)을 0으로 설정한다.
                                align : 행의 수직 정렬, justify : 행의 수평 정렬
                            -->

                            <v-progress-circular indeterminate color="grey lighten-5"/>
                            <!--
                                Vuetify의 원형 진행 표시기 구성 요소 (이미지 로딩할 때 동그라미 동글동글 돌아가는 거)
                            -->
                        </v-row>
                    </template>
                </v-img>
            </v-col>
        </v-row>
    </v-container>
</template>

<script>
import { mapActions } from 'vuex';
const filesModule = 'filesModule'
export default {
    data() {
        return {
            processedImages: [],
        }
    },
    methods: {
        ...mapActions(filesModule, ['requestImageListToSpring']),
    },
    async created() {
        const receivedImagePath = await this.requestImageListToSpring()
        this.processedImages = receivedImagePath.map(
            data => require('@/assets/uploadImgs/' + data.imagePath))
        // 왼쪽을 오른쪽으로 가공해서 바꿔침 (각각의 요소마다 적용함): 람다(Lambda)라고 부름
    }
}
</script>

<style lang="">
    
</style>