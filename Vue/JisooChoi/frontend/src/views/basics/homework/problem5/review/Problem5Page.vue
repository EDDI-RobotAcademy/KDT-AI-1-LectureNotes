<template lang="">
    <div>
        <AccountInfoPrintForm />
        <AccountCreationForm />
        <AccountLoginForm />
    </div>
</template>

<script>
import AccountCreationForm from '@/components/homework/problem5/review/AccountCreationForm.vue';
import AccountLoginForm from '@/components/homework/problem5/review/AccountLoginForm.vue';
import AccountInfoPrintForm from '@/components/homework/problem5/review/AccountInfoPrintForm.vue';

export default {
    components: {
        AccountInfoPrintForm,
        AccountCreationForm,
        AccountLoginForm
    }
}
</script>

<style lang="">
    
</style>