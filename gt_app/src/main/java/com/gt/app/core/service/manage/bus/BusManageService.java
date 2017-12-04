package com.gt.app.core.service.manage.bus;

import com.gt.app.core.bean.manage.res.AccountInfoRes;
import com.gt.app.core.bean.manage.res.IndustryRes;
import com.gt.axis.bean.wxmp.bus.BusUser;

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
}
