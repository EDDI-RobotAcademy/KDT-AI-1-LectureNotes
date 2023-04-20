<template lang="">
    <div>
        <v-btn color="primary" @click="createCharacter">캐릭터 생성</v-btn>
    </div>
</template>

<script>
export default {
    methods: {
        createCharacter () {
            alert('캐릭터 생성!')
        }
    }
}
</script>

<style lang="">
    
</style>