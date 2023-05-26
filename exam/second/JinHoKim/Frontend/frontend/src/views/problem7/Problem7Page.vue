<template lang="">
    <v-container>
      <div>
        <v-row>
            <v-col v-for="(image, idx) in images" :key="idx" cols="3">
                <v-img :src="image" aspect-ratio="1" class="grey lighten-2">
                    <template v-slot:placeholder>
                        <v-row class="fill-height ma-0" align="center" justify="center">
                            <v-progress-circular indeterminate color="grey lighten-5"/>
                        </v-row>
                    </template>
                </v-img>
            </v-col>
        </v-row>
        </div>
    </v-container>
</template>

<script>
export default {
  data() {
    return {
      images: [
        require('@/assets/downloadImg/bout.jpg'),
        require('@/assets/downloadImg/crazyArcade.jpg'),
        require('@/assets/downloadImg/dongkee.jpg'),
        require('@/assets/downloadImg/mapleStory.jpg'),
        require('@/assets/downloadImg/cloud.jpg'),
        require('@/assets/downloadImg/bout.jpg'),
        require('@/assets/downloadImg/mapleStory.jpg'),
        require('@/assets/downloadImg/mapleStory.jpg'),
      ]
    }
  }
}
</script>

<style lang="">
    
</style>