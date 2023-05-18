import Vue from 'vue'
import VueRouter from 'vue-router'
import Test1 from '@/views/problem/Test1.vue'
import Test2 from '@/views/problem/Test2.vue'
import Test3 from '@/views/problem/Test3.vue'
import Test4 from '@/views/problem/Test4.vue'
import Test7 from '@/views/problem/Test7.vue'
import Test8 from '@/views/problem/Test8.vue'
import Test14 from '@/views/problem/Test14RegisterMember.vue'
import Test20 from '@/views/problem/Test20LoginPage.vue'
import Test23 from '@/views/problem/Test23ProductRegisterPage.vue'






Vue.use(VueRouter)

const problemRoutes = [
    { path: '/test1-page',
      name: 'Test1',
      component: Test1
    },
    { path: '/test2-page',
      name: 'Test2',
      component: Test2
    },
    { path: '/test3-page',
      name: 'Test3',
      component: Test3
    },
    { path: '/test4-page',
      name: 'Test4',
      component: Test4
    },
    { path: '/test7-page',
      name: 'Test7',
      component: Test7
    },
    { path: '/test8-page',
      name: 'Test8',
      component: Test8
    },
    { path: '/test14-page',
    name: 'Test14',
    component: Test14
    },
    { path: '/test20-page',
    name: 'Test20',
    component: Test20
    },
    { path: '/test23-page',
    name: 'Test23',
    component: Test23
    },

]



export default problemRoutes