<template lang="">
    <div>
        <v-btn @click="afterLoginTokenTest">
            토큰 전송하기
        </v-btn>
    </div>
</template>

<script>
import SignInForm from "@/components/account/SignInForm.vue"
import { mapActions } from "vuex";

const afterLoginModule = 'afterLoginModule'
// 지금까지 한 상품 구매, 등록 등 이거랑 연동해야 한대
// 상품이 같이 날아가야 한다고 함

export default {
    components: {
        SignInForm,
    },
    methods: {
        ...mapActions(afterLoginModule, ['requestSomeDataToSpringWithUserToken']),
        async afterLoginTokenTest() {
            const userToken = localStorage.getItem('userToken')
            alert('token 값: ' + userToken)

            const memberInfo = await this.requestSomeDataToSpringWithUserToken({ userToken, testNumber: 3 })
            alert('memberInfo: ' + JSON.stringify(memberInfo))
        }
    }
}

</script>

<style lang="">
    
</style>