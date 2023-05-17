<template lang="">
    <div>
        <game-account-creation/>
        <game-account-status-load/>
    </div>
</template>

<script>
import GameAccountCreation from '@/components/componentTest/homework2/problem4/GameAccountCreation.vue'
import GameAccountStatusLoad from '@/components/componentTest/homework2/problem4/GameAccountStatusLoad.vue'

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

<style lang="">
    
</style>