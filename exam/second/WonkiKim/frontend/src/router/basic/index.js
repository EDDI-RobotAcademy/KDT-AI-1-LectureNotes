import Vue from 'vue'
import VueRouter from 'vue-router'
import ProblemPage from "@/views/problemPage/ProblemPage.vue";
import ProblemPage2 from "@/views/problemPage/problemPage2.vue";
import ProblemPage3 from "@/views/problemPage/ProblemPage3.vue";
import ProblemPage4 from "@/views/problemPage/ProblemPage4.vue";
Vue.use(VueRouter)

const basicRouter = [
    {
        path:"/problem-page",
        name:"ProblemPage",
        component: ProblemPage
    },
    {
        path:"/problem-page2",
        name:"ProblemPage2",
        component: ProblemPage2
    },
    {
        path:"/problem-page3",
        name:"ProblemPage3",
        component: ProblemPage3
    },
    {
        path:"/problem-page4",
        name:"ProblemPage4",
        component: ProblemPage4
    },
]
export default basicRouter
