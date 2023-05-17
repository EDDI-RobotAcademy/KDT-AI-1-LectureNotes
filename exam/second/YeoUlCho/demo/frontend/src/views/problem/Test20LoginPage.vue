<template lang="">
    <div>
        <login-form @login="submit"/>

    </div>
</template>
<script>
import LoginForm from '@/components/LoginForm.vue';
import { mapActions } from 'vuex';
const memberModule='memberModule'

export default {
    components:{
        LoginForm,
    },
    methods:{
        ...mapActions( memberModule, ['requestLoginToSpring']),
        async submit(payload) {
            
            const account = await this.requestLoginToSpring(payload)
            console.log('account: ' + JSON.stringify(account))
        }
    }
    

    
    
}
</script>
<style lang="">
    
</style>