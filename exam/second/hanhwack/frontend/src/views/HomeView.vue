<template>
  <div id="app">
    <nav>
      <router-link :to="{ name: 'Test1Page' }"> 1번문제 </router-link>|
      <router-link :to="{ name: 'Test2Page' }"> 2번문제 </router-link>|
      <router-link :to="{ name: 'Test3Page' }"> 3번문제 </router-link>|
      <router-link :to="{ name: 'Test4Page' }"> 4번문제 </router-link>|
      <router-link :to="{ name: 'Test7Page' }"> 7번문제 </router-link>|
      <router-link :to="{ name: 'Test8Page' }"> 8번문제 </router-link>|


    </nav>
    <router-view/>
  </div>

</template>
<style scoped>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
nav {
  padding: 30px;
}
nav a {
  font-weight: bold;
  color: #2c3e50;
}