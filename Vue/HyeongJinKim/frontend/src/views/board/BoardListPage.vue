<template lang="">
  <div>
    <h2>Vue + Spring + JPA 게시판</h2>
    <div style="text-align: left; margin: 15px">
      <router-link :to="{ name: 'BoardRegisterPage' }"> 게시물 작성 </router-link>
      <!-- 게시물 작성을 누르면 BordRegisterPage로 -->
    </div>
    <board-list-form :boards="boards" />
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";

import BoardListForm from "@/components/board/BoardListForm.vue";
// local component import

const boardModule = "boardModule";
export default {
  components: { BoardListForm },
  computed: {
    ...mapState(boardModule, ["boards"]),
    // state 관리자인 vuex에 state값(boards)를 모니터링
  },
  mounted() {
    this.requestBoardListToSpring();
    // vuex의 action 호출
  },
  methods: {
    ...mapActions(boardModule, ["requestBoardListToSpring"]),
    // vuex의 action을 method에 맵핑
  },
};
</script>

<style lang=""></style>
