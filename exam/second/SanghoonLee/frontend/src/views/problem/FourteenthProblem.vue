<template lang="">
  <v-container>

    <form @submit.prevent="onSubmit">
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
            axiosInst.post('/account/register', { email, password, roleType })
                .then((res) => {
                    this.redo = res.data
                    if (this.redo) {
                        alert('등록 성공!')
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