import Vue from "vue";
import VueRouter from "vue-router";

// 게시판
import BoardListPage from "@/views/basics/board/BoardListPage.vue";
import BoardRegisterPage from "@/views/basics/board/BoardRegisterPage.vue";
import BoardReadPage from "@/views/basics/board/BoardReadPage.vue";
import BoardModifyPage from "@/views/basics/board/BoardModifyPage.vue"

Vue.use(VueRouter);

const boardRoutes = [
  {
    path: "/board-list-page",
    name: "BoardListPage",
    component: BoardListPage,
  },
  {
    path: "/board-register-page",
    name: "BoardRegisterPage",
    component: BoardRegisterPage,
  },
  {
    // 멀티 컴포넌트 형태
    path: '/board-read-page/:boardId',
    name: 'BoardReadPage',
    components: { // 페이지가 다른 컴포넌트 어쩌구 (해당 페이지에 이어지는 페이지들이 많음)
      default: BoardReadPage
    },
    props: { // 파라미터 전달을 하기 위해서는 이 코드가 필요하며 값은 true여야 한다.
      default: true
    },
  },
  {
    // 멀티 컴포넌트 형태
    path: '/board-modify-page/:boardId',
    name: 'BoardModifyPage',
    components: {
      default: BoardModifyPage
    },
    props: {
      default: true
    },
  },
];

export default boardRoutes;
