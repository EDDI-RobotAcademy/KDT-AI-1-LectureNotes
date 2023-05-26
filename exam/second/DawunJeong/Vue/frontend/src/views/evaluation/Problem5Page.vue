<template lang="">
    <div>
        <!-- 문제 5번 -->
        <p>
            <v-btn @click="onSubmit">주사위 굴리기</v-btn>
            <p>과연 결과는! {{ resultDiceNumber }}</p>
        </p>
    </div>
</template>

<script>
import axiosInst from '@/utility/axiosInst';

export default {
    data () {
        return {
            resultDiceNumber: 0,
        }
    },
    methods: {
        onSubmit () {
            axiosInst.get('/problem5/rolldice')
            .then((res) => {
                this.resultDiceNumber = res.data
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