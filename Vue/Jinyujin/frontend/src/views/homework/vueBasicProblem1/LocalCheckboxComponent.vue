<template>
    <div>
        <label>
            <input type="checkbox" v-model="isChecked"> {{ isChecked }}
        </label>
        <div v-if="isChecked">
            <p>체크되어 있습니다</p>
        </div>
        <div v-else>
            <p>체크되어 있지 않습니다</p>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            isChecked: true,
        }
    },
}
</script>

<style>
    
</style>