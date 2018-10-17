<template>
  <div class="register-container">
    <el-form status-icon label-position="left" label-width="0px" ref="registerForm" :rules="registerRules"
             class="card-box register-form" :model="registerForm">
      <h3 class="title">账号注册</h3>
      <el-form-item prop="userName">
        <span class="svg-container svg-container_login">
          <svg-icon icon-class="zhanghao" />
        </span>
        <el-input name="userName" type="text" v-model="registerForm.userName" autoComplete="on" placeholder="请输入用户名" />
      </el-form-item>
      <el-form-item prop="password">
        <span class="svg-container">
          <svg-icon icon-class="mima"></svg-icon>
        </span>
        <el-input name="password" type="password" @keyup.enter.native="handleLogin" v-model="registerForm.password"
                  placeholder="请输入密码"></el-input>
      </el-form-item>
      <el-form-item prop="checkPassword">
        <span class="svg-container">
          <svg-icon icon-class="mima"></svg-icon>
        </span>
        <el-input name="checkPassword" type="password" @keyup.enter.native="handleLogin" v-model="registerForm.checkPassword"
                  placeholder="请确认密码"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" style="width:100%;" @click.native.prevent="register">
          注 册
        </el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  import LoginService from '../service/LoginService';

  export default {
    name: 'register',
    data() {
      var validateName = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入账号'));
        } else {
          callback();
        }
      };
      var checkUserName = (rule, value, callback) => {
        LoginService.checkUserName(value).then((res) => {
          if (!res) {
            callback(new Error('账号已存在'));
          } else {
            callback();
          }
        });
      };
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.registerForm.checkPassword !== '') {
            this.$refs.registerForm.validateField('checkPassword');
          }
          callback();
        }
      };
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.registerForm.password) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };

      return {
        registerForm: {
          userName: '',
          password: '',
          checkPassword: ''
        },
        registerRules: {
          userName: [
            { validator: validateName, trigger: 'blur' },
            { validator: checkUserName, trigger: 'blur' }
          ],
          password: [
            { validator: validatePass, trigger: 'blur' }
          ],
          checkPassword: [
            { validator: validatePass2, trigger: 'blur' }
          ]
        }

      };
    },

    created() {
    },

    methods: {
      register() {
        const self = this;
        this.$refs['registerForm'].validate((valid) => {
          if (valid) {
            LoginService.register(self['registerForm']).then((res) => {
              self.$message({
                message: '注册成功',
                type: 'success'
              });
              self.$router.push({ path: '/' })
            });
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      }
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss">
  @import "../../../styles/mixin";
  $bg:#2d3a4b;
  $dark_gray:#889aa4;
  $light_gray:#eee;

  .register-container {
    @include relative;
    height: 100vh;
    background-color: $bg;
    input:-webkit-autofill {
      -webkit-box-shadow: 0 0 0px 1000px #293444 inset !important;
      -webkit-text-fill-color: #fff !important;
    }
    input {
      background: transparent;
      border: 0px;
      -webkit-appearance: none;
      border-radius: 0px;
      padding: 12px 5px 12px 0px;
      color: $light_gray;
      height: 47px;
    }
    .el-input {
      display: inline-block;
      height: 47px;
      width: 85%;
    }
    .tips {
      font-size: 14px;
      color: #fff;
      margin-bottom: 10px;
    }
    .svg-container {
      padding: 6px 5px 6px 15px;
      color: $dark_gray;
      vertical-align: middle;
      width: 30px;
      display: inline-block;
      &_login {
        font-size: 20px;
      }
    }
    .title {
      font-size: 26px;
      font-weight: 400;
      color: $light_gray;
      margin: 0px auto 40px auto;
      text-align: center;
      font-weight: bold;
    }
    .register-form {
      position: absolute;
      left: 0;
      right: 0;
      width: 400px;
      padding: 35px 35px 15px 35px;
      margin: 120px auto;
    }
    .el-form-item {
      border: 1px solid rgba(255, 255, 255, 0.1);
      background: rgba(0, 0, 0, 0.1);
      border-radius: 5px;
      color: #454545;
    }
  }
</style>
