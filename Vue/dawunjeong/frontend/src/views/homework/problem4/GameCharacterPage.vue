<template lang="">
    <div>
        <account-info-print/>
        <game-character/>
        <game-login/>
    </div>
</template>

<script>
import GameCharacter from '@/components/homework/problem4/GameCharacter.vue'
import GameLogin from '@/components/homework/problem5/GameLogin.vue';
import AccountInfoPrint from '@/components/homework/problem5/AccountInfoPrint.vue';

export default {
    components: {
        GameCharacter,
        GameLogin,
        AccountInfoPrint,
    }
}
</script>

<style lang="">
    
</style>