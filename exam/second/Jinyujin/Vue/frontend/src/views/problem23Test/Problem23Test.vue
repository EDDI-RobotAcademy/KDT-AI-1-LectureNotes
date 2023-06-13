<!-- 
    1. 상품을 등록할 수 있는 UI를 만듭니다
       - 
 -->


<template lang="">
     <div align="center">
    <v-container>
      <h2>상품 등록</h2>
      <product-register-form @submit="onSubmit"/>
    </v-container>
  </div>
</template>

<script>

import { mapActions } from 'vuex';
import ProductRegisterForm from '@/components/product/ProductRegisterForm.vue';

const productModule = 'productModule'

export default {
    components: {
        ProductRegisterForm
    },

    methods: {
        ...mapActions(productModule, ['requestCreateProductToSpring']),

        async onSubmit(payload) {
            await this.requestCreateProductToSpring(payload)
        }
    },
}
</script>

<style lang="">
</style>