<!--
    1. vue에서 체크 박스를 만들고 체크 박스가 선택되면
    '체크 박스 선택'을 출력되게 만들어봅시다. 
-->

<template lang="">
    <div><br>
13번 문제 까지 풀었습니다.
        <br>

        <input type="checkbox" v-model="isChecked">
        {{isChecked}}
        <div>
            <h3>{{talkingCheck}}</h3>
        </div>
        <br>
        <v-btn v-model="isChecked" color = "red" @click = "checkCheck()">체크 박스 체크 하기</v-btn>
    </div>
</template>
<script>

export default {

    data() {
        return {
            isChecked: false,
            talkingCheck: "",
        }
    },
    methods: {
        checkCheck() {
            if (this.isChecked == false) {
                this.talkingCheck = "체크 박스 선택 안됨"
            } else {
                this.talkingCheck = "체크 박스 선택"
            }
        },
    },

}
</script>
<style lang="">
    
</style>