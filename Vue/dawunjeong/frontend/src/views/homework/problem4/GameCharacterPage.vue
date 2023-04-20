<template lang="">
    <div>
        캐릭터 생성<game-character/>
        로그인<game-login/>
    </div>
</template>

<script>
import GameCharacter from '@/components/homework/problem4/GameCharacter.vue'
import GameLogin from '@/components/homework/problem5/GameLogin.vue';

export default {
    components: {
        GameCharacter,
        GameLogin,
    }
}
</script>

<style lang="">
    
</style>