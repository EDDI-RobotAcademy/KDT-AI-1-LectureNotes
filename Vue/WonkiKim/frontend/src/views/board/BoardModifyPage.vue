<template>
    <div>
        <h2>게시물 수정</h2>
<!--        board가 null이 아니라면 board-modify-form 컴포넌트로 board를 바인딩하고 submit이벤트를 구독한다
            submit이벤트가 발생하면 onSubmit 메소드를 호출한다.
-->
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
            type: String,
            required: true,
        }
    },
    computed: {
        ...mapState(boardModule, ['board'])
    },
    methods: {
        ...mapActions(
            boardModule, ['requestBoardToSpring', 'requestBoardModifyToSpring']
        ),
        async onSubmit (payload) {
            //async를 붙이면 함수는 항상 프라미스를 리턴한다.
            const { title, content, writer } = payload
            const boardId = this.boardId

            await this.requestBoardModifyToSpring({ title, content, writer, boardId })
            //await가 붙으면 함수가 실행이 종료될 때까지 기다린다.
            await this.$router.push({
                name: 'BoardReadPage',
                params: { boardId: this.boardId }
            })
        }
    },
    created () {//라이프사이클 훅중 created때 boardId를 페이로드로 하여 스프링으로 보드 리퀘스트를 보낸다.
        this.requestBoardToSpring(this.boardId)
    }
}
</script>

<style lang="">
    
</style>