<template lang="">
    <div>
        <v-btn color="teal" @click="playGame">플레이</v-btn>
    </div>
</template>
<script>
import axios from 'axios';

export default {
    methods: {
        playGame () {
            alert('플레이!')
            axios.get('http://localhost:7777/test-account/get-status')
                .then((res) => {
                    alert('스테이터스 확보 성공!')
                })
        }
    }
}
</script>
<style lang="">
    
</style>
