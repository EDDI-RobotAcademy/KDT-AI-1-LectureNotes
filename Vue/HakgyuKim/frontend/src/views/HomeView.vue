<template>
  <v-container>
    <div>
      <nav>
        <router-link to="/">Home</router-link> |
        <router-link to="/about">About</router-link> |
        <!-- 
        router-link 파트는 UI 엔진인 Vue에서 경로를 지정
        부가적으로 to 라는 파라메터를 실제 URL에 입력하는 경로가 됩니다. 
        나타나는 형태는 text 형태고 누르면 자동으로 URL을 입력한 결과를 보여줍니다.
        이 작업을 자동화 하려면 반드시 router/index.js에
        /htmlTest를 누가 보여줄 것인지 컴포넌트 등록을 해줘야 합니다.
      -->
        <router-link to="/htmlTest">HtmlTest</router-link> |
        <router-link to="/cssTest">CssTest</router-link> |
        <router-link to="/vue-data-binding-page"
          >VueDataBindingPage</router-link
        >
        |
        <router-link to="/vue-click-event-page">VueClickEventPage</router-link>
        | <router-link to="/vue-input-event-page">VueInputEventPage</router-link
        ><br />
        |
        <router-link to="/duplex-model-test-page"
          >v-model 테스트 페이지</router-link
        >
        | <router-link to="/checkbox-test-page">checkbox 테스트</router-link> |
        <router-link to="/multi-checkbox-test-page"
          >다중checkbox 테스트</router-link
        >
        |
        <router-link to="/global-component-test-page"
          >전역 컴포넌트 테스트</router-link
        >
        |
        <router-link to="/data-send-test-page">데이터 샌드 테스트</router-link>
        | <router-link to="/homework1">문제은행1</router-link> |
        <router-link to="/data-response-from-spring-page"
          >주사위 굴리기</router-link
        >
        |
        <router-link to="/vue-lifecycle-test"
          >게임으로 파악하는 라이프 사이클</router-link
        >
        |
        <router-link to="/homework2">주사위로 핪으로 승패 정하기</router-link> |
        <router-link to="/homework-basic1">기본문제1</router-link> |
        <router-link to="/homework2-answer">숙제 2 정답</router-link> |
        <router-link to="/homework3">문제 은행3</router-link> |
        <router-link to="/homework4">문제 은행4</router-link> |
        <router-link to="/board-list-page"
          >Vue + Spring + JPA 게시판</router-link
        >
        |
        <router-link to="/vuetify-table-test">Vuetify Table-Test</router-link> |
        <router-link to="/vuetify-table-advanced"
          >Advanced Table Test</router-link
        >
        |
        <router-link to="/vuetify-image-gallery"
          >Image Gallery Test</router-link
        >
        | <router-link to="/homework6">문제은행6</router-link> |
        <router-link to="/dialog-test-page">Dialog 테스트</router-link> |
        <router-link to="/carousel-test-page">Carousel 테스트</router-link> |
        <router-link to="/d3-plot-page">D3 Plot 테스트</router-link> |
        <router-link to="/d3-homework1">D3 문제은행 1</router-link> |
        <router-link to="/file-handler-page">파일 저장 테스트</router-link> |
        <router-link to="/file-list-show-page"
          >Spring에 요청해서 파일 리스트 보기</router-link
        >
        |
        <router-link to="/food-register"
          >Food Aggregate Root 만들기</router-link
        >
        |
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
