<template lang="">
    <div>
        <v-btn color="primary" @click="readyToCreateCharacter">캐릭터생성</v-btn>
        <div v-if="isPressedButton">
            <div>
                <label >
                    이메일: <input type="text" v-model="userEmail"/>
                </label><br>
                <label>
                    비밀번호: <input type="password" v-model="userPassword"/>
                </label><br>
            </div>
                <v-btn color="purple" @click="processCreateCharacter">완료</v-btn>
        </div>
        
    </div>
</template>
<script>
export default {
    
}
</script>
<style lang="">
    
</style>