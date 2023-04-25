<template lang="">
    <div>
        <h2>Vue + Spring + JPA 게시판</h2>
        <div style="text-align: left; margin: 15px;">
        <!-- 실제 카페 가보면 글 리스트 나오고 글쓰기 기능 - 이걸 router링크로 만들어주기 -->
            <router-link :to="{ name: 'BoardRegisterPage' }" >
                게시물 작성
            </router-link>
        </div>
        <board-list-form :boards="boards"/>
        <!-- 보드 리스트에 보드 정보들 전달 = axios를 써서 스프링에서 받아와야겠다 -->
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex';
import BoardListForm from '@/components/board/BoardListForm.vue'

const boardModule = 'boardModule'

export default {
    // 지금까지 여기서 axios를 해쓴데 원래 그러면 초짜
    components: { BoardListForm },
    // state 관리자인 vuex에 state값(boards)를 모니터링
    computed: {
        ...mapState(boardModule, ['boards']),
        // boardModule까지 만들어줘야 함
        // 도메인관점 - 게시물이라는 것 자체가 도메인
        // store라는 걸 만지게 됨
    },
    mounted() {
        // vuex의 action 호출
        this.requestBoardListToSpring()
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