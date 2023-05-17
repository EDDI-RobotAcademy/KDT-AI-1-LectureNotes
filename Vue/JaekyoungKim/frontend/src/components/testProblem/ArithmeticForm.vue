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