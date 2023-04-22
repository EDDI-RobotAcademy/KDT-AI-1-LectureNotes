<template lang="">
    <div>
        <v-btn color ="red" @click="checkFruitNumber">과일 가격 확인 및 갯수 입력</v-btn>
        <div v-if="isPressedButton">
            <div>
                <label>사과 가격 : </label>
                <br>
                <label>당신이 살 사과 갯수 입력 : <input type="text" v-model="appleNumber"></label>
                <br>
            </div>
            <div>
                <label>수박 가격 : </label>
                <br>
                <label>당신이 살 수박 갯수 입력 : <input type="text" v-model="watermelonNumber"></label>
                <br>
            </div>
            <v-btn color="yellow" @click="processFruitNumber">확인</v-btn>


            </div>


        </div>
    </div>
</template>
<script>

import axios from 'axios'

export default {
    data() {
        return {
            appleNumber: '',
            watermelonNumber: '',
            isPressedButton: false,
        }
    },
    methods: {
        checkFruitNumber() {
            this.isPressedButton = true
            alert('입력 창 만들겠습니다.')

        },
        processFruitNumber() {
            this.isPressedButton = false
            alert('확인합니다. 계산하겠습니다!')
            const { appleNumber, watermelonNumber } = this
            axios.post('http://localhost:7777/apple-watermelon/Number', { appleNumber, watermelonNumber })
                .then((res) => {
                    if (res) {
                        alert('값을 성공적으로 전송했습니다.')
                    } else {
                        alert('에러 발생')
                    }
                })



        },

    },

}
</script>
<style lang="">
    
</style>