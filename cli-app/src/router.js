/**
 * @file router
 * @author dj(1193933@qq.com)
 */

import Vue from 'vue';
import Router from 'vue-router';
import Index from '@/pages/Index/Index';
import IndexPage from '@/pages/Index/IndexPage';
import Classify from '@/pages/Classify/Classify';
import Find from '@/pages/Find/Find';
import User from '@/pages/User/User';
Vue.use(Router);
export function createRouter() {
    let router = new Router({

        // history 模式，需要服务器后端配合做路由代理，将所有的前端路由同步代理到 /
        mode: 'history',
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
            name: "首页",
            component: Index
        }, {
            path: '/indexPage',
            name: "首页",
            component: IndexPage,
        }, {
            path: '/classify',
            name: "分类",
            component: Classify
        }, {
            path: '/find',
            name: "发现",
            component: Find
        }, {
            path: '/user',
            name: "用户",
            component: User
        }]
    });

    return router;
}
