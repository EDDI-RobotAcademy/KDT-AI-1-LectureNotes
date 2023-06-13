<template lang="">
    <div>
        <sign-in-form @submit="onSubmit"/>
    </div>
</template>

<script>

import SignInForm from '@/components/signIn/SignInForm.vue';

export default {
    
    components: {
        SignInForm
    }
}
</script>

<style lang="">
    
</style>