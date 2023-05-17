<template >
    <div>
        <!-- <p><input type="text" v-model="numberA"><input type="text" v-model="numberB"></p>
        <button @onclick="plus">+</button><button @onclick="minus">-</button><button @onclick="mutiple">*</button><button @onclick="division">/</button>
         <p>결과: {{ result }}</p> -->
         {{ firstValue }} {{ thirdValue }} {{ secondValue }} = {{ result }}
    </div>
</template>
<script>
export default {
    //Vue LifeCycle 상에서 mounted는 객체가 만들어져서 변수 값들을 붙이는 상황에 해당합니다. 마운트하다 이런건 가봄
    //그러므로 Component 객체가 구동하게 되면 무조건 mounted를 타게 됩니다.
    //여기서 조건 검색을 하기 위해 사용하는 것입니다.
    props: {
        firstValue: Number,
        secondValue: Number,
        thirdValue: String,
    },
    data () {
        return {
            result: 0,
        }
    },
    mounted () {
        if (this.thirdValue === '+') {
            this.result = this.firstValue + this.secondValue
        }
        if (this.thirdValue === '-') {
            this.result = this.firstValue - this.secondValue
        }
        if (this.thirdValue === '*') {
            this.result = this.firstValue * this.secondValue
        }
        if (this.thirdValue === '/') {
            this.result = this.firstValue / this.secondValue
        }
    }
}
// export default {
//     data() {
//         return {
//             numberA:0,
//             numberB:0,
//             result:0
            
//         }
//     },
//     methods: {
//         plus(){
//             result=numberA+numberB
//         },
//         minus(){
//             result=numberA-numberB
//         },
//         mutiple(){
//             result=numberA*numberB
//         },
//         division(){
//             result=numberA/numberB
//         }
    
//     }
    
// }
</script>
<style >
    
</style>