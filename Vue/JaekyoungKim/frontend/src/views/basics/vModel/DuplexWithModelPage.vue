<template>
    <div>
        <textarea v-model="message"></textarea>
        <pre>{{ message }}</pre>
        <table style="margin: 20px;"><tr>
           <th width="20%">김</th>
           <th width="70%">재</th>
           <th width="10%">경</th>
        </tr>
        </table>
    </div>
</template>
<script>
export default {
    data(){
        return{
        message: '양방향 맵핑이란 것이 요런 뜻입니다.',
    }
}}
</script>
<style>
    
</style>