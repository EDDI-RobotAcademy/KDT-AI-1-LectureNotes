<template lang="">
  <v-container>
    <v-row>
      <v-col v-for="(image, idx) in images" :key="idx" cols="3">
        <v-img :src="image" aspect-ratio="1" class="grey lighten-2">
          <!-- placeholder = 로딩 길 때를 위한-->
          <template v-slot:placeholder>
            <v-row class="fill-height ma-0" align="center" justify="center">
              <v-progress-circular indeterminate color="grey lighten-5" />
            </v-row>
          </template>
        </v-img>
      </v-col>
    </v-row>

    <v-img
      :src="require(`@/assets/downloadImg/${imageName}`)"
      aspect-ratio="1"
      class="grey lighten-2"
    >
    </v-img>
  </v-container>
</template>
<script>
export default {
  data() {
    return {
      imageName: "pikachu.png",
      images: [
        require("@/assets/downloadImg/mario.png"),
        require("@/assets/downloadImg/pikachu.png"),
        require("@/assets/downloadImg/zelda.png"),
        require("@/assets/downloadImg/Charizard.jpg"),
      ],
    };
  },
};
</script>
<style lang=""></style>
