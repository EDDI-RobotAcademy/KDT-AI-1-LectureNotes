<template lang="">
  <div>
    <h2>상품 등록</h2>
    <product-register-form @submit="onSubmit" />
  </div>
</template>

<script>
import ProductRegisterForm from "@/components/productBoard/ProductRegisterForm.vue";
import { mapActions } from "vuex";
const productBoardModule = "productBoardModule";
export default {
  components: { ProductRegisterForm },
  name: "ProductRegisterPage",
  methods: {
    ...mapActions(productBoardModule, ["requestCreateProductBoardToSpring"]),
    async onSubmit(payload) {
      const productBoard = await this.requestCreateBoardToSpring(payload);
      console.log("board: " + JSON.stringify(productBoard));
      await this.$router.push({
        name: "ProductReadPage",
        params: { productBoardId: productBoard.data.productBoardId.toString() },
      });
    },
  },
};
</script>

<style lang=""></style>
