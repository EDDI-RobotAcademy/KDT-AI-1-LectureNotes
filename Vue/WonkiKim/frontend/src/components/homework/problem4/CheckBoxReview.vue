<template lang="">
    <div>
        <input type="checkbox" v-model="wasChecked" 
        true-value = "체크되었다." false-value = "체크안되었다.">
        {{wasChecked}}
    </div>
</template>

<script>
export default {
    data() {
        return {
            wasChecked: false,
            talkingCheck : "",
        }
    },
    methods: {
        checkCheck() {
            if (this.wasChecked == false) {   
                talkingCheck = "체크 안됨"
            } else {     
                talkingCheck = "체크되었다."
            }
        },
    },
}
</script>

<style lang="">
    
</style>