<template>
  <v-app>
    <v-app-bar
      app
      color="orange"
      dark
    >
      <div class="d-flex align-center">
        <router-link to="/">
        <v-img
        id="jb"
          alt="Vuetify Logo"
          class="shrink mr-2"
          contain
          src="https://cdn.vuetifyjs.com/images/logos/vuetify-logo-dark.png"
          transition="scale-transition"
          width="40"
        />
        </router-link>
        <label>2차 테스트중</label>
        <v-img
          alt="Vuetify Name"
          class="shrink mt-1 hidden-sm-and-down"
          contain
          min-width="100"
          src="https://cdn.vuetifyjs.com/images/logos/vuetify-name-dark.png"
          width="100"
        />
      </div>

      <v-spacer></v-spacer>

      <v-btn
        href="https://github.com/vuetifyjs/vuetify/releases/latest"
        target="_blank"
        text
      >
        <span class="mr-2">Latest Release</span>
        <v-icon>mdi-open-in-new</v-icon>
      </v-btn>
    </v-app-bar>
    
    <v-main>
      <router-view/>
    </v-main> 
    <!-- <input type="checkbox" id="menuicon"/>
       <label for="menuicon">
            <span></span>
            <span></span>
        </label>
        <div class="sidebar"></div> -->

  </v-app>
  
  
        
</template>

<script>

export default {
  name: 'App',

  data: () => ({
    //
  }),
};

</script>

<style>
div[class="sidebar"]{
        width: 300px;
        height: 100%;
        background: #222;
        position: fixed;
        top: 0;
        left:-300px;
        z-index:1;
        transition: all .35s;
    }
input[id="menuicon"]:checked + label +div {
    left: 0;
}
#jb:hover {
	transform: rotate( 180deg );
}
</style>