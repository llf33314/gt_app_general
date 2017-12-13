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
            component: Index,
        }, {
            path: '/index',
            component: Index,
        }]
    });
    
    return router;
}
