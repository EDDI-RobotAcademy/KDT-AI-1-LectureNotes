<template lang="">
    <nav>
        <!-- App.ve 쪽에 script를 만들어 내부 설정해줌 <navigation-menu-page/>도 삽입 -->
        <v-app-bar color="dark" app dark>
           <v-app-bar-nav-icon @click="navigatio_drawer = !navigation_drawer"/>
           <v-img class="mx-2" src="@/assets/logo.png"
                 max-geight="40" max-width="40" contain/>
           <v-toolbar-title class="text-uppercase text--darken-4">
             <span>EDDI</span>
           </v-toolbar-title>  
        </v-app-bar>
    </nav>
</template>
<script>
export default {
    
}
</script>
<style lang="">
    
</style>