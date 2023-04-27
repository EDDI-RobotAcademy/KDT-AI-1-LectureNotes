<template lang="">
    <div>
        <h2>Vue + Spring + JPA 게시판 읽기</h2>
        <!-- board가 붙게 되면 requestBoardToSpring 게시물을 잘 읽어오면
        v-if는 참이 된다. -->
        <board-read-form v-if="board" :board="board"/>
        <p v-else>로딩중 .......</p>
        <router-link :to="{ name: 'BoardModifyPage', params: { boardId }}">
            게시물 수정
        </router-link>
        <button @click="onDelete">삭제</button>
        <!-- 돌아가기 하면 BoardListPage로 간다. -->
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
        // mapState에 의해 계속 모니터링 한다.
        ...mapState(boardModule, ['board'])
    },
    methods: {
        // 게시물을 읽기 위한 / 지우기 위한 2가지 Actions이 들어있다.
        // ['requestBoardToSpring', / 'requestDeleteBoardToSpring']
        ...mapActions(
            boardModule, ['requestBoardToSpring', 'requestDeleteBoardToSpring']
        ),
        // async await 가독성과 유지보수성을 향상
        // function 앞에 async을 붙여줌으로써, 함수내에서 await 키워드를 사용할 수 있게 된다.
        // 함수(function) 키워드 앞에 async 만 붙여주면 되고, 비동기로 처리되는 부분 앞에 await 만 붙여주면 된다.
        async onDelete () {
            // 순서 보장되면 모두 await를 걸어서 사용하는게 좋다.
            // 비동기적 접근방식을 동기적으로 작성할 수 있게 해준다.
            await this.requestDeleteBoardToSpring(this.boardId)
            // $router.push(경로)를 수행하면 해당 경로로 이동시켜주는 개념
            // 삭제하게 되면 BoardListPage로 이동
            // :to=”{ ~~~ }” 형태로 사용할 수 있고, 아래 코드와 같이 직접 사용도 가능하다.
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