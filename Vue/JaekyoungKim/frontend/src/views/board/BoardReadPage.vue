<template lang="">
    <div>
        <h2>Vue + Spring + JPA 게시판 읽기</h2>
        <board-read-form v-if="board" :board="board"/>
        <!-- 정상적으로 보드를 가져왔니 ? 그럼 그 보드 한 번 봐보자 약간 이런 느낌-->
        <p v-else>로딩중 .......</p>
        <!--못가져 왔으니까 일단 로딩이라도 띄우자 -->
        <router-link :to="{ name: 'BoardModifyPage', params: { boardId }}">
            게시물 수정
        </router-link><!--수정할려면 게시물 수정을 눌러라 그럼 모디파이 페이지로 이동 -->
        <button @click="onDelete">삭제</button>
        <router-link :to="{ name: 'BoardListPage' }">
            돌아가기<!--돌아가기 누르면 보드 리스트 페이지로 갑니다.-->
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
        //계산된 보드를 보여줌
    },
    methods: {
        ...mapActions(
            boardModule, ['requestBoardToSpring', 'requestDeleteBoardToSpring']
            //actions의 두가지['requestBoardToSpring', 'requestDeleteBoardToSpring']가져옴
        ),
        async onDelete () {
            await this.requestDeleteBoardToSpring(this.boardId)
            await this.$router.push({ name: 'BoardListPage' })
            // 삭제 된 후에 리스트로 가는 순서를 만들어 준것
        }
    },
    created () {
        this.requestBoardToSpring(this.boardId)
        //created 시점에 보드 id에 맞게  state에 board에 데이터를 넣어라
    }
}
</script>
<style lang="">
    
</style>