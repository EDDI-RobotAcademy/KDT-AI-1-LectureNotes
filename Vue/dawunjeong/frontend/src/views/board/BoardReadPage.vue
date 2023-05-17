<template lang="">
    <div>
        <h2>Vue + Spring + JPA 게시판 읽기</h2>
        <!-- 
            board가 있다면 BoardReadForm 컴포넌트를 렌더링하고,
            board가 없다면 로딩중이라는 문구를 출력합니다.
        -->
        <board-read-form v-if="board" :board="board"/>
        <p v-else>로딩중 .......</p>
        <!-- 게시물 수정이라는 문구를 클릭하면 'BoardModifyPage'로 이동합니다. -->
        <router-link :to="{ name: 'BoardModifyPage', params: { boardId }}">
            게시물 수정
        </router-link>
        <!-- 삭제 버튼을 클릭하면 onDelete 매서드가 실행됩니다. -->
        <button @click="onDelete">삭제</button>
        <!-- 돌아가기라는 문구를 클릭하면 'BoardListPage'로 이동합니다. -->
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

    // 현재 컴포넌트에서 사용할 props는 boardId 이것은 String 타입입니다.
    // 이 컴포넌트를 사용할 때 반드시 boardId 이름으로 props를 전달해주어야 합니다. (required: true)
    props: {
        boardId: {
            type: String,
            required: true,
        },
    },

    /*
    mapState를 통해 boardModule에 있는 boards를 모니터링 하며,
    boards의 상태가 변경되었을 때 computed이 실행되어
    현재 컴포넌트에서 사용하는 boards의 값이 업데이트됩니다.
    */
    computed: {
        ...mapState(boardModule, ['board'])
    },

    // mapActions을 통해 boardModule에 있는 requestBoardToSpring, 
    // requestDeleteBoardToSpring 액션을 매서드에 맵핑합니다.
    methods: {
        ...mapActions(
            boardModule, ['requestBoardToSpring', 'requestDeleteBoardToSpring']
        ),

        // onDelete 매서드는 requestDeleteBoardToSpring 액션이 실행된 후 $router.push을 실행합니다.
        async onDelete () {
            await this.requestDeleteBoardToSpring(this.boardId)
            await this.$router.push({ name: 'BoardListPage' })
        }
    },
    
    // created 단계에서 requestBoardToSpring 액션을 호출합니다.
    // created 단계 : 컴포넌트가 생성될 때 데이터 관찰, 매서드, 이벤트 등의 설정이 된 직후에 실행되는 단계
    created () {
        this.requestBoardToSpring(this.boardId)
    }
}
</script>
<style lang="">
    
</style>