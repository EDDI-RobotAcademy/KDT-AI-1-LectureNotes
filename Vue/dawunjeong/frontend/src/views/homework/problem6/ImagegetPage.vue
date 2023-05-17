<template lang="">
    <div>
        <h2>이미지 읽어오기</h2>
        <v-container>
            <!-- <h3>1번 방식(버튼 클릭하면 랜덤 캐릭터)</h3>
            <v-btn @click="onSubmit">뉴뉴</v-btn>
            <v-img v-if="imageName" :src="require(`@/assets/downloadImg/${imageName}`)"/> -->
            <h3>2번 방식(마운트될 때 알아서 캐릭터 가져오기)</h3>
            <v-img v-if="imageName" :src="require(`@/assets/downloadImg/${imageName}`)"></v-img>
        </v-container>
    </div>
</template>

<script>
import { mapActions } from 'vuex'
import axiosInst from '@/utility/axiosInst'

const uiVuetifyModule = 'uiVuetifyModule'

export default {
    data () {
        return {
            imageName: '',
        }
    },
    // 2번 방식의 state 이용
    async mounted () {
        this.imageName = await this.requestImageNameToSpring()
    },
    methods: {
        ...mapActions(uiVuetifyModule, ['requestImageNameToSpring']),
    }
    
    // 1번 방식의 버튼 매서드
    // methods: {
    //     onSubmit () {
    //         axiosInst.get('/vuetify/img')
    //         .then((res) => {
    //             console.log('통신됨')
    //             this.imageName = res.data
    //             console.log(this.imageName)
    //         })
    //     },
    // }
}
</script>

<style lang="">
    
</style>