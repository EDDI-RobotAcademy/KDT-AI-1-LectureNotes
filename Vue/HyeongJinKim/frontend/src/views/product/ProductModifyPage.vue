<template lang="">
  <div>
    <h2>상품 정보 수정</h2>
    <product-modify-form
      v-if="productBoard"
      :productBoard="productBoard"
      @submit="onSubmit"
    />
    <p v-else>로딩중 .......</p>
  </div>
</template>

<script>
import ProductModifyForm from "@/components/productBoard/ProductModifyForm.vue";
// local component import

import { mapActions, mapState } from "vuex";
const productBoardModule = "productBoardModule";
export default {
  components: { ProductModifyForm },

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
      "requestProductBoardModifyToSpring",
    ]),
    async onSubmit(payload) {
      const { title, content, writer } = payload;
      const boardId = this.boardId;
      await this.requestProductBoardModifyToSpring({ title, content, writer, boardId });
      await this.$router.push({
        name: "ProductReadPage",
        params: { productBoardId: this.productBoardId },
      });
    },
  },
  created() {
    this.requestProductBoardToSpring(this.productBoardId);
  },
};
</script>

<style lang=""></style>
