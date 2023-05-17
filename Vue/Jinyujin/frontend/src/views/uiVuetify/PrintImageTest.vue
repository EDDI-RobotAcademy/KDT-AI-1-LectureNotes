<template lang="">
    <v-container>
        <v-row>
            <v-col cols="12">
                <v-img v-if="imageName" :src="require(`@/assets/downloadImg/${imageName}`)"
                        aspect-ratio="1" class="grey lighten-2">
                    <template v-slot:placeholder>
                        <v-row class="fill-height ma-0" align="center" justify="center">
                            <v-progress-circular indeterminate color="grey lighten-5"/>
                        </v-row>
                    </template>
                </v-img>
            </v-col>
        </v-row>
        <h2>안녕 난 짱구야</h2>
    </v-container>
</template>

<script>
import { mapActions } from 'vuex'
const uiVuetifyModule = 'uiVuetifyModule'
export default {
    data () {
        return {
            imageName: '',
        }
    },
    async mounted () {
        this.imageName = await this.requestImagePathToSpring()
        // async - await를 하지 않았을 때 사진이 뜨지 않는 문제 발생
        // 게시판 구현할 때 삭제 부분에서 async - await을 해주지 않으면 
        // requestDeleteBoardToSpring이 완료되지 않았는데 router.push를 하는 경우가 발생한다고 하였음
        // requestImagePathToSpring이 동작하기 전에 
        // mounted 해버려서 뜨지 않는 경우가 발생한 것
        // => 비동기 문제
        // 사진은 무겁기 때문에 걸어줘야 한다고 하심
    },
    methods: {
        ...mapActions(uiVuetifyModule, ['requestImagePathToSpring']),
    }
}
</script>
<style lang="">
    
</style>