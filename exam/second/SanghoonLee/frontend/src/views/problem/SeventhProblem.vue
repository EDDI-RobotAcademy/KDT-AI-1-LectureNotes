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
    </v-container>
</template>

<script>
export default {
    data () {
        return {
            images: [
                require('@/assets/downloadImg/glass1.png'),
                require('@/assets/downloadImg/glass2.png'),
                require('@/assets/downloadImg/glass3.png'),
                require('@/assets/downloadImg/glass4.jpg'),
                require('@/assets/downloadImg/glass5.png'),
                require('@/assets/downloadImg/glass6.jpg'),
                require('@/assets/downloadImg/glass7.png'),
            ]
        }
    }
}
</script>

<style lang="">
    
</style>