<template lang="html">
    <div class="grey lighten-5" style="font-family: 'Noto Sans KR', sans-serif">
        <v-container class="white">
            <v-row justify="center">
                <v-col cols="auto" style="padding-bottom: 90px">
                    <router-link to="/">
                        <v-img src="/src/assets/logo.svg" width="120" class="mx-auto mb-6"/>
                    </router-link>
                    <v-card width="460">
                        <v-card-text class="text-center px-12 py-16">
                            <v-form @submit.prevent="onSubmit" ref="form">
                                <div class="text-h4 font-weight-black mb-10">Github Oauth 로그인</div>
                                <div class="d-flex">
                                    <v-img src="/src/assets/icon-github.svg" width="120" class="mx-auto mb-6"/>
                                </div>
                                
                                <v-btn type="submit" block x-large rounded
                                        color="gray lighten-1" class="mt-6"
                                        :disabled="false">
                                    로그인
                                </v-btn>

                                <!-- <v-btn type="submit" block x-large rounded
                                        color="gray lighten-1" class="mt-6"
                                        :disabled="false" to="/vue-auth-app/sign-up-page">
                                    회원 신청하기
                                </v-btn> -->
                            </v-form>
                        </v-card-text>
                    </v-card>
                </v-col>
            </v-row>
        </v-container>
    </div>
</template>

<script>
import { mapActions } from "vuex";

const authenticationModule = 'authenticationModule'

export default {
    components: {
    },
    methods: {
        ...mapActions(authenticationModule, ['requestGithubLoginToSpring']),
        async onSubmit () {
            console.log('Sign In Request to Spring!')
            window.location.href = await this.requestGithubLoginToSpring()
        }
    }
}

</script>

<style lang="">
    
</style>