<template lang="">
    <v-container>
        <v-img :src="require(`@/assets/downloadImage/${imageName}`)"
                aspect-ratio="1" class="grey lighten-2"/>
        </v-image>
    </v-container>
</template>

<script>

import { mapState, mapActions } from 'vuex';
const uiVuetifyModule = 'uiVuetifyModule'

export default {
    data() {
        return {
            imageName: '',
        }
    },
    // computed: {
    //     ...mapState(
    //         uiVuetifyModule, ['imageName']
    //     )
    // },
    async mounted() {
        this.imageName =
            await this.requestImageToSpring();
    },
    methods: {
        ...mapActions(
            uiVuetifyModule, ['requestImageToSpring'])
    },
}
</script>

<style lang="">
    
</style>