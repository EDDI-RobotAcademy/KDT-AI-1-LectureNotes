<template lang="">
    <!-- 
        vuetify를 사용해서 이미지 갤러리를 만들어봅시다.
    -->
    <v-container>
        <h2>이미지 갤러리</h2>
        <v-row>
            <v-col v-for="(image, idx) in images" :key="idx" cols="3">
                <v-img :src="image" aspect-ratio="1" class="grey lighten-2"/>

                <template v-slot:plceholder>
                    <v-row class="fill-height ma-0" align="center" justify="center">
                        <v-progress-circular indeterminate color="grey lighten-2"/>
                    </v-row>
                </template>
            </v-col>
        </v-row>

        <v-img :src="require(`@/assets/downloadImg/${imageName}`)"
                aspect-ratio="1" class="grey lighten-2" />
    </v-container>
</template>

<script>

export default {
    data() {
        return {
            imageName: "mario.jpg",
            images: [
                require('@/assets/downloadImg/mario.jpg'),
                require('@/assets/downloadImg/mario_funch.jpg'),
                require('@/assets/downloadImg/mario.jpg'),
                require('@/assets/downloadImg/mario_funch.jpg'),
            ]
        }
    },
    
}
</script>

<style lang="">
    
</style>