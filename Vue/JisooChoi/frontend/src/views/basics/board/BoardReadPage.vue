<template lang="">
    <div>
        <h2>Vue + Spring + JPA 게시판 읽기</h2>
        <!-- board가 보이는 시점은 mounted가 끝난 시점 -->
        <board-read-form v-if="board" :board="board"/>
        <p v-else>로딩중 .......</p>
        <router-link :to="{ name: 'BoardModifyPage', params: { boardId }}">
            게시물 수정
        </router-link>
        <button @click="onDelete">삭제</button>
        <!--  다른 컴포넌트들 이 있으므로, components: defualt 가 있었던 것이다.-->
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
        ...mapState(boardModule, ['board'])
    },
    methods: {
        ...mapActions(       // 게시물 읽기               // 게시물 지우기
            boardModule, ['requestBoardToSpring', 'requestDeleteBoardToSpring']
        ),
        async onDelete () {
            // async, await 이런 부분 잘 기억하며, 같이 쓰기
            await this.requestDeleteBoardToSpring(this.boardId)
            await this.$router.push({ name: 'BoardListPage' })
        }
    },
    created () {
        // 얘가 어떻게 동작하는지 액션에서 확인
        this.requestBoardToSpring(this.boardId)
    }
}
</script>
<style lang="">
    
</style>