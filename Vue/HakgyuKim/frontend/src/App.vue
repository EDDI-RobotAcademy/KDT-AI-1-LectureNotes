<template>
  <div id="app">
    <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link> |
      <!-- 
        router-link 파트는 UI 엔진인 Vue에서 경로를 지정
        부가적으로 to 라는 파라메터를 실제 URL에 입력하는 경로가 됩니다. 
        나타나는 형태는 text 형태고 누르면 자동으로 URL을 입력한 결과를 보여줍니다.
        이 작업을 자동화 하려면 반드시 router/index.js에
        /htmlTest를 누가 보여줄 것인지 컴포넌트 등록을 해줘야 합니다.
      -->
      <router-link to="/htmlTest">HtmlTest</router-link> |
      <router-link to="/cssTest">CssTest</router-link> |
      <router-link to="/vue-data-binding-page">VueDataBindingPage</router-link> |
      <router-link to="/vue-click-event-page">VueClickEventPage</router-link> |
      <router-link to="/vue-input-event-page">VueInputEventPage</router-link> |
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

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
