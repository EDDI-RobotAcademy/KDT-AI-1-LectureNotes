<template lang="">
  <div>
    <h2>Vue + Spring + JPA + Backlog 종합 문제 은행 [ 2 ]</h2>
    <product-read-form v-if="productBoard" :productBoard="productBoard" />
    <p v-else>로딩중 .......</p>
    <router-link :to="{ name: 'ProductModifyPage', params: { productBoardId } }">
      저장
    </router-link>
    <button @click="onDelete">삭제</button>
    <router-link :to="{ name: 'ProductListPage' }"> 돌아가기 </router-link>
  </div>
</template>

<script>
import BoardReadForm from "@/components/productBoard/productReadForm.vue";
import { mapActions, mapState } from "vuex";
const productBoardModule = "productBoardModule";
export default {
  components: { ProductReadForm },
  props: {
    productBoardId: {
      type: String,
      required: true,
    },
  },
  computed: {
    ...mapState(productBoardModule, ["productBoard"]),
  },
  methods: {
    ...mapActions(productBoardModule, [
      "requestProductBoardToSpring",
      "requestProductDeleteBoardToSpring",
    ]),
    async onDelete() {
      await this.requestDeleteProductBoardToSpring(this.productBoardId);
      await this.$router.push({ name: "ProductListPage" });
    },
  },
  created() {
    this.requestProductBoardToSpring(this.boardId);
  },
};
</script>
<style lang=""></style>
