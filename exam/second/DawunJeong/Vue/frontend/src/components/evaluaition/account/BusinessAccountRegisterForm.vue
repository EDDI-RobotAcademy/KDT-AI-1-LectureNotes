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
                <tr>
                    <td>회원 타입</td>
                    <td>
                        <div>
                            <input type="radio" v-model="roleType" name="radioBtn" value="NORMAL">
                            <label>일반 회원(구매자)</label>
                        </div>
                        <div>
                            <input type="radio" v-model="roleType" name="radioBtn" value="BUSINESS" checked>
                            <label>사업자 회원(판매자)</label>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>사업자번호</td>
                    <td>
                        <input type="number" v-model="businessNumber">
                    </td>
                </tr>
            </table>
            <v-btn type="submit">가입하기</v-btn>
        </form>
    </div>
</template>

<script>
export default {
    data () {
        return {
            email: '',
            password: '',
            roleType: '',
            businessNumber: 0,
        }
    },
    methods: {
        onSubmit () {
            const { email, password, roleType, businessNumber } = this
            this.$emit('submit', { email, password, roleType, businessNumber })
        },
    }
}
</script>

<style lang="">
    
</style>