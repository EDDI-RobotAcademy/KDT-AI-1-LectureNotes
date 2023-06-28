<template>
  <v-container>
    <div>
      <nav>
        <router-link to="/">Home</router-link> |
        <router-link to="/about">About</router-link> |
        <!-- 
          router-link 파트는 UI 엔진인 Vue에서 ★경로를 지정★
          부가적으로 to라는 피라메터는 실제 URL에 입력하는 경로가 된다.
          나타나는 형태는 text 형태고 누르면 자동으로 URL을 입력한 결과를 보여준다.
          이 작업을 자동화 하려면 반드시 router/index.js에
          /htmlTest를 누가 보여줄 것인지 ★컴포넌트 등록★을 해야한다.
        -->
        <router-link to="/htmlTest">HtmlTest</router-link> |
        <router-link to="/cssTest">CssTest</router-link> |
        <router-link to="/vue-data-binding-page">VueDataBindingPage</router-link>|
        <router-link to="/vue-click-event-page">VueClickEventPage</router-link>|
        <router-link to="/vue-input-event-page">VueInputEventPage</router-link><br />|
        <router-link to="/duplex-model-test-page">textarea 테스트 페이지</router-link>|
        <router-link to="/checkbox-test-page">checkbox 테스트 페이지</router-link>|
        <router-link to="/multi-checkbox-test-page">다중 checkbox 테스트 페이지</router-link>|
        <router-link to="/global-componenet-test-page">전역 컴포넌트 테스트</router-link>|
        <router-link to="/axios-test-page">axios 통신 테스트</router-link> |
        <router-link to="/homework-global-component">Vue 문제은행 1</router-link>|
        <router-link to="/random-dice-from-spring">axios로 주사위 값 받기</router-link>|
        <router-link to="/vue-lifecycle-test">게임으로 파악하는 라이프사이클</router-link>|
        <router-link to="/vue-basic-test">Vue 문제은행 2-1</router-link> |
        <router-link to="/vue-prob-test">Vue 문제은행 2-2</router-link>|
        <router-link to="/problem-page2">Vue 문제은행 2 [Review]</router-link>|
        <router-link to="/problem-page3-alone">Vue 문제은행 3</router-link>|
        <router-link to="/problem-3page">Vue 문제은행 3 [Review]</router-link>|
        <router-link to="/vue-problem-4page-alone">Vue 문제은행 Re4</router-link>|
        <router-link to="/vue-problem-4page">Vue 문제은행 4 [Review]</router-link>|
        <router-link to="/vue-problem-5page">Vue 문제은행 5 [Review]</router-link>|
        <router-link to="/vue-prob6">Vue 문제은행 6</router-link>|
        <router-link to="/board-list-page">Vue + Spring + JPA 게시판</router-link>|
        <router-link to='/vuetify-table-test'>Vuetify Page 테스트</router-link>|
        <router-link to='/vuetify-table-advanced'>Vuetify Table 추가 테스트</router-link>|
        <router-link to='/vuetify-image-gallery'>Vuetify Image 갤러리</router-link>|
        <router-link to='/vuetify-image-prob-page'>Vue 문제 은행 6의 페이지</router-link>|
        <router-link to='/dialog-test-page'>dialog 테스트</router-link>|
        <router-link to='/carousel-test-page'>carousel 테스트</router-link>|
        <router-link to='/d3plot-test-page'>d3plot 테스트</router-link>|
        <router-link to='/d3plot-prob'>Vue + Spring + D3 문제 은행 1</router-link>|
        <router-link to="/d3-health-print-page">Vue + Spring + D3 문제 은행 1 [Review]</router-link> |
        <router-link to="/file-handler-test-page">File Test Page</router-link> |
        <router-link to="/file-list-show-page">Spring에 요청해서 파일 리스트 보기</router-link> |
        <router-link to="/food-aggregate-root-register-page">Aggrigate Root 만들기</router-link> |
        <router-link to="/fastapi-test-page">FastAPI 숫자 테스트</router-link> |
        <router-link to="/composition-problem-page">Spring, FastAPI 통합 숫자 테스트</router-link> |
        <router-link to="/sign-up-page">회원 가입</router-link> |
        <router-link to="/github-sign-in-page">Github 로그인</router-link> |
        <router-link to="/after-login/sample">토큰 전송</router-link> |
        <router-link to="/computer-income-homework-page">Vue + FastAPI + Keras 문제 은행 [ 1 ]</router-link> |
        <router-link to="/payment-page">결제 페이지</router-link> |
        <router-link to="/number-traffic-page">Vue + Spring + FastAPI 문제 은행 [ 1 ]</router-link> |
        <router-link to="/chat-page">웹소켓 채팅 테스트</router-link> |
        <router-link to="/s3-page">s3 테스트</router-link> |
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