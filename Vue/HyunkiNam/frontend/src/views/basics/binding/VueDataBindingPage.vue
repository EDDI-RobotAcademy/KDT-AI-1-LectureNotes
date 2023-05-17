<template>
    <div>
        <p>Hello {{ message }}</p>
        <p>길이: {{ message.length }}</p>
        <p>list[2]: {{ list[2] }}</p>
        <p>list[{{number}}]: {{list[number]}}</p>
    </div>
</template>
<script>
export default {
    data () {
        return {
            message: 'Vue 프로그래밍',
            list: ['apple', 'grape', 'watermelon'],
            show: true,
            number: 1
        }
    }
}

</script>
<style>
    
</style>