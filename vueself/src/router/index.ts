import { createRouter, createWebHistory } from 'vue-router'
import Login from "@/views/login/login.vue"
import Register from "@/views/login/register.vue"
import Home from "@/views/home/home.vue"
import Anime from '@/views/anime/anime.vue'

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
      path: '/home',
      name: 'home',
      component: Home
    },
    {
      path: '/home/anime',
      name: 'anime',
      component: Anime
    }

  ],
})

export default router
