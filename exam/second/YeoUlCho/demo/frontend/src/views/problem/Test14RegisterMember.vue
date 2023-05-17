<template lang="">
    <div>
        <h2>회원가입</h2>
        <test14-register-member-form @onSubmit="onSubmit"/> 
    </div>
</template>

<script>
import Test14RegisterMemberForm from '@/components/Test14RegisterMemberForm.vue'
import { mapActions } from 'vuex';

const memberModule = 'memberModule' 


export default {
    components: {
        Test14RegisterMemberForm,
    },
    name: "Test14",
    methods: {
        ...mapActions( 
            memberModule, ['requestRegisterMemberToSpring']
        ),
        onSubmit (payload) {
            const member =this.requestRegisterMemberToSpring(payload)
            console.log('member: ' + JSON.stringify(member))
        }
    }
}
</script>

<style lang="">
    
</style>