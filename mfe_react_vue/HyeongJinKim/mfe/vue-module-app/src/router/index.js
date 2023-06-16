import { createRouter, createWebHashHistory } from "vue-router";
import BoardListPage from "../domain/board/page/BoardListPage.vue";
import BoardRegisterPage from "../domain/board/page/BoardRegisterPage.vue";

const routes = [
  {
    path: "/",
    name: "BoardListPage",
    component: BoardListPage,
  },
  {
    path: "/board-register-page",
    name: "BoardRegisterPage",
    component: BoardRegisterPage,
  },
  // {
  //   path: "/board-read-page/:boardId",
  //   name: "BoardReadPage",
  //   components: { default: BoardReadPage },
  //   props: { default: true },
  // },
  // {
  //   path: "/board-modify-page/:boardId",
  //   name: "BoardModifyPage",
  //   components: { default: BoardModifyPage },
  //   props: { default: true },
  // },
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;
