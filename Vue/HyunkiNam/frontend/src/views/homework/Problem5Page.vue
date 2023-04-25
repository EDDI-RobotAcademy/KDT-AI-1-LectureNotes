<template lang="">
    <div>
        <AccountInfoPrintForm/>
        <AccountCreationForm/>
        <AccountLoginForm/>
    </div>
</template>

<script>
import AccountCreationForm from '@/components/homeworkComponent/problem5/solution/AccountCreationForm.vue'
import AccountLoginForm from '@/components/homeworkComponent/problem5/solution/AccountLoginForm.vue'
import AccountInfoPrintForm from '@/components/homeworkComponent/problem5/solution/AccountInfoPrintForm.vue'


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