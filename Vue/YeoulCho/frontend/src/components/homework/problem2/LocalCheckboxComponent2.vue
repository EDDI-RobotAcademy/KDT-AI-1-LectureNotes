

<template >
    <div>
        <li>Grammar  <input type = "checkbox" @change="check"> </li>
            <div v-if="is"><p>Grammar</p></div>            
            <div v-else="is"> false</div>
        <div>  
            <li>Writing  <input type="checkbox" @change="check2"></li>
            <div v-if="is2">Writing</div>
            <div v-else="is2">false</div>
       </div>
       </div>   
</template>
<script>
export default {
    
    
    data(){
        return{
       is: false,
       is2: false,
       
    }},

    methods: {
        check(){   
            this.is= !this.is            
        },
        check2(){   
            this.is2= !this.is2            
        }
    

    }
}
</script>
<style>    
</style>