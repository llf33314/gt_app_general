package com.gt.app.core.service.manage.login;

import com.gt.api.bean.sign.SignBean;

/**
 * @author psr
 *         Created by psr on 2017/12/7 0007.
 */
public interface LoginService {
    /**
     * 获取登录签名
     *
     * @param loginName
     * @param password
     * @return
     */
    SignBean getSign(String loginName, String password);
}
