<template lang="">
    <!--
        ★ 4번 문제 프론트 백로그 (백엔드 파트는 Spring에 있습니다 !)

        front
        1. 사용자가 주사위 버튼을 누르면 숫자를 요청하는 컴포넌트를 만듭니다.
        - Success Criteria
            (1) 요청, 응답에 따른 주사위 값은 하나입니다.
            (2) 주사위 버튼을 누르면 데이터를 받아와서 보여주는 p태그를 만듭니다.

        - To Do
            [o] 주사위 버튼 만들기
            [o] 주사위 요청의 응답 값을 보여주는 p태그 만들기
            [o] axios를 통한 backend 요청
    -->

    <!--
        5. vue를 활용하여 주사위를 굴릴 수 있는 UI를 만들어봅시다.
        6. 주사위 굴리기 버튼을 누르면 Spring에 요청을 날려서 주사위 값을 출력해봅시다.
    -->
    <div>
        <v-btn color="orange" @click="onClick">주사위 굴리기</v-btn>
        <p>{{ diceNum }}</p>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data() {
        return {
            diceNum: "",
        }
    },
    methods: {
        onClick() {
            axios.get("http://localhost:7777/exam-test4/dice-number")
            .then((res) => {
                alert("요청 성공!");
                this.diceNum = res.data;
            })
            .catch((res) => {
                alert("요청 실패!");
            })
        }
    }
}
</script>

<style lang="">
    
</style>