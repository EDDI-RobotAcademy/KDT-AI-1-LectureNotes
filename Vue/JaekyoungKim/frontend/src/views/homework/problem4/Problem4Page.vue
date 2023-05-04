<template>
    <div>
        <game-account-creation/>
        <game-account-status-load/>
    </div>
</template>

<script>
import GameAccountCreation from '@/components/homework/problem4/GameAccountCreation.vue'
import GameAccountStatusLoad from '@/components/homework/problem4/GameAccountStatusLoad.vue'
export default {
    components: {
        GameAccountCreation,
        GameAccountStatusLoad
    },
    data () {
        return {
        }
    }
}
</script>

<style>
    
</style>