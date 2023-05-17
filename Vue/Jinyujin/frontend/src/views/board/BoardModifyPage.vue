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

            const { title, content, writer } = payload
            const boardId = this.boardId

            await this.requestBoardModifyToSpring({ title, content, writer, boardId })
            await this.$router.push({
                // 수정 완료하고 잘 수정됐는지 보기 위해 router로 페이지 이동
                name: 'BoardReadPage',
                params: { boardId: this.boardId }
            })
        }
    },
    created () {
        // 처음 수정할 때에 읽을 정보가 있어야 하기 때문에 created 해주어야 함
        // 읽을 정보가 많아서 불러올 데이터가 많을 때 async 처리를 해줘야 한다
        // 지금은 정보가 별로 없지만 리스트를 불러오는 경우 async 필요할 것으로 보임
        this.requestBoardToSpring(this.boardId)
    }
}
</script>

<style lang="">
    
</style>