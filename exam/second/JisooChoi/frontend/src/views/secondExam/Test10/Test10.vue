<template lang="">
    <!--
        ★ 10번 문제 프론트 백로그 (백엔드 파트는 Spring에 있습니다 !)

        front
        1. 사용자가 회원 정보를 기입히고 가입하기 버튼을 누르면 회원 정보가 전송되는 컴포넌트를 만듭니다.
        - Success Criteria
            (1) 회원 정보를 기입합니다.
            (2) 회원의 정보는 이메일, 비밀번호, 역할, 관리자 추가 정보로 구성되어 있습니다.
            (3) 항목을 기입한 후 가입하기 버튼을 누르면 백엔드로 정보가 전송됩니다.

        - To Do
            [o] email, password, role input 처리
            [o] 가입 버튼 생성
            [o] axios를 통한 backend 요청
    -->

    <v-container>
        <h2>회원 가입하기</h2>
        <div>
            <input type="text" v-model="email" placeholder="email을 기입해주세요." /><br />
            <input type="password" v-model="password" placeholder="password를 기입해주세요." /><br />

            <label>roleType 선택 : </label>
            <select size="1" id="roleType" @change="handleInput($event)">
                <option type="role" v-model="role" value="NORMAL">일반</option>
                <option type="role" v-model="role" value="BUSINESS">사업자</option>
            </select><br />

            <p v-if="selectRole">
                <input type="text" v-model="managerRoleNum" placeholder="only 사업자 (10자리)" />
            </p>

            <v-btn color="orange" @click="writeComplete">가입하기</v-btn>
            <p>{{ finishMassage }}</p>
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
            finishMassage: "",
            selectRole: false
        }
    },
    methods: {
        handleInput(event) {
            if(event.target.value == "BUSINESS"){
                this.selectRole = true;
                this.role = "사업자";
                alert("사업자 타입 !")
            }

            if(event.target.value == "NORMAL"){
                this.selectRole = false;
                this.role = "일반";
                alert("일반 타입 !")
            }
        },
        writeComplete () { 
            const { email, password, role, managerRoleNum } = this;
            axios.post("http://localhost:7777/exam-test10/register", {
                email, password, role, managerRoleNum
            })
            .then((res) => {
                alert("요청 성공!")
                console.log("res.data: ", typeof(res.data));
                this.finishMassage = res.data;

                if(this.finishMassage == ""){
                    alert("회원 정보가 존재합니다.")
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