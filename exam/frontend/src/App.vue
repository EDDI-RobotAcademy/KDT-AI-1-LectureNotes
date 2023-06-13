<template>
  <div id="app">
    <navbar></navbar>
    <router-view></router-view>
  </div>
</template>

<script>
import Navbar from './components/navbar/navbar.vue'

export default {
  name: 'app',
  components: { Navbar },
  data () {
    return {
    }
  }
}
</script>

<style>

</style>