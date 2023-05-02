<template lang="">
    <v-container>
        <v-row>
            <v-col v-for="(image, idx) in images" :key="idx" cols="3">
                <v-img :src="image" aspect-ratio="1" class="grey lighten-2">
                    <template v-slot:placeholder>
                        <v-row class="fill-height ma-0" align="center" justify="center">
                            <v-progress-circular indeterminate color="grey lighten-5"/>
                        </v-row>
                    </template>
                </v-img>
            </v-col>
        </v-row>

        <!-- 
            변수에 들어있는 값을 이미지로 사용하려면 이런 방식을 사용 
            우리들은 이 방식을 많이 사용할 것. 
            사진을 다운받지 않아 주석을 걸어두었음
            -->
            <!-- <v-img :src="require(`@/assets/downloadImg/${imageName}`)" 
                    aspect-ratio="1" class="grey lighten-2"/> -->
                
    </v-container>
</template>
<script>
export default {
    data () {
        return {
            imageName: "사진이름",
            Image: [
                // 사진을 다운받지않아 주석을 걸어두었음
                // require('@/assets/downloadImg/사진이름'),
                // require('사진의 경로1/사진이름'),
                // require('사진의 경로2/사진이름')
                // 사진이 많아지면 로딩시간이 걸림
                // 로고를 가져다 박는다던지 특정 위치에 사진이 박혀있어야 하는경우
                // 이런 방식을 사용
            ]
        }
    }
    
}
</script>
<style lang="">
    
</style>