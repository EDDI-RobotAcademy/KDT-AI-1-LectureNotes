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
import BoardReadForm from '@/components/board/BoardReadForm.vue'
import { mapActions, mapState } from 'vuex';

const boardModule = 'boardModule'

export default {
    components: {
        BoardReadForm
    },
    props: {
        boardId: {
            type: String, //boardListForm에서 routerlink를 통해 보낸 params의 BoardId
            required: true, //필수로 Property(boardId)가 필요하다면 required true로 선언
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
        //vueLifeCycle=>created>mounted>update>destroyed
        //위에 boardReadFoam의 board가 바인딩되는 때는 마운트가 끝나는 시점이기 때문에
        //그전에 게시물 정보를 가지고 오는 것
    }
}
</script>
<style lang="">
    
</style>