<template lang="">
  <div>
    <h2>Vue + Spring + JPA 게시판</h2>
    <div style="text-align: left; margin: 15px">
      <!-- <router-link :to="{ name: 'BoardRegisterPage' }"> 게시물 작성 </router-link> -->
    </div>
    <board-list-form :boards="boards" />
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";
import BoardListForm from "@/components/board/components/BoardListForm.vue";

const boardModule = "boardModule";
export default {
  components: { BoardListForm },
  computed: {
    ...mapState(boardModule, ["boards"]),
  },
  mounted() {
    this.requestBoardListToSpring();
  },
  methods: {
    ...mapActions(boardModule, ["requestBoardListToSpring"]),
  },
};
</script>

<style lang=""></style>
