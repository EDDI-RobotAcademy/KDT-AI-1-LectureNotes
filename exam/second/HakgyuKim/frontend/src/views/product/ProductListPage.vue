<template lang="">
  <div>
    <h2>상품 목록</h2>
    <div>
      <button @click="register">상품 등록</button>
    </div>
    <div>
      <ProductListComponent :products="products" />
    </div>
  </div>
</template>
<script>
import { mapActions, mapState } from "vuex";
import ProductListComponent from "@/components/product/ProductListComponent.vue";

const AccountModule = "AccountModule";
const ProductModule = "ProductModule";

export default {
  data() {
    return {
      accountId: "",
    };
  },
  components: {
    ProductListComponent,
  },
  computed: {
    ...mapState(ProductModule, ["products"]),
  },
  mounted() {
    this.requestProductListToSpring();
  },
  methods: {
    ...mapActions(AccountModule, ["requestCheckRoleToSpring"]),
    ...mapActions(ProductModule, ["requestProductListToSpring"]),

    async register() {
      this.accountId = localStorage.getItem("loginUserInfo");
      if (await this.requestCheckRoleToSpring(this.accountId)) {
        this.$router.push({
          name: "ProductRegisterPage",
        });
      } else {
        alert("사업자가 아닙니다.");
      }
    },
  },
};
</script>
<style lang=""></style>
