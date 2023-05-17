import Vue from 'vue'
import VueRouter from 'vue-router'
import CharacterGame from '@/views/homework/Myproblem4/Problempage4.vue'
import Problem4Page from '@/views/homework/problem4/Problem4Page.vue'
import Problem5Page from '@/views/homework/problem5/Problem5Page.vue'
import MyBacklogPage from '@/views/homework/myfolder/MyBacklogPage.vue'
import HomeworkPage from '@/views/homework/HomeworkPage.vue'
import PostNumPage from '@/views/homework/PostNumPage.vue'
import Problem2Page from '@/views/homework/problem2/Problem2Page.vue'
import MyFolderPage from '@/views/homework/myfolder/MyFolderPage.vue'
import Problem3Page from '@/views/homework/problem3/Problem3Page.vue'

Vue.use(VueRouter)

const problemsRoutes = [
  {

    path: '/character',
    name: 'CharacterGame',
    component: CharacterGame
    },{
    
      path: '/charactertest',
      name: 'Problem4Page',
      component: Problem4Page
      },
      {
        path: '/problem-page5',
        name: 'Problem5Page',
        component: Problem5Page
      }, {
        path: '/my-backlog-page',
        name: 'MyBacklogPage',
        component: MyBacklogPage
      },  {
        path: '/homework-page',
        name: 'HomeworkPage',
        component: HomeworkPage
      },
      {
        path: '/post-num-test',
        name: 'PostNumPage',
        component: PostNumPage
      },
      {
      path: '/problem-page-two',
      name: 'Problem2Page',
      component: Problem2Page
    },
    {
      path: '/my-test',
      name: 'MyFolderPage',
      component: MyFolderPage
    },
    {
      path: '/fruits-page',
      name: 'Problem3Page',
      component: Problem3Page
    },  

]

export default problemsRoutes
