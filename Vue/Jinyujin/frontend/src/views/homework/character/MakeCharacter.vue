<template lang="">
    <div>
        <!-- 계정생성 컴포넌트 불러오기 -->
        <character-component/>
        <!-- 로그인 컴포넌트 -->
        <character-id/>
        <!-- 캐릭터 status 컴포넌트 불러오기 -->
        <character-status/>


    </div>
</template>

<script>

import CharacterComponent from "@/views/homework/character/CharacterComponent"
import CharacterStatus from "@/views/homework/character/CharacterStatus"
import CharacterId from "@/views/homework/character/CharacterId"

export default {
    components: {
        CharacterComponent,
        CharacterStatus,
        CharacterId,  
    },
    data() {
        return {
            
        }
    },
    methods: {

    }
}
</script>

<style lang="">
</style>