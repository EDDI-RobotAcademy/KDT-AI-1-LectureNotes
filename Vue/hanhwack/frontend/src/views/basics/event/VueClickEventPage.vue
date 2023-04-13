<template>
    <div>
        <p>{{ count }} 번 클릭했습니다!</p>
        <button @click="clickHandler">카운트 하기</button>
    </div>
</template>

<script>

export default {
    data () {
        return {
            count : 0,
        }
    },
    methods: {
        clickHandler () {
            this.count++
        }
    },
    
}
</script>
<style>
    
</style>