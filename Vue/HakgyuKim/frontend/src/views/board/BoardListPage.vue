<template lang="">
    <div>
        <h2>Vue + Spring + JPA 게시판</h2>
        <div style="text-align: left; margin: 15px;">
        <router-link :to="{ name: 'BoardRegisterPage'}">
            게시물 작성
        </router-link>
        </div>  
        <!-- 
            action으로 Spring에서 board 리스트를 가져와 
            v-binding으로 BoardListForm으로 보내 
            리스트 전체를 볼 수 있게 해줌
        -->
        <board-list-form :boards="boards"/>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex';
import BoardListForm from '@/components/board/BoardListForm.vue'

const boardModule = 'boardModule'

export default {
    components: { 
        BoardListForm 
    },
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