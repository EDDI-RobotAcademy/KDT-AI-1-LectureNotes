<template>
    <div>
        <h3>Vue 기본 문제 1</h3>
        <h4>1번</h4>
        <input type="checkbox" v-model="check">
        {{ check ? "체크" : "체크 안됨" }}
    </div>
</template>
<script>
export default {
    name: "IsCheckboxComponent",
    data() {
        return {
            check: false
        }
    },
}
</script>
<style></style>