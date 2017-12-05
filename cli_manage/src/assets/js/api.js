'use strict'
/**
 * 页面接口工具类
 */
import $api from "./request.js"

const requesturl = '';

const index = {
    //获取账号信息
    getAccountInfo(obj) {
        return $api.post({
            url: requesturl + '/app/bus/getAccountInfo',
            params: obj.params,
            fn: obj.fn
        })
    },
    //根据行业code获取各行业信息
    getIndustryInfo(obj) {
        return $api.post({
            url: requesturl + '/app/bus/getIndustryInfo/' + obj.params,
            fn: obj.fn
        })
    },
    //获取账号对应的行业列表
    listIndustry(obj) {
        return $api.post({
            url: requesturl + '/app/bus/listIndustry',
            params: obj.params,
            fn: obj.fn
        })
    }
}

export {
    index
}
