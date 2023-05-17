import BoardCommunicationListPage from '@/views/practice/BoardCommunicationListPage.vue'

Vue.use(VueRouter)

const boardCommunicationRoutes = [
    {
        path: '/board-communication-list-page',
        name: 'BoardCommunicationListPage',
        component: BoardCommunicationListPage
    },
]

export default boardCommunicationRoutes