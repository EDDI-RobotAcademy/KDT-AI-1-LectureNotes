<template>
    <v-container>
      <div>
        <nav>
          <router-link to="/">Home</router-link> |
          <router-link to="/about">About</router-link> |
          <router-link to="/aws-s3">이미지 테스트</router-link> |
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
