<template lang="">
    <v-app-bar color="primary" app dark height="64">
        <v-app-bar-nav-icon @click="navigation_drawer = !navigation_drawer"/>
        <v-btn @click="goHome">
            <v-toolbar-title class="text-uppercase text--darken-4">
                <span>EDDI</span>
            </v-toolbar-title>
        </v-btn>
        
        <v-spacer></v-spacer>
        <v-menu>
            <template v-slot:activator="{ props }">
                <v-btn color="white" v-bind="props">
                    <b>Activator Slot</b>
                </v-btn>
            </template>
            <v-list>
                <v-list-item v-for="(item, index) in items" :key="index" :value="index">
                    <v-list-item-title>{{ item.title }}</v-list-item-title>
                </v-list-item>
            </v-list>
        </v-menu>

        <v-btn text @click="clickToggle">
            <span>클릭 토글</span>
            <v-icon right>mdi-hand-back-left-outline</v-icon>
        </v-btn>
        <v-btn v-if="!isLogin" text @click="signUp">
            <span>회원가입</span>
            <v-icon right>mdi-account-plus-outline</v-icon>
        </v-btn>
        <v-btn v-if="!isLogin" text @click="signIn">
            <span>로그인</span>
            <v-icon right>mdi-login</v-icon>
        </v-btn>
        <v-btn v-if="isLogin" text @click="signOut">
            <span>로그아웃</span>
            <v-icon right>mdi-exit-to-app</v-icon>
        </v-btn>
    </v-app-bar>
</template>
<script>
import 'vuetify/dist/vuetify.min.css'

export default {
    data(){
        return{
            navigation_drawer: false,
            items: [
                {title: '클릭해봐!'},
                {title: '클릭하지마!'},
                {title: '이렇게 나오지!'},
                {title: '요로코롬!'},

            ]
        }
    },
    methods: {
        clickToggle(){
            alert('토글')
        },
        signUp(){
            alert('회원가입')
        },
        signIn(){
            alert('로그인')
        },
        signOut(){
            alert('로그아웃')
        },
        gotoHome(){
            alert('고 홈')
        },
    }
}
</script>
<style scoped lang="scss">
#data-v-app {
    height: 64px;
}
.app-container{
    height: 64px;
}
.main-container {
    max-height: 100%;
    overflow-y: auto;
}
.v-application--wrap {
    height: 64px !important;
}
.v-application{
    height: 64px;
}
.v-main{
    height: 64px;
}
.v-application__wrap {
    > .v-app-bar{
        height: 64px;
    }
}
</style>