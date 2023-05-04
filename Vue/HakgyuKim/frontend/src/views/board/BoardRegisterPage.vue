<template lang="">
    <div>
        <h2>게시물 작성</h2>
        <BoardRegisterForm @submit="onSubmit"/>
    </div>
</template>

<script>
import { mapActions } from 'vuex';
import BoardRegisterForm from '@/components/board/BoardRegisterForm.vue'

const boardModule = 'boardModule'

export default {
    components: {
        BoardRegisterForm,
    },
    name: "BoardRegisterPage",
    methods: {
        ...mapActions(
            // 게시물 등록 매서드
            boardModule, ['requestCreateBoardToSpring']
        ),
        // 게시물 등록 후 작성된 게시물의 readPage로 이동
        async onSubmit (payload) {
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