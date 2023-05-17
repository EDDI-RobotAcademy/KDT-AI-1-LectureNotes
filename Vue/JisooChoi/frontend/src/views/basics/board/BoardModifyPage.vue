<template lang="">
  <div>
    <h2>게시물 수정</h2>
    <!-- 
      board 값을 가지고 있다면 아래 컴포넌트 실행하며, 매개변수를 보내준다.

      submit 이벤트의 이름은 하위/상위 컴포넌트가 같아야 한다.
    -->
    <board-modify-form v-if="board" :board="board" @submit="onSubmit" />
    <p v-else>로딩중 .......</p>
  </div>
</template>

<script>
import BoardModifyForm from "@/components/board/BoardModifyForm.vue";
import { mapActions, mapState } from "vuex";

const boardModule = "boardModule";

export default {
  components: {
    BoardModifyForm,
  },
  props: {
    boardId: {
      type: String,
      required: true,
    },
  },
  computed: {
    /*
      백엔드로 보내준 작업에 따라 board가 수정되었으니 모니터링 하고 있던 state값이 변경된다.
      board에 대한 연결은 mapState로 되고 있다.
    */
    ...mapState(boardModule, ["board"]),
  },
  methods: {
    ...mapActions(boardModule, [
      "requestBoardToSpring", // 읽기
      "requestBoardModifyToSpring", // 변경 내역 전달
    ]),
    // ● 1. 하위 컴포넌트인 BoardMidifyForm에서 변수들을 payload로 받아왔다.
    async onSubmit(payload) {
      const { title, content, writer } = payload;
      const boardId = this.boardId;

      // ● 2. 이제 수정된 payload의 값들을 백엔드로 보내주는 작업을 한다.
      await this.requestBoardModifyToSpring({
        title, content, writer, boardId,
      });

      // ● 3. 보기 페이지
      await this.$router.push({
        name: "BoardReadPage",
        params: { boardId: this.boardId },
      });
    },
  },
  created() {
    // 먼저 state에 boardId 값이 들어가 있을 것이다.
    alert("게시물을 누르면 가장 먼저 실행되는 아이가 이 친구")
    /*
      게시물을 가져오는 것은 get 요청이 필요한 것이니까 맞다맞다.
    */
    this.requestBoardToSpring(this.boardId);
  },
};
</script>

<style lang=""></style>
