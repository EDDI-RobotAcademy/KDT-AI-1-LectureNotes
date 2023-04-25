<template>
<div>
    <h2>Vue+Spring+JPA Board</h2>
    <!--
    <router-link :to="{name:''}">
        게시물 작성
    </router-link>-->
    <board-list-form :board="boards"/>
</div>
</template>

<script>
import {mapActions, mapState} from "vuex";
import BoardListForm from "@/components/board/BoardListForm.vue";

const boardModule = 'boardModule'
export default {
    name: "BoardListPage",
    components: {BoardListForm},
    computed: {
        //state의 관리자인 vuex에 state값(board)을 모니터링
        ...mapState(boardModule, ['boards']),
    },
    mouted() {
        //vuex의 action 호출
        this.requestboardListToSpring()
    },
    methods: {
        //vuex의 action을 methods에 맵핑
        ...mapActions(
            boardModule, ['requestBoardListToSpring']
        )
    }
}
</script>

<style scoped>

</style>