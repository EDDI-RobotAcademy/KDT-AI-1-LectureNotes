<template lang="">
    <!--
        ★ 17번 문제 프론트 백로그 (백엔드 파트는 Spring에 있습니다 !)

        front
        1. 사용자가 계정 정보를 기입하고 로그인하기 버튼을 누르면 계정 정보가 전송되는 컴포넌트를 만듭니다.
        - Success Criteria
            (1) 계정 정보를 기입합니다.
            (2) 계정의 정보는 이메일, 비밀번호, 역할, 관리자 추가 정보로 구성되어 있습니다.
            (3) 항목을 기입한 후 로그인 버튼을 누르면 백엔드로 정보가 전송됩니다.

        - To Do
            [o] email, password, role input 처리
            [o] 로그인 버튼 생성
            [o] axios를 통한 backend 요청
    -->

    <v-container>
        <h2>로그인 하기</h2>
        <div>
            <input type="text" v-model="email" placeholder="email을 기입해주세요." /><br />
            <input type="password" v-model="password" placeholder="password를 기입해주세요." /><br />
            <input type="role" v-model="role" placeholder="role (일반/사업자)" /><br />
            <input type="text" v-model="managerRoleNum" placeholder="only 사업자 (10자리)" /><br />
            <v-btn color="orange" @click="loginBtn">로그인</v-btn>
        </div>
    </v-container>
</template>

<script>
import axios from "axios";

export default {
    data() {
        return {
            email: "",
            password: "",
            role: "",
            managerRoleNum: null,
        }
    },
    methods: {
        loginBtn () {
            const { email, password, role, managerRoleNum } = this;
            axios.post("http://localhost:7777/exam-test10/login", {
                email, password, role, managerRoleNum
            })
            .then((res) => {
                alert("요청 성공!")
                console.log("res.data: ", typeof(res.data));
                if(res.data != null){
                    alert("로그인 되었습니다.")
                }
            })
            .catch((res) => {
                alert("요청 실패!")
            })
        }
    }
}
</script>

<style lang="">
    
</style>