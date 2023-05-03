<template lang="">
  <div>
    <!--
    <label
      ><input
        type="radio"
        name="image"
        @change="selectImage($event)"
        value="mario.png"
      />마리오</label
    >
    <label
      ><input
        type="radio"
        name="image"
        @change="selectImage($event)"
        value="pikachu.png"
      />피카츄</label
    >
    <label
      ><input
        type="radio"
        name="image"
        @change="selectImage($event)"
        value="Charizard.jpg"
      />리자몽</label
    >
    <label
      ><input
        type="radio"
        name="image"
        @change="selectImage($event)"
        value="zelda.png"
      />젤다</label
    >
    <v-btn color="red" @click="getImage">사진 보기</v-btn>
  -->

    <v-btn color="red" @click="getImage($event)" name="mario.png" value="1"
      >마리오</v-btn
    >
    <v-btn color="yellow" @click="getImage($event)" name="pikachu.png" value="2"
      >피카츄</v-btn
    >
    <v-btn
      color="orange"
      @click="getImage($event)"
      name="Charizard.jpg"
      value="3"
      >리자몽</v-btn
    >
    <v-btn color="green" @click="getImage($event)" name="zelda.png" value="4"
      >젤다</v-btn
    >
  </div>
</template>
<script>
export default {
  data() {
    return {
      imageName: "",
    };
  },
  methods: {
    selectImage(event) {
      this.imageName = event.target.value;
      console.log(this.imageName);
    },
    async getImage(event) {
      this.imageName = event.target.name;
      console.log(this.imageName);
      const { imageName } = this;
      this.$emit("click", { imageName });
    },
  },
};
</script>
<style lang=""></style>
