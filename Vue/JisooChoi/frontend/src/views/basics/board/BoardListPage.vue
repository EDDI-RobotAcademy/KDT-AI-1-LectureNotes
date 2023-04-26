<template lang="">
  <div>
    <h2>Vue + Spring + JPA 게시판</h2>
    <div style="text-align: left; margin: 15px">
      <!-- 페이지 링크를 라우터로 구현하여 누르면 register 페이지로 이동 -->
      <router-link :to="{ name: 'BoardRegisterPage' }">
        게시물 작성
      </router-link>
    </div>
    <!--
      게시물 목록을 로컬 컴포넌트 형태로 만들어서 가지고 왔다. 
      boards라는 매개변수를 전달한다.
    -->
    <board-list-form :boards="boards" />
  </div>
</template>

<script>
// 우리가 만들어둔 store의 actions과 states를 매핑하여 연결해 준 것으로 추정 !
import { mapActions, mapState } from "vuex";
import BoardListForm from "@/components/board/BoardListForm.vue";

// BoardModule 을 가져온다.
const boardModule = "boardModule";

export default {
  name: "BoardListPage",
  components: { BoardListForm },
  // state 관리자인 vuex에 state값(boards)을 모니터링
  computed: {
    // computed는 템플릿의 데이터 표현을 더 직관적이고 간결하게 도와주는 속성이다.
    // mapState는 state 매핑하는 문법이다.
    ...mapState(boardModule, ["boards"]),
    // ※ 즉, boardModule 상에 존재하는 "boards" state를 계산해놓고 있음 !
  },
  mounted() {
    // mounted()는 컴포넌트, 템플릿, 렌더링 된 DOM에 접근이 가능하다. (DOM 조작)
    // vuex의 action 호출
    this.requestBoardListToSpring(); // (라이프 사이클) 생성 과정에서 얘를 불렀다.
    // 그래서 새로고침 마다 계속해서 백엔드에 요청이 들어간다.
  },
  methods: {
    // vuex의 action을 method에 맵핑
    // 꼭 이런 형태로 써야 사용할 수 있다. (매핑액션 = 맵 액션)
    // boardModule의 모든 정보를 매핑하겠다는 뜻이다.
    ...mapActions(boardModule, ["requestBoardListToSpring"]),
  },
};
</script>

<style lang=""></style>
