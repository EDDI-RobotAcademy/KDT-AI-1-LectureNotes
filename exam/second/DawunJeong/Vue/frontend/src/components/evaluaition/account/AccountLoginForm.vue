<template lang="">
    <div>
        <form @submit.prevent="onSubmit">
            <table>
                <tr>
                    <td>이메일</td>
                    <td>
                        <input type="text" v-model="email">
                    </td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td>
                        <input type="text" v-model="password">
                    </td>
                </tr>
            </table>
            <v-btn type="submit">로그인</v-btn>
        </form>
    </div>
</template>

<script>
export default {
    data () {
        return {
            email: '',
            password: '',
        }
    },
    methods: {
        onSubmit () {
            const { email, password } = this
            this.$emit('submit', { email, password })
        }
    }
}
</script>

<style lang="">
    
</style>