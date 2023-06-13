<template lang="">
  <div>
    <table style="margin: 10px">
      <tr>
        <th text-align="center" width="20%">번호</th>
        <th text-align="center" width="60%">이름</th>
        <th text-align="center" width="20%">가격</th>
      </tr>
      <tr
        v-if="!products || (Array.isArray(products) && products.length === 0)"
      >
        <td colspan="3">현재 등록된 상품이 없습니다</td>
      </tr>
      <tr v-else v-for="(product, index) in products" :key="index">
        <td text-align="center">
          {{ product.id }}
        </td>
        <td text-align="center">
          {{ product.name }}
        </td>
        <td text-align="center">
          {{ product.price }}
        </td>
      </tr>
    </table>
  </div>
</template>
<script>
export default {
  props: {
    products: {
      type: Array,
    },
  },
};
</script>
<style lang=""></style>
