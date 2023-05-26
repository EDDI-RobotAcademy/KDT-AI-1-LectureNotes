<template lang="">
    <div>
        <AccountInFoPrintForm/>
        <AccountCreationForm/>
        <AccountLoginForm/>
    </div>
</template>
<script>
import AccountCreationForm from
 '@/components/homework/problem5/AccountCreationForm.vue';
import AccountLoginForm from
 '@/components/homework/problem5/AccountLoginForm.vue';
 import AccountInFoPrintForm from
  '@/components/homework/problem5/AccountInFoPrintForm.vue';
export default {
    components: {
        AccountCreationForm,
        AccountLoginForm,
        AccountInFoPrintForm,
    }
    
}
</script>
<style lang="">
    
</style>