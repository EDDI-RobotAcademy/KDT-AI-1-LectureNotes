<template>
    <v-container>
        <v-row>
            <v-col sols="12">
                <v-img :src="imagePath">
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
import {mapActions} from "vuex";
const uiVuetifyModule = 'uiVuetifyModule'
export default {
    name: "PrintImageTest",
    data() {
        return {
            imagePath: '',
        }
    },
    async mounted() {
        const imageName = await this.requestImagePathToSpring()
        this.imagePath = require(`@/assets/downloadImg/${imageName}`)
    },
    methods: {
        ...mapActions(uiVuetifyModule, ['requestImagePathToSpring'])
    }
}
</script>

<style scoped>

</style>