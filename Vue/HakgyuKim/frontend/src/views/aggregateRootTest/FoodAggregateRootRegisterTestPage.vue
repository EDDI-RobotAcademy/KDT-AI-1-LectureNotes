<template lang="">
  <!-- 
        우리가 어떤 석재료를 판매한다고 가정하겠습니다
        이 때 사업자 혹은 물건을 판매하는 판매자는 상품을 등록해야 합니다
        상품을 등록 할 때 사진, 재료 자체, 단위(그램, 개수), 
        카테고리(육류, 뭔지 등등)
    -->
  <div>
    <v-container>
      <h2>식재료 등록</h2>
      <FoodAggregateRootRegisterForm @submit="onSubmit" />
    </v-container>
  </div>
</template>

<script>
import FoodAggregateRootRegisterForm from "@/components/food/FoodAggregateRootRegisterForm.vue";
import { mapActions } from "vuex";

const FoodModule = "FoodModule";

export default {
  components: {
    FoodAggregateRootRegisterForm,
  },
  methods: {
    ...mapActions([FoodModule, "requestCreateFoodToSpring"]),
    async onSubmit(payload) {
      await this.requestCreateFoodToSpring(payload);
      await this.$router.push({
        name: "home",
      });
    },
  },
};
</script>

<style lang=""></style>
