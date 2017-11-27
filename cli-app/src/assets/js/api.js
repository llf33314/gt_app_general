'use strict'
/**
 * 页面接口工具类
 */
import $api from "./request.js"

// const requesturl = 'http://rap.duofee.com/mockjsdata/38/';
const requesturl = '';

const common = {
    manage(obj) {
        return $api.post({
            url: requesturl + '/propertyStaff/login.do',
            params: obj.params,
            fn: obj.fn
        })
    },
};

export {
    //公共模块
    common
}
