<template>
  <v-container>
    <div>
      <nav>
        <router-link to="/">Home</router-link> |
        <router-link to="/about">About</router-link> |
        <!--
        router-link 파트는 UI 엔진인 Vue에서 경로를 지정
        부가적으로 to라는 파라메터는 실제 URL에 입력하는 경로가 됩니다.
        나타나는 형태는 text 형태고 누르면 자동으로 URL을 입력한 결과를 보여줍니다.
        이 작업을 자동화 하려면 반드시 router/index.js에
        /htmlTest를 누가 보여줄 것인지 컴포넌트 등록을 해줘야 합니다.
      -->
        <router-link to="/htmlTest">HtmlTest</router-link> |
        <router-link to="/cssTest">CssTest</router-link> |
        <router-link to="/vue-data-binding-page">VueDataBindingPage</router-link> |
        <router-link to="/vue-click-event-page">VueClickEventPage</router-link> |
        <router-link to="/vue-input-event-page">VueInputEventPage</router-link> |
        <router-link to="/duplex-model-test-page">v-model 테스트 페이지</router-link> |
        <router-link to="/vue-checkbox-page">Cehckbox 테스트 페이지</router-link> |
        <router-link to="/vue-multi-checkbox-page">다중 Cehckbox 테스트 페이지</router-link> |
        <router-link to="/global-component-test-page">전역 컴포넌트 테스트</router-link> |
        <router-link to="/axios-test-page">axios 통신 테스트</router-link> |
        <router-link to="/random-dice-from-spring">axios 주사위 값 받기</router-link> |
        <router-link to="/homework-page">문제 은행</router-link> |
        <router-link to="/vue-lifecycle-test">게임으로 파악하는 라이프 사이클</router-link> |
        <router-link to="/practice-page">연습</router-link> |
        <router-link to="/kakao-api-page">API 사용</router-link> |


      </nav>
    </div>
  </v-container>
</template>

<script>
import HelloWorld from '../components/HelloWorld'

export default {
  name: 'Home',

  components: {
    HelloWorld,
  },
}
</script>
