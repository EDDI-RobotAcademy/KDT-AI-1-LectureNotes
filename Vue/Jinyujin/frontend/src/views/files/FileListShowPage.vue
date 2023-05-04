<!-- 
        업로드된 이미지 띄우기
        여기서 이미지 갤러리처럼 받은 이미지를 띄울 수 있음
        다 구성하고 홈페이지에서 사진 첨부하면 뷰 uploadImgs에 사진이 추가되어야 하는 구조인 것임
        이제 저장된 이미지는 뭘할 수 있지? 
        홈페이지에서 이미지를 넣어서 상품이 보이게 할 수 있음
        경로는 uploadImgs로 바꿔서!
-->
<template lang="">
    <v-container>
        <v-row>
            <v-col v-for="(image, idx) in processedImages" :key="idx" cols="3">
                <v-img :src="image" aspect-ratio="1" class="grey lighten-2">
                    <template v-slot:placeholder>
                        <v-row class="fill-height ma-0" align="center" justify="center">
                            <v-progress-circular indeterminate color="grey lighten-5"/>
                        </v-row>
                    </template>
                </v-img>
            </v-col>
        </v-row>
    </v-container>
</template>

<script>

const filesModule = 'filesModule'
import { mapActions } from 'vuex';

export default {
    // 람다 문법
    // receivedImagePath에서 가져와서 경로쪽으로 바꿔치기 한다는 것 
    // 리스트 쇼페이지에서 디버그 → created에서 
    // 스프링에 잘 요청됐는지 확인하기 위함
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
        // receivedImagePath로 이미지경로 리스트를 받아
        this.processedImages = receivedImagePath.map(
            data => require('@/assets/uploadImgs/' + data.imagePath))
        // 왼쪽을 오른쪽으로 가공해서 바꿔침 (각각의 요소마다 적용함): 람다(Lambda)라고 부름
        // require: 파일 경로를 불러옴
        // data는 변수 이름, 바꾸면 왼쪽 오른쪽 둘다 바꿔주면 됨
        // receivedImagePath 안에 있는 data를 오른쪽으로 가공해줘라
        // 그래서 저장할 수 있는 것
    }
}

</script>

<style lang="">
</style>