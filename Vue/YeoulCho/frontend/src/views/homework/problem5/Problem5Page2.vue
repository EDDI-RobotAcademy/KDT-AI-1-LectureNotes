<template>
    <div>
       <account-creation-form/>
       <account-login-form/> 
       <account-info-print-form/>
    </div>
</template>

<script>
import AccountCreationForm from "@/components/homework/problem5/teacher/AccountCreationForm.vue"
import AccountLoginForm from "@/components/homework/problem5/teacher/AccountLoginForm.vue"
import AccountInfoPrintForm from "@/components/homework/problem5/teacher/AccountInfoPrintForm.vue"
export default {
    components: {
        AccountCreationForm,
        AccountLoginForm,
        AccountInfoPrintForm,
        
    },
    data(){
        return{

        }

    }
    
}
</script>
<style>
    
</style>