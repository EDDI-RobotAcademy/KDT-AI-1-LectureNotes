<template lang="">
    <div>
        <h2>Vue + Spring + JPA 게시판 읽기</h2>
        <board-read-form v-if="board" :board="board"/>
        <p v-else>로딩중 .......</p>
        <!-- 
            수정 페이지로 가기
            boardId로 지정한 게시물 수정할 수 있게 해줌
        -->
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
import BoardReadForm from '@/components/board/BoardReadForm.vue'
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
        // state에 저장된 게시물 가져오기
        ...mapState(boardModule, ['board'])
    },
    methods: {
        // requestBoardToSpring: 게시물 가져오기 매서드
        // requestDeleteBoardToSpring: 게시물 삭제 요청 매서드
        ...mapActions(
            boardModule, ['requestBoardToSpring', 'requestDeleteBoardToSpring']
        ),
        // 
        async onDelete () {
            await this.requestDeleteBoardToSpring(this.boardId)
            await this.$router.push({ name: 'BoardListPage' })
        }
    },
    created () {
        // 아이디 값을 통해 지정된 게시물을 불러옴
        // 불러온 게시물을 BoardReadForm으로 전달
        this.requestBoardToSpring(this.boardId)
    }
}
</script>
<style lang="">
    
</style>