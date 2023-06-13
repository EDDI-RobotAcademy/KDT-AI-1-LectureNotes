<template lang="">
  <v-container>
    <v-row>
      <v-col v-for="(image, idx) in images" :key="idx" cols="5">
        <v-img :src="image" aspect-ratio="1">
          <template v-slot:placeholder>
            <v-row class="fill-height ma-0" align="center" justify="center">
              <v-progress-circular indeterminate color="gray lighten-5" />
            </v-row>
          </template>
        </v-img>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  data() {
    return {
      images: [
        require("@/assets/image/vue.png"),
        require("@/assets/image/spring.png"),
      ],
    };
  },
};
</script>

<style lang=""></style>
