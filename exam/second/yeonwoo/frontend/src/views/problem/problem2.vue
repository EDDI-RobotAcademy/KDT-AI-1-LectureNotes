<template lang="">
    <div>
      
    </div>
</template>

<script>
import axios from 'axios'
export default {
    data () {
        return {
          
        }
    },
    methods: {
        onSubmit () {
            axios.get('http://localhost:7777/hello/hi')
                .then((res) => {
                    
                })
                .catch((res) => {
                    alert('데이터 전송 실패!')
                })
        }
    }
}
    
</script>

<style lang="">
    
</style>