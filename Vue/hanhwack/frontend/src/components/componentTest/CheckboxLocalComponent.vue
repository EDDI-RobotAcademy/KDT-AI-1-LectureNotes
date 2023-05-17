<template>
    <div>
        <p>입력: 
            <input :value="message" @change="handleInput">
        </p><br>

        <form action="/" style="text-align: left;">
            <li><input type="checkbox" value="decrease">10%감소</li>
        </form><br>

        <p>출력: {{outputNumber}}</p>

    </div>
</template>
<script>
export default {
    name: "checkboxLocalComponent",
    props: {
       
       
        outputNumber: Number,
    },
    data () {
        return {
            message : 0,
            decrease : false
        
        }
    },

    methods: {
        
        handleInput (event) {
          
            this.outputNumber = event.target.value 
            if(this.decrease) {
                outputNumber: outputNumber * 0.9
            }
           
        }
    },
    
}
</script>

<style>
    
</style>