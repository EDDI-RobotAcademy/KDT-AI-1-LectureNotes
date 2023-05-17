<template lang="">
  <div>
    <form @submit.prevent="onSubmit">
      <table>
        <tr>
          <td>게시물 번호</td>
          <td>
            <!-- 
              게시물 고유 번호와 작성자는 바꿔선 안된다.
            -->
            <input type="text" :value="board.boardId" disabled />
          </td>
        </tr>
        <!--
          v-model 과 v-bind 차이 ?
          제목은 양방향 통신을 위해서 v-model로 했다.
        -->
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
        <!--
          위의 submit을 막기 위해 위에서 prevent를 설정해 두었다.
          여기서 버튼을 눌러야 작동한다.
        -->
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
      this.$emit("submit", { title, content, writer });
      /*
        $emit하면 상위 컴포넌트의 onSubmit이 작동된다.

        vue에서 $는 전역 객체 속성을 말한다.
        private하게 사용하는 게 아닌 public 하게 사용하는 속성이다.

        하위 컴포넌트에서 상위 컴포넌트로 이벤트를 전달하는 경우
        이벤트 발생은 $emit('이벤트명') 속성을 사용하여 구현합니다.
      */
    },
  },
};
</script>

<style lang=""></style>
