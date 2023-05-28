<template lang="">
    <div>
        <label>
            <!-- 1. vue에서 체크 박스를 만들고 체크 박스가 선택되면 
                '체크 박스 선택'을 출력되게 만들어봅시다 -->
            <input type="checkbox" v-model="isChecked">
            <span v-if="isChecked">체크박스선택</span>
        </label>
    </div>
</template>

<script>

export default {
    data () {
        return {
            isChecked: false,
        }
    },
    
}
</script>
<style lang="">
    
</style>