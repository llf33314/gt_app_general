'use strict'
/**
 * @file 接口模块
 * @author dj
 */

import $api from "./request.js"

const index = {
    //获取账号信息
    getAccountInfo(obj) {
        return $api.post({
            url: '/app/bus/getAccountInfo',
            fn: obj.fn
        })
    },
    //根据行业code获取各行业信息
    getIndustryInfo(obj) {
        return $api.post({
            url: '/app/bus/getIndustryInfo/' + obj.params,
            fn: obj.fn
        })
    },
    //获取账号对应的行业列表
    listIndustry(obj) {
        return $api.post({
            url: '/app/bus/listIndustry',
            fn: obj.fn
        })
    }
}

export {
    index
}
