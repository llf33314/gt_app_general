'use strict'
/**
 * @file axios 请求封装
 * @author dj
 */
import axios from 'axios'
import Qs from 'qs'
import { Toast } from 'mint-ui';
import { Indicator } from 'mint-ui';

const request = window.request

axios.defaults.baseURL = request;
//响应时间
axios.defaults.timeout = 10000;
//`withCredentails`选项表明了是否是跨域请求
axios.defaults.withCredentials = false;
//设置默认请求头
axios.defaults.headers = {
    "Content-Type": "application/json; charset=UTF-8"
};

//添加请求拦截器
axios.interceptors.request.use(config => {
    //纯数据展示不加全屏loding
    if (typeof config.data !== 'undefined' && Qs.stringify(config.data) !== '') {
        Indicator.open();
    }
    return config
}, error => {
    Indicator.close()
    return Promise.reject(error)
})

//添加返回拦截器
axios.interceptors.response.use(response => {
    if (response.data.code === 100) {
        return response.data;
    } else if (response.data.message) {
        checkCode(response.data.message)
    } else {
        Indicator.close()
        // 弹出错误信息
        Toast({
            message: '操作失败，请重试',
            position: 'middle',
            duration: 5000
        });
    }
    return '';
}, error => {
    Indicator.close()
    if (error && error.response) {
        switch (error.response.status) {
            case 400:
                error.message = '请求错误'
                break
            case 401:
                error.message = '访问失败，请重试'
                break
            case 403:
                error.message = '拒绝访问'
                break
            case 404:
                error.message = '请求失败'
                break
            case 408:
                error.message = '请求超时'
                break
            case 500:
                error.message = '服务器内部错误'
                break
            case 501:
                error.message = '服务未实现'
                break
            case 502:
                error.message = '网关错误'
                break
            case 503:
                error.message = '服务不可用'
                break
            case 504:
                error.message = '网关超时'
                break
            case 505:
                error.message = 'HTTP版本不受支持'
                break
            default:
        }
    }
    //对返回的错误处理
    return Promise.reject(error);
});

//请求失败错误信息提示
function checkCode(message) {
    Indicator.close()
    // 弹出错误信息
    Toast({
        message: message,
        position: 'middle',
        duration: 5000
    });
}
export default {
    post(obj) {
        return axios.post(obj.url, obj.params).then(res => {
            if (typeof res.data != 'undefined') {
                obj.fn(res.data)
            }
            Indicator.close()
        }).catch(err => {
            checkCode(err.message)
        })
    },
    get(obj) {
        return axios.get(obj.url, obj.params).then(res => {
            if (typeof res.data != 'undefined') {
                obj.fn(res.data)
            }
            Indicator.close()
        }).catch(err => {
            checkCode(err.message)
        })
    },
    put(obj) {
        return axios.put(obj.url, obj.params).then(res => {
            if (typeof res.data != 'undefined') {
                obj.fn(res.data)
            }
            Indicator.close()
        }).catch(err => {
            checkCode(err.message)
        })
    },
    delete(obj) {
        return axios.delete(obj.url, obj.params).then(res => {
            if (typeof res.data != 'undefined') {
                obj.fn(res.data)
            }
            Indicator.close()
        }).catch(err => {
            checkCode(err.message)
        })
    },
}