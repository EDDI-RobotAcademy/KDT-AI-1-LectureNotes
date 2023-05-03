import Vue from 'vue';
import Vuetify from 'vuetify/lib/framework';

// 아래와 같이 vuetify는 Vue.use(vuetify)를 통해 전역으로 걸려 있다.
/*
전역 컴포넌트는

우리가 별도의 frontend 프레임워크나 vuetify같은 UI 엔진을 만드는 경우

사용하게 될 것
*/ 
Vue.use(Vuetify);

export default new Vuetify({
});
