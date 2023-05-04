<template lang="">
    <v-container>  
        <v-btn @click="image">이미지가져오기</v-btn>
        <v-img 
        :src="require(`@/assets/downloadImg/${receivedImageName}`)"
            aspect-ratio="1" class="grey lighten-2"/>
    </v-container> 
    
</template>
<script>
import axios from 'axios'
export default {
    data(){
        return{
            receivedImageName: "clound.jpg",
       
        }
    },
    methods: {
        image(){
        
            axios.get("http://localhost:7777/image/imageName")   
        .then(((res)=>
        this.receivedImageName=res.data))
        
        .catch((res)=>{
            console.log(res)
            alert('이미지 정보가져오기 실패')})

        }
    }
    
}
</script>
<style lang="">
    
</style>