<template lang="">
  <div>
    <h2>Vue + Spring + JPA 게시판</h2>
    <div style="text-align: left; margin: 15px">
      <!--
        페이지 링크를 라우터로 구현하여 누르면 register 페이지로 이동
      -->
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
import { mapActions, mapState } from "vuex";
import BoardListForm from "@/components/board/BoardListForm.vue";

// BoardModule 을 가져온다.
const boardModule = "boardModule";

export default {
  name: "BoardListPage",
  components: { BoardListForm },
  computed: {
    /*
      computed는 템플릿의 데이터 표현을 더 직관적이고 간결하게 도와주는 속성이다.

      mapState는 state 매핑하는 문법이며,
      state 관리자인 vuex에 state값(boards)을 모니터링 한다고 한다.
      
      즉, boardModule 상에 존재하는 "boards" state가 변함에 따라 값을 바꾸어준다.
    */
    ...mapState(boardModule, ["boards"]),
  },
  mounted() {
    /*
      mounted()는 컴포넌트, 템플릿, 렌더링 된 DOM에 접근이 가능하다. (DOM 조작)

      (라이프 사이클) 생성 과정에서 vuex의 action을 호출하였다.
      여기의 호출로 인해 requestBoardListToSpring 이 부분이 동작한다.
    */
    this.requestBoardListToSpring();
  },
  methods: {
    /*
      vuex의 action을 method에 맵핑하는 과정이다.
      아래와 같은 형태로 작성해야 사용이 가능하다. (그저 문법이다.)

      즉, boardModule의 모든 정보를 매핑하겠다는 뜻이다.
    */
    ...mapActions(boardModule, ["requestBoardListToSpring"]),
  },
};
</script>

<style lang=""></style>
