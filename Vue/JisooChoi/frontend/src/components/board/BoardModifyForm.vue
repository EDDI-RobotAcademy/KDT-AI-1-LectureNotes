<template lang="">
  <div>
    <form @submit.prevent="onSubmit">
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
    // BoardReadPage 에서 boardId 값을 매개변수로 받아왔다.
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
    // 가장 먼저 수정한 값을 넣어준다.
    this.title = this.board.title;
    this.content = this.board.content;
    this.writer = this.board.writer;
    this.createDate = this.board.createDate;
  },
  methods: {
    onSubmit() {
      const { title, content, writer } = this;
          // ↓emit하면 BoardModifyPage.vue의 onSubmit 작동이 작동된다.
      this.$emit("submit", { title, content, writer });
      // vue에서 $는 전역 객체 속성을 말한다.
      // private하게 사용하는 게 아닌 public 하게 사용하는 속성이다.

      // 하위 컴포넌트에서 상위 컴포넌트로 이벤트를 전달하는 경우
      // 이벤트 발생은 $emit('이벤트명') 속성을 사용하여 구현합니다.
    },
  },
};
</script>

<style lang=""></style>
