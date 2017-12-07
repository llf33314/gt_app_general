package com.gt.app.core.service.manage.login.impl;

import com.alibaba.fastjson.JSONObject;
import com.gt.api.bean.sign.SignBean;
import com.gt.api.util.sign.SignUtils;
import com.gt.app.core.service.manage.login.LoginService;
import com.gt.axis.content.AxisProperties;
import org.apache.commons.collections.map.LinkedMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author psr
 *         Created by psr on 2017/12/7 0007.
 */
@Service
public class LoginServiceImpl implements LoginService {

    private static Logger logger = Logger.getLogger(LoginServiceImpl.class);

    @Autowired
    AxisProperties axisProperties;

    /**
     * 获取登录签名
     *
     * @param loginName
     * @param password
     * @return
     */
    @Override
    public SignBean getSign(String loginName, String password) {
        Map<String, Object> paramMap = new LinkedMap();
        paramMap.put("login_name", loginName);
        paramMap.put("password", password);
        logger.debug(axisProperties.getWxmpSignKey());
        return SignUtils.sign(axisProperties.getWxmpSignKey(), JSONObject.toJSONString(paramMap));
    }
}
