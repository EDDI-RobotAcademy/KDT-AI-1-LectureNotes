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
        async onSubmit (payload) {
            // emit으로 이거 동작
            const board = await this.requestCreateBoardToSpring(payload)
            // requestCreateBoardToSpring에서 반환한 res를 board로 저장

            console.log('board: ' + JSON.stringify(board))
            await this.$router.push({
                // 회원가입하고 바로 로그인 페이지로 가도록 하는 것이 좋은 것처럼
                // 등록하고 바로 Read 페이지로 가게 router.push를 걸어줌
                name: 'BoardReadPage',
                params: { boardId: board.data.boardId.toString() }
                // 파라미터는 boardId
                // 스프링에서 받아온 데이터를 board에 저장했으니
                // 그것으로 boardId를 찾아와 해당하는 페이지 보여줌
            })
        }
    },
}
</script>
<style lang="">
    
</style>