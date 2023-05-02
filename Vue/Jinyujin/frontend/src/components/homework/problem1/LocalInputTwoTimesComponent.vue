<template lang="">
    <div>
        <input v-model="inputNumber"/>
        <p>출력: {{ inputNumber * 2 }}</p>
    </div>
</template>

<script>
export default {
    name: 'LocalInputTwoTimesComponent',
    props: {
        receiveNumber: Number
    },
    data() {
        return {
            inputNumber: this.receiveNumber,
        }
    },
    // methods: {
    //     handleInput(event) {
    //         this.message = event.target.value,
    //         alert('event.target.value: ' + event.target.value)
    //     }
        
    // },
    // 굳이 없어도 될 것 같음
}
</script>
<style lang="">
    
</style>