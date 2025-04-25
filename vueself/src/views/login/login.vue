<template>
    <div class="common-layout">
      <el-container>
        <el-aside width="200px">
          <div justify="center" align="middle" class="login-aside">
              <el-col :span="5">
                  <h2>欢</h2>
              </el-col>
              <el-col :span="5">
                  <h2>迎</h2>
              </el-col>
              <el-col :span="5">
                  <h2>欢</h2>
              </el-col>
              <el-col :span="5">
                  <h2>迎</h2>
              </el-col>
              <el-col :span="5">
                  <h2>欢</h2>
              </el-col>
              <el-col :span="5">
                  <h2>迎</h2>
              </el-col>
              <el-col :span="5">
                  <h2>你</h2>
              </el-col>
              <el-col :span="5">
                  <h2>呀</h2>
              </el-col>
          </div>       
        </el-aside>
  
  
        <el-main width="100%">
          <el-row class="login-container" justify="center" align="middle">
            <el-col :span="14">
              <el-card class="login-card" shadow="hover"> 
                <h2 style="font-size: 35px; ">登录</h2>
                <el-form ref="form" :model="form" label-width="80px">
                  <el-form-item label="用户名">
                    <el-input placeholder="请输入账号" clearable v-model="form.username"></el-input>
                  </el-form-item>
                  <el-form-item label="密码">
                    <el-input clearable show-password placeholder="请输入密码" type="password" v-model="form.password"></el-input>
                  </el-form-item>
                  
                    <el-form-item label="验证码">
                      <div style="display: flex">
                          <el-input v-model="ValidCode" style="width: 60%" placeholder="请输入验证码" size="medium"></el-input>
                          <ValidCode @input="getCode" style="background-color: aliceblue;margin-top: 5px;margin-left: 5px;"/>
                          <!--<el-button style="margin-left: 0px;" color="pink" type="primary" plain round>获取验证码</el-button>-->
                      </div>
                    </el-form-item>
                    <el-form-item>
                      <el-button color="purple" type="primary"  plain round @click="handleLogin"> <div>登录</div> </el-button>
                      <el-text tag="ins" shadow="hover" @click="registerHandler">还没有账号？点击注册</el-text>
                    </el-form-item>
                  </el-form>
         
              </el-card>
            </el-col>
          </el-row>
        </el-main>
  
  
        <el-aside width="200px">
          <div justify="center" align="middle" class="login-aside">
              <h2>来</h2>
              <h2>看</h2>
              <h2>来</h2>
              <h2>看</h2>
              <h2>来</h2>
              <h2>看</h2>
              <h2>我</h2>
              <h2>呀</h2>
          </div>  
        </el-aside>
      </el-container>
    </div>
  </template>
  
  <script>
  import { ref } from 'vue'
  import { useRouter } from 'vue-router'
  import ValidCode from '@/components/vaildCode.vue'

  export default {
      name: 'Login',
      data() {
          return {
              form: {
                  username: '',
                  password: '',
                  code: ''      //用户输入的code
              },
              vaildCode: '',    //组件里面传过来的code
          }
      },
      components: {
        ValidCode
      },
  
      methods: {
        registerHandler() {
          this.$router.push('/register')
        },

        
        getCode(code) {
          console.log('验证码:', code),
          this.code = code
        },

        handleLogin() {
          console.log('登录信息:', this.form)
          if (this.form.username === '' || this.form.password === '') {
            alert('用户名和密码不能为空')
            return
          }
          if (this.form.ValidCode === '') {
            alert('验证码不能为空')
            return
          }
          if (this.form.ValidCode !== this.ValidCode) {
            alert.error('验证码错误')
            return
          }
          alert('登录成功！')
          // 登录成功后跳转到首页
          this.$router.push('/home')
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