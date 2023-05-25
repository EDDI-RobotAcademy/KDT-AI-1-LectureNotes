<template lang="">
    <div>
        <game-account-creation/>
        <game-account-status-load/>
        <check-box-review/>

    </div>
</template>

<script>
import GameAccountCreation from '@/components/homework/problem4/GameAccountCreation.vue'
import GameAccountStatusLoad from '@/components/homework/problem4/GameAccountStatusLoad.vue'
import CheckBoxReview from '@/components/homework/problem4/CheckBoxReview.vue'

export default {
    components: {
        GameAccountCreation,
        GameAccountStatusLoad,
        CheckBoxReview

    },
    data () {
        return {
        }
    }
}
</script>

<style lang="">
    
</style>