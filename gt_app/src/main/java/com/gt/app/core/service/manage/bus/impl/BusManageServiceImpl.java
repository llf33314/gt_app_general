package com.gt.app.core.service.manage.bus.impl;

import com.gt.api.bean.session.TCommonStaff;
import com.gt.app.common.enums.AccountEnums;
import com.gt.app.common.enums.ResponseEnums;
import com.gt.app.core.bean.manage.res.AccountInfoRes;
import com.gt.app.core.bean.manage.res.AccountInfoStaffRes;
import com.gt.app.core.bean.manage.res.IndustryRes;
import com.gt.app.core.bean.manage.res.LoginAccountRes;
import com.gt.app.core.entity.manage.industry.IndustryRegister;
import com.gt.app.core.exception.manage.BusException;
import com.gt.app.core.service.manage.bus.BusManageService;
import com.gt.app.core.service.manage.industry.IndustryRegisterService;
import com.gt.app.core.util.CommonUtil;
import com.gt.app.core.util.DateTimeKit;
import com.gt.axis.bean.wxmp.bus.BusUser;
import com.gt.axis.bean.wxmp.dict.DictApiReq;
import com.gt.axis.bean.wxmp.dict.DictApiRes;
import com.gt.axis.bean.wxmp.erp.ErpApiReq;
import com.gt.axis.bean.wxmp.erp.ErpBraPosReq;
import com.gt.axis.bean.wxmp.erp.ErpBraPosRes;
import com.gt.axis.bean.wxmp.erp.MenusLevelList;
import com.gt.axis.bean.wxmp.fenbiflow.BusFlowRes;
import com.gt.axis.server.wxmp.DictServer;
import com.gt.axis.server.wxmp.ErpServer;
import com.gt.axis.server.wxmp.FenbiflowServer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 商家服务
 *
 * @author psr
 *         Created by psr on 2017/12/1 0001.
 */
@Service
public class BusManageServiceImpl implements BusManageService {

    private static final Logger logger = Logger.getLogger(BusManageServiceImpl.class);

    @Autowired
    IndustryRegisterService industryRegisterService;

    @Value("${gt.app.homeUrl}")
    private String homeUrl;

    /**
     * 版本字典
     */
    private static final String versionDict = "1004";

    /**
     * 获取登录账号信息
     *
     * @param request
     * @return
     */
    @Override
    public LoginAccountRes getLoginAccount(HttpServletRequest request) {
        LoginAccountRes loginAccountRes = new LoginAccountRes();
        Integer loginStyle = CommonUtil.getLoginAccount(request);
        if (CommonUtil.isEmpty(loginStyle)) {
            throw new BusException(ResponseEnums.SESSION_ACCOUNT_NULL);
        }
        loginAccountRes.setAccountType(loginStyle);
        loginAccountRes.setHomeUrl(null);
        if (AccountEnums.BOOS.getCode().equals(loginStyle)) {
            logger.debug(homeUrl);
            loginAccountRes.setHomeUrl(homeUrl);
        }
        return loginAccountRes;
    }

    /**
     * 获取账号信息
     *
     * @param busUser
     * @return
     */
    @Override
    public AccountInfoRes getAccountInfo(BusUser busUser) throws Exception {
        AccountInfoRes accountInfoRes = new AccountInfoRes();
        accountInfoRes.setName(busUser.getName());
        accountInfoRes.setFanbiNum(busUser.getFansCurrency() == null ? 0 : busUser.getFansCurrency().doubleValue());
        accountInfoRes.setSmsNum(busUser.getSmsCount() == null ? 0 : busUser.getSmsCount());
        // 过期信息
        accountInfoRes.setExpireDate(busUser.getEndTime());
        Integer expireDay = (int) DateTimeKit.diffDaysAddOne(busUser.getEndTime(), new Date());
        accountInfoRes.setExpireDay(expireDay);
        // 版本信息
        String versionCode = String.valueOf(busUser.getLevel());
        accountInfoRes.setVersionCode(versionCode);
        DictApiReq dictApiReq = new DictApiReq();
        dictApiReq.setStyle(versionDict);
        List<DictApiRes> dictApiResList = DictServer.getDictApi(dictApiReq).getData();
        for (DictApiRes dictApiRes : dictApiResList) {
            if (dictApiRes.getItemKey().equals(versionCode)) {
                accountInfoRes.setVersion(dictApiRes.getItemValue());
            }
        }
        // 获取流量
        List<BusFlowRes> busFlowResList = FenbiflowServer.getBusFlowsByUserId(busUser.getId()).getData();
        int flowNum = 0;
        for (BusFlowRes busFlowRes : busFlowResList) {
            flowNum += busFlowRes.getCount();
        }
        accountInfoRes.setFlowNum(flowNum);
        return accountInfoRes;
    }

    /**
     * 获取账号信息（员工）
     *
     * @param tCommonStaff
     * @return
     */
    @Override
    public AccountInfoStaffRes getAccountInfo(TCommonStaff tCommonStaff) throws Exception {
        ErpBraPosReq erpBraPosReq = new ErpBraPosReq();
        erpBraPosReq.setUserId(tCommonStaff.getId());
        ErpBraPosRes erpBraPosRes = ErpServer.getBraPos(erpBraPosReq).getData();
        AccountInfoStaffRes accountInfoStaffRes = new AccountInfoStaffRes();
        accountInfoStaffRes.setName(tCommonStaff.getName());
        accountInfoStaffRes.setBranchName(erpBraPosRes.getBranchName());
        accountInfoStaffRes.setPosName(erpBraPosRes.getPosName());
        return accountInfoStaffRes;
    }

    /**
     * 获取账号对应的行业列表
     *
     * @param loginStyle 员工或者主账号
     * @param userId     用户id
     * @return
     */
    @Override
    public List<IndustryRes> listIndustry(Integer loginStyle, Integer userId) throws Exception {
        if (userId < 0) {
            throw new BusException(ResponseEnums.DATA_ERROR);
        }
        ErpApiReq erpApiReq = new ErpApiReq();
        erpApiReq.setLoginStyle(loginStyle);
        erpApiReq.setUserId(userId);
        List<MenusLevelList> menusLevelLists = ErpServer.getErpListApi(erpApiReq).getData();
        List<IndustryRes> industryResList = new ArrayList<>();
        List<IndustryRegister> industryRegisterList = industryRegisterService.selecAll();
        for (MenusLevelList menusLevelList : menusLevelLists) {
            IndustryRes industryRes = new IndustryRes();
            industryRes.setCode(menusLevelList.getErpmodel());
            industryRes.setName(menusLevelList.getErpname());
            industryRes.setStatus(0);
            industryRes.setUrl("#");
            for (IndustryRegister industryRegister : industryRegisterList) {
                if (industryRegister.getIndustryCode().equals(industryRes.getCode())) {
                    industryRes.setName(industryRegister.getIndustryName());
                    industryRes.setStatus(industryRegister.getIndustryStatus());
                    industryRes.setUrl(industryRegister.getIndustryUrl());
                }
            }
            industryResList.add(industryRes);
        }
        return industryResList;
    }
}
