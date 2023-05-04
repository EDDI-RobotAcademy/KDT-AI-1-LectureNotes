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
        { boardId: 1, title: "10번", writer: "20번" },
        { boardId: 2, title: "11번", writer: "21번" },
        { boardId: 3, title: "12번", writer: "22번" },
        { boardId: 4, title: "13번", writer: "23번" },
        { boardId: 5, title: "14번", writer: "24번" },
        { boardId: 6, title: "15번", writer: "25번" },
        { boardId: 7, title: "16번", writer: "26번" },
        { boardId: 8, title: "17번", writer: "27번" },
        { boardId: 9, title: "18번", writer: "28번" },
        { boardId: 10, title: "19번", writer: "29번" },
        { boardId: 11, title: "20번", writer: "30번" },
        { boardId: 12, title: "21번", writer: "31번" },
      ],
    };
  },
};
</script>
<style lang=""></style>
