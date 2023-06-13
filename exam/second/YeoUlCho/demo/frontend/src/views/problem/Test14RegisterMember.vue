<template lang="">
    <div>
        <h2>회원가입</h2>
        <test14-register-member-form @submit="onSubmit"/> 
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
        async onSubmit (payload) {
            const member = await this.requestRegisterMemberToSpring(payload)
            console.log('member: ' + member.data )
        }
    }
}
</script>

<style lang="">
    
</style>