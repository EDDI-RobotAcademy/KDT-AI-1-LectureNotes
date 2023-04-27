<template lang="">
  <div>
    <h2>Vue + Spring + JPA 게시판 읽기</h2>
    <!--
      만약 board에 값이 있으면 컴포넌트를 실행하고,
      매개변수를 전달해준다.

      여기서 board가 보이는 시점(=바인딩)은 mounted가 끝난 시점이다.
    -->
    <board-read-form v-if="board" :board="board" />
    <p v-else>로딩중 .......</p>

    <router-link :to="{ name: 'BoardModifyPage', params: { boardId } }">
      게시물 수정
    </router-link>
    <button @click="onDelete">삭제</button>
    
    <!--  다른 컴포넌트들 이 있으므로, index.js에 components: defualt 가 있었던 것이다.-->
    <router-link :to="{ name: 'BoardListPage' }"> 돌아가기 </router-link>
  </div>
</template>

<script>
import BoardReadForm from "@/components/board/BoardReadForm.vue";
import { mapActions, mapState } from "vuex";

const boardModule = "boardModule";

export default {
  components: {
    BoardReadForm,
  },
  props: {
    /*
      BoardRegisterPage 혹은 BoardModifyForm, BoardModifyPage 에서
      해당 페이지를 불렀으며, 파라미터 값으로 boardId를 보냈다.
    */
    boardId: {
      type: String,
      required: true,
    },
  },
  computed: {
    // Q.여기서 받아온 board가 하위 컴포넌트의 매개변수로 들어가는 게 맞나 ?
    ...mapState(boardModule, ["board"]),
  },
  methods: {                        // 게시물 읽기              // 게시물 지우기
    ...mapActions( boardModule, ["requestBoardToSpring", "requestDeleteBoardToSpring"]),
    async onDelete() {
      /*
        async, await 이런 부분 잘 기억하며, 같이 쓰기
        동기적으로 사용하겠다고 명시해주는 것이다.

        원래 자바 스크립트는 비동기적으로 동작을 해서
        아직 끝나지 않은 작업이 있다고 하면
        그 작업이 화면에 뜨지 않는 상황이 발생한다.

        그러한 상황들을 개선하고자 동기적 단계가 필요한 곳에는 명시를 해준다.
      */
      await this.requestDeleteBoardToSpring(this.boardId);
      await this.$router.push({
        name: "BoardListPage"
      });
    },
  },
  created() {
    // 가장 먼저 action이 실행되는 코드이다.
    this.requestBoardToSpring(this.boardId);
  },
};
</script>
<style lang=""></style>
