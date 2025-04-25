<template>
    
    <div class="common-layout">
      <el-container>
        <el-aside :width="asideWidth" style="min-height:100vh; background-color: pink;">
        
            <div style="height: 60px; display: flex; align-items: center; justify-content: center; background-color: plum; color: purple; transition: width 0.5s ease;">
                <img src="@/assets/5t5.jpg" alt="logo" style="width: 50px; height: 50px; border-radius: 50%; ">
                <span v-show="! isCollapse" style="font-size: 20px; color: #fff;">
                    IHIRINA/Yeri
                </span>
            </div>

            <el-menu :collapse="isCollapse" router  active-color="blueviolet !important" style="border: none; background-color: pink; " :default-active=" $route.path ">
                <el-menu-item index="/home">
                    <el-icon style="color: blueviolet;"><HomeFilled /></el-icon>
                    <span style="color: black;">我的主页</span>
                </el-menu-item>
                <el-menu-item index="/music">
                    <el-icon style="color: blueviolet;"><Service /></el-icon>
                    <span style="color: black;">网抑云音乐</span>
                </el-menu-item>
                <el-menu-item index="/study">
                    <el-icon  style="color: blueviolet;"><EditPen /></el-icon>
                    <span style="color: black;">学习捏</span>
                </el-menu-item>

                <el-sub-menu>
                    <template #title>
                        <el-icon style="color: blueviolet;"><Menu /></el-icon>
                        <span style="display: flex;height: 56px; width: 1000px;">二刺猿</span>
                    </template>
                    <template slot="title">
                        <i class="el-icon-menu"></i>
                        <span>信息管理</span>
                    </template>
                    <el-menu-item index="/anime" style="background-color: hotpink; color: black;" >动漫</el-menu-item>
                    <el-menu-item index="/manga" style="background-color: hotpink; color: black;" >漫画</el-menu-item>
                </el-sub-menu>
            </el-menu>
        </el-aside>



        <el-container>
            <el-header>
                <i class="el-icon-menu" style="width: 5px;" @click="toggleMenu">
                    <el-icon style="color: red;" :size="40"><Grid /></el-icon>
                    
                </i>
                <el-breadcrumb style="margin-left: 100px; color: blueviolet;">
                    <span style="margin-left: 10px; color: brown;">（开放功能这些捏）</span>
                    <el-breadcrumb-item :to="{ path: '/home' }">我的主页</el-breadcrumb-item>
                    <el-breadcrumb-item :to="{ path: '/music'}">网抑云音乐</el-breadcrumb-item>
                    <el-breadcrumb-item :to="{ path: '/study'}">学习捏</el-breadcrumb-item>
                    <el-breadcrumb-item :to="{ path: '/anime'}">动漫</el-breadcrumb-item>
                    <el-breadcrumb-item :to="{ path: '/manga'}">漫画</el-breadcrumb-item>
                    <el-breadcrumb-item :to="{ path: ''}"></el-breadcrumb-item>
                </el-breadcrumb>

                <span style="margin-left: 550px;" @click="handleFullscreen">
                    <el-icon :size="30"><Rank /></el-icon>
                </span>

                <div style="flex: 1; width: 0; display: flex; align-items: center; justify-content: flex-end;">
                    <el-dropdown placement="bottom">
                        <span>
                            <img src="@/assets/5t5.jpg" alt="logo" style="width: 40px; height: 40px; box-shadow: 2px 0 6px rgba(0,21,41,35);">
                        </span>
    
                        <el-icon><Rank /></el-icon>
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item>个人中心</el-dropdown-item>
                            <el-dropdown-item>设置</el-dropdown-item>
                            <el-dropdown-item @click="">退出登录</el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                </div>

            </el-header>

          
            <el-main>
            <!--主内容区-->
                <div>
                    <el-card>
                      <div style="height: 100%; display: flex; align-items: center; justify-content: center; background-color: papayawhip; color: blueviolet;">
                        <h1 style="font-size: 40px; color: cadetblue;">欢迎来到我的网站捏，以下的宝贝们</h1>
                      </div>
                    </el-card>
                </div>

                <div>
                    <el-table :data="users">
                      <!--label是表格的头部-->
                        <el-table-column label="ID" prop="id"></el-table-column>
                        <el-table-column label="username" prop="username"></el-table-column>
                        <el-table-column label="password" prop="password"></el-table-column>
                        <el-table-column label="address" prop="address"></el-table-column>
                    </el-table>
                </div>
            </el-main>
        </el-container>


      </el-container>
    </div>
</template>
  
<script lang="ts">
import { ref } from 'vue'
import { useRouter } from 'vue-router'

import {ArrowRight, EditPen, Grid, HomeFilled, Menu, Rank, Service} from '@element-plus/icons-vue';

import request from "@/utils/request";

export default {
    components: {
      Grid,
      Menu,
      EditPen,
      Service,
      HomeFilled,
      Rank,
      ArrowRight,
    },
    name: 'Home',

    data() {
        return {
            isCollapse: false, // 控制菜单的收缩状态
            asideWidth: '200px', // 侧边栏宽度
            change: '收起',
            users: []
        }
    },

    mounted() {
      request.get('/user/selectAll')
          .then((res: { data: never[]; }) => {
          this.users = res.data;
      })
    },

    methods: {
        // 控制菜单的收缩状态
        toggleMenu() {
            this.isCollapse = !this.isCollapse
            this.asideWidth = this.isCollapse ? '60px' : '200px'
            this.change = this.isCollapse ? '展开' : '收起'
        },
        handleFullscreen() {
            document.documentElement.requestFullscreen()
        },
    }
    
}
</script>

<style scoped lang="scss">

.common-layout {
    box-shadow: 2px 0 6px rgba(0,21,41,35);
}
.el-menu-item .isactive {
    background-color: blueviolet !important;
}
.el-menu-item:hover {
    background-color: rgb(188, 146, 227) !important;
}
.el-aside {
    transition: width 0.3s ease; /* 添加过渡效果 */
    box-shadow: 2px 2px 16px rgba(0,21,20,20);
    margin: 1px;
}
.el-header {
    height: 60px;
    display: flex;
    box-shadow: 2px 0 6px rgba(0,21,41,35);
    background-color: bisque;
    margin: 1px;
    align-items: center;
}
.el-main {
    background-color: rgb(255, 248, 239);
}
</style>