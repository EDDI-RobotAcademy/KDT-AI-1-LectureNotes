<template lang="">
    <div>
        <!-- 계정생성 컴포넌트 불러오기 -->
        <character-component/>
        <!-- 로그인 컴포넌트 -->
        <character-id/>
        <!-- 캐릭터 status 컴포넌트 불러오기 -->
        <character-status/>
        <!-- 게임 계정 불러오는 컴포넌트 불러오기 -->
        <account-info-print-form/>
    </div>
</template>

<script>

import CharacterComponent from "@/views/homework/character/CharacterComponent"
import CharacterStatus from "@/views/homework/character/CharacterStatus"
import CharacterId from "@/views/homework/character/CharacterId"
import AccountInfoPrintForm from "@/views/homework/character/AccountInfoPrintForm"

export default {
    components: {
        CharacterComponent,
        CharacterStatus,
        CharacterId,  
        AccountInfoPrintForm,
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