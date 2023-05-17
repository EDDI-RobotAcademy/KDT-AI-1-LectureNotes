<template>
    <div>
        <!-- 뭘 만들어 볼까 \
        싯가별로 가격이 달라지는 물고기를 사도록 만들어 보자-->
            <form @submit.prevent="onSubmit">
           <p><input type="number" v-model="highFish">: 고등어</p>
           <p><input type="number" v-model="threeFish" >: 삼치</p>
            <v-btn type="submit" color="yellow">버튼</v-btn>
               
            <div v-if="showMe">
            <p>고등어 가격: </p>{{ totalHighFish }}
                <p>삼치 가격: </p> {{totalThreeFish }}
            </div>
               
        </form>
        
    </div>
</template>
<script>
import axios from 'axios';
export default {
    name: "MyBacklogComponent",
    
    data() {
        return {
            highFish: 0,
            threeFish: 0,
            totalHighFish:0,
            totalThreeFish:0,
            showMe:false
    
            
        }
    },
    methods: {
        onSubmit(){
            const{highFish,threeFish}=this
            axios.post('http://localhost:7777/fish-test/fish-price',{highFish,threeFish})
                .then((res) => {
                    
                    this.totalHighFish = res.data.highFish
                    this.totalThreeFish = res.data.threeFish
                    this.showMe=true
                
                })
                .catch((res)=>{
                alert('데이터 전송 실패!')
            })
            },
    }}
</script>
<style>
    
</style>