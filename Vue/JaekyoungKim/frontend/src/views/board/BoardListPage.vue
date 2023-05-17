<template lang="">
    <div>
        <h2>Vue + Spring + JPA 게시판</h2>
        <div style="text-align: left; margin: 15px;">
            <router-link :to="{ name: 'BoardRegisterPage' }">
                게시물 작성
            </router-link>
            <!-- 작성 페이지로 이동하는 링크 생성-->
        </div>
        <board-list-form :boards="boards"/>
    </div>

   
</template>

<script>
import { mapActions, mapState } from 'vuex';
import BoardListForm from '@/components/board/BoardListForm.vue'
const boardModule = 'boardModule'
export default {
    components: { BoardListForm },
    // state 관리자인 vuex에 state값(boards)를 모니터링
    computed: {
        ...mapState(boardModule, ['boards']),
        //리스트를 가져올거기 때문에 boards 가져와야함
    },
    mounted () {
        // vuex의 action 호출
        this.requestBoardListToSpring()
        //리퀘스트 보드 가져오기
    },
    methods: {
        // vuex의 action을 method에 맵핑
        ...mapActions(
            boardModule, ['requestBoardListToSpring']
        )
    }
}
</script>

<style lang="">
    
</style>