<template lang="">
    <div>
        <dice-game-two-times/>
        <!-- 로컬 컴포넌트로 만들고 불러오기 -->
    </div>
</template>
<script>

import DiceGameTwoTimes from './DiceGameTwoTimes.vue';

export default {
    components: {
        DiceGameTwoTimes,
    }
    
}
</script>
<style lang="">
    
</style>