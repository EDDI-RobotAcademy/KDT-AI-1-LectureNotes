<template lang="">
    <div>
        <select v-model="selected">
        <option>A</option>
        <option>B</option>
        </select>
        <br>
        <span>선택한 정보는 {{ selected }} 입니다</span>
    </div>
</template>
<script>
export default {
    data() {
        return {
            selected: ''
        }
    },
    
}
</script>
<style lang="">
    
</style>