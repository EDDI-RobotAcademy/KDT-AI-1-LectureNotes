<template>
    <v-row>
      <v-col
        v-for="(image,idx) in images"
        :key="idx"
        class="d-flex child-flex"
        cols="4"
      >
        <v-img
        :src="image"
          aspect-ratio="1"
          cover
          class="bg-grey-lighten-2"
        >
          <template v-slot:placeholder>
            <v-row
              class="fill-height ma-0"
              align="center"
              justify="center"
            >
              <v-progress-circular
                indeterminate
                color="grey-lighten-5"
              ></v-progress-circular>
            </v-row>
          </template>
        </v-img>
      </v-col>
    </v-row>
  </template>
<script>
export default {
    data(){
        return{
            imageName: "clound.jpg",
            images: [
            require('@/assets/downloadImg/loz.jpg'),
            require('@/assets/downloadImg/마리오.png'),
            require('@/assets/downloadImg/clound.jpg'),
            require('@/assets/downloadImg/naruto.jpg'),
            ]
        }
    }
    
}
</script>
<style lang="">
    
</style>