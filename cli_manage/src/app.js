/**
 * @file entry
 * @author dj(1193933@qq.com)
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
import store from './assets/js/store.js';
import support from "./components/support";

Vue.use(MintUI)
Vue.component("df-support", support)
Vue.config.productionTip = true;


/* eslint-disable no-new */
export function createApp() {
    let router = createRouter();
    let app = new Vue({
        router,
        store,
        ...App
    });
    return { app, router };
}
