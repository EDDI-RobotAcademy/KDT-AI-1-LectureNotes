<template lang="">
    <div>
        <p>{{ count }} 번 클릭했습니다.</p> 
                <button @click="clickHandler">카운트하기</button><br>
        <button @click="alertHandler">경고 메시지 출력하기</button><br>
    </div>
</template>
<script>
export default {
    data() {
        return {
            count: 0,
        }
    },
    methods: {
        clickHandler() {
            this.count++
        },

        alertHandler() {
            alert('누르지마!')
        },
    }

}
</script>
<style lang="">
    
</style>