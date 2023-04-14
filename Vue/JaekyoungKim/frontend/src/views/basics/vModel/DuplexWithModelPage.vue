<template>
    <div>
        <textarea v-model="message"></textarea>
        <pre>{{ message }}</pre>
    </div>
</template>
<script>
export default {
    data(){
        return{
        message: '양방향 캡핑이란 것이 요런 뜻입니다.',
    }
}}
</script>
<style>
    
</style>