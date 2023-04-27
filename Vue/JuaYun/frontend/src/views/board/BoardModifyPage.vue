<template lang="">
    <div>
        <h2>게시물 수정</h2>
        <!-- board값을 가지고 있다면 LocalComponent 실행 -->
        <board-modify-form v-if="board" :board="board" @submit="onSubmit"/>
        <p v-else>로딩중 .......</p>
    </div>
</template>

<script>
import BoardModifyForm from '@/components/board/BoardModifyForm.vue'
import { mapActions, mapState } from 'vuex';

// BoardModule 연결
const boardModule = 'boardModule'

export default {
    components: {
        BoardModifyForm,
    },
    props: {
        boardId: {
            type: String,
            required: true,
        }
    },
    computed: {
        // boardModule에서 board를 가져와서 사용
        ...mapState(boardModule, ['board'])
    },
    methods: {
        // mapActions을 이용하여 requestBoardToSpring, requestBoardModifyToSpring을 선언
        // actions는 비동기적인 로직을 처리하고 mutations를 호출하여 state를 변경한다.
        // requestBoardToSpring: 읽는 것
        // requestBoardModifyToSpring: 변경내역
        ...mapActions(
            boardModule, ['requestBoardToSpring', 'requestBoardModifyToSpring']
        ),
        //onSubmit 함수에서는 requestBoardModifyToSpring을 호출
        // requestBoardModifyToSpring은 board의 제목, 내용, 작성자, boardId를 
        // 인자로 받아서 서버로 요청을 보내는 함수
        // $router.push를 이용하여 BoardReadPage로 이동하고 있습니다.
        async onSubmit (payload) {
            const { title, content, writer } = payload
            const boardId = this.boardId
            await this.requestBoardModifyToSpring({ title, content, writer, boardId })
            await this.$router.push({
                name: 'BoardReadPage',
                params: { boardId: this.boardId }
            })
        }
    },
    created () {
        // requestBoardToSpring은 boardId를 인자로 받아서 서버로 요청을 보내는 함수
        this.requestBoardToSpring(this.boardId)
    }
}
</script>

<style lang="">
    
</style>