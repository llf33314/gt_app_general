/**
 * @file router
 * @author dj
 */

import Vue from 'vue';
import Router from 'vue-router';
import Index from './pages/Index/Index';
Vue.use(Router);
export function createRouter() {
    let router = new Router({

        // history 模式，需要服务器后端配合做路由代理，将所有的前端路由同步代理到 /
        // mode: 'history',
        scrollBehavior(to, from, savedPosition) {
            if (savedPosition) {
                return savedPosition;
            }
            return {
                x: 0,
                y: 0
            };
        },
        routes: [{
            path: '/',
            component: Index,
        }, {
            path: '/index',
            component: Index,
        }]
    });

    return router;
}
