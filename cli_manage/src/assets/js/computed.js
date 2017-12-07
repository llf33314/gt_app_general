'use strict'
/**
 * @file DATA映射
 * @author dj
 */
import { mapState } from 'vuex';
import store from "./store.js";

const computed = mapState({
    industry: state => {
        return state.industry;
    },
    userId: state => {
        if (state.userId === 0 && window.localStorage.getItem("userId")) {
            store.commit("userId", window.localStorage.getItem("userId"));
        }
        return state.userId;
    },
    token: state => {
        if (state.token === "" && window.localStorage.getItem("token")) {
            store.commit("token", window.localStorage.getItem("token"));
        }
        return state.token;
    },
    clickCount: state => {
        if (state.clickCount === 0 && window.localStorage.getItem("clickCount")) {
            store.commit("clickCount", window.localStorage.getItem("clickCount"));
        }
        return state.clickCount;
    }
})
export default computed