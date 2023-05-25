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
            </table>
        </form>
        <v-btn @click="()=>$router.push('/')">cancel</v-btn>
        <v-btn @click="logIn">log in</v-btn>
    </v-container>
</template>

<script>
import {mapActions} from "vuex";

const accountModule = "accountModule"
export default {
    name: "LogIn",
    methods: {
        async logIn() {
            const {email, password} = this
            console.log({email, password})
            await this.requestLogIn({email, password})
                .then((res) => {
                    console.log(res.data)
                    localStorage.setItem("userId", res.data)
                }
        )
            await this.$router.push('/')
        },
        ...mapActions(accountModule, ['requestLogIn'])

    },
    data() {
        return {
            email: "",
            password: ""
        }
    }
}
</script>

<style scoped>

</style>