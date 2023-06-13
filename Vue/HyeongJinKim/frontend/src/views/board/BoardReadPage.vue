<template lang="">
  <div>
    <h2>Vue + Spring + JPA 게시판 읽기</h2>
    <board-read-form v-if="board" :board="board" />
    <!-- 
      받아온 board의 정보를 board-read-form에 전달
      board-read-form에서 객체 정보를 출력한다.
     -->
    <p v-else>로딩중 .......</p>
    <!-- create되어 mount되기 전 board가 비어있다면 로딩 -->
    <router-link :to="{ name: 'BoardModifyPage', params: { boardId } }">
      게시물 수정
    </router-link>
    <!-- 
      게시물 수정 시 boardId값을 들고 BoardModifyPage로
     -->
    <button @click="onDelete">삭제</button>
    <router-link :to="{ name: 'BoardListPage' }"> 돌아가기 </router-link>
  </div>
</template>

<script>
import BoardReadForm from "@/components/board/BoardReadForm.vue";
// local component import
import { mapActions, mapState } from "vuex";
const boardModule = "boardModule";
export default {
  components: { BoardReadForm },

  props: {
    boardId: {
      // BoardRegisterPage에서 전달받은 Id값
      type: String,
      required: true,
    },
  },

  computed: {
    ...mapState(boardModule, ["board"]),
    // board 모니터링
  },

  methods: {
    ...mapActions(boardModule, [
      "requestBoardToSpring",
      "requestDeleteBoardToSpring",
    ]),
    // boardModule에 requestBoardToSpring, requestDeleteBoardToSpring 맵핑

    async onDelete() {
      // onDelete 함수 비동기처리
      await this.requestDeleteBoardToSpring(this.boardId);
      // 받아온 boardId값을 매개변수로 requestDeleteBoardToSpring 실행
      await this.$router.push({ name: "BoardListPage" });
    },
  },
  created() {
    this.requestBoardToSpring(this.boardId);
    // 받아온 boardId을 매개변수로 backend에 데이터 요청
    // boardId값으로 board의 정보를 받아와서 boardModule - board 에 저장
  },
};
</script>
<style lang=""></style>
