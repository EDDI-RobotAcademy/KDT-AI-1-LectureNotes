<template lang="">
    <v-container>
        <h2>Vue 문제 은행 6</h2>
        <v-img :src="require(`@/assets/downloadImg/${name}`)"
                aspect-ratio="1" class="grey lighten-2" />
    </v-container>
</template>

<script>
import { mapActions, mapState } from "vuex";

const imageModule = "imageModule";

export default {
    computed: {
        ...mapState(imageModule, ["name"]),
    },
    mounted() {
        this.requestImageToSpring();
    },
    methods: {
        ...mapActions(imageModule, ["requestImageToSpring"]),
    }
}
</script>

<style lang=""></style>