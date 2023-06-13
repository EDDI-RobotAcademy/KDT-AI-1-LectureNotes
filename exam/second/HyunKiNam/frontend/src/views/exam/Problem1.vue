<template lang="">
    <div align="center">
        <label>
            <input type="checkbox" v-model="isChecked" value="체크 박스 선택"> 체크박스 </input>
            <br>
            {{isChecked}}
        </label>
    </div>
</template>
<script>
export default {
    data() {
        return {
            isChecked: [],
        }
    }
}
</script>
<style lang="">
    
</style>