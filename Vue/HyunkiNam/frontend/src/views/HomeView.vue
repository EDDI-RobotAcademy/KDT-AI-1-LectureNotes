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
        <router-link to="/problem4-page">문제 은행4</router-link> |
        <router-link to="/problem5-page">문제 은행5</router-link> |
        <router-link to="/product-image-page">상품</router-link> |
        <router-link to="/board-list-page">Vue + SPRING + JPA 게시판</router-link> |
        <router-link to="/vuetify-table-test">Vuetify Table 테스트</router-link> |
        <router-link to="/vuetify-table-advanced">Vuetify Table 추가 테스트</router-link> |
        <router-link to="/vuetify-image-gallery">Vuetify Image 갤러리</router-link> |
        <router-link to="/image-homework-page">Vue 문제 은행 6</router-link> |
        <router-link to="/dialog-test-page">Dialog 테스트</router-link> |
        <router-link to="/carousel-test-page">Carousel 테스트</router-link> |
        <router-link to="/d3plot-test-page">D3 plot 테스트</router-link> |
        <router-link to="/d3plot-homework-page">Vue + Spring + D3 문제 은행 [ 1 ]</router-link> |
        <router-link to="/d3plot-exam-page">테스트</router-link> |
        <router-link to="/file-handler-page">파일</router-link> |
        <router-link to="/file-list-show-page">파일 리스트</router-link> |
        <router-link to="/food-register">Food Aggregate Root 만들기</router-link> |
        <router-link to="/fastapi-test-page">FastAPI 숫자 테스트</router-link> |


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
