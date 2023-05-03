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
            <router-link to="/basics/binding">VueDataBindingPage</router-link> |
            <router-link to="/basics/event">VueClickEventPage</router-link> <br>
            <router-link to="/vue-input-event-page">VueInputEventPage</router-link> |
            <router-link to="/duplex-model-test-page">textarea 테스트 페이지</router-link> |
            <router-link to="/vue-checkbox-page">checkbox 테스트 페이지</router-link> |
            <router-link to="/multi-checkbox-page">다중 checkbox 테스트 페이지</router-link> |
            <router-link to="/global-component-test-page">전역 컴포넌트 테스트</router-link> |
            <router-link to="/data-send-test-page">데이터 전송 테스트 페이지</router-link> |
            <router-link to="/homework-page">숙제 페이지</router-link> |
            <router-link to="/random-dice-from-spring">주사위 받아오기</router-link> |
            <router-link to="/life-cycle-test">몬스터 정보</router-link> |
            <router-link to="/homework-page-two">주사위 숙제</router-link> |
            <router-link to="/post-num-test"> 숫자 보내기 </router-link> |
            <router-link to="/problem-two-page">2번 문제</router-link> |
            <router-link to="/my-test">숫자 보내보기</router-link>|
            <router-link to="/fruits-page">과일 페이지</router-link> |
            <router-link to="/april">배열 내 값을 증가</router-link> |
            <router-link to="/character">캐릭터 생성</router-link>|
            <router-link to="/charactertest">선생님 캐릭터</router-link> |
            <router-link to="/problem-page5">5번 연습 문제</router-link> |
            <router-link to="/my-backlog-page">물고기 문제</router-link> |
            <router-link to="board-list-page">JPA 기반 게시판</router-link> |
           
            
        </nav></div>
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
