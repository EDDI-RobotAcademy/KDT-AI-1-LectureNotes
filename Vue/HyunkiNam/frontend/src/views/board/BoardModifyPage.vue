<template lang="">
    <div>
        <h2>게시물 수정</h2>
        <!-- board에 정상적인 값이 들어오면 표시 -->
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
        // requestBoardToSpring에서 계산된 값 맵핑
        ...mapState(boardModule, ['board'])
    },
    methods: {
        // actions에 있는 requestBoardToSpring, requestBoardModifyToSpring 사용하겠습니다!
        ...mapActions(
            boardModule, ['requestBoardToSpring', 'requestBoardModifyToSpring']
        ),

        async onSubmit(payload) {
            // requestBoardToSpring에서 리턴 받은 값 대입? 전달?
            const { title, content, writer } = payload
            const boardId = this.boardId
            // 액션에서 맵핑한 게시물 수정 메서드 호출
            await this.requestBoardModifyToSpring({ title, content, writer, boardId })
            await this.$router.push({
                // boardId를 가지고 BoardReadPage로 이동
                name: 'BoardReadPage',
                params: { boardId: this.boardId }
            })
        }
    },
    created() {
        // 액션에서 맵핑한 게시물 읽기 메서드 호출
        this.requestBoardToSpring(this.boardId)
    }
}
</script>

<style lang="">
    
</style>