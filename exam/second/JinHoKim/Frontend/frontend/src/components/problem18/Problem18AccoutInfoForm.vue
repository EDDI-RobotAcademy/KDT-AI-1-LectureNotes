<template lang="">
    <div v-if="email !== null">
        <h3>{{email}} 계정으로 로그인하셨습니다</h3>
    </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      email: null,
    }
  },
  mounted() {
    let accountId = localStorage.getItem("loginUserInfo")
    axios.post("http://localhost:7777/account/find-account-info", { accountId: accountId })
      .then((res) => {
        this.email = res.data
      })
  }
}
</script>
<style lang="">
    
</style>