<template lang="">
    <div>
        <v-btn @click="buttonProcess">
            결제
        </v-btn>
    </div>
</template>

<script>
import axiosInst from '@/utility/axiosInst';
export default {
    methods: {
        buttonProcess () {
            axiosInst.fastApiAxiosInst('/email-notification')
                .then((res) => {
                    alert(JSON.stringify(res.data))
                })
                .catch(() => {
                    alert('문제 발생!')
                })
        }
    }
}
</script>

<style lang="">
    
</style>