import 'babel-polyfill';
import Vue from 'vue';

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

import './styles/sidebar.scss';
import main from './App.vue';

import router from './router';
import './mock';
import SvgIcon from './components/SvgIcon/index';
import './assets/iconfont/iconfont';

Vue.config.productionTip = false;

Vue.use(ElementUI);
Vue.component('svg-icon', SvgIcon);


new Vue({
  render: h => h(main),
  router
}).$mount('#app');
