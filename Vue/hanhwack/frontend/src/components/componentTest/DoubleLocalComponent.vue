<template>
    <div>
        <p>입력: 
            <input :value="message" @change="handleInput">
        </p>
        <p>출력: {{outputNumber}}
        </p>
    </div>
</template>

<script>
export default {
    name: "DoubleLocalComponent",
    props: {
       
        
        outputNumber: Number,
    },
    data () {
        return {
            message : 0
        
        }
    },

    methods: {
        
        handleInput (event) {
            console.log('event: ' + event)
            this.outputNumber = event.target.value * 2
            console.log('event.target.value: ' + this.outputNumber)
        }
    },
    
}
</script>

<style>
    
</style>