<template lang="">
  <div>
    <p>로그인 중인 계정: {{ myEmail }}</p>
    <p>Account ID: {{ myAccountId }}</p>
  </div>
</template>

<script>
export default {
  props: {
    myEmail: String,
    myAccountId: Number,
  },
  data() {
    return {
      characterGender: "",
    };
  },
};
</script>

<style lang=""></style>
