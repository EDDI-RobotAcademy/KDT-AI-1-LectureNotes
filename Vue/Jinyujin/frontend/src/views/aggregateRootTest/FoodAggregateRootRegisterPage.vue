<!-- 
    테스트하는 대상이 식재료
    시나리오
    우리가 어떤 식재료을 판매한다고 가정하겠습니다
    이 때 사업자 혹은 물건을 판매하는 판매자는 식재료를 등록해야 합니다
    상품을 등록할 때 (실제 상품에 대한 정보, 사진에 대한 정보, 
    상품의 수량에 대한 정보(예를 들어 음식의 경우 개수 or gram))
    사진, 재료 자체, 단위(그람, 개수), 
    카테고리(육류, 채소 등등) 등등을 등록해야 합니다
    이 시나리오를 바탕으로 만들어보자
-->
<template lang="">
     <div align="center">
    <v-container>
      <h2>식재료 등록</h2>
      <!-- 실제 재료를 등록하기 위한 폼 -->
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
    // 템플레이트 다 짜고
    // 메서드가 필요할 것이고
    // 그 안에는 맵액션이 필요할 것 같아 미리 넣어줌
    methods: {
        ...mapActions(foodModule, ['requestCreateFoodToSpring']),
        // 그리고 onSubmit에 async-await 걸어줌
        async onSubmit(payload) {
            await this.requestCreateFoodToSpring(payload)
            await this.$router.push({
                name: 'home',
            })
        }
        // 여기까지 하고 스토어, 라우터, 컴포넌트 작업ㄱㄱ
    },
}
</script>

<style lang="">
</style>