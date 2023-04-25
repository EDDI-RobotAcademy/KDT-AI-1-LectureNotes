<template lang="">
    <div>
        <table>
            <tr>
                <th>사과 개수</th>
                <td><input type="number" v-model="appleCount"></td>
            </tr>
            <tr>
                <th>수박 개수</th>
                <td><input type="number" v-model="watermelon"></td>
            </tr>                
         </table>
        <div>
            <button type="submit">전송</button>
        </div>
    </div>
</template>
<script>
import axios from 'axios'
export default {
    data () {
        return {
            appleCount: 0,
            watermelonCount: 0
        }
    },
    methods: {
        appleMinus () {
            this.appleCount --
        },
        applePlus () {
            this.appleCount ++
        },
        watermelonMinus () {
            this.watermelonCount --
        },
        watermelonPlus () {
            this.watermelonCount ++
        },
        purchaseAlertHandler (appleCount, watermelonCount) {
            if (2 < this.appleCount) {
                alert('이 이상은 구매할 수 없습니다!')}
            if (4 < this.watermelonCount) {
                alert('이 이상은 구매할 수 없습니다!')}    
            }
        },
        onSubmit () {
            const {} = this
            axios.post('http://localhost:7777/vue-test/receive-test', 
                    {appleCount, watermelonCount})        
                    .then((res) => {
                    this.appleCount = res.data
                    this.watermelonCount = res.data
                })        
        }
    }
</script>
<style lang="">
    
</style>
