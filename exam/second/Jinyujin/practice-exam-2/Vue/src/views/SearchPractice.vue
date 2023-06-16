<template>
  <div> 

    <input type="text" v-model="searchTerm" placeholder="상품명을 입력하세요"/>
        <v-btn :small=true raised type="submit">검색</v-btn>

    <ul>
      <li v-for="product in filteredProducts" :key="product.id">
        {{ product.name }}
      </li>
    </ul>

  </div>
</template>

<script>
export default {
  data() {
    return {
      products: [
        { id: 1, name: "Macbook Pro" },
        { id: 2, name: "iPhone 12" },
        { id: 3, name: "iPad Pro" },
        { id: 4, name: "Apple Watch" },
        { id: 5, name: "AirPods" },
      ],
      searchTerm: "",
    };
  },
  computed: {
    filteredProducts() {
      return this.products.filter((product) =>
        product.name.toLowerCase().includes(this.searchTerm.toLowerCase())
      );
    },
  },
};
</script>

<style>

</style>