<template lang="">
  <nav>
    <!-- 아래 링크를 참고하여 본인 취향의 Navigation Bar를 만들 수 있습니다.
         https://vuetifyjs.com/en/components/app-bars/ -->
    <v-app-bar color="dark" app dark>
      <v-app-bar-nav-icon @click="navigation_drawer = !navigation_drawer"/>
      <v-btn @click="goToHome">
        <v-img class="mx-2" src="@/assets/logo.png"
                max-height="40" max-width="40" contain>
        </v-img>
        <v-toolbar-title class="text-uppercase text--darken-4">
          <span>EDDI</span>
        </v-toolbar-title>
      </v-btn>
      <v-spacer></v-spacer>
      <!--
        사용하고 싶은 아이콘을 자유롭게 선택해서 UI를 꾸미세요.
        https://pictogrammers.com/library/mdi/?welcome

        아이콘 따올때 맨 앞에 mdi 키워드가 붙어야 합니다.
      -->
      <v-btn text @click="clickToggle">
        <span>테스트</span>
        <v-icon right>mdi-hand-back-left-outline</v-icon>
      </v-btn>
      <v-btn v-if="!isAuthenticated" text @click="signUp">
        <span>회원가입</span>
        <v-icon right>mdi-account-plus-outline</v-icon>
      </v-btn>
      <v-btn v-if="!isAuthenticated" text @click="signIn">
        <span>로그인</span>
        <v-icon right>mdi-login</v-icon>
      </v-btn>
      <v-btn v-if="isAuthenticated" text @click="signOut">
        <span>로그아웃</span>
        <v-icon right>mdi-exit-to-app</v-icon>
      </v-btn>
    </v-app-bar>

    <v-navigation-drawer app v-model="navigation_drawer">
      <v-list-item>
        <v-list-item-content>
          <v-list-item-title class="text-h6">EDDI</v-list-item-title>
          <v-list-item-subtitle>페이지 기능</v-list-item-subtitle>
        </v-list-item-content>
      </v-list-item>

      <v-divider></v-divider>
      
      <v-list nav dense>
        <v-list-item v-for="(link, index) in links" :key="link.index" router :to="link.route">
          <v-list-item-action>
            <v-icon>
              {{ link.icon }}
            </v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>
              {{ link.text }}
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
  </nav>
</template>

<script>
import {
    GITHUB_LOGIN_COMPLETE,
} from '@/store/authentication/mutation-types'

import router from '@/router'
import { mapState, mapMutations } from 'vuex'

const authenticationModule = 'authenticationModule'

export default {
  data () {
    return {
      navigation_drawer: false,
      links: [
        { icon: 'mdi-home', text: 'Home', route: '/' }
      ],
      //accountId: 0,
      //isLogin: false,
      userToken: null
    }
  },
  computed: {
    ...mapState(authenticationModule, ['isAuthenticated'])
  },
  methods: {
    ...mapMutations(authenticationModule, ['GITHUB_LOGIN_COMPLETE']),
    clickToggle () {
      alert('토글')
    },
    signUp () {
      router.push('/problem-page5')
    },
    signIn () {
      router.push('/problem-page5')
    },
    signOut () {
      //localStorage.removeItem("loginUserInfo")
      //this.isLogin = false

      localStorage.removeItem("userToken")
      this[GITHUB_LOGIN_COMPLETE](false)
      //this.$store.state.authenticationModule.isAuthenticated = false
    },
    goToHome () {
      // 자기 참조 형태에서 push()는 오류가 발생하므로 go()로 변경함
      router.push('/')
    }
  },
  mounted () {
    //this.accountId = localStorage.getItem("loginUserInfo")
    //this.accountId = localStorage.getItem("userToken")
    
    //if (this.accountId > 0) {
      //this.isLogin = true
      //this.$store.state.authenticationModule.isAuthenticated = true
      //this[GITHUB_LOGIN_COMPLETE](true)
    //} else {
      //this.isLogin = false
      //this.$store.state.authenticationModule.isAuthenticated = false
      //this[GITHUB_LOGIN_COMPLETE](false)
    //}
    this.userToken = localStorage.getItem("userToken")

    if (this.userToken == null) {
      this[GITHUB_LOGIN_COMPLETE](false)
    } else {
      this[GITHUB_LOGIN_COMPLETE](true)
    }
  }
}
</script>

<style lang="">
    
</style>