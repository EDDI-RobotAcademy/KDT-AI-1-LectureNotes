<template lang="">
    <div>
        <sign-up-form @submit="onSubmit"></sign-up-form>
    </div>
</template>

<script>
import SignUpForm from "@/components/account/SignUpForm.vue"
import { mapActions } from "vuex";

const accountModule = 'accountModule'

export default {
    components: {
        SignUpForm
    },
    methods: {
        ...mapActions(accountModule, ['requestRegisterAccountToSpring']),
        async onSubmit (payload) {
            const isSuccess = await this.requestRegisterAccountToSpring(payload)
            if (isSuccess) {
                this.$router.push("/sign-in-page")
            }
        }
    }
}

</script>

<style lang="">
    
</style>