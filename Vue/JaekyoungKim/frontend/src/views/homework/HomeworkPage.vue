<template>
    <div>
        <local-diploic :receiveNumber="3"/>
        <local-minus :numberA="3" :numberB="1"/>
    </div>
</template>
<script>
import LocalDiploic from '@/components/componentTest/LocalDiploic.vue';
import LocalMinus from '@/components/componentTest/LocalMinus.vue';
export default {
    components:{
        'local-diploic':LocalDiploic,
        'local-minus':LocalMinus
    },
}
</script>
<style>
    
</style>