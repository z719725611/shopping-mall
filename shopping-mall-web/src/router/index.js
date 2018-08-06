import Vue from 'vue';
import Router from 'vue-router';
import login from '../views/login/Login.vue';
import videoLogin from '../views/login/VideoLogin.vue';

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
    }
  ]
})
