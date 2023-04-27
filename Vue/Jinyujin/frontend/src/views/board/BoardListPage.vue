<!-- 게시판을 만들 때 가장 먼저 생각해야 하는 것은 조회 기능 -->

<template lang="">
    <div>
        <h2>Vue + Spring + JPA 게시판</h2>
        <div style="text-align: left; margin: 15px;">
        <!-- 실제 카페 가보면 글 리스트 나오고 글쓰기 기능 - 이걸 router링크로 만들어주기 -->
            <router-link :to="{ name: 'BoardRegisterPage' }">
                <!-- 버튼 없어도 링크 누르고 넘어가게 -->
                게시물 작성
            </router-link>
        </div>
        <board-list-form :boards="boards"/>
        <!-- 
            보드 리스트 폼에 boards 정보 전달
            정보는 axios를 써서 스프링에서 받아올 것임
            받아온 정보는 computed 통해서 전달
            결국 화면에 출력해주는 것은 이 컴포넌트 
        -->
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex';
import BoardListForm from '@/components/board/BoardListForm.vue'

const boardModule = 'boardModule'
// boardModule을 const로 선언해주어 import 대신 사용할 수 있음
// 'BoardModule'이라고 하니까 홈페이지에서 작성한 게시물들의 리스트가 뜨지 않는 문제가 나타남
// store/index.js에서 BoardModule을 소문자로 쓰겠다고 선언해두어서 이렇게 사용하는 것

export default {
    components: { BoardListForm },
    // state 관리자인 vuex에 state값(boards)를 모니터링
    computed: {
        // 새로운 정보를 받을 때마다 boards에 전달되도록 하는 것이 computed
        ...mapState(boardModule, ['boards']),
        // boardModule에서 관리하고 있는 state를 맵핑하여
        // 스프링에서 받아온 정보를 boards에 전달하도록 함
    },
    mounted () {
        // vuex의 action 호출
        this.requestBoardListToSpring()
        // 홈페이지에 단순히 데이터를 띄울 때는 mounted
    },
    methods: {
        // vuex의 action을 method에 맵핑
        ...mapActions(
            boardModule, ['requestBoardListToSpring']
        )
    },
}
</script>

<style lang="">
</style>