<template lang="">
    <div>
        <label>
            <input type="checkbox" v-model="isChecked"> {{ isChecked }}
        </label>
        <div v-if="isChecked">
            <p>금액(VAT 포함): {{ inputAmount }}, 세금: {{ taxAmount }}</p>
        </div>
        <div v-else>
            <p>금액: {{ inputAmount }}</p>
        </div>
    </div>
</template>
<script>
export default {
    props: {
        inputAmount: Number
    },
    data() {
        return {
            taxAmount: 0,
            isChecked: true
        }
    },
    mounted() {
        this.taxAmount = this.inputAmount * 0.1
    }
}
</script>
<style lang="">
    
</style>