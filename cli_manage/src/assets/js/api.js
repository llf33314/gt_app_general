'use strict'
/**
 * @file 接口模块
 * @author dj
 */

import axios from 'axios'
import $api from "./request.js"

const index = {
    //获取账号信息与行业列表
    getAccountInfo(obj) {
        return $api.all({
            url: [axios.post('/app/bus/getAccountInfo'), axios.post('/app/bus/listIndustry')],
            fn: obj.fn
        })
    },
    //根据行业code获取各行业信息
    getIndustryInfo(obj) {
        return $api.post({
            url: '/app/bus/getIndustryInfo/' + obj.params,
            params: false,
            fn: obj.fn
        })
    },
}

export {
    index
}
