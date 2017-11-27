'use strict'
/**
 * axios请求工具类
 */
import axios from 'axios'
import Qs from 'qs'
import { Toast } from 'mint-ui';
import { Indicator } from 'mint-ui';

//服务器地址
const request = 'https://wuye.deeptel.com.cn';
axios.defaults.baseURL = request;
//响应时间
axios.defaults.timeout = 5000;
//`withCredentails`选项表明了是否是跨域请求
axios.defaults.withCredentials = true;
//设置默认请求头
axios.defaults.headers = {
    'X-Requested-With': 'XMLHttpRequest',
    "Content-Type": "application/x-www-form-urlencoded; text/html; charset=UTF-8"
};

//添加请求拦截器
axios.interceptors.request.use(config => {
    Indicator.open();
    // 判断是否存在token，如果存在的话，则每个http header都加上token
    if (typeof sessionStorage.getItem('token') != 'undefined' && sessionStorage.getItem('token') != null) {
        config.headers.token = sessionStorage.getItem('token');
    }
    return config
}, error => {
    Indicator.close()
    return Promise.reject(error)
})

//添加返回拦截器
axios.interceptors.response.use(function (response) {
    if (response.status == 200 && response.data.code == 0) {
        return response;
    } else {
        return checkCode(response.data.message)
    }
}, function (error) {
    Indicator.close()
    //对返回的错误处理
    return Promise.reject(error);
});

//请求成功，返回错误回调函数
function checkCode(message) {
    Indicator.close()
    // 弹出错误信息
    Toast({
        message: message,
        position: 'middle',
        duration: 5000
    });
}
//请求失败，回调函数
function checkStatus(err) {
    Indicator.close()
    Toast({
        message: '网络异常',
        position: 'middle',
        duration: 5000
    });
}
export default {
    post(obj) {
        return axios.post(obj.url, Qs.stringify(obj.params)).then(res => {
            if (res.data.data) {
                obj.fn(res.data.data)
            } else {
                obj.fn(res.data)
            }
            Indicator.close()
        }).catch(err => {
            return checkStatus(err)
        })
    },
    get(obj) {
        return axios.get(obj.url, {
            params: obj.params
        }).then(res => {
            if (res.data.data) {
                obj.fn(res.data.data)
            } else {
                obj.fn(res.data)
            }
            Indicator.close()
        }).catch(err => {
            return checkStatus(err)
        })
    },
    put(obj) {
        return axios.put(obj.url, {
            params: obj.params
        }).then(res => {
            if (res.data.data) {
                obj.fn(res.data.data)
            } else {
                obj.fn(res.data)
            }
            Indicator.close()
        }).catch(err => {
            return checkStatus(err)
        })
    },
    delete(obj) {
        return axios.delete(obj.url, {
            params: obj.params
        }).then(res => {
            if (res.data.data) {
                obj.fn(res.data.data)
            } else {
                obj.fn(res.data)
            }
            Indicator.close()
        }).catch(err => {
            return checkStatus(err)
        })
    },
}
