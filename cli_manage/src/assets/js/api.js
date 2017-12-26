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
            url: [axios.post('/app/manage/bus/getAccountInfo'), axios.post('/app/manage/bus/listIndustry')],
            fn: obj.fn
        })
    },
    //根据行业code获取各行业信息
    getIndustryInfo(obj) {
        return $api.post({
            url: '/app/manage/bus/getIndustryInfo/' + obj.params,
            params: false,
            fn: obj.fn,
            err: obj.err
        })
    },
}

export {
    index
}
