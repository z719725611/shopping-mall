import Vue from 'vue';
import Router from 'vue-router';
import login from '../views/login/pages/Login.vue';
import videoLogin from '../views/login/pages/VideoLogin.vue';
import register from '../views/login/pages/Register.vue';

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: login
    },
    {
      path: '/videoLogin',
      name: 'videoLogin',
      component: videoLogin
    },
    {
      path: '/register',
      name: 'register',
      component: register
    }
  ]
})
