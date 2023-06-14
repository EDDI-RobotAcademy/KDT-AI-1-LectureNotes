<!--
    components 한 데이터들을 묶어서 보여준다.
    java로 보면 클래스들 끼리 import 하여 본다고 생각하면 편하다.
-->
<template lang="">
    <div>
        <game-account-creation/>
        <game-account-status-load/>
    </div>
</template>

<script>
//import 정보가 담긴 components from components주소(패키지)
import GameAccountCreation from './GameAccountCreation.vue'
import GameAccountStatusLoad from './GameAccountStatusLoad.vue'

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