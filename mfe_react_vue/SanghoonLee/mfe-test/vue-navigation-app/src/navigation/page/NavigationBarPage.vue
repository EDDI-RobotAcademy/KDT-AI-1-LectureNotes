<template lang="">
    <v-app-bar color="primary" app dark height="64">
        <!-- <v-app-bar-nav-icon @click="navigation_drawer = !navigation_drawer"/> -->
        <v-btn @click="gotoHome">
            <v-toolbar-title class="text-uppercase text--darken-4">
                <span>EDDI</span>
            </v-toolbar-title>
        </v-btn>
        <v-spacer></v-spacer>

        <v-menu>
            <template v-slot:activator="{ props }">
                <v-btn color="white" v-bind="props">
                    <b>Activator Slot</b>
                </v-btn>
            </template>
            <v-list>
                <v-list-item v-for="(item, index) in items" 
                        :key="index" :value="index" @click="item.action">
                    <v-list-item-title>{{ item.title }}</v-list-item-title>
                </v-list-item>
            </v-list>
        </v-menu>

        <v-btn text @click="callVuetifyBoard">
            <span>Vuetify 게시판</span>
            <v-icon right>mdi-hand-back-left-outline</v-icon>
        </v-btn>
        <v-btn v-if="isLogin" text @click="myPage">
            <span>마이페이지</span>
            <v-icon right>mdi-account-plus-outline</v-icon>
        </v-btn>
        <v-btn v-if="!isLogin" text @click="signIn">
            <span>로그인</span>
            <v-icon right>mdi-login</v-icon>
        </v-btn>
        <v-btn v-if="isLogin" text @click="signOut">
            <span>로그아웃</span>
            <v-icon right>mdi-exit-to-app</v-icon>
        </v-btn>
    </v-app-bar>
</template>

<script>
import 'vuetify/dist/vuetify.min.css'
import { mapGetters, useStore } from 'vuex';

export default {
    data () {
        return {
            navigation_drawer: false,
            isLogin: false,
            items: [
                { title: '클릭해봐!', action: this.clickHandler },
                { title: '클릭하지마!', action: this.dontClickHandler },
                { title: 'React Query + Zustand + MUI 게시판', action: this.callReactMuiBoard },
            ]
        }
    },
    computed: {
        ...mapGetters('authenticationModule', {
            getAccessToken: 'getAccessToken',
        }),
    },
    inject: ['eventBus', 'authEventBus'],
    mounted () {
        // console.log('Navigation onMounted: ' + this.authEventBus);
        // const authStore = useStore()
        // console.log('authStore: ' + authStore)
        // console.log('accessToken: ' + this.getAccessToken)
        // console.log('authStore.state.authenticationModule: ' + authStore.state.authenticationModule)

        this.eventBus.on("login-complete", (data) => {
            console.log('로그인 완료 - 전달된 토큰: ' + data)
            localStorage.setItem("userInfo", data)
            this.isLogin = true

            this.gotoHome()
        })

        const userInfoExist = localStorage.getItem("userInfo")
        if (userInfoExist) {
            this.isLogin = true
        }

        // this.acquireAccessToken();
    },
    methods: {
        // acquireAccessToken() {
        //     const accessToken = this.getAccessToken;
        //     console.log('accessToken 값:', accessToken);
        // },
        callVuetifyBoard () {
            this.eventBus.emit('call-vuetify-board', 'callVuetifyBoard() 요청 완료')
            alert('Vuetify Board')
        },
        myPage () {
            alert('마이 페이지')
        },
        signIn () {
            // Container App -> Navigation App -> Auth App
            // Navigation App에서 Auth App을 remotes로 등록해야함 (앞서 Counter App으로 컨셉 검증 완료)
            this.eventBus.emit('sign-in', 'signIn() 요청 완료')
            alert('로그인')
        },
        signOut () {
            this.isLogin = false
            localStorage.removeItem("userInfo")
            // 'sign-out' event 미구현 -> Container에서 Auth App으로 event 보내고
            // Auth App에서 Spring에 연결한 정보들 끊도록 구성해야함
            this.eventBus.emit('sign-out')
            alert('로그아웃')
        },
        gotoHome () {
            this.eventBus.emit('goto-home')
            alert('고 홈')
        },
        clickHandler () {
            alert('클릭했네 ?')
        },
        dontClickHandler () {
            alert('클릭하지 말라니까 ?')
        },
        callReactMuiBoard () {
            this.eventBus.emit('call-react-mui-board', 'react mui 게시판 요청')
            alert('React Query + Zustand + MUI Board')
        }
    }
}
</script>

<style scoped lang="scss">
#data-v-app {
    height: 64px;
}
.app-container {
    height: 64px;
}
.main-container {
    max-height: 100%;
    overflow-y: auto;
}
.v-application--wrap {
    height: 64px !important;
}
.v-application {
    height: 64px;
}
.v-main {
    height: 64px;
}
.v-application__wrap {
    > .v-app-bar {
        height: 64px;
    }
}
</style>