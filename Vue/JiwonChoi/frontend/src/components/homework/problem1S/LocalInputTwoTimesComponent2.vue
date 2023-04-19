<template lang="">
    <div>
        <p>입력(단방향): 
            <input :value = "inputNumber" @change="handleInput"/>
        </p>
        <p>출력: {{inputNumber * inputNumber}}</p>

        <p>입력(양방향):
            <input v-model="inputNumber" @change="handleInput"/>
        </p>
        <p>출력: {{inputNumber * inputNumber}}</p>
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

    //handleInput()의 경우엔 실제로 전달된 이벤트에 어떤 값이 있는지 살펴보기 위해 
    //console.log로 출력을 하고 동시에 data() 영역에 있는 message로 값을 갱신하는 역할을 수행합니다.
    methods: {
        handleInput (event) {
            this.message = event.target.value
            alert('event.target.value: ' + event.target.value)
        }
    }
}
</script>
<style lang="">
    
</style>