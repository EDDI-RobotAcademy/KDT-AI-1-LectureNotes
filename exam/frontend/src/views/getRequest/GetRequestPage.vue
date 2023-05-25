<template lang="">
    <div>
        <button type="submit" @click="onSubmit">hi</button>
        <p>
            수신된 메세지: {{ receivedMessage }}
        </p>
    </div>
</template>
<script>
import axiosInst from '../../uility/axiosInst'

export default {
    data () {
        return {
            receivedMessage: '',
        }
    },
    methods: {
        onSubmit () {            
            axiosInst.get('/get-request')
            .then((res) => {
                alert('데이터 전송 성공')
            })
            .catch((res) =>{
                alert('데이터 전송 실패')
            })
        }
    }
}
</script>
<style lang="">
    
</style>