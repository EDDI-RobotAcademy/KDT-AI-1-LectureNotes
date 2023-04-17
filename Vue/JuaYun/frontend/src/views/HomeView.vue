<template>
  <v-container>
    <div>
      <nav>
        <router-link to="/">Home</router-link> |
        <router-link to="/about">About</router-link> |
        <router-link to="/global-component-test-page">전역 컴포넌트 테스트</router-link> |
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