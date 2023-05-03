<template>
        <form @submit.prevent="onSubmit">
        <p>ID: <input type="text" v-model="id" ></p>
        <p>PASSWORD: <input type="text" v-model="password"></p><br>
        <button type="submit">완료</button>
        <table v-for="(characterStat,index) in status" :key="index">
        <p>{{ characterStat.ATT }} : {{ characterStat.STAT }}</p>       
        </table>
    </form>
</template>
<script>
import axios from 'axios'
export default {
    data() {
    return {
        id:'unKnown',
        password:'unKnown',
        status:[
            {ATT:'STR',STAT:0},
            {ATT:'DEX',STAT:0},
            {ATT:'INT',STAT:0},
            {ATT:'LUK',STAT:0},
        ],
    }
   },
   methods: {
    onSubmit(){
            const{id,password} =this
            axios.post('http://localhost:7777/game-test/character', { id,password })
            .then((res)=>{
                
                this.status[0].ATT=res.data[0].ATT
                this.status[1].ATT=res.data[1].ATT
                this.status[2].ATT=res.data[2].ATT
                this.status[3].ATT=res.data[3].ATT
                this.status[0].STAT=res.data[0].STAT
                this.status[1].STAT=res.data[1].STAT
                this.status[2].STAT=res.data[2].STAT
                this.status[3].STAT=res.data[3].STAT
                console.log(this.status)
            })
            .catch((res)=>{
                alert('데이터 전송 실패!')
            })
        },
   },
}
</script>
<style>
     
</style>