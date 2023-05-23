<template>
  <v-container>
    <div>
      <nav>
        <router-link to="/">Home</router-link> |
        <router-link to="/first-problem">1번 문제</router-link> |
        <router-link to="/third-problem">3번 문제</router-link> |
        <router-link to="/fifth-problem">5번 문제</router-link> |
        <router-link to="/seventh-problem">7번 문제</router-link> |
        <router-link to="/eighth-problem">8번 문제</router-link> |
        <router-link to="/fourteenth-problem">14번 문제</router-link> |
        <router-link to="/twentieth-problem">20번 문제</router-link> |
        <router-link to="/twentythreeth-problem">23번 문제</router-link> |
        <router-link to="/twentysixth-problem">26번 문제</router-link> |
        <router-link to="/twentynineth-problem">29번 문제</router-link> |
        <router-link to="/thirtieth-problem">30번 문제</router-link> |

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
