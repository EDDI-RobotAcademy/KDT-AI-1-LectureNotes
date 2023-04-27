<template lang="">
    <div>
        <h2>게시물 작성</h2>
        <!-- 디버그 -->
        <board-register-form @submit="onSubmit"/> 
        <!--자식컴포넌트의 submit이라는 이벤트가 발행되면 onSubmit을 실행시킨다.-->
    </div>
</template>

<script>
import BoardRegisterForm from '@/components/board/BoardRegisterForm.vue'
import { mapActions } from 'vuex';

const boardModule = 'boardModule' 
//불변 변수 boardModule을 선언하는데, boardModule에 store에 있는 'boardModule'로 할당하겠다.


export default {
    components: {
        BoardRegisterForm,
    },
    name: "BoardRegisterPage",
    methods: {
        ...mapActions( 
            //boardModule에 있는requestCreateBoardToSpring action을 맵핑한다. 
            boardModule, ['requestCreateBoardToSpring']
        ),
        async onSubmit (payload) {
            const board = await this.requestCreateBoardToSpring(payload)
            //동기1.작성한 게시물을 spring에 등록하는 메서드
            console.log('board: ' + JSON.stringify(board))
            
            await this.$router.push({
                name: 'BoardReadPage',
            //동기2.등록하고 BoardReadPage로 가라
                params: { boardId: board.data.boardId.toString() }
                //console.log(typeof(board.data.boardId)) ==> number
            })
        }
    }
}
</script>

<style lang="">
    
</style>