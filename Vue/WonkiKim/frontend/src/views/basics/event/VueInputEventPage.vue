<template>
    <div>
        <p>
            input:
            <input :value="message" @change="handleInput"/>
        </p>
    </div>
</template>
<script>
export default {
    data() {
        return {
            message: 'hi'
        }
    },
    methods: {
        handleInput(event) {
            console.log('event: '+event)
            this.message=event.target.value
            console.log('event.target.value: '+event.target.value)
        }
    }
}
</script>