<template lang="">
    <div>
        <h2>게시물 작성</h2>
        <!-- 
            BoardRegisterForm 컴포넌트가 렌더링되고 
            이 컴포넌트의 submit 이벤트가 발생하면 onSubmit 매서드를 실행합니다. 
        -->
        <board-register-form @submit="onSubmit"/>
    </div>
</template>

<script>
import BoardRegisterForm from '@/components/board/BoardRegisterForm.vue'
import { mapActions } from 'vuex';

const boardModule = 'boardModule'

export default {
    components: {
        BoardRegisterForm,
    },
    name: "BoardRegisterPage",
    methods: {

        // mapActions을 통해 boardModule에 있는 requestCreateBoardToSpring 액션을 매서드에 맵핑합니다.
        ...mapActions(
            boardModule, ['requestCreateBoardToSpring']
        ),

        // onSubmit 매서드의 인자는 payload이며 이는 자식 컴포넌트에서 보낸 데이터입니다.
        // payload의 값을 상수에 할당합니다.
        async onSubmit (payload) {
            
            // await를 통해 requestCreateBoardToSpring 액션이 실행된 후 $router.push가 실행됩니다.
            // console.log는 비동기적으로 작동하지 않기 때문에 await을 붙여주지 않아도 됩니다.
            const board = await this.requestCreateBoardToSpring(payload)
            console.log('board: ' + JSON.stringify(board))
            await this.$router.push({
                name: 'BoardReadPage',
                params: { boardId: board.data.boardId.toString() }
            })
        }
    }
}
</script>

<style lang="">
    
</style>