<template lang="">
  <!--
    우리가 어떤 식재료를 판매한다고 가정하겠습니다
    이 때 사업자 혹은 물건을 판매하는 판매자는 식재료를 등록해야 합니다
    상품을 등록 할 때 사진, 재료 자체, 단위(그람, 개수),
    카테고리(육류, 뭔지 등등) 등등을 등록해야합니다
  -->
  <div>
    <v-container>
      <h2>식재료 등록</h2>
      <food-aggregate-root-register-form @submit="onSubmit"/>
    </v-container>
  </div>
</template>

<script>
import { mapActions } from 'vuex';
import FoodAggregateRootRegisterForm from '@/components/food/FoodAggregateRootRegisterForm.vue';

const foodModule = 'foodModule'

export default {
    components: {
      FoodAggregateRootRegisterForm
    },
    methods: {
      ...mapActions(foodModule, ['requestCreateFoodToSpring']),
      async onSubmit (payload) {
        await this.requestCreateFoodToSpring(payload)
        await this.$router.push({
          name: 'home',
        })
      }
    },
}

</script>

<style lang="">
    
</style>