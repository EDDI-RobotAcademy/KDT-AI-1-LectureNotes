<template lang="">
    <div>
        <table cols="20">
            <tr>
                <th>1</th>
                <th>2</th>
                <th>3</th>
            </tr>
            <tr>
                <td>4</td>
                <td>5</td>
                <td>6</td>
            </tr>
            <tr>
                <td>7</td>
                <td>8</td>
            </tr>
        </table>
        <v-row>
            <v-col v-for="(image, idx) in processedImages" :key="idx" cols="2">
                <v-img :src="image" aspect-ratio="1" class="grey lighten-2">
                    <template v-slot:placeholder>
                        <v-row class="fill-height ma-0" align="center" justify="center">
                            <v-progress-circular indeterminate color="grey lighten-5"/>
                        </v-row>
                    </template>
                </v-img>
            </v-col>
        </v-row>
    </div>
</template>
<script>
import { mapActions } from 'vuex';
const filesModule = 'filesModule'
export default {
    data () {
        return {
            processedImages: [],
        }
    },
    methods: {
        ...mapActions(filesModule, ['requestImageListToSpring']),
    },
    async created () {
        const receivedImagePath = await this.requestImageListToSpring()
        this.processedImages = receivedImagePath.map(
            data => require('@/assets/uploadImgs/' + data.imagePath))
            // 왼쪽을 오른쪽으로 가공해서 바꿔침 (각각의 요소마다 적용함): 람다(Lambda)라고 부름
    }
}
</script>

<style scoped>
    table, td, th{
        border:1px solid black
    }
</style>