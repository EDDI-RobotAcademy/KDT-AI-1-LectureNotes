<template lang="">
    <div>
        <h2>게시물 수정</h2>
        <!--submit 이벤트 발생시 onSubmit 메서드실행-->
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
            // 이 컴포넌트를 사용할 때 반드시 boardId 이름으로 props를 전달해주어야 합니다. 
            //(required: true)
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
        this.requestBoardToSpring(this.boardId)
    }
}
</script>
<style lang="">
    
</style>