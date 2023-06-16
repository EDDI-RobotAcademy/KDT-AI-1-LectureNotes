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
                                <!-- 
                                    ref="form" form안의 모든 유효성 검사가 통과해야 한다는 뜻
                                    로그인 성공하면 
                                    window.location.href = await this.requestGithubLoginToSpring()
                                    실행하여 새로운 페이지로 넘어가는 거고
                                    로그인 안되면 회원 신청하는 페이지로 넘어가도록
                                -->
                                <div class="text-h4 font-weight-black mb-10">Github Oauth 로그인</div>
                                <div class="d-flex">
                                    <v-img
                                        :src="require('@/assets/icon-github.svg')" 
                                        width="120" class="mx-auto mb-6"></v-img>
                                </div>
                                
                                <v-btn type="submit" block x-large rounded
                                        color="gray lighten-1" class="mt-6"
                                        :disabled="false">
                                        <!-- 
                                            disabled: 버튼을 사용할 수 없게 하는 불리언 속성
                                            disabled가 true이면 버튼 클릭 불가
                                            disabled를 false로 하여 입력 폼 활성화
                                         -->
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
        onSubmit() {
            this.$emit("submit")
        },
    },
}

</script>

<style lang="">
    
</style>