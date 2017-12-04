import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

const store = new Vuex.Store({
    state: {
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