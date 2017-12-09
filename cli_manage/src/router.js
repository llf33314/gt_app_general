/**
 * @file router
 * @author dj
 */

import Vue from 'vue';
import Router from 'vue-router';
import Index from './pages/Index/Index';
Vue.use(Router);
export function createRouter() {
    const router = new Router({
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
            meta: {
                keepAlive: true
            },
            component: Index,
        }, {
            path: '/index',
            meta: {
                keepAlive: true
            },
            component: Index,
        }]
    });

    //全局路由守卫-拦截
    router.beforeEach((to, from, next) => {
        if (typeof to.meta.requireAuth == "undefined" || to.meta.requireAuth) {
            next();
            //TODO App Shell登录
        } else {
            next();
        }
    });

    return router;
}
