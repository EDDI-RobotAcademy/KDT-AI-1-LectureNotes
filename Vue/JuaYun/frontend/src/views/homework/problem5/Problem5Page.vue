<template>
    <div>
        <AccountInfoPrintForm/>
        <AccountCreationForm/>
        <AccountLoginForm/>
    </div>
</template>

<script>
import AccountCreationForm from '@/components/componentTest/homework2/problem5/AccountCreationForm.vue'
import AccountLoginForm from '@/components/componentTest/homework2/problem5/AccountLoginForm.vue'
import AccountInfoPrintForm from '@/components/componentTest/homework2/problem5/AccountInfoPrintForm.vue'

export default {
    components: {
        AccountCreationForm,
        AccountLoginForm,
        AccountInfoPrintForm
    }
    
}
</script>
<style lang="">
    
</style>