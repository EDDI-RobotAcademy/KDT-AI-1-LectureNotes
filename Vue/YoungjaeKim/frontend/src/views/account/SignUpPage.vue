<template lang="">
    <div>
        <sign-up-form @submit="onSubmit"></sign-up-form>
    </div>
</template>

<script>
import SignUpForm from "@/components/account/SignUpForm.vue"

export default {
    components: {
        SignUpForm
    },
    methods: {
        onSubmit (payload) {

        }
    }
}

</script>

<style lang="">
    
</style>