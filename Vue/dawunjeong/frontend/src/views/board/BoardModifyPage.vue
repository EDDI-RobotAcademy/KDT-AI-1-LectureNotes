<template lang="">
    <div>
        <h2>게시물 수정</h2>
        <!-- 
            board가 있다면 BoardModifyForm 컴포넌트를 렌더링하고,
            submit 이벤트가 발생하였을 때 onSubmit 매서드를 실행합니다. 
            board가 없다면 로딩중이라는 문구를 출력합니다.
        -->
        <board-modify-form v-if="board" :board="board" @submit="onSubmit"/>
        <p v-else>로딩중 .......</p>
    </div>
</template>

<script>
import BoardModifyForm from '@/components/board/BoardModifyForm.vue'
import { mapActions, mapState } from 'vuex';

const boardModule = 'boardModule'

export default {
    components: {
        BoardModifyForm,
    },

    // 현재 컴포넌트에서 사용할 props는 boardId 이것은 String 타입입니다.
    // 이 컴포넌트를 사용할 때 반드시 boardId 이름으로 props를 전달해주어야 합니다. (required: true)
    props: {
        boardId: {
            type: String,
            required: true,
        }
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
    // requestBoardModifyToSpring 액션을 매서드에 맵핑합니다.
    methods: {
        ...mapActions(
            boardModule, ['requestBoardToSpring', 'requestBoardModifyToSpring']
        ),

        // onSubmit 매서드의 인자는 payload이며 이는 자식 컴포넌트에서 보낸 데이터입니다.
        // payload의 값을 상수에 할당합니다.
        async onSubmit (payload) {

            // await이 붙어있지 않은 아래 두 줄은 비동기적으로 작동합니다.
            const { title, content, writer } = payload
            const boardId = this.boardId

            // await이 붙어있는 아래 두 줄은 동기적으로 작동합니다.
            // await에 의해 requestBoardModifyToSpring 액션이 실행되고
            // 이후 router.push가 실행됩니다.
            await this.requestBoardModifyToSpring({ title, content, writer, boardId })
            await this.$router.push({
                name: 'BoardReadPage',
                params: { boardId: this.boardId }
            })
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