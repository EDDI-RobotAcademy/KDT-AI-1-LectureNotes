<template lang="">
    <div>
        <h2>게시물 수정</h2>
        <board-modify-form v-if="board" :board="board" @submit="onSubmit"/>
        <p v-else>로딩중 .......</p>
    </div>
</template>

<script>
import BoardModifyForm from '@/components/board/BoardModifyForm.vue'
import { mapActions, mapState } from 'vuex';
const boardModule = 'boardModule'
export default {
    components: {
        BoardModifyForm,
    },
    props: {
        boardId: {
            type: String,  // boardId 값의 데이터 타입 명시
            required: true, // 필수로 전달 받아야 한다는 뜻
        }
    },
    computed: {
        ...mapState(boardModule, ['board']) // State에 board를 맵핑
    },
    methods: {
        ...mapActions(
            boardModule, ['requestBoardToSpring', 'requestBoardModifyToSpring']
        ), // action에 requestBoardToSpring, requestBoardModifyToSpring 실행
        async onSubmit (payload) { // onSubmit 에 payload 대입
            const { title, content, writer } = payload // payload의 값
            const boardId = this.boardId // boardId의 불변객체 화
            await this.requestBoardModifyToSpring({ title, content, writer, boardId }) 
            await this.$router.push({
                name: 'BoardReadPage', // BoardReadPage로 이동
                params: { boardId: this.boardId } // 파라미터는 받아온 boardId
            })
        }
    },
    created () {
        this.requestBoardToSpring(this.boardId) // requestBoardToSpring에 받아온 boardId 입력
    }
}
</script>

<style lang="">
    
</style>