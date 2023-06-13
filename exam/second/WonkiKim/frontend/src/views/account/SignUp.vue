<template>
    <v-container>
        <form>
            <table width="50%">
                <tr>
                    <td colspan="3">
                        <v-text-field label="email" v-model="email"></v-text-field>
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <v-text-field label="password" v-model="password"></v-text-field>
                    </td>
                </tr>
                <tr>
                    <v-radio-group inline v-model="role">
                        <v-radio label="NORMAL" value="NORMAL" name="roleBtn"/>
                        <v-radio label="BUSINESS" value="BUSINESS" name="roleBtn"/>
                    </v-radio-group>
                </tr>
                <tr v-if="role==='BUSINESS'">
                    <td colspan="3">
                        <v-text-field label="business number" v-model="businessNumber"></v-text-field>
                    </td>
                </tr>
            </table>
        </form>
        <v-btn @click="()=>$router.push('/')">cancel</v-btn>
        <v-btn @click="signUp">sign up</v-btn>
    </v-container>
</template>

<script>
import {mapActions} from "vuex";
const accountModule = 'accountModule'
export default {
    name: "signUp",
    methods: {
        async signUp() {
            const {email, password, role, businessNumber} = this
            console.log({email, password, role, businessNumber} )
            await this.requestSignUp({email, password, role, businessNumber})
            await this.$router.push('/')
        },
        ...mapActions(accountModule, ['requestSignUp'])
    },
    data() {
        return {
            email: "",
            password: "",
            role: "NORMAL",
            businessNumber: "",
        }
    }
}
</script>

<style scoped>

</style>