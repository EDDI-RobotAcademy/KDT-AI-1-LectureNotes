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
            // 아래 board 는 백엔드에서 전달받은 JpaBoard가 된다
            const board = await this.requestCreateBoardToSpring(payload)
            console.log('board: ' + JSON.stringify(board))
            // 게시물을 눌러서 읽기를 누르면 주소 창이 boardId로 바뀌는 것을 확인할 수 있다.
            // 아래 코드로 인해 그렇게 작동하는 것이다.
            await this.$router.push({
                // $는 vue에서 전역 객체 속성이다.
                // private하게 사용하는 게 아닌 public하게 사용하는 속성을 말한다.
                name: 'BoardReadPage',
                params: { boardId: board.data.boardId.toString() }
            })
        }
    }
}
</script>

<style></style>