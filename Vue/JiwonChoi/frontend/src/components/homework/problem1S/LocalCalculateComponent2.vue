<template lang="">
    <div>

        {{firstValue}}{{thirdValue}}{{secondValue}} = {{result1}}
        <br>
        {{result1}}{{fourthValue}}{{secondValue}} = {{result2}}


        
    </div>
</template>
<script>
export default {
    props: {
        firstValue: Number,
        secondValue: Number,
        thirdValue: String,
        fourthValue: String,
    },
    data () {
        return {
            result1: 0,
            result2: 0
        }
    },
    mounted() {
        if (this.thirdValue === '+') {
            this.result1 = this.firstValue + this.secondValue
        }
        if (this.thirdValue === '-') {
            this.result1 = this.firstValue - this.secondValue
        }
        if (this.thirdValue === '*') {
            this.result1 = this.firstValue * this.secondValue
        }
        if (this.thirdValue === '/') {
            this.result1 = this.firstValue / this.secondValue
        }
        if (this.fourthValue === '+') {
            this.result2 = this.result1 + this.secondValue
        }
        if (this.fourthValue === '-') {
            this.result2 = this.result1 - this.secondValue
        }
    },
}
</script>
<style lang="">
    
</style>