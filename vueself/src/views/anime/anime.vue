<template>
    
    <div class="common-layout">
      <el-container>
        <el-aside width="200px" min-height="100vh">
        <!--侧边栏-->
            <div style="height: 60px; display: flex; align-items: center; justify-content: center; background-color: pink; color: purple;">
                logo
            </div>

            <el-menu router style="border: none;" :default-active="$route.path">
                <el-menu-item index="/home">
                    <el-icon><HomeFilled /></el-icon>
                    <span>我的主页</span>
                </el-menu-item>
                <el-menu-item>系统首页</el-menu-item>
                <el-menu-item>系统首页</el-menu-item>
                <el-menu-item>系统首页</el-menu-item>
                <el-sub-menu>
                    <template #title>
                        <el-icon><Menu /></el-icon>
                        <span>二刺猿</span>
                    </template>
                    <template slot="title">
                        <i class="el-icon-menu"></i>
                        <span>信息管理</span>
                    </template>
                    <el-menu-item index="/home/anime">动漫</el-menu-item>
                </el-sub-menu>
            </el-menu>
        </el-aside>


        <el-container>
            <el-header>
                yyeyeye
            </el-header>

          
            <el-main>
            <!--主内容区-->
            主题
            <router-view></router-view>
            </el-main>
        </el-container>


      </el-container>
    </div>
</template>

<script>
export default {
    name: 'Anime',
    data() {
        return {
            // Define your data properties here
        }
    },
    methods: {
        // Define your methods here
    }
}
</script>