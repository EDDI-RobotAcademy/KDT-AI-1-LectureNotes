<template lang="">
    <!--
        문제 7번: 
        vuetify를 사용해서 이미지 갤러리를 만들어봅시다.
    -->
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
    </v-container>
</template>

<script>
export default {
    data () {
        return {
            imageName: "naruto.png",
            images: [
                require('@/assets/downloadImg/naruto.png'),
                require('@/assets/downloadImg/kakashi.png'),
                require('@/assets/downloadImg/sasuke.png'),
            ]
        }
    }
}
</script>

<style lang="">
    
</style>