<template lang="">
    <div>
        <h2>Vue + Spring + JPA 게시판</h2>
        <div style="text-align: left; margin: 15px;">
            <!-- 
                router-link 는 라우터 지원 앱에서 사용자 네비게이션을 
                가능하게 하는 컴포넌트이다.
                화면이 갱신되지 않고 바로 페이지 이동이 가능하다.
                :t0="이동할링크" 이런 형태로 쓰는 것이 일반적
            -->
            <router-link :to="{ name: 'BoardRegisterPage' }">
                게시물 작성
            </router-link>
        </div>    
        <board-list-form :boards="boards"/>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex';
import BoardListForm from '@/components/board/BoardListForm.vue'

// const 는 자바의 final 과 같은 기능을 함
const boardModule = 'boardModule'

export default {
    components: { BoardListForm },
    // state 관리자인 vuex에 state값(boards)를 모니터링
    // computed 함수는 컴포넌트로드할 떄 한번 실행되고 
    // 그 값을 계속 저장해 사용한다.
    computed: {
        ...mapState(boardModule, ['boards'])
    },
    // mounted 는 생성되는 과정이라고 생각하면 된다.
    mounted () {
        // vuex의 action 호출
        // requestBoardListToSpring 를 actions 로 보내서 사용
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