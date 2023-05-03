<template lang=""> <!-- html -->
    <div>
        <!-- <h2> 폰트 크기 -->
        <h2>Vue + Spring + JPA 게시판</h2>
        <!-- 게시물 작성의 style 표현 -->
        <div style="text-align: left; margin: 15px;">
            <!-- 
                router-link :to는 이동 링크로 게시물 작성을 클릭하면
                해당 링크 ('BoardRegisterPage') 로 이동한다.
            -->
            <router-link :to="{ name: 'BoardRegisterPage' }">
                게시물 작성
            </router-link>
        </div>
        <!-- 
        board-list-form 로컬 컴포먼트
        :boards="boards" 매개변수(props)
        boards의 값이 아래 script 흐름에 따라 아래에서 전달한다.
        한마디로 아래 코드 boards로 전달해서 script ['boards'] 가 활성화 된다. 

        board-list-form에 boards가 전달 된다.
        바인딩이 된 이후에 실행이 된다.
        -->
        <board-list-form :boards="boards"/>
    </div>
</template>

<!-- script -->
<script>
// mapState 게시물의 상태를 관리
// mapState는 State를 맵핑
import { mapActions, mapState } from 'vuex';
// 로컬 컴포먼트(board-list-form)를 사용하려면 import를 하여 사용할 수 있다.
import BoardListForm from '@/components/board/BoardListForm.vue'
// BoardModule.js에 해당 (소문자로 만들어둠)
const boardModule = 'boardModule'
export default {
    // import한 컴포넌트 BoardListForm 사용하려면 여기에 명시 해준다.
    components: { BoardListForm },
    // computed : 사전적 의미와 동일하게 ‘계산됨’을 나타낸다.
    // state의 값이 변할때만 응답하므로 값이 변경되면 boards 
    // 값이 갱신되니 새로운 리스트를 보여주게 된다.
    // template에 표현될 내용들이 사전 준비된 형태이고, 
    // html 코드에 표현될 정보가 미리 계산되어 있다고 생각하면 된다.
    // template에 배치할 정보만 사전에 계산해서 배치할 필요 없이
    // state 정보도 가져오는 족족 맵핑하여 모니터링하는 용도로 활용할 수 있다.
    computed: {
        // state 관리자인 vuex에 state값(boards)를 모니터링
        // boardModule 상에 존재하는 boards를 계산해놓고 있다고 보면 된다.
        // ['boards']는 게시물 리스트를 가지고 온다. 
        ...mapState(boardModule, ['boards']), 
    },
    // mounted 무조건 실행
    mounted () {
        // vuex의 action 호출 (action.js)
        this.requestBoardListToSpring()
    },
    methods: {
        // vuex의 action을 method에 맵핑
        // mounted 위 코드를 사용하려면 반드시 아래 코드를 같이 써줘야한다.
        ...mapActions(
            boardModule, ['requestBoardListToSpring']
        )
    }
}
</script>

<!-- css -->
<style lang="">
    
</style>