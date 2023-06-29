<template lang="">
    <div>
        <h2>Vue + Spring + JPA 게시판 읽기</h2>
        <board-read-form v-if="board" :board="board"/>
        <p v-else>로딩중 .......</p>
        <router-link :to="{ name: 'BoardModifyPage', params: { boardId }}">
            게시물 수정
        </router-link>
        <button @click="onDelete">삭제</button>
        <router-link :to="{ name: 'BoardListPage' }">
            돌아가기
        </router-link>
    </div>
</template>

<script>
import BoardReadForm from '../components/BoardReadForm.vue'
import { mapActions, mapState } from 'vuex';

const boardModule = 'boardModule'

export default {
    components: {
        BoardReadForm
    },
    props: {
        boardId: {
            type: String,
            required: true,
        },
    },
    computed: {
        ...mapState(boardModule, ['board'])
    },
    methods: {
        ...mapActions(
            boardModule, ['requestBoardToSpring', 'requestDeleteBoardToSpring']
        ),
        async onDelete () {
            await this.requestDeleteBoardToSpring(this.boardId)
            await this.$router.push({ name: 'BoardListPage' })
        }
    },
    created () {
        this.requestBoardToSpring(this.boardId)
    }
}
</script>
<style lang="">
    
</style>