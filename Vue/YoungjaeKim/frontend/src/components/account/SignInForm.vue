<template lang="">
    <div class="grey lighten-5" style="font-family: 'Noto Sans KR', sans-serif">
        <v-container class="white">
            <v-row justify="center">
                <v-col cols="auto" style="padding-bottom: 90px">
                    <router-link to="/">
                        <v-img
                            :src="require('@/assets/logo.png')"
                            width="120"
                            class="mx-auto mb-6"></v-img>
                    </router-link>
                    <v-card width="460">
                        <v-card-text class="text-center px-12 py-16">
                            <v-form @submit.prevent="onSubmit" ref="form">
                                <div class="text-h4 font-weight-black mb-10">Github Oauth 로그인</div>
                                <div class="d-flex">
                                    <v-img
                                        :src="require('@/assets/icon-github.svg')" 
                                        width="120" class="mx-auto mb-6"></v-img>
                                </div>
                                
                                <v-btn type="submit" block x-large rounded
                                        color="gray lighten-1" class="mt-6"
                                        :disabled="false">
                                    로그인
                                </v-btn>

                                <v-btn type="submit" block x-large rounded
                                        color="gray lighten-1" class="mt-6"
                                        :disabled="false" to="/sign-up-page">
                                    회원 신청하기
                                </v-btn>
                            </v-form>
                        </v-card-text>
                    </v-card>
                </v-col>
            </v-row>
        </v-container>
    </div>
</template>

<script>

export default {
    
    methods: {
        onSubmit () {
            this.$emit("submit")
        },
    },
}

</script>

<style lang="">
    
</style>