<template>
<v-container>
    <p>fhjkdljhfdak</p>
    <v-row>
        <v-col v-for="(image, idx) in images" :key="idx" cols="3">
            <v-img :src="image" aspect-ratio="1" class="lighten-2">
<!--                TODO: v-slot과 placeholder-->
                <template v-slot:placeholder>
                    <v-row class="fill-height ma-0" align="center" justify="center">
                        <v-progress-circular indeterminate color="grey lighten-5"/>
                    </v-row>
                </template>
            </v-img>

        </v-col>
    </v-row>
    <v-img :src="require(`@/assets/downloadImg/${imageName}`)"
           aspect-ratio="1" class="lighten-2"/>
</v-container>
</template>

<script>
export default {
    name: "ImageGalleryTest",
    data() {
        return {
            imageName: "Java.png",
            images: [
                require('@/assets/downloadImg/vue.png'),
                require('@/assets/downloadImg/python.png'),
                require('@/assets/downloadImg/vuetify.svg'),
            ]
        }
    }
}
</script>

<style scoped>

</style>