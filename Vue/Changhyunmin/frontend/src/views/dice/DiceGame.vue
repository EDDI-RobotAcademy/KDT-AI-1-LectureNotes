<template>
    <div>
        <label>
            <input type="checkbox" v-model="isChecked">{{ isChecked }}
        </label>

        <div id="oddneven">
            <input type="text" v-model="Num"/>
            <p v-if="Num == ''">값을 입력해 주세요.</p>
            <p v-else-if="Num==0">1 이상의 숫자를 입력해 주세요.</p>
            <p v-else-if="Num%2==0">짝수입니다.</p>
            <p v-else>홀수입니다.</p>
            <input type="안녕">
        </div>

        
    </div>
</template>
<script>
export default {
    el: '#oddneven',
    data() {
        return {
            isChecked: true,
            Num: '',
        }
    }
    
}
</script>
<style>
    
</style>