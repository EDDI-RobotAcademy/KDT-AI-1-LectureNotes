<template>
    <div>
        <CreateAccount/>
        <LoginForm/>
        <BringCharacterInfo/>
        <BringEnemy/>
    </div>
</template>
<script>

import CreateAccount from '@/components/homeworkComponent/homework4/CreateAccount.vue';
import BringCharacterInfo from '@/components/homeworkComponent/homework4/BringCharacterInfo.vue';
import BringEnemy from '@/components/homeworkComponent/homework4/BringEnemy.vue';
import LoginForm from '@/components/homeworkComponent/homework4/LoginForm.vue';

export default {
    components: {
        CreateAccount,
        BringCharacterInfo,
        BringEnemy,
        LoginForm
    },
    data () {
      return {
        
      }  
    }  
}
</script>
<style>
    
</style>