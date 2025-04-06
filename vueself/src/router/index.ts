import { createRouter, createWebHistory } from 'vue-router'
import Login from "@/views/login/login.vue"
import Register from "@/views/login/register.vue"
import Admin from "@/views/admin/admin.vue"

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'login',
      component: Login,
    },
    {
      path: '/register',
      name: 'register',
      component: Register
    },
    {
      path: '/admin',
      name: 'admin',
      component: Admin
    }
  ],
})

export default router
