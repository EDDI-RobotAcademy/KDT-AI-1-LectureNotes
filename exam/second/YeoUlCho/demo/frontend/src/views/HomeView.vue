<template>
  <v-container>
    <div>
      <nav>
        <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link> |
      <router-link to="/test1-page">테스트1</router-link> |
      <router-link to="/test2-page">테스트2</router-link> |
      <router-link to="/test3-page">테스트3</router-link> |
      <router-link to="/test4-page">테스트4</router-link> |
      <router-link to="/test7-page">테스트7</router-link> |
      <router-link to="/test8-page">테스트8</router-link> |
      <router-link to="/test14-page">테스트14-회원가입</router-link> |
      <router-link to="/test20-page">테스트20-로그인</router-link> |
      <router-link to="/test23-page">테스트23-상품등록</router-link> |






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
