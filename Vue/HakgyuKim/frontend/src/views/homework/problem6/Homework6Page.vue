<template lang="">
  <div>
    <image-button-form @click="onClick" />
  </div>
</template>

<script>
import ImageButtonForm from "@/components/imageProblem/ImageButtonForm.vue";
import { mapActions } from "vuex";

const imageModule = "ImageModule";

export default {
  components: {
    ImageButtonForm,
  },
  data() {
    return {
      imageName2: "",
    };
  },
  methods: {
    ...mapActions(imageModule, ["requestImageNameToSpring"]),
    async onClick(payload) {
      const { imageName } = payload;
      console.log(imageName);
      this.imageName2 = await this.requestImageNameToSpring({ imageName });
      await this.$router.push({
        name: "ImagePage",
        params: { imageName: this.imageName2 },
      });
    },
  },
};
</script>
<style lang=""></style>
