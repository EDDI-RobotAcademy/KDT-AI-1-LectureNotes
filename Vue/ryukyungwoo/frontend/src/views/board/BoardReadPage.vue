<template lang="">
    <div>
        <h2>Vue + Spring + JPA 게시판 읽기</h2>
        <board-read-form v-if="board" :board="board"/> <!-- board-read-form의 board가 board면 board가 board -->
        <p v-else>로딩중 .......</p>
        <router-link :to="{ name: 'BoardModifyPage', params: { boardId }}"> <!-- 게시물 수정을 누르면 boardId를 가지고 BoardModifyPage로 이동-->
            게시물 수정
        </router-link>
        <button @click="onDelete">삭제</button> <!-- 삭제 누르면 onDelete 반응 -->
        <router-link :to="{ name: 'BoardListPage' }"> <!-- 돌아가기 누르면 BoardListPage로 돌아감 -->
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
            type: String,   // boardId 값의 데이터 타입 명시
            required: true, // 필수로 전달 받아야 한다는 뜻
        },
    },
    computed: {
        ...mapState(boardModule, ['board']) // State에 board 맵핑
    },
    methods: {
        ...mapActions(
            boardModule, ['requestBoardToSpring', 'requestDeleteBoardToSpring']
        ), // Actions에 있는 requestBoardToSpring, requestDeleteBoardToSpring 실행 
        async onDelete () { // onDelete를 비동기 실행
            await this.requestDeleteBoardToSpring(this.boardId) // requestDeleteBoardToSpring에 boardId값을 넣고
            await this.$router.push({ name: 'BoardListPage' }) // BoardListPage로 이동
        }
    },
    created () {
        this.requestBoardToSpring(this.boardId) // 페이지가 생성 될 때 boardId값 가지고 requestBoardToSpring 실행
    }
}
</script>
<style lang="">
    
</style>