<template lang="">
  <form @submit="onSubmit">
    <div>
      <label>상품명: </label>
      <input type="text" v-model="name" />
    </div>
    <div>
      <label>가격: </label>
      <input type="number" v-model="price" />
    </div>
    <div>
      <label>상품 사진</label>
      <input
        type="file"
        id="files"
        ref="files"
        multiple
        @change="handleFileUpload"
      />
    </div>
    <div>
      <button type="submit">등록</button>
    </div>
  </form>
</template>
<script>
export default {
  data() {
    return {
      name: "",
      price: "1000",
      files: "",
    };
  },
  methods: {
    onSubmit() {
      let formData = new FormData();
      for (let idx = 0; idx < this.files.length; idx++) {
        formData.append("imageFile", this.files[idx]);
      }
      const { name, price, files } = this;
      let productInfo = {
        name: name,
        price: price,
      };
      formData.append(
        "productInfo",
        new Blob([JSON.stringify(productInfo)], { type: "application/json" })
      );
      this.$emit("submit", formData);
    },
    handleFileUpload() {
      this.files = this.$refs.files.files;
    },
  },
};
</script>
<style lang=""></style>
