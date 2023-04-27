<template lang="">
  <div>
    <h2>Vue + Spring + JPA + Backlog 종합 문제 은행 [ 2 ]</h2>
    <div style="text-align: left; margin: 15px">
      <router-link :to="{ name: 'ProductRegisterPage' }"> 상품 등록 </router-link>
    </div>
    <product-list-form :Products="Products" />
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";

import ProductListForm from "@/components/productBoard/ProductListForm.vue";
// local component import

const productBoardModule = "productBoardModule";
export default {
  components: { ProductListForm },
  computed: {
    ...mapState(productBoardModule, ["productBoards"]),
  },
  mounted() {
    this.requestProductBoardListToSpring();
  },
  methods: {
    ...mapActions(productBoardModule, ["requestProductBoardListToSpring"]),
  },
};
</script>

<style lang=""></style>
