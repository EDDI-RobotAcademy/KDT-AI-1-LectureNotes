<template lang="">
  <v-container>
    <div>
      <v-carousel
        :cycle="cycle"
        :interval="interval"
        :height="height"
        v-model="carouselModel"
      >
        <v-carousel-item v-for="(picture, idx) in bannerPictures" :key="idx">
          <v-sheet :height="height" tile>
            <v-row class="fill-height" align="center" justify="center">
              <v-img :src="picture.img" :height="height" contain />
            </v-row>
          </v-sheet>
        </v-carousel-item>
      </v-carousel>
    </div>
  </v-container>
</template>

<script>
export default {
  data() {
    return {
      carouselModel: false,
      bannerPictures: [
        { img: require("@/assets/downloadImg/iu.png") },
        { img: require("@/assets/downloadImg/Doraemon.png") },
        { img: require("@/assets/downloadImg/mario_run.png") },
        { img: require("@/assets/downloadImg/Kirby.png") },
      ],
      cycle: true,
      interval: 2000,
      height: 400,
    };
  },
};
</script>

<style lang=""></style>
