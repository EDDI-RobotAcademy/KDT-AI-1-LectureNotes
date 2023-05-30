<!-- [ 복합 문제 4 ~ 6]
vue와 Spring을 활용하는 문제입니다.
Spring에서 주사위를 굴려서 결과를 알려주게 되며 vue에서는 이것을 출력하도록 구성합니다.

4. 작업을 진행하기 위한 Backlog를 작성해보세요.
5. vue를 활용하여 주사위를 굴릴 수 있는 UI를 만들어봅시다.
6. 주사위 굴리기 버튼을 누르면 Spring에 요청을 날려서 주사위 값을 출력해봅시다.
 -->

 <!-- 
    vue
    1.게임에 사용할 주사위 버튼 만들기
    2.판정된 주사위의 값을 결과를 보여준다.
  -->
<template lang="">
    <div>
        <h3>주사위 굴리기!</h3>
        <v-btn color="grey" @click="onSubmit">주사위 던지기</v-btn>
        <p>얻은결과: {{receivedDiceNubmer }}</p>
    </div>
</template>
<script>

import axios from 'axios';
export default {
    data() {
        return {
            receivedDiceNubmer:0,
        }
    },
    methods: {
        onSubmit(){
            axios.get('http://localhost:7778/vue-test/get-random-dice')
            .then((res)=>{
                this.receivedDiceNubmer = res.data
            })
            .catch((res)=>{
                alert('데이터 전송 실패!')
            })
        }
    },
}
</script>
<style lang="">
    
</style>