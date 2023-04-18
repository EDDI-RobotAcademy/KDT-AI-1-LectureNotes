<template lang="">
    <div>
        <p>
            <input :value="message" @change="handleInput"/>
        </p>
    </div>
</template>
<script>
export default {
    data () {
        return {
            message: '안녕'
        }
    },
    methods: {        
        handleInput (event) {
            console.log('evnet: ' + event)
            this.message = event.target.value
            console.log('event.target.value: ' + event.target.value)
        }
    },
}
</script>
<style lang="">
    
</style>