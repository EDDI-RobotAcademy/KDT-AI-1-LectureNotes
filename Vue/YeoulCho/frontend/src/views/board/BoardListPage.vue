<template lang="">
    <div>
        <h2>Vue + Spring + JPA 게시판</h2>
        <div style="text-align: left; margin: 15px;">
            <router-link :to="{ name: 'BoardRegisterPage' }">
                게시물 작성
            </router-link>
        </div>
        <board-list-form :boards="boards"/> 
        <!--BoardModule의 state에 boards를 바인딩(boardlist의 boards)
        state왜 필요할까? 정보관리를 위해-->
    </div>
</template>

<script>

import BoardListForm from '@/components/board/BoardListForm.vue'
import { mapActions, mapState } from 'vuex';

const boardModule = 'boardModule' 

export default {
    components: { BoardListForm },
    // state 관리자인 vuex에 state값(boards)를 모니터링
    computed: { 
        //mapState에서 모니터링을 하다가 boards의 값이 바뀌면
        //computed에서 boards값 바뀜
        ...mapState(boardModule, ['boards']),
    },
    mounted () {
        // vuex의 action 호출
        this.requestBoardListToSpring()
    },
    methods: {
        // vuex의 action을 method에 맵핑(가져오다)
        ...mapActions(
            boardModule, ['requestBoardListToSpring']
        )
    }
}
</script>

<style lang="">
    
</style>