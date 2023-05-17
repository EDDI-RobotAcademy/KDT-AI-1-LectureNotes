<template lang="">
  <v-container>
    <v-data-table
      :headers="headerTitle"
      :items="contents"
      :items-per-page="7"
      class="elevation-1"
    />
  </v-container>
</template>
<script>
export default {
  data() {
    return {
      headerTitle: [
        { text: "번호", value: "boardId", width: "70px" },
        { text: "제목", value: "title", width: "200px" },
        { text: "작성자", value: "writer", width: "100px" },
      ],
      contents: [
        { boardId: 1, title: "가즈아!", writer: "우딜" },
        { boardId: 2, title: "어디갈건데?", writer: "방구석" },
        { boardId: 3, title: "주식", writer: "나락" },
        { boardId: 4, title: "마포대교", writer: "오늘간다" },
        { boardId: 5, title: "주님", writer: "제가" },
        { boardId: 6, title: "존버", writer: "떡상" },
        { boardId: 7, title: "골로감", writer: "우딜어딨냐" },
        { boardId: 8, title: "단타ㄱ", writer: "ㄹㅇㅋㅋ" },
        { boardId: 9, title: "무야호", writer: "무야호" },
        { boardId: 10, title: "하이", writer: "바이" },
        { boardId: 11, title: "헬로우", writer: "헬로" },
        { boardId: 12, title: "곰방와", writer: "곰방와" },
      ],
    };
  },
};
</script>
<style lang=""></style>
