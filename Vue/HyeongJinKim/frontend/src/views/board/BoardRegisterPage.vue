<template lang="">
  <div>
    <h2>게시물 작성</h2>
    <board-register-form @submit="onSubmit" />
    <!-- 
      submit가 onSubmit에 맵핑되어
      ohSubmit 실행시 board-register-form의
      { title, writer, content } 값을 받아온다.
     -->
  </div>
</template>

<script>
import BoardRegisterForm from "@/components/board/BoardRegisterForm.vue";
// local component import
import { mapActions } from "vuex";
const boardModule = "boardModule";
export default {
  components: { BoardRegisterForm },
  name: "BoardRegisterPage",
  methods: {
    ...mapActions(boardModule, ["requestCreateBoardToSpring"]),
    // boardModule에 requestCreateBoardToSpring 에 맵핑

    async onSubmit(payload) {
      // onSubmit 함수 비동기처리
      const board = await this.requestCreateBoardToSpring(payload);
      // board에 payload로 받아온 값 저장
      console.log("board: " + JSON.stringify(board));
      await this.$router.push({
        // BoardReadPage에 board에 저장한 Id값을 String 형태로 전달
        name: "BoardReadPage",
        params: { boardId: board.data.boardId.toString() },
      });
    },
  },
};
</script>

<style lang=""></style>
