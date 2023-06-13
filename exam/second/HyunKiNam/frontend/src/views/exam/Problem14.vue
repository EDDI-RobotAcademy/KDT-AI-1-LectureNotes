<template lang="">
    <div>
        <AccountRegisterForm/>
        <br></br>
        <AccountLoginForm/>
    </div>
</template>

<script>
import AccountRegisterForm from '@/components/problem14Component/AccountRegisterForm.vue';
import AccountLoginForm from '@/components/problem14Component/AccountLoginForm.vue';

export default {
    components: {
        AccountRegisterForm,
        AccountLoginForm,
    }
}
</script>

<style lang="">
    
</style>