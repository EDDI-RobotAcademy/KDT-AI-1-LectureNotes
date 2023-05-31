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
                            <!--
                                유효성 검사를 위해
                                v-text-field 에다가 :rules="ruleName"
                                
                                그리고 폼 안에 데이터 모두 유효성 검사가 통과했는지 안 했는지
                                판단하기 위해 v-form 에다가 ref="form"를 넣어준다.
                            -->
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
                                    <v-btn text large outlined style="font-size: 13px"
                                            class="mt-3 ml-5" color="teal lighten-1"
                                            @click="checkDuplicateEmail"
                                            :disabled="false">
                                        이메일 <br/>중복 확인
                                    </v-btn>
                                </div>

                                <v-btn type="submit" block x-large rounded
                                        color="orange lighten-1" class="mt-6"
                                        :disabled="!isFormValid()">회원 신청하기</v-btn>
                            </v-form>
                        </v-card-text>
                    </v-card>
                </v-col>
            </v-row>
        </v-container>
    </div>
</template>

<script>
import axiosInst from '@/utility/axiosInst'
import { mapActions } from 'vuex'

const accountModule = 'accountModule'

export default {
    data () {
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
            ]
        }
    },
    methods: {
        ...mapActions('accountModule', ['requestSpringToCheckEmailDuplication']),
        onSubmit () {
            /*
                저장 버튼을 눌렀을 때,
                유효성 검사가 모두 통과했는지 안 했는지 확인하는 방법

                const validata = this.$refs.form.validata();

                이거 한 줄만 넣으면 v-text-field 안에 :rules가 사용된
                필드들이 모두 유효성 검사를 통과하면 ture를 반환한다.
            */
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
        async checkDuplicateEmail () {
            /*
                String 표준 빌트인 객체가 제공하는 match 메서드는
                대상 문자열과 인자로 전달받은 정규 표현식과의 매칭 결과를 배열로 반환한다.
                매칭 결과가 없는 경우 null을 반환한다.
            */
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
        isFormValid () {
            return this.emailPass && this.email_rule[1](this.email) === true
            /*
                아이디 중복이 되지 않고, 올바른 형식의 아이디이면 return
            */
        }
    },
}

</script>

<style lang="">
    
</style>