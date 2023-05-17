<template >
    <div>
        <input :value="message" @change="handleInput">
    </div>
</template>
<script>
export default {
    data() {
        return {
            message: '안녕'
        }
    },
    methods: {
        handleInput(event) {
            console.log('event: ' + event)
            this.message = event.target.value
            console.log('event.target.value: ' + event.target.value)
        }
    },
}
</script>
<style></style>