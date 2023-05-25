<template>
    <div>
        <label>
            <input type="checkbox" v-model="isChecked" > {{ isChecked }}
        </label>
    </div>
</template>

<script>

export default {
    data () {
        return {
            isChecked: "체크박스선택"
        }
    }
}
</script>

<style>


</style>