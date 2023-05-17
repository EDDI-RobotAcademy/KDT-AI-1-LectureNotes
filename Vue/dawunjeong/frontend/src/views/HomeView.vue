<template>
  <v-container>
    <div>
      <nav>
        <router-link to="/">Home</router-link> |
        <router-link to="/about">About</router-link> |
        <!-- 
          router-link 파트는 UI엔진인 Vue에서 경로를 지정 
          부가적으로 to라는 파라메터는 실제 URL에 입력하는 경로가 됩니다.
          나타나는 형태는 text 형태고 누르면 자동으로 URL을 입력한 결과를 보여줍니다.
          이 작업을 자동화 하려면 반드시 router/index.js에 
          /htmlTest를 누가 보여줄 것인지 컴포넌트 등록을 해줘야 합니다.
        -->
        <router-link to="/htmlTest">HtmlTest</router-link> |
        <router-link to="/cssTest">CssTest</router-link> |
        <router-link to="/vue-data-binding-page">VueDataBindingPage</router-link> |
        <router-link to="/vue-click-event-page">VueClickEventPage</router-link> |
        <router-link to="/vue-input-event-page">VueInputEventPage</router-link><br> |
        <router-link to="/duplex-model-test-page">textarea 테스트 페이지</router-link> |
        <router-link to="/checkbox-test-page">checkbox 테스트 페이지</router-link> |
        <router-link to="/multi-checkbox-test-page">다중 checkbox 테스트 페이지</router-link> |
        <router-link to="/global-component-test-page">전역 컴포넌트 테스트</router-link> |
        <router-link to="/axios-test-page">axios 통신 테스트</router-link> |
        <router-link to="/homework-test-page">과제 테스트 페이지</router-link> |
        <router-link to="/problem-page1">과제 풀이 페이지</router-link> |
        <router-link to="/random-dice-from-spring">axios로 주사위 데이터 받기</router-link> |
        <router-link to="/vue-lifecycle-test">게임으로 파악하는 라이프사이클</router-link> |
        <router-link to="/random-dice-check-win-from-spring">axios로 주사위 승패 판정하기</router-link> |
        <router-link to="/random-dice-game-from-spring">axios로 1:1 주사위 게임하기</router-link> |
        <router-link to="/problem-page2">2번 연습 문제</router-link> |
        <router-link to="/buy-fruit-page">과일 구매하기</router-link> |
        <router-link to="/problem-page3">3번 연습 문제</router-link> |
        <router-link to="/game-character-page">게임 캐릭터 만들기</router-link> |
        <router-link to="/buy-fruits-page">주말 과제</router-link> |
        <router-link to="/board-list-page">Vue + Spring + JPA 게시판</router-link> |
        <router-link to="/product-list-page">상품 목록 페이지</router-link> |
        <router-link to="/vuetify-table-test">뷰티파이 테스트 페이지</router-link> |
        <router-link to="/vuetify-table-advanced">뷰티파이 어드벤스드 페이지</router-link> |
        <router-link to="/vuetify-image-gallery">뷰티파이 어드벤스드 페이지</router-link> |
        <router-link to="/print-image-test">Vuetify Image 테스트</router-link> |
        <router-link to="/image-get-page">이미지 페이지</router-link> |
        <router-link to="/dialog-test-page">Dialog 테스트</router-link> |
        <router-link to="/carousel-test-page">Carousel 테스트</router-link> |
        <router-link to="/d3-plot-test">D3 Plot 테스트</router-link> |
        <router-link to="/d3-plot-study">D3 Plot 스터디</router-link> |
        <router-link to="/d3-health-homework-page">운동 문제 풀기!</router-link> |
        <router-link to="/file-handler-page">파일 테스트!</router-link> |
        <router-link to="/food-register">Aggregate Root 만들기</router-link> |
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