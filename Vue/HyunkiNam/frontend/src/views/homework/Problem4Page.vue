<template lang="">
    <div>
        <game-account-creation/>
        <game-account-status-load/>
    </div>
</template>

<script>
import GameAccountCreation from '@/components/homeworkComponent/problem4/solution/GameAccountCreation.vue';
import GameAccountStatusLoad from '@/components/homeworkComponent/problem4/solution/GameAccountStatusLoad.vue';

export default {
    components: {
        GameAccountCreation,
        GameAccountStatusLoad,
    },
    data() {
        return {
        }
    }
}
</script>

<style lang="">
    
</style>