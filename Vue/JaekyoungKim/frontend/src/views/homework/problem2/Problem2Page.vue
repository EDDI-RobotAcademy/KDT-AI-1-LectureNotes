<template lang="">
    <div>
        <dice-game-two-time/>
        <send-one-parameter/>
    </div>
</template>

<script>
import DiceGameTwoTime from '@/components/DiceGameTwoTime.vue'
import SendOneParametr from '@/components/SendOneParameter.vue'
export default {
    components: {
       'dice-game-two-time': DiceGameTwoTime,
       SendOneParametr
    }
}
</script>

<style lang="">
    
</style>