<template lang="">
  <v-container>
    <v-row>
      <v-col cols="12">
        <v-img
          :src="require(`@/assets/downloadImg/${imageName}`)"
          aspect-ratio="1"
          class="grey lighten-2"
        >
          <template v-slot:placeholder>
            <v-row class="fill-height ma-0" align="center" justify="center">
              <v-progress-circular indeterminate color="grey lighten-5" />
            </v-row>
          </template>
        </v-img>
      </v-col>
    </v-row>
    <h2>Hi</h2>
  </v-container>
</template>

<script>
import { mapActions } from "vuex";
const uiVuetifyModule = "uiVuetifyModule";
export default {
  data() {
    return {
      imageName: "",
    };
  },
  async mounted() {
    this.imageName = await this.requestImagePathToSpring();
  },
  methods: {
    ...mapActions(uiVuetifyModule, ["requestImagePathToSpring"]),
  },
};
</script>

<style lang=""></style>
