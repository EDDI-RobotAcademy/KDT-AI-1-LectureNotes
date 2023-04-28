<template>
    <div>
        1번<br>
        number1 = <input type="text" v-model="number1"><br>
        number2 = <input type="text" v-model="number2"><br>
        {{ number1 }} + {{ number2 }} = {{ parseInt(number1) + parseInt(number2) }}<br><br>
    </div>
</template>
<script>
export default {
    name: "plusComponent",
    props: {
    },
    data() {
        return {
            number1: 0,
            number2: 0,
        }
    }
}
</script>
<style></style>