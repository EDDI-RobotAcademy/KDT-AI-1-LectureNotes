<template>
    <div>
        <v-btn color="primary" @click="Wasrenai">캐릭터 생성</v-btn>
        <div v-if="isPressedButton">
    
                <label>
                    이메일: <input type="text"/>
                </label><br/>
                <label>
                    비밀번호: <input type="password"/>
                </label><br/>
            </div>
          <ul>
            <li v-for="(numAr,idx) in abcd" :key="idx">
             숫자: {{ numAr.num }}
             <button @click="clickMe(idx)">증가 버튼</button>     
        </li>
        </ul>
    </div>
</template>
<script>
export default {
    data() {
        return {
            abcd:[{num:1},{num:2},{num:3}],
            isPressedButton:false
        }
    },
    methods: {
        clickMe(idx){
            this.abcd[idx].num++
        },
        Wasrenai() {
        this.isPressedButton=true
    }}
}
</script>
<style>
    
</style>