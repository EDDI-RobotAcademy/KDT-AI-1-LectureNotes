<template>
    <div>
        <tr>
            <th>비밀번호 힌트/답변</th>
            <td>
                <select v-model="signup.passwordHint" size="1" class="select">
                <option value="">
                    선택하세요.
                </option>
                <option v-for="(item, index) in passwordHintList" :key="index" :value="item.value">
                    {{ item.text }}
                </option>
                </select>
            </td>
        </tr>
        <tr>
            <th>답변</th>
            <td><input v-model="signup.passwordHintAns" type="text"></td>
        </tr>
    </div>
</template>
<script>
export default {

    
}
</script>
<style>
    
</style>