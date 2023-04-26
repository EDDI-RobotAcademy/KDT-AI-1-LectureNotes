<template lang="">
    <div>
        <h2>Vue + Spring + JPA 게시판</h2>
        <div style="text-align: left; margin: 15px;">
            <router-link :to="{ name: 'BoardRegisterPage' }">
                게시물 작성
            </router-link><!-- 게시물 작성을 누르면 BoardRegisterPage로 이동 -->
        </div>
        <board-list-form :boards="boards"/>
        <!-- board-list-form의 props에 들어갈 board -->
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex';
import BoardListForm from '@/components/board/BoardListForm.vue'
const boardModule = 'boardModule'
// namespace화 시킨 boardModule 호출
export default {
    components: { BoardListForm },
    computed: {
        ...mapState(boardModule, ['boards']),
    },// State에 boards를 맵핑
    mounted () {
        this.requestBoardListToSpring()
    },// mounted 할때 requestBoardListToSpring을 동작시켜줌
    methods: {
        ...mapActions(
            boardModule, ['requestBoardListToSpring']
        )// Actions에 requestBoardListToSpring 실행
    }
}
</script>

<style lang="">
    
</style>