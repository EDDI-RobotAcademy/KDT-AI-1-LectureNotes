<template>
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
        //boardModule에서 board를 매핑한다.
        //...mapState는 map state helper라고 한다.
        //...은 spread operator: 객체 또는 배열을 나열한다.
        ...mapState(boardModule, ['board'])
    },
    methods: {
        ...mapActions(
            //boardModule에서 두 액션을 매핑한다.
            boardModule, ['requestBoardToSpring', 'requestDeleteBoardToSpring']
        ),
        async onDelete () {
            //async
            await this.requestDeleteBoardToSpring(this.boardId)
            //$router.push 로 라우팅 해준다.
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