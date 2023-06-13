<template lang="">
    <div>
        <h3>VUE<->Spring<->FastAPI</h3>
        <p>{{receivedInteger}}</p>
    </div>
</template>

<script>
import { mapActions } from 'vuex';

const fastApiModule = 'fastApiModule'
export default {
    data(){
        return{
            receivedInteger: 0
        }
    },
    
    methods:{
        ...mapActions(fastApiModule,[
            'requestIntegertoFastApiAfteroSpring'
        ])

    },
    async mounted() {
        const receivedData= await this.requestIntegertoFastApiAfteroSpring()
        console.log(receivedData)
        this.receivedInteger = receivedData.data
        
    }
        
}
</script>

<style lang="">
    
</style>