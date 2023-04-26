<template lang="">
  <div>
    <h2>게시물 수정</h2>
    <board-modify-form v-if="board" :board="board" @submit="onSubmit" />
    <!-- 
      boardId값으로 created에서 받아온
      기존 board 정보가 board-modify-form에 객체로 전달됨

      board-modify-form에서 수정 완료를 누르면
      onSubmit 실행, 페이지 리로딩
     -->
    <p v-else>로딩중 .......</p>
  </div>
</template>

<script>
import BoardModifyForm from "@/components/board/BoardModifyForm.vue";
// local component import

import { mapActions, mapState } from "vuex";
const boardModule = "boardModule";
export default {
  components: { BoardModifyForm },

  props: {
    boardId: {
      // BoardReadPage에서 받아온 boardId값
      type: String,
      required: true,
    },
  },
  computed: {
    ...mapState(boardModule, ["board"]),
    // state값 모니터링
  },
  methods: {
    ...mapActions(boardModule, ["requestBoardToSpring", "requestBoardModifyToSpring"]),
    // vuex의 action을 method에 맵핑

    async onSubmit(payload) {
      // onSubmit 함수 비동기처리
      const { title, content, writer } = payload;
      // payload에 받아온 값
      const boardId = this.boardId;
      await this.requestBoardModifyToSpring({ title, content, writer, boardId });
      // 데이터 수정을 위해 requestBoardModifyToSpring로 값 전달
      await this.$router.push({
        name: "BoardReadPage",
        params: { boardId: this.boardId },
        // 수정된 정보 적용 후 다시 BoardReadPage로
      });
    },
  },
  created() {
    this.requestBoardToSpring(this.boardId);
    // boardId값으로 기존 board 정보 불러오기
  },
};
</script>

<style lang=""></style>
