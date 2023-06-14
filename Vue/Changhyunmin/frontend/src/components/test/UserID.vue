<template lang="">
    <div>
        <tr>
            <th>아이디</th>
            <td>
                <input v-model="signup.id" type="text" maxlength="20">
                <div v-if="!idValid">
                유효하지 않은 아이디 입니다!
                </div>
            </td>
        </tr>
        
    </div>
</template>
<script>
export default {
    data() {
        return {
            id: null,
            
        }
    },
    
}
</script>
<style lang="">
    
</style>