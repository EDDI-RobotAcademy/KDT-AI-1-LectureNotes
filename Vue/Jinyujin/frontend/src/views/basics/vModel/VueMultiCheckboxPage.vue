<template>
    <div>
        <label><input type="checkbox" v-model="whichOneChecked" value="사망보험">사망보험</label>
        <label><input type="checkbox" v-model="whichOneChecked" value="자동차보험">자동차보험</label>
        <label><input type="checkbox" v-model="whichOneChecked" value="담보대출">담보대출</label>
        <p>{{ whichOneChecked }}</p>
    </div>
</template>

<script>
export default {
    data() {
        return {
            whichOneChecked: [], // 답안(?)을 받을 때 배열을 이용하는 것
        }
    },
}
</script>

<style>
</style>