<template lang="">
  <div>
    <v-img
      :src="require(`@/assets/downloadImg/${imageName}`)"
      aspect-ratio="1"
      class="grey lighten-2"
    ></v-img>
  </div>
</template>
<script>
export default {
  props: {
    imageName: {
      type: String,
      required: true,
    },
  },
};
</script>
<style lang=""></style>
