<template lang="">
    <div>
        <h2>게시물 작성</h2>
        <!-- BoardRegisterForm에서 submit을 던져주면 onSubmit 동작 -->
        <board-register-form @submit="onSubmit"/>
    </div>
</template>

<script>

import BoardRegisterForm from '@/components/board/BoardRegisterForm.vue'
import { mapActions } from 'vuex';

const boardModule = 'boardModule'

export default {
    components: {
        BoardRegisterForm,
    },
    name: "BoardRegisterPage",
    methods: {
        // actions에 있는 requestCreateBoardToSpring 사용하겠습니다!
        ...mapActions(
            boardModule, ['requestCreateBoardToSpring']
        ),
        // BoardRegisterForm에서 받은 정보를 바탕으로 requestCraeteBoardToSpring 호출
        // requestCreateBoardToSpring에서 리턴 받은 걸 board에 저장하고
        // board의 데이터 안에 있는 boardId를 가지고 BoardReadPage로 이동
        async onSubmit(payload) {
            const board = await this.requestCreateBoardToSpring(payload)
            console.log('board: ' + JSON.stringify(board))
            await this.$router.push({
                name: 'BoardReadPage',
                params: { boardId: board.data.boardId.toString() }
            })
        }
    }
}
</script>

<style lang="">
    
</style>