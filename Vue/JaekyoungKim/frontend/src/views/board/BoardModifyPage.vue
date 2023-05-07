<template lang="">
    <div>
        <h2>게시물 수정</h2>
        <board-modify-form v-if="board" :board="board" @submit="onSubmit"/>
        <!--게시물이 정상적으로 받아졌으면 수정 폼이 표출됩니다.-->
        <p v-else>로딩중 .......</p>
        <!--정상적으로 받지 못하면 로딩중이 뜯ㅁ-->
    </div>
</template>

<script>
import BoardModifyForm from '@/components/board/BoardModifyForm.vue'
import { mapActions, mapState } from 'vuex';
const boardModule = 'boardModule'// name 지정했기때문에 소문자 사용 가능하다.
export default {
    components: {
        BoardModifyForm,
    },
    props: {
        boardId: {
            type: String,
            required: true,
        }
    },
    computed: {
        ...mapState(boardModule, ['board'])
        //스테이트를 매핑한다는 뜻으로 보드가 계산된 것을 가져옴
    },
    methods: {
        ...mapActions(
            //보드 모듈의 액션의 'requestBoardToSpring', 'requestBoardModifyToSpring'
            //두 가지 매서드 가져옴
            boardModule, ['requestBoardToSpring', 'requestBoardModifyToSpring']
        ),
        async onSubmit (payload) {
            const { title, content, writer } = payload
            //payload는 보낼 데이터임
            const boardId = this.boardId
            // 수정한 게시물의 id기때문에 this.사용
            await this.requestBoardModifyToSpring({ title, content, writer,boardId })
            await this.$router.push({//수정 요청이 보내져 작동한 후에 읽기 페이지를 푸시함
                name: 'BoardReadPage',
                params: { boardId: this.boardId }
            })
        }
    },
    created () {
        this.requestBoardToSpring(this.boardId)
        //created시점에 보드 아이디에 맞게 보드를 가져옴
    }
}
</script>

<style lang="">
    
</style>