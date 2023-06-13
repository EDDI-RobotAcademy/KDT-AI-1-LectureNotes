<template lang="">
  <div>
    <ProductRegisterComponent @submit="onSubmit" />
  </div>
</template>
<script>
import ProductRegisterComponent from "@/components/product/ProductRegisterComponent.vue";
import { mapActions } from "vuex";

const ProductModule = "ProductModule";

export default {
  components: { ProductRegisterComponent },
  methods: {
    ...mapActions(ProductModule, ["requestCreateProductToSpring"]),

    async onSubmit(payload) {
      await this.requestCreateProductToSpring(payload);
      this.$router.push({
        name: "ProductListPage",
      });
    },
  },
};
</script>
<style lang=""></style>
