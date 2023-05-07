<template lang="">
    <div>
        <h2>게시물 작성</h2>
        <!-- 디버그 -->
        <!-- 로컬 컴포넌트(board-register-form) 
        submit 제출하다 -->
        <board-register-form @submit="onSubmit"/> 
    </div>
</template>

<script>
// 컴포넌트 사용을 위해 import 해준다.
import BoardRegisterForm from '@/components/board/BoardRegisterForm.vue'
import { mapActions } from 'vuex';
const boardModule = 'boardModule'
export default {
    components: {
        BoardRegisterForm,
    },
    name: "BoardRegisterPage", 
    methods: {
        ...mapActions(
            boardModule, ['requestCreateBoardToSpring']
        ),
        // payload는 actions에 전달
        async onSubmit (payload) {
            // vuex의 action 호출 (action.js)
            // payload에 방금 저장한 게시물
            const board = await this.requestCreateBoardToSpring(payload)
            // 잘 나오는지 콘솔창에서 확인하는 코드 (저장한 이력 나옴)
            console.log('board: ' + JSON.stringify(board))
         
            // $router.push 작업으로 인하여 등록을 누르면 해당 페이지로 바로 이동 한다.
            await this.$router.push({
                // BoardReadPage를 자동으로 읽기 전용이 된다.
                name: 'BoardReadPage',
                params: { boardId: board.data.boardId.toString() }
            })
        }
    }
}
</script>

<style lang="">
    
</style>