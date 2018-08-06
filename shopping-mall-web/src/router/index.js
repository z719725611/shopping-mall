import Vue from 'vue'
import Router from 'vue-router'
import login from '../views/login/Login.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: login
    }
  ]
})
