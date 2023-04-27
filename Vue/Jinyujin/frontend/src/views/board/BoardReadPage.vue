<template lang="">
    <div>
        <h2>Vue + Spring + JPA 게시판 읽기</h2>
        <board-read-form v-if="board" :board="board"/>
        <!-- 
            mapState를 해서 board를 사용할 수 있는 것 
        -->
        <p v-else>로딩중 ......</p>
        <router-link :to="{ name: 'BoardModifyPage', params: { boardId }}">
            게시물 수정
            <!-- 수정은 ReadPage에서 요청해줘야 함 -->
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
        ...mapState(boardModule, ['board'])
    },
    methods: {
        ...mapActions(
            boardModule, ['requestBoardToSpring', 'requestDeleteBoardToSpring']
        ),
        async onDelete () {
            await this.requestDeleteBoardToSpring(this.boardId)
            await this.$router.push({ name: 'BoardListPage' })
            // async - await: 작업이 끝나는걸 보장하도록 하는 것
            // async를 쓸 때는 안에 있는 애들에게 적절하게 await를 다 걸어줘야 한다
            // 만약 router쪽에 await를 쓰지 않으면 위의 작업이 다 끝나지 않았는데 
            // router.push가 먼저 작동하는 상황이 발생할 수 있음
            // 순서대로 뭔가를 작동시키는 작업을 할 때에는 
            // 그 메서드들을 모아 따로 빼서 처리해주는 것이 좋음
        }
    },
    created () {
        // mounted로 바꿨는데 사용 가능했음 - 상관은 없다고 함
        // created는 통신할 때,
        // mounted는 말그대로 화면에 빨리 띄워야 할 때 사용하면 된다고 생각하자
        this.requestBoardToSpring(this.boardId)
    }
}
</script>

<style lang="">
</style>