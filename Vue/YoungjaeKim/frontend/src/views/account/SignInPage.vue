<template lang="">
    <div>
        <sign-in-form @submit="onSubmit"></sign-in-form>
    </div>
</template>

<script>
import SignInForm from "@/components/account/SignInForm.vue"

export default {
    components: {
        SignInForm,
    },
    methods: {
        onSubmit () {

        }
    }
}

</script>

<style lang="">
    
</style>