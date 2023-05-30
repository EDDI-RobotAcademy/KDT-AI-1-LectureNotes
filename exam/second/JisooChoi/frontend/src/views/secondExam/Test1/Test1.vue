<template lang="">
    <div>
        <!--
            1. vue에서 체크 박스를 만들고 체크 박스가 선택되면
            "체크 박스 선택"을 출력되게 만들어봅시다.
        -->
        <div>
            <label>
                <input type="checkbox" :value="check" @change="handleInput">
                <p v-if="isChecked">{{ check }}</p>
            </label>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            check : "",
            isChecked: "",
        }
    },
    methods: {
        handleInput () {
            if(this.isChecked = !this.isChecked){
                this.check = "체크 박스 선택";
            }
        }
    }
}
</script>

<style lang="">
    
</style>