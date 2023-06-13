<template lang="">
    <div>
        <!--
            문제 1번: 
            vue에서 체크 박스를 만들고 
            체크 박스가 선택되면 '체크 박스 선택'을 출력되게 만들어봅시다.
        -->
        <label><input type="checkbox" v-model="whichOneChecked" value="체크 박스 선택">체크 박스</label>
        <p>{{ whichOneChecked }}</p>
    </div>
</template>

<script>
export default {
    data () {
        return {
            whichOneChecked: [],
        }
    }
}
</script>

<style lang="">
    
</style>