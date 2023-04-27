<template lang="">
    <div>
        <h2>게시물 수정</h2>
        <!-- 로컬 컴포넌트  만약 보드값이 있으면 아래코드가 실행되고, submit 이벤트  
        board 전달 -->
        <board-modify-form v-if="board" :board="board" @submit="onSubmit"/>
        <!-- 아니면 아래 코드가 실행 -->
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
            type: String,
            required: true,
        }
    },
    computed: {
        ...mapState(boardModule, ['board'])
    },
    methods: {
        ...mapActions(
            //           내용을 읽고 (수정할 부분을 띄어둔다.) / 변경 내역을 전달한다.
            // requestBoardToSpring -> 요청한다.
            boardModule, ['requestBoardToSpring', 'requestBoardModifyToSpring']
        ),
        // payload로 전달
        async onSubmit (payload) {
            // title, content, writer  전달 
            const { title, content, writer } = payload
            // boardId 전달
            const boardId = this.boardId
            await this.requestBoardModifyToSpring({ title, content, writer, boardId })
            // $ 의미는 전역 객체 속성 (public이랑 같은 속성) 
            await this.$router.push({
                name: 'BoardReadPage',
                // params 키워드를 사용하면 개수의 제한 없이 매개변수를 넘길 수 있다.
                params: { boardId: this.boardId }
            })
        }
    },
    created () {
        // Board는 requestBoardToSpring 확보
        this.requestBoardToSpring(this.boardId)
    }
}
</script>

<style lang="">
    
</style>