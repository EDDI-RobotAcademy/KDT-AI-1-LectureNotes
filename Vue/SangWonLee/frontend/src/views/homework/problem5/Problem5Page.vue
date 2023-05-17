
<template lang="">
    <div>
        <AccountInfoPrintForm/>
        <AccountCreationForm/>
        <AccountLoginForm/>
    </div>
</template>

<script>
import AccountCreationForm from '@/components/homework/problem5/AccountCreationForm.vue'
import AccountLoginForm from '@/components/homework/problem5/AccountLoginForm.vue'
import AccountInfoPrintForm from '@/components/homework/problem5/AccountInfoPrintForm.vue'

export default {
    components: {
        AccountCreationForm,
        AccountLoginForm,
        AccountInfoPrintForm,
    }
}
</script>

<style lang="">
    
</style>