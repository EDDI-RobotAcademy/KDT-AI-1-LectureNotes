<template lang="">
  <v-container>

    <form @submit.prevent="onSubmit">
      <!--
        폼이 자동으로 넘어가는 것을 submit이 눌리기 전까지 방지하는 것이다.
      -->
      <label>일반회원
        <input type="radio" v-model="roleType" value="NORMAL"/>
      </label>
      <label>사업자
        <input type="radio" v-model="roleType" value="BUSINESS"/>
      </label>

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
        <button type="submit">등록</button>
      </div>
    </form>
  </v-container>
</template>

<script>
import axiosInst from '@/utility/axiosInst';

export default {
    data () {
        return {
            email: '',
            password: '',
            roleType: '',
            redo: null,
        }
    },
    methods: {
        onSubmit () {
            const { email, password, roleType } = this
            // 보낼 데이터 불변 객체화 한다.
            axiosInst.post('/account/register', { email, password, roleType })
                .then((res) => {
                    this.redo = res.data
                    if (this.redo) {
                        alert('등록 성공!')
                        // redo의 값은 boolean 타입으로 넘어오는 듯하다.
                    } else {
                        alert('이메일이 중복되었습니다!')
                    }
                })
        }
    }
}
</script>

<style lang="">
    
</style>