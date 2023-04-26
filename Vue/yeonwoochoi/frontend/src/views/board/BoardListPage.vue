<template lang="">
    <div>
        <!-- to="{ name: 'BoardRegisterPage' }"> BoardRegisterPage로 보냄 -->
        <h2>Vue + Spring + JPA 게시판</h2>
        <div style="text-align: left; margin: 15px;">
            <!-- BoardRegisterPage 로 이동 -->
            <router-link :to="{ name: 'BoardRegisterPage' }">
                게시물 작성
            </router-link>
        </div>
        <!-- 로컬 컴포넌트 
        boards로 전달해서 ['boards']),가 활성화 된다. -->
        <board-list-form :boards="boards"/>
    </div>
</template>
<script>
// mapState 문법
// 게시물의 상태를 관리 (BoardModule.js에 해당)
// mapState State 를 맵핑
import { mapActions, mapState } from 'vuex';
import BoardListForm from '@/components/board/BoardListForm.vue'
const boardModule = 'boardModule'
export default {
    components: { BoardListForm },
    // state 관리자인 vuex에 state값(boards)를 모니터링 >>  state 값이 변할 때만 응답이 있다 보면 된다.
    // 그래서 값이 변경되면 boards 값이 갱신되니 새로운 리스트를 보여주게 된다.
    // computed 사전적 의미와 동일하게 ‘계산됨’을 나타낸다.
    // 어떤 계산된 정보를 나타내는지가 중요한데, 
    // 실제로 template에 표현될 내용들이 사전 준비된 형태라 보면 된다.
    // 즉 html 코드에 표현될 정보가 미리 계산되어 있다 보면 된다.
    // template에 배치할 정보만 사전에 계산해서 배치할 필요 없이
    // state 정보도 가져오는 족족 맵핑하여 모니터링하는 용도로 활용할 수 있다.
    computed: {
        // boardModule상에 존재하는 boards state를 계산해놓고 있다고 보면 된다.
        ...mapState(boardModule, ['boards']),
    },
    // mounted 생성 과정
    mounted () {
        // vuex의 action 호출
        this.requestBoardListToSpring()
    },
    methods: {
        // vuex의 action을 method에 맵핑
        // mounted 위 코드를 사용하려면 반드시 이코드를 같이 써줘야한다.
        ...mapActions(
            boardModule, ['requestBoardListToSpring']
        )
    }
}
</script>
<style lang="">
    
</style>