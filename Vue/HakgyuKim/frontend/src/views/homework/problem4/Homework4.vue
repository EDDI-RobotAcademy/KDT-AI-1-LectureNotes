<template>
    <div>
        <create-character/>
        <BringCharacterInfo/>
        <BringEnemy/>
    </div>
</template>
<script>

import CreateCharacter from '@/components/homeworkComponent/homework4/CreateCharacter.vue';
import BringCharacterInfo from '@/components/homeworkComponent/homework4/BringCharacterInfo.vue';
import BringEnemy from '@/components/homeworkComponent/homework4/BringEnemy.vue';

export default {
    components: {
        CreateCharacter,
        BringCharacterInfo,
        BringEnemy,
    },
    data () {
      return {
        
      }  
    }   
}
</script>
<style>
    
</style>