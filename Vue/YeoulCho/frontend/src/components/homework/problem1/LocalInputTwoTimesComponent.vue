<template>
    <div>
        <p>입력(단방향):
            <input :value="inputNumber" @change="handleInput"/>
        </p>
        <p>출력:
            {{ inputNumber * 2 }}
        </p>
        <p>입력(양방향):
            <input v-model="inputNumber" @change="handleInput"/>
        </p>
        <p>출력:
            {{ inputNumber * 2 }}
        </p>
    </div>
</template>
<script>
export default {
    props: {
        receivedNumber: Number
    },
    data() {
        return {
            inputNumber: this.receivedNumber,
        }
    },
    methods: {
        handleInput(event){
            alert('입력받은 값: ' + event.target.value)
        }
    }
    
}
</script>
<style>
    
</style>