<template lang="">
    <div>
        <game-account-creation/>
        <game-account-status-load/>
        <game-account-login/>
    </div>
</template>
<script>
import GameAccountCreation from '@/components/homework/problem4/GameAccountCreation.vue';
import GameAccountStatusLoad from '@/components/homework/problem4/GameAccountStatusLoad.vue';
import GameAccountLogin from '@/components/homework/problem5/GameAccountLogin.vue';

export default {
    components: {
        GameAccountCreation,
        GameAccountStatusLoad,
        GameAccountLogin,

    },
    data(){
        return{
        
        }
    }
}
</script>
<style lang="">
    
</style>