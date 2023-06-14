<template lang="">
    <div>
        <!-- 4, 5, 6 번 문제 주사위 굴리기-->
        <!-- 
            랜덤으로 굴리는 주사위를 UI에 표시할 수 있게 게임 시작 버튼 만들기

            Success Criteria
            - 게임 시작 버튼 생성
            - console 을 생성하여 주사위 값을 받아오는지 확인하기

            To-Do
            - 게임 시작 버튼 
            - backend 에 주사위 값을 받아오게 요청하기
            - console 에 정상적으로 받아오는지 확인하지
        -->
        <h3>주사위 굴리기</h3>
        <v-btn color="primary" @click="startTwoTimesDiceGame">주사위 굴리기</v-btn>
        <p>얻은 결과: {{ playingNumber }}</p>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data () {
        return {
            playingNumber: 0,
            /*
            마지막설정
            */
            playerList: []
        }
    },
    methods: {
        startTwoTimesDiceGame () {
            axios.get('http://localhost:7777/dice-game/random')
                .then((res) => {
                    this.result = res.data
                    console.log('result: ' + res.data)
                    this.playingNumber = res.data
                })
        },
    }
}
</script>

<style lang="">
    
</style>