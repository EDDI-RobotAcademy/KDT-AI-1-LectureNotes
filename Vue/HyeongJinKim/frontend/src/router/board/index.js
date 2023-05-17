import Vue from "vue";
import VueRouter from "vue-router";
import BoardListPage from "@/views/board/BoardListPage.vue";
import BoardRegisterPage from "@/views/board/BoardRegisterPage.vue";
import BoardReadPage from "@/views/board/BoardReadPage.vue";
import BoardModifyPage from "@/views/board/BoardModifyPage.vue";

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
  // 다중 컴포넌트가 되면 component->components
  // props:{default:true}가 되어야 데이터가 전달됨
  {
    path: "/board-read-page/:boardId",
    name: "BoardReadPage",
    components: { default: BoardReadPage },
    props: { default: true },
  },
  {
    path: "/board-modify-page/:boardId",
    name: "BoardModifyPage",
    components: { default: BoardModifyPage },
    props: { default: true },
  },
];
export default boardRoutes;
