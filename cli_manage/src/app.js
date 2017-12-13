/**
 * @file entry
 * @author dj
 */

import Vue from 'vue';
import MintUI from 'mint-ui';
import 'mint-ui/lib/style.css';
import App from './App.vue';
import { createRouter } from './router.js';
import './assets/iconfont/iconfont.js';
import "normalize.css";
import "./assets/css/theme.less";
import 'lib-flexible';
import './assets/js/util.js';
import store from './assets/js/store.js';
import PullTo from 'vue-pull-to';

Vue.use(MintUI)
Vue.config.productionTip = true
Vue.component('pull-to', PullTo)

/* eslint-disable no-new */
export function createApp() {
    const router = createRouter();
    const app = new Vue({
        router,
        store,
        ...App
    });
    return { app, router };
}
