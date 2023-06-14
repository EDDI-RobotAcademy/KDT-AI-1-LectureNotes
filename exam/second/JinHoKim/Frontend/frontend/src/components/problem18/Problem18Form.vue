<template lang="">
    <div>
        <v-btn color="primary" @click="readyToCreateAccount">회원가입</v-btn>
        <div v-if="isPressedButton">
            <div>
                <label>
                    이메일: <input type="text" v-model="email"/>
                </label><br>
                
                <label>
                    비밀번호: <input type="password" v-model="password"/>
                </label><br>

                <label>
                  <input type="checkbox" v-model="isChecked">일반회원
                </label>
                <label>
                  <input type="checkbox" v-model="isChecked2">사업자 회원
                </label>
            </div>
            <v-btn color="purple" @click="processCreateAccount">완료</v-btn>
        </div>
    </div>
</template>
<script>
import axios from 'axios'

export default {
  data() {
    return {
      email: "",
      password: "",
      isPressedButton: false,
      isChecked: false,
      isChecked2: false,
    }
  },

  methods: {
    readyToCreateAccount() {
      this.isPressedButton = true
      alert('회원가입하기')
    },
    processCreateAccount() {
      this.isPressedButton = false

      const { email, password,  isChecked, isChecked2 } = this
      axios.post("http://localhost:7777/account/create", { email, password, isChecked ,isChecked2 })
        .then((res) => {
          if (res.data) {
            alert("계정 생성 완료!")
          } else {
            alert("동일한 계정이 이미 존재합니다")
          }
        })
    }
  },

}
</script>
<style lang="">
    
</style>