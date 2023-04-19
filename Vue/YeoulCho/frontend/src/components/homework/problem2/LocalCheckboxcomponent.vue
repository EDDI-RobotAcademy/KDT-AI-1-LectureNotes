<template >
    <div>
        <li>Grammar  <input type = "checkbox" v-model="ischecked1"> </li>
            <div v-if="ischecked1"><p>Grammar</p></div>            
            <div v-else="ischecked1"> false</div>
        <div>  
            <li>Writing  <input type="checkbox" v-model="ischecked2"></li>
            <div v-if="ischecked2">Writing</div>
            <div v-else="ischecked2">false</div>
       </div>
       </div>
       
            

          
        
    
</template>
<script>
export default {
    
    data(){
        return{
       ischecked1: false,
       ischecked2: false,
    }
}
        
}
</script>
<style>
    
</style>