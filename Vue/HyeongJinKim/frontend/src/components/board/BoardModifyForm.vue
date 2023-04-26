<template lang="">
  <div>
    <form @submit.prevent="onSubmit">
      <!-- 
        submit에 onSubmit를 맵핑
        새로고침 막기
     -->
      <table>
        <tr>
          <td>게시물 번호</td>
          <td>
            <input type="text" :value="board.boardId" disabled />
          </td>
        </tr>
        <tr>
          <td>제목</td>
          <td>
            <input type="text" v-model="title" />
          </td>
        </tr>
        <tr>
          <td>작성자</td>
          <td>
            <input type="text" :value="board.writer" disabled />
          </td>
        </tr>
        <tr>
          <td>등록일자</td>
          <td>
            <input type="text" :value="board.createDate" disabled />
          </td>
        </tr>
        <tr>
          <td>본문</td>
          <td>
            <textarea cols="70" rows="25" v-model="content" />
          </td>
        </tr>
      </table>

      <div>
        <button type="submit">수정 완료</button>
        <!-- submit의 요청에 의해 onSubmit 실행 -->
        <router-link
          :to="{
            name: 'BoardReadPage',
            params: { boardId: board.boardId.toString() },
          }"
          >수정 취소</router-link
        >
      </div>
    </form>
  </div>
</template>

<script>
export default {
  props: {
    // 수정 전의 값을 받아옴
    board: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      title: "",
      content: "",
      writer: "",
      createDate: "",
    };
  },
  created() {
    this.title = this.board.title;
    this.content = this.board.content;
    this.writer = this.board.writer;
    this.createDate = this.board.createDate;
    // BoardModifyPage에서 받아온 정보로 페이지 생성
  },
  methods: {
    onSubmit() {
      const { title, content, writer } = this;
      this.$emit("submit", { title, content, writer });
      // 새로 작성한 정보를 submit
    },
  },
};
</script>

<style lang=""></style>
