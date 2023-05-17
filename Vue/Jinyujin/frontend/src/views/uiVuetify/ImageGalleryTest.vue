<template lang="">
    <v-container>
        <v-row>
            <v-col v-for="(image, idx) in images" :key="idx" cols="3">
                <!-- 
                    이 경우 cols="auto"라고 하면 여기서는 v-row의 폭이 정의되어 있지 않기 때문에 
                    올바른 값이 나오지 않는다
                -->
                <v-img :src="image" aspect-ratio="1" class="grey lighten-2">
                    <!-- aspect-ratio를 사용하면 그림을 이미지의 가로:높이 비율에 맞춰 자를 수 있다 -->
                    <template v-slot:placeholder>
                        <!-- 
                            뱅글뱅글 돌아가는 로딩 표현
                            이걸 없애면 사진에서 뱅글뱅글이 계속 돌아가있음
                            즉, 이미지가 로드되는 동안 표시할 slot을 placeholder로 표시하겠다는 뜻
                            placeholder는 이미지가 뜨기 전 로드되는 것을 보여줌
                            그리고 이미지가 뜨면 v-progress-circular가 작동하지 못하게 함
                        -->
                        <v-row class="fill-height ma-0" align="center" justify="center">
                            <v-progress-circular indeterminate color="grey lighten-5"/>
                            <!-- 그리고 뱅글뱅글 돌아가는 원을 보여주는게 v-progress-circular -->
                        </v-row>
                    </template>
                </v-img>
            </v-col>
        </v-row>

        <v-img :src="require(`@/assets/downloadImg/${imageName}`)"
                aspect-ratio="1" class="grey lighten-2"/>
    </v-container>
</template>

<script>

export default {
    data() {
        return {
            imageName: "jjangGu.png",
            images: [
                require('@/assets/downloadImg/mario_run.jpg'),
                require('@/assets/downloadImg/apeach.jpg'),
                require('@/assets/downloadImg/jjangGu.png'),
                require('@/assets/downloadImg/peach_princess.jpg'),
            ]
        }
    },
}
</script>
<style lang="">
    
</style>