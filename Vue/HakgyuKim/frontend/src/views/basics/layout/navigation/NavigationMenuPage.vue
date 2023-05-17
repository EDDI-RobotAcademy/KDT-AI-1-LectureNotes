<template lang="">
   <nav>
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
      <v-btn href="https://zoom.us/j/99591291759?pwd=VS9QY1RuRWswenRXSTlmWlRrbW9Ldz09" target="_blank">
        <span>줌 참여</span>
        <v-icon right>mdi-monitor-account</v-icon>
      </v-btn>
      <v-btn href="https://github.com/EDDI-RobotAcademy/KDT-AI-1-LectureNotes" target="_blank">
        <span>github</span>
        <v-icon right>mdi-github</v-icon>
      </v-btn>
      <v-btn href="https://www.notion.so/eddi-robot-academy/c1038c896dbd410287d8feeef8c8fd20" target="_blank">
        <span>notion</span>
        <v-icon right>mdi-book-open-variant</v-icon>
      </v-btn>
      <v-btn href="https://app.slack.com/client/T04B9JMKZ2R/browse-channels" target="_blank">
        <span>slack</span>
        <v-icon right>mdi-slack</v-icon>
      </v-btn>
      <v-btn href="https://cafe.naver.com/eddicorp" target="_blank">
        <span>카페</span>
        <v-icon right>mdi-coffee</v-icon>
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
          { icon: 'mdi-home', text: 'Home', route: '/' },
          { icon: 'mdi-human-greeting', text: 'About', route: '/about'}
        ],
      }
    },
    methods: {
      goToHome () {
        router.push('/')
      }
    }
}
</script>