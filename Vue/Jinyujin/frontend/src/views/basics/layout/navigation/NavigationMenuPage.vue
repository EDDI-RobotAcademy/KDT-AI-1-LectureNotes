<template lang="">
    <nav>
      <!-- 아래 링크를 참고하여 본인 취향의 Navigation Bar를 만들 수 있습니다.
           https://vuetifyjs.com/en/components/app-bars/ -->
      <v-app-bar color="black" app dark>
        <v-app-bar-nav-icon @click="navigation_drawer = !navigation_drawer"/>
        <!-- <v-img class="mx-2" src="@/assets/logo.png"
                max-height="40" max-width="40" contain/>
        <v-toolbar-title class="text-uppercase text--darkens-4">
          <span>EDDI</span>
        </v-toolbar-title> -->
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
        <v-btn v-if="!isLogin" text @click="signUp">
          <span>회원가입</span>
          <v-icon right>mdi-account-plus-outline</v-icon>
        </v-btn>
        <v-btn v-if="!isLogin" text @click="signIn">
          <span>로그인</span>
          <v-icon right>mdi-login</v-icon>
        </v-btn>
        <v-btn v-if="isLogin" text @click="signOut"> 
          <!-- 
            먼저 회원가입과 로그인 버튼 뜨고 로그아웃은 로그인 된 후 떠도 된다
            그래서 일단 회원가입과 로그인 버튼만 뜨게 하고 로그아웃은 숨겨놓음
            아래 마운트에서 로그인이 되었다면 로그아웃이 뜨도록 설정
          -->
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
  import router from '@/router'
  export default {
      
      data () {
        return {
          navigation_drawer: false,
          links: [
            { icon: 'mdi-home', text: 'Home', route: '/' }
          ],
          gameId: 0,
          isLogin: false,
        }
      },
      methods: {
        clickToggle () {
          alert('토글')
        },
        signUp () {
          alert('회원가입')
          router.push('/make-character')
        },
        signIn () {
          alert('로그인')
          router.push('/make-character')
        },
        signOut () {
          alert('로그아웃')
        },
        goToHome () {
          router.push('/')
        }
      },
      mounted() {
        // gameId가 0보다 클 경우 로그아웃 창 뜰 수 있도록
        this.gameId = localStorage.getItem("logInUserInfo")
        if (this.gameId > 0) {
          this.isLogin = true
        }

      },
  }
  </script>
  

<style lang="">
</style>