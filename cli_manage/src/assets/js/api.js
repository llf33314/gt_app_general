'use strict'
/**
 * 页面接口工具类
 */
import $api from "./request.js"

// const requesturl = 'http://rap.duofee.com/mockjsdata/38/';
const requesturl = '';

const login = {
    logoImage(obj) {
        return $api.post({
            url: requesturl + '/propertyStaff/login.do',
            params: obj.params,
            fn: obj.fn
        })
    },
    verify(obj) {
        return $api.post({
            url: requesturl + '/propertyStaff/login/verification.do',
            params: obj.params,
            fn: obj.fn
        })
    }
};

const index = {
    info(obj) {
        return $api.post({
            url: requesturl + '/propertyStaff/index.do',
            params: obj.params,
            fn: obj.fn
        })
    }
}

export {
    login,
    index
}
