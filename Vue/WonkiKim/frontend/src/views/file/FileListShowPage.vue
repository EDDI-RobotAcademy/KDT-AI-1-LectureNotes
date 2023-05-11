<template>
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
import {mapActions} from 'vuex';

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
    }
}

</script>

<style lang="">

</style>