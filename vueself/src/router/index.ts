import { createRouter, createWebHistory } from 'vue-router'
import Login from "@/views/login/login.vue"
import Register from "@/views/login/register.vue"
import Home from "@/views/home/home.vue"
import Anime from '@/views/anime/anime.vue'
import Manga from '@/views/anime/manga.vue'
import Study from '@/views/study/study.vue'
import Music from '@/views/wyy/wyy.vue'

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
      path: '/anime',
      name: 'anime',
      component: Anime
    },
    {
      path: '/manga',
      name: 'manga',
      component: Manga
    },
    {
      path: '/study',
      name: 'study',
      component: Study
    },
    {
      path: '/music',
      name: 'music',
      component: Music
    }

  ],
})

export default router
