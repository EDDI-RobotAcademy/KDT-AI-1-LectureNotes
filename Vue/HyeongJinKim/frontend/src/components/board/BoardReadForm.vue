<template lang="">
  <div>
    <table>
      <tr>
        <td>게시물 번호</td>
        <!-- readonly: 읽기전용 태그 -->
        <td>
          <input type="text" :value="board.boardId" readonly />
        </td>
      </tr>
      <tr>
        <td>제목</td>
        <td>
          <input type="text" :value="board.title" readonly />
        </td>
      </tr>
      <tr>
        <td>작성자</td>
        <td>
          <input type="text" :value="board.writer" readonly />
        </td>
      </tr>
      <tr>
        <td>등록일자</td>
        <td>
          <input type="text" :value="board.createDate" readonly />
        </td>
      </tr>
      <tr>
        <td>본문</td>
        <td>
          <textarea cols="80" rows="30" :value="board.content" readonly />
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "BoardReadForm",
  props: {
    board: {
      // BoardReadPage에서 받아온 boardId -> board의 정보
      type: Object,
      required: true,
    },
  },
};
</script>

<style lang=""></style>
