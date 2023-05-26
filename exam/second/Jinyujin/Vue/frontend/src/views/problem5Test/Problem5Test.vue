<!-- 
    프론트 백로그
    1. 주사위를 굴릴 수 있도록 UI 작업을 진행합니다
       - 주사위 시험이라는 것을 알려주는 메세지를 작성합니다 
    2. 주사위 굴리기 버튼을 누르면 주사위 값을 받아와 출력하도록 합니다
 -->
<template lang="">
    <div>
        <p>안농 주사위 굴리기 시험이야</p>
        <button @click="startDiceGameWithComputer">주사위 굴리기</button>
        <p>주사위 숫자는 {{ result }}</p>
    </div>
</template>

<script>

import axios from 'axios';

export default {
    data() {
        return {
            result: ''
        }
    },
    methods: {
        startDiceGameWithComputer() {
            axios.get('http://localhost:7777/problem4/dice')
                .then((res) => {
                    this.result = res.data
                })
        }
    },
}
</script>

<style lang="">
</style>