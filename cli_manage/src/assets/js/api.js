'use strict'
/**
 * 页面接口工具类
 */
import $api from "./request.js"

const requesturl = '';

const index = {
    getAccountInfo(obj) {
        return $api.post({
            url: requesturl + '/app/bus/getAccountInfo.do',
            params: obj.params,
            fn: obj.fn
        })
    }
}

export {
    index
}
