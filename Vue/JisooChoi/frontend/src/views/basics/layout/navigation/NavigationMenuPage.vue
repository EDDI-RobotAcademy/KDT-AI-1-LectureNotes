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
          https://pictogrammers.com/library/mdi/
          아이콘 사이트
         -->
        <v-btn text @click = "clickToggle">
          <span>테스트</span>
          <v-icon right>mdi-hand-back-left-outline</v-icon>
        </v-btn>
        <v-btn text @click = "signUp">
          <span>회원가입</span>
          <v-icon right>mdi-account-plus-outline</v-icon>
        </v-btn>
        <v-btn text @click = "signIn">
          <span>로그인</span>
          <v-icon right>mdi-login</v-icon>
        </v-btn>
        <v-btn text @click = "signOut">
          <span>로그아웃</span>
          <v-icon right>mdi-logout</v-icon>
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
                {{link.icon}}
              </v-icon>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title>
                {{link.text}}
              </v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>
      </v-navigation-drawer>
    </nav>
  </template>


  <script>
  import router from '@/router'
  export default {
    data () {
      return {
        navigation_drawer: false,
        links: [
          { icon: 'mdi-home', text: 'Home', route: '/' }
        ],
      }
    },
    methods: {
      clickToggle () {
        alert('토글')
      },
      signUp () {
        alert('회원가입')
      },
      signIn () {
        alert('로그인')
      },
      signOut () {
        alert('로그아웃')
      },
      goToHome () {
        // router.push('/')
        router.go()
      }
    }
  }
  </script>
  <style lang="">
      
  </style>