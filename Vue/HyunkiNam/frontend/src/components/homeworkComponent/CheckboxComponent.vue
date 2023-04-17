<template>
    <div>
        5번 <br>
        <input type="checkbox" v-model="check">
        {{ check ? num * 0.9 : num }}
    </div>
</template>
<script>
export default {
    name: "CheckboxComponent",
    props: { num: { required: true, type: Number } },
    data() {
        return {
            check: false
        }
    },
}
</script>
<style></style>