<template lang="">
    <div>
        <input type="checkbox" v-model="isChecked">
        {{ isChecked }}
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
<style lang="">
    
</style>