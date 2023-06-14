<template lang="">
    < <v-container>
        <v-row>
            <v-col v-for="(image, idx) in images" :key="idx" cols="3">
                <v-img :src="image" aspect-ratio="1" class="grey lighten-2">
                    <template v-slot:placeholder>
                        <v-row class="fill-height ma-0" align="center" justify="center">
                            <v-progress-circular indeterminate color="grey lighten-1"/>
                        </v-row>
                    </template>
                </v-img>
            </v-col>
        </v-row>
</template>
<script>
export default {
    data() {
        return {
            images: [
                require('@/assets/img/cat.jpg'),
                require('@/assets/img/fireflower.jpg'),
                require('@/assets/img/tomato.jpg'),
            ]
        }
    },
}
</script>
<style lang="">
    
</style>