<template lang="">
    <div>
        <h2>Vue + Spring + JPA 게시판</h2>
        <!--
        <router-link :to="{ name: ' '}"></router-link>
        -->
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
        ...mapState( boardModule, ['boards']),
    },
    mounted () {
        // vuex의 action 호출
        this.requestBoardListToSpring()
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