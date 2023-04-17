<template >
    <div>
        <li>Grammar  <input type = "checkbox" v-model="ischecked"> </li>
            <div v-if="ischecked"><p>Grammar</p></div>            
            <div v-else="ischecked"> false</div>
        <div>  
            <li>Writing  <input type="checkbox" v-model="ischecked"></li>
            <div v-if="ischecked">Writing</div>
            <div v-else="ischecked">false</div>
       </div>
       </div>
       
            

          
        
    
</template>
<script>
export default {
    
    data(){
        return{
       ischecked: true,
    }
}
        
}
</script>
<style>
    
</style>