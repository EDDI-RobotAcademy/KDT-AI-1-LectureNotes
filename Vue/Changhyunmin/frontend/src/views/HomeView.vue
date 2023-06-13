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

    <router-link to="/htmlTest">HtmlTest</router-link>|
    <router-link to="/cssTest">CssTest</router-link>|
    <router-link to="/vue-data-binding-page">VueDataBindingPage</router-link>|
    <router-link to="/vue-click-binding-page">VueClickEventPage</router-link>|
    <router-link to="/vue-input-binding-page">VueInputEventPage</router-link>|
    <router-link to="/dupix-with-model-page">DupixWithModelPage</router-link>|
    <router-link to="/vue-checkbox-page">VueCheckboxPage</router-link>|
    <router-link to="/vue-muilti-chcekbox-page">VueMuiltiChcekboxPage</router-link>|
    <router-link to="/global-component-test-page">전역 컴포넌트 테스트</router-link> |    
    <router-link to="/data-send-test-page">통신 테스트</router-link> |    
    <router-link to="/global-component">덧셈계산기</router-link> |    
    <router-link to="/local-component">계산기</router-link> |    
    <router-link to="/problem-page1">1번 문제</router-link> |    
    <router-link to="/random-dice-from-spring">주사위 굴리기</router-link> |    
    <router-link to="/life-cycle-test-page">몬스터 소환</router-link> |    
    <router-link to="/baseball">숫자야구게임</router-link> |    
    <router-link to="/dicegame">숙제</router-link> | 
    <router-link to="/problem-page2">2번 연습 문제</router-link> |   
    <router-link to="/problem-page3">3번 연습 문제</router-link> |   
    <router-link to="/problem-page4">4번 연습 문제</router-link> |
    <router-link to="/test-page1">Vue연습</router-link> |   
    <router-link to="/problem-page5">5번 연습 문제</router-link> |
    <router-link to="/board-list-page">게시물</router-link> |
    
    <router-link to="/test-page">연습</router-link> |

    <router-link to="/vuetify-table-test">Vuetify Table 테스트</router-link> |

    <router-link to="/vuetify-table-advanced">Vuetify Table 추가 테스트</router-link> |

    <router-link to="/vuetify-image-gallery">Vuetify Image 갤러리</router-link> |
    <router-link to="/print-image-test">Vuetify Image 테스트</router-link> |
    <router-link to="/dialog-test-page">Dialog 테스트</router-link> |
    <router-link to="/carousel-test-page">carousel 테스트</router-link> |
    <router-link to="/d3-plot-test-page">d3 테스트</router-link> |
    <router-link to="/test-d3-plot">d3연습</router-link> |
    <router-link to="/d3-health-print-page">d3문제</router-link> |
    
    <router-link to="/file-handler-page">file연습</router-link> |
    <router-link to="/file-list-show-page">Spring에 요청해서 파일 리스트 보기</router-link> |
    
    <router-link to="/image-test">사이트 연습</router-link> |
    <router-link to="/animetion">움직임 연습</router-link> |
    <router-link to="/food-register">식류품</router-link> |
    
    <router-link to="/test-page2">CSS연습</router-link> |   

    <router-link to="/product-list-page">product</router-link> |   

    <router-link to="/vue-test-1">VueTest01</router-link> |   
    <router-link to="/vue-test-2">VueTest02</router-link> |  
    <router-link to="/vue-test-3">VueTest03</router-link> | 
    <router-link to="/vue-test-4">VueTest04</router-link> | 
    <router-link to="/vue-test-7">VueTest07</router-link> | 
    <router-link to="/vue-test-8">VueTest08</router-link> | 
    <router-link to="/vue-test-9">VueTest09</router-link> | 
    <router-link to="/vue-test-10">VueTest10</router-link> | 
    <router-link to="/vue-test-15">VueTest15</router-link> | 
    <router-link to="/vue-test-16">VueTest16</router-link> | 
    <router-link to="/vue-test-17">VueTest17</router-link> | 
    <router-link to="/vue-test-21">VueTest21</router-link> | 
    <router-link to="/vue-test-25">VueTest25</router-link> | 
    
    
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
