<template lang="">
    <div>
        <h2>Vue + Spring + JPA 게시판</h2>
        <div style="text-align: left; margin: 15px;">
            <!-- 게시물 작성 문구를 클릭하면 router-link에 설정한 'BoardRegisterPage'로 이동합니다. -->
            <router-link :to="{ name: 'BoardRegisterPage' }">
                게시물 작성
            </router-link>
        </div>
        <!-- 
            mapState를 통해 boardModule에서 가져온 boards(우측)를 
            BoardListForm의 props(좌측 boards)로 전달합니다. 
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

    /*
    state 관리자인 vuex에 state값(boards)를 모니터링

    mapState를 통해 boardModule에 있는 boards를 모니터링 하며,
    boards의 상태가 변경되었을 때 computed이 실행되어
    현재 컴포넌트에서 사용하는 boards의 값이 업데이트됩니다.
    */
    computed: {
        ...mapState(boardModule, ['boards']),
    },

    // mounted 단계에서 requestBoardListToSpring 액션을 호출합니다.
    // mounted 단계 : 컴포넌트가 생성될 때 컴포넌트가 DOM에 마운트된 직후에 실행되는 단계 
    mounted () {
        this.requestBoardListToSpring()
    },
    
    // mapActions을 통해 boardModule에 있는 requestBoardListToSpring 액션을 매서드에 맵핑합니다.
    methods: {
        ...mapActions(
            boardModule, ['requestBoardListToSpring']
        )
    }
}
</script>

<style lang="">
    
</style>