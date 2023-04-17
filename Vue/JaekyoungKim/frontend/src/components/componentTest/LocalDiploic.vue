<template >
    <div>
        <!-- <p><input type="text" v-model="numberA"></p>
        <button @onclick="diploic">두 배 버튼</button>
        {{ result }} -->
        <p>입력: 
            <input type="text" v-model=receiveNumber @change="handleInput"/>
        </p>
        <p>출력: {{receiveNumber*2}}</p>
        
    </div>
</template>
<script>
export default {
    props:{
        receiveNumber: Number
    },
    data () {
        return {
            inputNumber: this.receiveNumber,
         }
    },
    methods: {
        handleInput (event) {
            
            this.message = event.target.value
            console.log('event.target.value: ' + event.target.value)
        }
    }
}
//     name: "LocalDiploic",
//     props:{
//         numberA:Number,
//         result:Number
    
//     },
//     data() {
//         return {
//             numberA:0,
//             result:0
//         }
//     },
//     methods:{
//         diploic(){
//             result=numberA*2
//         }
//     }
    
// }
</script>
<style >
    
</style>