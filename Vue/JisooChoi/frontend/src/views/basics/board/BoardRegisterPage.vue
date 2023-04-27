<template lang="">
  <div>
    <h2>게시물 작성</h2>
    <!--
      하위 컴포넌트에서 submit 클릭 이벤트가 발생되면 상위 컴포넌트(이곳)onSubmit을 실행한다.
    -->
    <board-register-form @submit="onSubmit" />
  </div>
</template>

<script>
import BoardRegisterForm from "@/components/board/BoardRegisterForm.vue";
import { mapActions } from "vuex";

const boardModule = "boardModule";

export default {
  components: {
    BoardRegisterForm,
  },
  name: "BoardRegisterPage",
  methods: {
    ...mapActions(boardModule, ["requestCreateBoardToSpring"]),
    /*
      payload에는 하위 컴포넌트 인 BoardRegisterForm에서 발생한 이벤트 값이 전달된다.
    */
    async onSubmit(payload) {
      /*
        여기서 board는 지역변수일 뿐이고, 우리가 받아온 결과 값은 현재 엔터티 타입인데
        javascript에서는 이를 Object 타입으로 받아오고 있다.

        그렇기에 아래 console에 typeof(board)를 찍어서 타입을 확인해 볼 수 있는 것이다.

        또한 사실상 this.requestCreateBoardToSpring(payload)가 action 동작이 되게 해주는 코드이다.
      */
      const board = await this.requestCreateBoardToSpring(payload);
      console.log("board: " + JSON.stringify(board));
      console.log("typeof(board): "+ typeof(board));

      /* 읽기 동작 */
      await this.$router.push({
        /*
          $는 vue에서 전역 객체 속성이다.
          private하게 사용하는 게 아닌 public하게 사용하는 속성을 말한다.
        */
        name: "BoardReadPage",
        params: { boardId: board.data.boardId.toString() },
      });
    },
  },
};
</script>

<style></style>
