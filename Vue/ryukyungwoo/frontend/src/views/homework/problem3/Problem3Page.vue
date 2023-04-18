<template lang="">
    <div>
        <button @click="appleMinus">사과</button>
        <button @click="applePlus"></button>
        <p>{{ appleCount }} 개 사과를 담았습니다</p>
        <br>
        <button @click="watermelonMinus">수박</button>
        <button @click="watermelonPlus"></button>
        <br>
        <p>{{ watermelonCount }} 개 수박을 담았습니다</p>
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
        purchaseAlertHandler () {
            if (2 < this.appleCount) {
                alert('이 이상은 구매할 수 없습니다!')}
            if (4 < this.watermelonCount) {
                alert('이 이상은 구매할 수 없습니다!')}    
            }
        },
        onSubmit () {
            const {} = this
            axios.post('http://localhost:7777/vue-test/receive-test', 
                    {})                
        }
    }
</script>
<style lang="">
    
</style>
