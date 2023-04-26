<template lang="">
    <div>
        <h2>게시물 작성</h2>
        
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
            //store의 board의 boardmodule의 action의 requestCreateBoardToSpring 매서드 가져오시오.
        ),
        async onSubmit (payload) {
            const board = await this.requestCreateBoardToSpring(payload)
            //requestCreateBoardToSpring를 통해 생성된 후에 board에 해당 데이터를 넣는다.
            console.log('board: ' + JSON.stringify(board))
            //받아온 데이터를 JSON.stringify(board)통해 문자열로 변환하여 콘솔 찍는다.
            await this.$router.push({
                name: 'BoardReadPage',
                params: { boardId: board.data.boardId.toString() }
            })//그 뒤에 읽기 페이지로 이동 한다.
        }
    }
}
</script>

<style lang="">
    
</style>