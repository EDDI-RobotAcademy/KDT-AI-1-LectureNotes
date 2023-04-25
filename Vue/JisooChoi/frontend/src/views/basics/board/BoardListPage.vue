<template lang="">
  <div>
    <h2>Vue + Spring + JPA 게시판</h2>
    <div style="text-align: left; margin: 15px">
      <!-- 페이지 링크를 라우터로 구현하여 누르면 register 페이지로 이동 -->
      <router-link :to="{ name: 'BoardRegisterPage' }">
        게시물 작성
      </router-link>
    </div>
    <!-- 게시물 목록을 컴포넌트 형태로 만들어서 가지고 왔다. -->
    <board-list-form :boards="boards" />
  </div>
</template>

<script>
// 우리가 만들어둔 store의 actions과 states를 매핑하여 연결해 준 것으로 추정 !
import { mapActions, mapState } from "vuex";
import BoardListForm from "@/components/board/BoardListForm.vue";

const boardModule = "boardModule";

export default {
  name: "BoardListPage",
  components: { BoardListForm },
  // state 관리자인 vuex에 state값(boards)를 모니터링
  computed: {
    // computed는 템플릿의 데이터 표현을 더 직관적이고 간결하게 도와주는 속성이다.
    ...mapState(boardModule, ["boards"]),
  },
  mounted() {
    // mounted()는 컴포넌트, 템플릿, 렌더링 된 DOM에 접근이 가능하다. (DOM 조작)
    // vuex의 action 호출
    this.requestBoardListToSpring();
  },
  methods: {
    // vuex의 action을 method에 맵핑
    ...mapActions(boardModule, ["requestBoardListToSpring"]),
  },
};
</script>

<style lang=""></style>
