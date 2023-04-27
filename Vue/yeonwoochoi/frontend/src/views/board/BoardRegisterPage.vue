<template lang="">
    <div>
        <h2>게시물 작성</h2>
        <!-- 디버그 -->
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
        ...mapActions(
            boardModule, ['requestCreateBoardToSpring']
        ),
        // payload는 actions에 전달
        async onSubmit (payload) {
            // 방금 저장한 게시물 내용 jpaboard
            const board = await this.requestCreateBoardToSpring(payload)
            // 저장한 이력 나옴
            console.log('board: ' + JSON.stringify(board))
         
            // $router.push 작업으로 인하여 등록을 누르면 해당 페이지로 바로 이동 한다.
            await this.$router.push({
                // BoardReadPage를 자동으로 읽기 전용이 된다.
                name: 'BoardReadPage',
                params: { boardId: board.data.boardId.toString() }
            })
        }
    }
}
</script>

<style lang="">
    
</style>