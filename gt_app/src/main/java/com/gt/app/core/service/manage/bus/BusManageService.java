package com.gt.app.core.service.manage.bus;

import com.gt.app.core.bean.manage.res.AccountInfoRes;
import com.gt.app.core.bean.manage.res.IndustryRes;
import com.gt.app.core.bean.manage.res.LoginAccountRes;
import com.gt.axis.bean.wxmp.bus.BusUser;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 商家服务
 *
 * @author psr
 *         Created by psr on 2017/12/1 0001.
 */
public interface BusManageService {

    /**
     * 获取账号信息
     *
     * @param busUser
     * @return
     */
    AccountInfoRes getAccountInfo(BusUser busUser) throws Exception;

    /**
     * 获取账号对应的行业列表
     *
     * @param busUser
     * @return
     */
    List<IndustryRes> listIndustry(BusUser busUser) throws Exception;

    /**
     * 获取登录账号信息
     * @param request
     * @return
     */
    LoginAccountRes getLoginAccount(HttpServletRequest request);
}
