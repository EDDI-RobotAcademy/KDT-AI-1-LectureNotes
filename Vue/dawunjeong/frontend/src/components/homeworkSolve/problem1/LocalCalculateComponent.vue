<template lang="">
    <div>
        {{ firstValue }} {{ thirdValue }} {{ secondValue }} = {{ result }}
    </div>
</template>
<script>
export default {
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
    /* 
    Vue LifeCycle 상에서 mounted는 객체가 만들어져서 변수 값들을 붙이는 상황에 해당합니다.
    그러므로 Component 객체가 구동하게 되면 무조건 mounted를 타게 됩니다.
    여기서 조건 검색을 하기 위해 사용하는 것입니다.
    */
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
</script>
<style lang="">
    
</style>