<template>
    <div>
        <label>
            <input type="checkbox" v-model="isChecked"> {{ isChecked }}
        </label>
    </div>
</template>

<script>
export default {
    data() {
        return {
            isChecked: true,
        }
    }
}
</script>

<style>
    
</style>