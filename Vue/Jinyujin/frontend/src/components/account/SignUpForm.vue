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
                    <!-- 사진에 라우터 링크 걸어주기 -->
                    <v-card width="460">
                        <v-card-text class="text-center px-12 py-16">
                            <v-form @submit.prevent="onSubmit" ref="form">
                                <div class="text-h4 font-weight-black mb-10">회원 신청하기</div>
                                <div class="d-flex">
                                    <v-text-field
                                        v-model="email"
                                        label="github 이메일" 
                                        :rules="email_rule"
                                        :disabled="false"
                                        required>
                                    </v-text-field>
                                    <!-- 
                                        ref="form" form안의 모든 유효성 검사가 통과해야 한다는 뜻

                                        label="github 이메일"은 placeholder와 비슷한 느낌
                                        대신 label이 되면 입력창에 입력값을 넣을 때 
                                        "github 이메일"이 없어지지 않음
                                        이걸 이용하면 이메일 칸이라는 것을 따로 명시해줄 필요가 없는 것!

                                        rules: 입력값을 검증하기 위한 속성
                                        사용하여 email_rule함수로 이메일 유효성 검사
                                        입력값이 올바른지 검사하고, 올바르지 않은 경우 에러 메세지 반환

                                        disabled: 버튼을 사용할 수 없게 하는 불리언 속성
                                        disabled가 true이면 버튼 클릭 불가
                                        disabled를 false로 하여 입력 폼 활성화
                                        꼭 있어야 하나 싶은데 원래 이렇게 만들 때 형식인가 싶다

                                        required: 이메일 입력이 필수임을 나타냄
                                    -->
                                    <v-btn text large outlined style="font-size: 13px"
                                            class="mt-3 ml-5" color="teal lighten-1"
                                            @click="checkDuplicateEmail"
                                            :disabled="false">
                                        이메일 <br/>중복 확인
                                    </v-btn>
                                </div>
                                <!-- <div>
                                <v-text-field
                                        v-model="password"
                                        label="github 패스워드" 
                                        :rules="password_rule"
                                        :disabled="false"
                                        required>
                                </v-text-field>
                                <v-text-field
                                        v-model="password_chk"
                                        label="github 패스워드 확인" 
                                        :rules="password_check"
                                        :disabled="false"
                                        required>
                                </v-text-field>
                                </div> -->

                                <v-btn type="submit" block x-large rounded
                                        color="orange lighten-1" class="mt-6"
                                        :disabled="!isFormValid()">회원 신청하기</v-btn>
                                        <!-- 
                                            이메일 중복 확인까지 완료되면 isFormValid() 활성화
                                            그전까지는 회색이다가 isFormValid()가 활성화되면 
                                            오렌지색 나타나게 됨

                                            Todo: 비밀번호 확인까지 하고 isFormValid() 활성화 되도록
                                            !를 안붙였을 때 동작 제대로 하는 것 확인
                                            근데 주아 언니 말로는 이메일 중복확인까지 하고 
                                         -->
                            </v-form>
                        </v-card-text>
                    </v-card>
                </v-col>
            </v-row>
        </v-container>
    </div>
</template>

<script>
import { mapActions } from 'vuex'

const accountModule = 'accountModule'

export default {
    data() {
        return {
            email: "",
            emailPass: false,
            email_rule: [
                v => !!v || '이메일을 입력해주세요!',
                v => {
                    const replaceV = v.replace(/(\s*)/g, '')
                    const pattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/
                    return pattern.test(replaceV) || '올바른 이메일 형식으로 입력해주세요!'
                }
                // 이메일 형식은 이거 고대로 쓰면 됨
                // v는 입력값 
                // 첫번째는 입력값이 비어있는지 검사
                // 두번째는 입력값이 있는 경우 올바른 형식으로 입력되어 있는지 검사
            ],
            // password: "",
            // password_rule: [
            //     v => !!v || '비밀번호를 입력하세요',
            //     v => v.length >= 8 || '비밀번호는 최소 8자 이상이어야 합니다.',
            //     v => /(?=.*[a-z])(?=.*\d)(?=.*(_|[^\w])).+/g.test(v) || '비밀번호는 소문자, 숫자, 특수문자를 모두 포함해야 합니다.'
            // ],
            // password_chk: "",
            // password_check: [
            //     v => !!v || '비밀번호를 확인하세요',
            //     v => v === this.password || '비밀번호가 일치하지 않습니다.'
            //     // this.password를 해주었어야 했음
            // ],
            // passwordPass: false,
        }
    },
    methods: {
        ...mapActions('accountModule', ['requestSpringToCheckEmailDuplication']),
        onSubmit() {
            if (this.$refs.form.validate()) {
                const { email } = this
                this.$emit("submit", { email })
            } else {
                alert('올바른 정보를 입력하세요!')
            }

            if (!this.emailPass) {
                alert("이메일 중복 확인을 해주세요!")
            }
        },
        async checkDuplicateEmail() {
            const emailValid = this.email.match(
                /^(([^<>()[\]\\.,;:\s@]+(\.[^<>()[\]\\.,;:\s@]+)*)|(.+))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
            )
            this.emailPass = false

            if (emailValid) {
                const { email } = this
                console.log('before actions - email: ' + email)
                this.emailPass = await this.requestSpringToCheckEmailDuplication({ email })
            }
        },
        isFormValid() {
            return this.emailPass && this.email_rule[1](this.email) === true
            // const isEmailValid = this.emailPass && this.email_rule[1](this.email) === true;
            // const isPasswordValid = this.passwordPass && this.password_rule[1](this.password) === true
            //     && this.password_check[1](this.password_chk) === true;
            // const isPasswordMatched = this.password === this.password_chk;
            // return isEmailValid && isPasswordValid && isPasswordMatched;;
        }
    },
}

</script>

<style lang="">
    
</style>