'use strict'
/**
 * @file Vuex 状态封装
 * @author dj
 */
import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

const store = new Vuex.Store({
    //数据源申明
    state: {
        //行业对应模板
        industry: {
            2: "car",
            5: "home"
        },
        userId: 0,
        token: '',
        clickCount: 0
    },
    //写入缓存并同步state
    mutations: {
        userId: (state, val) => {
            state.userId = val;
            window.localStorage.setItem('userId', val);
        },
        token: (state, val) => {
            state.token = val;
            window.localStorage.setItem('token', val);
        },
        clickCount: (state, val) => {
            state.clickCount = val;
            window.localStorage.setItem('clickCount', val);
        },
    }
})

export default store