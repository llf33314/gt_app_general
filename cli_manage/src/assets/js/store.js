import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

const store = new Vuex.Store({
    state: {
        //行业对应模板
        industry: {
            2: "car",
            5: "home"
        },
        userId: 0,
        token: ''
    },

    mutations: {
        userId(state, val) {
            state.userId = val;
            window.localStorage.setItem('userId', val);
        },
        token(state, val) {
            state.token = val;
            window.localStorage.setItem('token', val);
        },
    }
})

export default store