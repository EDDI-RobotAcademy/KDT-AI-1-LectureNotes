<template lang="">
    <div>
        <h2>게시물 작성</h2>
        <board-register-form @submit="onSubmit"/>

    </div>
</template>
<script>
import BoardRegisterForm from '@/components/board/BoardRegisterForm'
import BoardModule from '@/store/board/BoardModule';
import { mapActions } from 'vuex';
const boardModul='boardMoudle'
export default {
    components:{
        BoardRegisterForm,
    },
    methods: {
        ...mapActions(
            BoardModule,['requestCreateBoardToSpring']
        ),
        async onSubmit(payload){
            const board=await this.requestCreateBoardToSpring(payload)
            console.log('board: '+JSON.stringify(board))
        }
    },
}
</script>
<style lang="">
    
</style>