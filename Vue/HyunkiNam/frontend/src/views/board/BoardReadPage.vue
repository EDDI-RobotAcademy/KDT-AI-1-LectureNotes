<template lang="">
    <div>
        <h2>Vue + Spring + JPA 게시판 읽기</h2>
        <!-- board에 정상적인 값이 들어오면 표시 -->
        <board-read-form v-if="board" :board="board"/>
        <p v-else>로딩중 .......</p>
        <!-- BoardModifyPage로 이동하는데 boardId라는 값을 같이 가지고 감 -->
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
        // requestBoardToSpring에서 계산된 값 맵핑
        ...mapState(boardModule, ['board'])
    },
    methods: {
        // actions에 있는 requestBoardToSpring, requestDeleteBoardToSpring 사용하겠습니다!
        ...mapActions(
            boardModule, ['requestBoardToSpring', 'requestDeleteBoardToSpring']
        ),
        async onDelete() {
            // 액션에서 맵핑한 메서드 호출
            await this.requestDeleteBoardToSpring(this.boardId)
            await this.$router.push({ name: 'BoardListPage' })
        }
    },
    created() {
        // 액션에서 맵핑한 메서드 호출
        this.requestBoardToSpring(this.boardId)
    }
}
</script>
<style lang="">
    
</style>