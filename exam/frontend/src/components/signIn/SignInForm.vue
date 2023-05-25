<template lang="">
<form @submit.prevent="onSubmit" >
    <div align="center">
        <table>      
      <tr>
        <td>
          <h3>로그인</h3>
          <hr/>
          <div>
            <input type="text" v-model="email">
            <label>email</label>
          </div>
          <div>
            <input type="text" v-model="password">
            <label>password</label>
          </div>        
        </td>
      </tr>
      <tr>
        <td>
          <h3>Category</h3>
          <hr/>
          <div>
            <input type="radio" v-model="category" name="radioBtn" value="NORMAL">
            <label>일반 회원</label>
          </div>
          <div>
            <input type="radio" v-model="category" name="radioBtn" value="BUSINESS">
            <label>사업자 회원</label>
          </div>
          <div>
            <input type="text" v-model="businessNumber">
            <label>businessNumber</label>
          </div>         
        </td>
      </tr>    
    </table>
    </div>
    <div>
        <button type="submit" align="center">Sign In</button>
    </div>
</form>
</template>
<script>
export default {
    data() {
        return {
            email: '',
            password: '',
            category: '',
            businessNumber: '0000000000',
        }
    },
    methods: {        
        onSubmit () {
            if (this.category === 'NORMAL') {
                this.businessNumber = '0000000000';
                }

            if (this.category === 'BUSINESS' && this.businessNumber.length > 8) {
                alert('사업자 번호를 정확히 입력하세요');
                return null;
                }

            if (this.businessNumber.length > 8) {
                alert('사업자 번호를 정확히 입력하세요');
                return null;
                }
            
            let formData = new FormData()

            const { email, password, category, businessNumber } = this

            formData.append('email', email)
            formData.append('password', password)
            formData.append('category', category)
            formData.append('businessNumber', businessNumber)

            this.$emit('submit', formData)
            alert('신청 완료')
        }
    }
}
</script>
<style lang="">
    
</style>