// 내가 보고 적절하게 분배할 것

import Vue from 'vue'
import VueRouter from 'vue-router'

import ProblemPage1 from '@/views/basics/solved/problem1/ProblemPage1.vue'
import Problem2Page from '@/views/basics/solved/problem2/Problem2Page.vue'
import Problem3Page from '@/views/basics/solved/problem3/Problem3Page.vue'

import VueBasicProblem1 from '@/views/homework/vueBasicProblem1/VueBasicProblem1.vue'

import DiceGame3 from '@/views/homework/diceGame3/DiceGame3.vue'

import MakeCharacter from '@/views/homework/character/MakeCharacter.vue'

Vue.use(VueRouter)

const solvedRoutes = [
    {
        path: '/problem-page1',
        name: 'ProblemPage1',
        component: ProblemPage1
    },
    {
        path: '/problem-page2',
        name: 'Problem2Page',
        component: Problem2Page
    },
    {
        path: '/problem-page3',
        name: 'Problem3Page',
        component: Problem3Page
    },
    {
        path: '/vue-basic-problem1',
        name: 'VueBasicProblem1',
        component: VueBasicProblem1
    },
    {
        path: '/dice-game3',
        name: 'DiceGame3',
        component: DiceGame3
    },
    {
        path: '/make-character',
        name: 'MakeCharacter',
        component: MakeCharacter
    },
]

export default solvedRoutes