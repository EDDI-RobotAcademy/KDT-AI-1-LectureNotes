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
    <router-link to="/data-send-test-page">DataSendTestPage</router-link> |    
    <router-link to="/global-component">덧셈계산기</router-link> |    
    <router-link to="/local-component">계산기</router-link> |    
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
