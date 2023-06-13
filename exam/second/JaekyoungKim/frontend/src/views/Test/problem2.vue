<template lang="">
    <div>
        <button @clcik="isClick">클릭</button>
        <p>{{hi}}</p>
    </div>
</template>
<script>
import axiosInst from '@/utility/axiosInst';
//http://localhost:7777 세팅 되어있는 것
export default {
    data() {
        return {
            hi:''
        }
    },
    methods: {
        isClcik(){
            axiosInst.get('/hello')
            .then((res)=>{
                this.hi=res.data
            })
            .catch((res)=>{
                alert('안녕하지 못한가 보다')
            })
        }
    },
    
}
</script>
<style lang="">
    
</style>