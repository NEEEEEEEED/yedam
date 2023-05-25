import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import UserView from "../views/UserView.vue";
import BoardView from "../views/BoardView.vue";
import ApproveView from "../views/ApproveView.vue";
import PayView from "../views/PayView.vue";

const routes = [
  {
    path: "/admin",
    name: "home",
    component: HomeView,
  },
  {
    path: "/user",
    name: "user",
    component: UserView,
  },
  {
    path: "/board",
    name: "board",
    component: BoardView,
  },
  {
    path: "/approve",
    name: "approve",
    component: ApproveView,
  },
  {
    path: "/pay",
    name: "pay",
    component: PayView,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
