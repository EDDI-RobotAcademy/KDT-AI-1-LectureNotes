<template lang="">
  <v-container><!--역시나 버튼이 눌릴때 폼이 전송되는 것 예방한다.-->
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
            //보낼 데이터의 불변성을 위해 const로 선언 한다.
            axiosInst.post('/account/login', { email, password })
                .then((res) => {
                    this.userToken = res.data
                    // 로그인 성공하면 유저토큰 값을 가져와서 아래의 코드 실행한다.
                    if (!this.userToken) {
                        alert('입력 정보가 잘못되었습니다!')

                    } else {
                        localStorage.setItem("accountToken", this.userToken)
                        alert('로그인 성공!')
                    }//브라우저의 로컬 스토리지의 accountToken에 유저 토큰 저장함
                })
        }
    }
}
</script>

<style lang="">
    
</style>