<template>
    <div>
    <textarea v-model="message"></textarea>
    <pre>{{ message }}</pre>
    </div>
</template>

<script>
export default {
    data() {
        return {
            message: '초기값',
        } 
    }
}
</script>

<style>
</style>