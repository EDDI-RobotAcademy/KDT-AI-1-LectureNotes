<template lang="">
    <v-container>
        <v-row>
            <v-col v-for="(image, idx) in images" :key="idx" cols="4">
                <v-img :src="image" aspect-ratio="1" class="grey lighten-2">
                    <template v-slot:placeholder>
                        <v-row>
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
    data() {
        return {
            images: [
                require('@/assets/downloadImage/Pororo.jpg'),
                require('@/assets/downloadImage/lufy.jpg'),
                require('@/assets/downloadImage/crong.jpg'),
                require('@/assets/logo.png'),
                require('@/assets/logo.svg'),
            ]
        }
    }
}
</script>

<style lang="">
    
</style>