<template lang="">
  <div>
    <!--
        prevent를 넣어주어야 게시물을 등록하고 읽기 형태가 된다.
        만일, 없을 경우에는 게시물을 등록하고 새 게시물 등록 페이지가 뜬다.
    -->
    <form @submit.prevent="onSubmit">
      <table>
        <tr>
          <td>제목</td>
          <td>
            <input type="text" v-model="title" />
          </td>
        </tr>
        <tr>
          <td>작성자</td>
          <td>
            <input type="text" v-model="writer" />
          </td>
        </tr>
        <tr>
          <td>본문</td>
          <td>
            <textarea cols="80" rows="30" v-model="content" />
          </td>
        </tr>
      </table>

      <div>
        <!-- ★ 아래 type="submit" 부분은 없어도 잘 동작함 -->
        <button type="submit">등록</button>
        <router-link :to="{ name: 'BoardListPage' }"> 취소 </router-link>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  name: "BoardRegisterForm",
  data() {
    return {
      title: "제목을 입력하세요",
      writer: "누구세요 ?",
      content: "본문을 입력하세요",
    };
  },
  methods: {
    onSubmit() {
      // 불변 객체 만들어주기
      const { title, writer, content } = this;
      // BoardRegisterPage의 @submit은 여기의 submit에 대응함
      this.$emit("submit", { title, writer, content });
      // vue에서 $는 전역 객체 속성을 말한다.
      // private하게 사용하는 게 아닌 public 하게 사용하는 속성이다.

      // 하위 컴포넌트에서 상위 컴포넌트로 이벤트를 전달하는 경우
      // 이벤트 발생은 $emit('이벤트명') 속성을 사용하여 구현합니다.
    },
  },
};
</script>

<style lang=""></style>
