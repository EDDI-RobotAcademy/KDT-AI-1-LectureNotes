<template>
<v-container>
  <div>
    <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link> |
      <!--
        router-link 파트는 UI엔진인 Vue에서 경로를 지정
        부가적으로 to라는 파라메터는 실제 URL에 입력하는 경로가 됩니다
        나타나는 형태는 text 형태고 누르면 자동으로 URL을 입력한 결과를 보여줍니다.
        이 작업을 자동화 하려면 반드시 router/index.js에
        /htmlTest를 누가 보여 줄 것인지 컴포넌트 등록을 해줘야합니다.
      -->
      <router-link to="/htmlTest">HtmlTest</router-link> |
      <router-link to="/CssTest">CssTest</router-link> |
      <router-link to="/vue-data-binding-page">VueDataBindingPage</router-link> |
      <router-link to="/vue-click-event-page">VueClickEventPage</router-link> |
      <router-link to="/vue-input-event-page">VueInputEventPage</router-link> |<br>
      <router-link to="/duplex-model-test-page">textarea 테스트 페이지</router-link> |
      <router-link to="/checkbox-test-page">checkbox 테스트 페이지</router-link> |
      <router-link to="/multi-checkbox-test-page">다중checkbox 테스트 페이지</router-link> |
      <router-link to="/global-component-test-page">전역 컴포넌트 테스트</router-link> |
      <router-link to="/axios-test-page"> axios 통신 테스트</router-link> |
      <router-link to="/component-homework-test-page"> 과제</router-link> |
      <router-link to="/problem1-page"> 1번 연습 문제</router-link> |
      <router-link to="/random-dice-from-spring">axios로 주사위 값 받기</router-link> |
      <router-link to="/vue-lifecycle-test">게임으로 파악하는 라이프 사이클</router-link> |<br>
      <router-link to="/problem2-page"> 2번 연습 문제</router-link> |
      <router-link to="/problem2-2page"> 2번-2 연습 문제</router-link> |
      <router-link to="/basic-problem">vue 기본 문제</router-link> |
      <router-link to="/problem3-page">vue 3번 문제</router-link> |<br>
      <router-link to="/Study-page">공부하자</router-link> |<br>
      <router-link to="/Problem4-page">4번 연습문제</router-link> |
      <router-link to="/Problem5-page">5번 연습문제(혼자 도전)</router-link> |

      <router-link to="/Problem5-page2">5번 연습문제 복습</router-link> |

      <router-link to="/Problem5-page2">Vue 5번</router-link> |
      <router-link to="/board-list-page">Vue+Spring+JPA</router-link> |
      <router-link to="/vuetify-table-page">Vuetify Table테스트</router-link> |
      <router-link to="/vuetify-table-advanced">Vuetify Table 추가 테스트</router-link> |
      <router-link to="/vuetify-image-gallery">이미지</router-link> |
      <router-link to="/problem6-page">6번 연습문제</router-link> |
      <router-link to="/print-image-test">6번 연습문제 (Vuetify Image 테스트)</router-link> |
      <router-link to="/dialog-test-page">Dialog 테스트</router-link> |
      <router-link to="/carousel-test-page">carousel 테스트</router-link> |
      <router-link to="/d3plot-test-page">d3plot 테스트</router-link> |
      <router-link to="/d3problem-page">d3plot 문제</router-link> |
      <router-link to="/d3HealthPrint-page">d3plot HEALTH문제</router-link> |
      <router-link to="/file-handler-test-page">파일업로드</router-link> |
      <router-link to="/file-list-show-page">Spring에 요청해서 파일 리스트 보기</router-link> |
      <router-link to="/food-register-page">Food Aggergate Root 만들기</router-link> |


      
     


      


      

    </nav>
  </div>
</v-container> 
</template>

<script>
  import HelloWorld from '../components/HelloWorld'

  export default {
    name: 'HomeView',

    components: {
      HelloWorld,
    },
  }
</script>
