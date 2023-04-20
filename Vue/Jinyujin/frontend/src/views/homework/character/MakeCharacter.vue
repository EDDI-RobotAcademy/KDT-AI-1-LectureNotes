<template lang="">
    <div>
        <!-- 계정생성 컴포넌트 불러오기 -->
        <character-component/>
        <!-- 캐릭터 status 컴포넌트 불러오기 -->
        <character-status/>
        <!-- 플레이 버튼 누르면 캐릭터 status 가져와서 뿌려주기 -->
        <!-- <v-btn @click="showCharacterStatus">플레이</v-btn> -->
    </div>
</template>

<script>

import CharacterComponent from "@/views/homework/character/CharacterComponent"
import CharacterStatus from "@/views/homework/character/CharacterStatus"

export default {
    components: {
        CharacterComponent,
        CharacterStatus,
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