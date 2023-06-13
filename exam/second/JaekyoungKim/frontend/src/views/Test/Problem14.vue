<template lang="">
    <div>
        <div style="text-align: center">
            <h3>일반 회원 가입</h3>
        <v-btn color="primary" @click="readyToCreateAccount">계정 생성</v-btn>
    
        <div v-if="isPressedNormalButton">
            <div>
                <label>
                    이메일: <input type="text" v-model="email"/>
                </label><br/>
                <label>
                    비밀번호: <input type="password" v-model="password"/>
                </label><br/>
            </div>
            <v-btn color="purple" @click="processCreateNormal">완료</v-btn>
          
        </div>
    </div>
    <br><br>
    <br>
    <div style="text-align: center">
            <h3>사업자 회원 가입</h3>
            <v-btn color="primary" @click="readyToCreateBusinessAccount">계정 생성</v-btn>
    
    <div v-if="isPressedBusinessButton">
        <div>
            <label>
                이메일: <input type="text" v-model="email"/>
            </label><br/>
            <label>
                비밀번호: <input type="password" v-model="password"/>
            </label><br/>
            <label>
                사업자 번호: <input type="number" v-model="businessCode"/>
            </label><br/>
            <label>
              <button @click="isChecked">사업자 버튼</button>
            </label><br/>
        </div>
        <v-btn color="purple" @click="processCreateBusiness">완료</v-btn>
      
    </div>
        <button></button>


    </div></div>
</template>
<script>
import axios from 'axios'
export default {
    methods: {
        isChecked(){
            this.role='BUSINESS'
            alert("사업자 회원 체크 되었습니다!")
        },
        readyToCreateAccount(){
            this.isPressedNormalButton=true
        },
        readyToCreateBusinessAccount(){
            this.isPressedBusinessButton=true
        },
        processCreateNormal(){ 
            this.isPressedNormalButton = false
            const { email, password ,role} = this
            axios.post('http://localhost:7777/account-test/normal-test', { email, password,role })
                .then((res) => {
                    if (res.data) {
                        alert('계정 생성 완료!')
                    } else {
                        alert('동일한 계정이 이미 존재합니다')
                    }  
                })
        },
        processCreateBusiness(){ 
            this.isPressedBusinessButton = false
            const { email, password ,role,businessCode} = this
            axios.post('http://localhost:7777/account-test/business-test', { email, password,role,businessCode })
                .then((res) => {
                    if (res.data) {
                        alert('계정 생성 완료!')
                    } else {
                        alert('동일한 계정이 이미 존재합니다')
                    }  
                })
        }
    },
    data() {
        return {
            isPressedNormalButton:false,
            isPressedBusinessButton:false,
            email:'',
            password:'',
            role:'NORMAL',
            businessCode:''
        }
    },
    
}
</script>
<style lang="">
    
</style>