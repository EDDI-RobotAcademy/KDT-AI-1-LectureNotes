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
import { Output } from 'webpack-chain'

export default {
    name: "checkboxLocalComponent",
    props: {
       
        inputNumber: Number,
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
          
            
            if(this.decrease) {
                inputNumber: event.target.value * 0.9
                outputNumber: inputNumber
            }
            
           
        }
    },
    
}
</script>

<style>
    
</style>