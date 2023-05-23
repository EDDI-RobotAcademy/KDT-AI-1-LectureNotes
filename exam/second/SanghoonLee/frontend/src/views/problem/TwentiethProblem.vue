<template lang="">
  <v-container>
    <form @submit.prevent="onSubmit">
      <table>
        <tr>
          <td>이메일</td>
          <td>
            <input type="text" v-model="email"/>
          </td>
        </tr>
        <tr>
          <td>비밀번호</td>
          <td>
            <input type="text" v-model="password"/>
          </td>
        </tr>
      </table>

      <div>
        <button type="submit">로그인</button>
      </div>
    </form>
  </v-container>
</template>

<script>
import axiosInst from '@/utility/axiosInst'

export default {
    data () {
        return {
            email: '',
            password: '',
            userToken: '',
        }
    },
    methods: {
        onSubmit () {
            const { email, password } = this
            axiosInst.post('/account/login', { email, password })
                .then((res) => {
                    this.userToken = res.data

                    if (!this.userToken) {
                        alert('입력 정보가 잘못되었습니다!')
                    } else {
                        localStorage.setItem("accountToken", this.userToken)
                        alert('로그인 성공!')
                    }
                })
        }
    }
}
</script>

<style lang="">
    
</style>