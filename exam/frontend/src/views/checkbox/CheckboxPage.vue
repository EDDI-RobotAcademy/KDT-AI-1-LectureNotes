<template lang="">
    <div>
        <label>
            <input type="checkbox" v-model="isChecked" @click="showMassage"> 
            {{ isChecked }}
        </label>
    </div>
</template>
<script>
export default {
    data () {
        return {
            isChecked: true,
        }
    },
    methods: {
        showMassage () {
            alert("체크 박스 선택")
        }
    }
}
</script>
<style lang="">
    
</style>