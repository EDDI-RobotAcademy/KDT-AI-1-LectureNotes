<template lang="">
    <v-container>
        <v-row>
            <v-col v-for="(image, idx) in images" :key="idx" cols="3">
                <v-img :src="image" aspect-ratio="1" class="grey lighten-2"/>

                <!--
                    plceholder는 없어도 되나, 이게 없으면 밋밋한 느낌이 든다.
                -->
                    <template v-slot:plceholder>
                        <v-row class="fill-height ma-0" align="center" justify="center">
                            <v-progress-circular indeterminate color="grey lighten-2"/>
                        </v-row>
                    </template>
            </v-col>
        </v-row>
        
        <!-- 
            ● 변수에 들어가 있는 이름을 이렇게 사용 (우리는 주로 이런 방식으로 사용하게 될 것이다.)
        -->
        <v-img :src="require(`@/assets/downloadImg/${imageName}`)"
                aspect-ratio="1" class="grey lighten-2" />
    </v-container>
</template>

<script>
export default {
    data () {
        return {
            // ● 변수를 이용하여 사용자 원하는 사진의 경로를 넣어주는 경우
            imageName: "cloud.png",
            images: [
                // 이와 같은 방식은 이미 저장되어 있는 사진의 경우 (이런 방식은 로고를 넣을 때 사용한다.)
                require('@/assets/downloadImg/mario_run.png'),
                require('@/assets/downloadImg/cloud.png'),
                require('@/assets/downloadImg/loz.jpg'),
                require('@/assets/downloadImg/naruto.jpg'),
            ]
        }
    }
    
}
</script>

<style lang=""></style>