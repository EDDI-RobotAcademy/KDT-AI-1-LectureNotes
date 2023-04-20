<template lang="">
    <div>
        <input type="checkbox" v-model="wasChecked">
        {{wasChecked}}
        <div>
            <h3>{{talkingCheck}}</h3>
        </div>
        <br>
        <v-btn v-model="wasChecked" color = "red" @click = "checkCheck()">체크 박스 체크 하기</v-btn>
    </div>
</template>
<script>

export default {

    data() {
        return {
            wasChecked: false,
            talkingCheck: "",
        }
    },
    methods: {
        checkCheck() {
            if (this.wasChecked == false) {
                this.talkingCheck = "체크 안됨"
            } else {
                this.talkingCheck = "체크되었다."
            }
        },
    },

}
</script>
<style lang="">
    
</style>