<template lang="">
    <div>
        <p>입력(단방향): 
            <input :value="inputNumber" @change="handleInput"/>
        </p>
        <p>출력: {{ inputNumber * 2 }}</p>

        <p>입력(양방향): 
            <input v-model="inputNumber" @change="handleInput"/>
        </p>
        <p>출력: {{ inputNumber * 2 }}</p>
    </div>
</template>

<script>
export default {
    props: {
        receivedNumber: Number
    },
    data () {
        return {
            inputNumber: this.receivedNumber,
        }
    },
    methods: {
        handleInput (event) {
            this.message = event.target.value
            alert('event.target.value: ' + event.target.value)
            // 이벤트가 발생했을때 발생한 위치의 값을 표출해 준다.
        }
    }
}
</script>
<style lang="">
    
</style>