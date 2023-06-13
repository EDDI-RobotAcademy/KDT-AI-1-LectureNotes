<template>
  <v-container>
    <div>
      <nav>
        <router-link to="/problem-page1">1번 문제</router-link> |
        <router-link to="/problem-page1">2번 문제</router-link> |
        <router-link to="/problem-page1">3번 문제</router-link> |

        
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
