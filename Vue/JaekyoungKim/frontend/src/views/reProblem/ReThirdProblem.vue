<template lang="">
    <div>
        <input type="checkbox" >

            <input type="text" v-model="sendingData" >
            <button type="submit" @click="onSubmit"></button>
    </div>
</template>
<script>
import axios from 'axios';
export default {
    data() {
        return {
        

        }
    },
   
}
</script>
<style lang="">
    
</style>