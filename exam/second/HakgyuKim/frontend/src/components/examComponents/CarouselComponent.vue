<template lang="">
  <div>
    <v-carousel
      :cycle="cycle"
      :interval="interval"
      :height="height"
      v-model="carouselModel"
    >
      <v-carousel-item v-for="(image, idx) in bannerPictures" :key="idx">
        <v-sheet :height="height" tile>
          <v-row class="fill-height" align="center" justify="center">
            <v-img :src="image.img" :height="height" contain />
          </v-row>
        </v-sheet>
      </v-carousel-item>
    </v-carousel>
  </div>
</template>
<script>
export default {
  data() {
    return {
      carouselModel: false,
      bannerPictures: [
        { img: require("@/assets/imgs/bulbasaur.jpg") },
        { img: require("@/assets/imgs/charmander.png") },
        { img: require("@/assets/imgs/pikachu.png") },
        { img: require("@/assets/imgs/squirtle.png") },
      ],
      cycle: true,
      interval: 2000,
      height: 300,
    };
  },
};
</script>
<style lang=""></style>
