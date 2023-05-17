<template lang="">
    <div>

        <register-button-form @submit="onSubmit"/>
    </div>
</template>
<script>

import RegisterButtonForm from '@/components/RegisterButtonForm.vue';
// RegisterButtonForm 컴포넌트를 가져옴
import { mapActions } from 'vuex';
// vuex에서 mapActions 함수를 가져옴.

const productModule = 'productModule'

export default {
    components: {
        RegisterButtonForm
    },
    name: "RegisterButtonPage",
    methods: {
        ...mapActions(
            productModule, ['requestCreateProductToSpring']
        ),
        async onSubmit(payload) {
            const product = await this.requestCreateProductToSpring(payload)
            console.log('product: ' + JSON.stringify(product))

        }
    },


}
</script>
<style lang="">
    
</style>