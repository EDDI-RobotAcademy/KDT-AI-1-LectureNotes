<template lang="">
    <div>
        <v-container>
            <v-img :src="require(`@/assets/downloadImg/${imageName}`)"/>
        </v-container>
    </div>
</template>

<script>
import axios from 'axios';

export default {

    data () {
        return {
            imageName: "",
        }
    },    
    mounted () {
        axios.post('http://localhost:7777/img-request/get-path')
        .then((res) => {
            this.imageName = res.data
        })
    }
}
</script>
<style lang="">
    
</style>
