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
        <router-link to="/vue-input-event-page">VueInputEventPage</router-link><br />
        <router-link to="/duplex-model-test-page">textarea 테스트 페이지</router-link> |
        <router-link to="/checkbox-test-page">checkbox 테스트 페이지</router-link> |
        <router-link to="/multi-checkbox-test-page">다중 checkbox 테스트 페이지</router-link> |
        <router-link to="/global-component-test-page">전역 컴포넌트 테스트</router-link><br />
        <router-link to="/axios-test-page">axios 통신 테스트</router-link> |
        <router-link to="/random-dice-from-spring">axios로 주사위 값 받기</router-link> |
        <router-link to="/vue-lifecycle-test">게임으로 파악하는 라이프사이클</router-link> |
        <router-link to="/board-list-page">Vue + Spring + JPA 게시판</router-link> |
        <router-link to="/vuetify-table-test">Vuetify 테스트</router-link> |
        <router-link to="/vuetify-table-advanced">Vuetify Table 추가 테스트</router-link> |
        <router-link to="/vuetify-image-gallery">Vuetify Image 갤러리</router-link> |
        <router-link to="/dialog-test-page">Dialog 테스트</router-link> |
        <router-link to="/carousel-test-page">Carousel 테스트</router-link> |
        <router-link to="/d3-plot-page">D3 Plotting 테스트</router-link> |
        <router-link to="/file-handler-test-page">File 처리 테스트</router-link> |
        <router-link to="/file-list-show-page">Spring에 요청해서 파일 리스트 보기</router-link> |
        <router-link to="/food-register">Food Aggregate Root 만들기</router-link> |
      </nav>
    </div>
    <br /><br />
    <div>
      <p>HOMEWORK</p>
      <nav>
        <router-link to="/vue-homework-page">Vue 문제 은행 [1]</router-link> |
        <router-link to="/vue-homework-page2_1">Vue 문제 은행 [2] - 1</router-link> |
        <router-link to="/vue-homework-page2_2" >Vue 문제 은행 [2] - 2</router-link> |
        <router-link to="/vue-basic-probs">Vue 기본 문제 [1]</router-link><br />
        <router-link to="/vue-homework-page3">Vue 문제 은행 [3] - GetMapping</router-link> |
        <router-link to="/vue-homework-page3-Copy">Vue 문제 은행 [3] - PostMapping</router-link> |
        <router-link to="/vue-homework-page4">Vue 문제 은행 [4]</router-link> |
        <router-link to="/vue-homework-page5">Vue 문제 은행 [5]</router-link> |
        <router-link to="/print-image-test">Vue 문제 은행 [6]</router-link> |
        <router-link to="/plot-problem-page">Vue + Spring + D3 문제 은행 [1]</router-link> |
      </nav>
    </div>
  </v-container>
</template>
<script>
import HelloWorld from "../components/HelloWorld";
export default {
  name: "Home",
  components: {
    HelloWorld,
  },
};
</script>

<!-- 
  vue add vuetify
 -->
