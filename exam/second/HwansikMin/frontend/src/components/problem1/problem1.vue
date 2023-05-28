<!--vue에서 체크 박스를 만들고 체크 박스가 선택되면 
    '체크 박스 선택'을 출력되게 만들어봅시다.-->
<template lang="">
    <div>
        <input type="checkbox" v-model="isChecked" @change="handleCheckbox"> {{ischecked}}
    </div>
</template>

<script>
export default {
    data() {
        return {
            isChecked: false
        }
    },
    methods: {
        handleCheckbox() {
            if(this.isChecked) {
                return '체크 박스 선택'
            } else {
                return ''
            }
        }

    }
}
</script>

<style lang="">
    
</style>