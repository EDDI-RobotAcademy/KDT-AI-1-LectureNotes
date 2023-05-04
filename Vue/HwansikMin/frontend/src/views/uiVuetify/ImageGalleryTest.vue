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
        
        <v-img :src="require(`@/assets/downloadImg/${imageName}`)"
                aspect-ratio="1" class="grey lighten-2"/>
    </v-container>
</template>

<script>
export default {
    data () {
        return {
            imageName: "cloud.png",
            images: [
                require('@/assets/downloadImg/mario_run.png'),
                require('@/assets/downloadImg/loz.jpg'),
                require('@/assets/downloadImg/cloud.png'),
                require('@/assets/downloadImg/naruto.jpg'),
            ]
        }
    }
}
</script>

<style lang="">
    
</style>