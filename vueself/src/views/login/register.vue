<template>
    <div class="common-layout">
      <el-container>
        <el-aside width="300px">
          <div justify="center" align="middle" class="login-aside">
              <el-col :span="5" style="color: blueviolet; font-size: 35px;">
                  <h2>欢</h2>
              </el-col>
              <el-col :span="5" style="color: blueviolet; font-size: 35px;">
                  <h2>迎</h2>
              </el-col>
              <el-col :span="5" style="color: blueviolet; font-size: 35px;">
                  <h2>欢</h2>
              </el-col>
              <el-col :span="5" style="color: blueviolet; font-size: 35px;">
                  <h2>迎</h2>
              </el-col>
              <el-col :span="5" style="color: blueviolet; font-size: 35px;">
                  <h2>欢</h2>
              </el-col>
              <el-col :span="5" style="color: blueviolet; font-size: 35px;">
                  <h2>迎</h2>
              </el-col>
              <el-col :span="5" style="color: blueviolet; font-size: 35px;">
                  <h2>你</h2>
              </el-col>
              <el-col :span="5" style="color: blueviolet; font-size: 35px;">
                  <h2>呀</h2>
              </el-col>
          </div>       
        </el-aside>
  
  
        <el-main>
          <el-row class="login-container" justify="center" align="middle">
            <el-col :span="20">
              <el-card class="login-card" shadow="hover" >
                <h2 style="font-size: 35px; ">注册</h2>
                <el-form ref="form" :model="form" label-width="80px">
                  <el-form-item label="账号">
                    <el-input placeholder="请输入账号" clearable v-model="form.account"></el-input>
                  </el-form-item>
                  <el-form-item label="密码">
                    <el-input clearable show-password placeholder="请输入密码" type="password" v-model="form.password"></el-input>
                  </el-form-item>
                  <el-form-item label="确认密码">
                    <el-input clearable show-password placeholder="确认密码" type="password" v-model="form.password"></el-input>
                  </el-form-item>
                  <el-form-item>
                    <el-button color="purple" type="primary"  plain round @click="handleRegister"> <div>注册</div> </el-button>
                    <el-text tag="ins" shadow="hover" @click="loginHandler">已经有账号？点击登录</el-text>
                  </el-form-item>
                </el-form>
              </el-card>
            </el-col>
          </el-row>
        </el-main>
  
  
        <el-aside width="300px">
          <div justify="center" align="middle" class="login-aside">
              <h2 style="color: blueviolet; font-size: 55px;">来</h2>
              <h2 style="color: blueviolet; font-size: 55px;">看</h2>
              <h2 style="color: blueviolet; font-size: 55px;">来</h2>
              <h2 style="color: blueviolet; font-size: 55px;">看</h2>
              <h2 style="color: blueviolet; font-size: 55px;">来</h2>
              <h2 style="color: blueviolet; font-size: 55px;">看</h2>
              <h2 style="color: blueviolet; font-size: 55px;">我</h2>
              <h2 style="color: blueviolet; font-size: 55px;">呀</h2>
          </div>  
        </el-aside>
      </el-container>
    </div>
  </template>
  
<script>
  import { ref } from 'vue'
  import { useRouter } from 'vue-router'
  import { ElMessage } from 'element-plus'
  
  export default {
      name: 'Register',
      data() {
          return {
              form: {
                  account: '',
                  password: ''
              }
          }
      },
      methods: {
        handleRegister() {
            // 这里可以添加注册逻辑，比如发送请求到后端进行注册
            console.log('注册信息:', this.form)
            alert('注册成功！')
            // 注册成功后跳转到登录页面
            this.$router.push('/login')
        },
        loginHandler() {
            this.$router.push('/login')
        },

      }
  }
  </script>
  
  <style scoped lang="scss">
  .common-layout {
    height: 100vh;
    width: 100%;
    background-color: #f7aae4;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    .el-container {
      height: 100%;
      background-color: #f7aae4;
      width: 100%;
      height: 100%;
      display: flex;
      justify-content: center;
      align-items: center;
      .el-aside {
          background-color: #fbd8f2;
          height: 100vh;
          display: flex;
          justify-content: center;
          align-items: center;
      }
      .el-main {
        background-color: #f7aae4;
        .login-card {
          width: 100%;
          max-width: 400px;
          margin: 0 auto;
          padding: 20px;
          background-color: #fbd8f2;
          border-radius: 10px;
          box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
          
        }
      }
    }
  }
  
  
  
  </style>