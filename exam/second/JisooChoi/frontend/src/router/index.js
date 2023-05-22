import Vue from 'vue'
import VueRouter from 'vue-router'

import Test1routes from './Test1'
import Test2routes from './Test2'
import Test3routes from './Test3'
import Test4routes from './Test4'
import Test7routes from './Test7'
import Test8routes from './Test8'
import Test9routes from './Test9'
import Test10routes from './Test10'
import Test17routes from './Test17'
import Test21routes from './Test21'

Vue.use(VueRouter)

const routes = [
  ...Test1routes,
  ...Test2routes,
  ...Test3routes,
  ...Test4routes,
  ...Test7routes,
  ...Test8routes,
  ...Test10routes,
  ...Test17routes,
  ...Test9routes,
  ...Test21routes,
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

export default router
