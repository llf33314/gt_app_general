package com.gt.app.core.service.manage.bus.impl;

import com.gt.app.core.bean.manage.res.AccountInfoRes;
import com.gt.app.core.bean.manage.res.IndustryRes;
import com.gt.app.core.service.manage.bus.BusManageService;
import com.gt.app.core.util.DateTimeKit;
import com.gt.axis.bean.wxmp.bus.BusUser;
import com.gt.axis.bean.wxmp.dict.DictApiReq;
import com.gt.axis.bean.wxmp.dict.DictApiRes;
import com.gt.axis.bean.wxmp.erp.ErpApiReq;
import com.gt.axis.bean.wxmp.erp.MenusLevelList;
import com.gt.axis.bean.wxmp.fenbiflow.BusFlowRes;
import com.gt.axis.server.wxmp.DictServer;
import com.gt.axis.server.wxmp.ErpServer;
import com.gt.axis.server.wxmp.FenbiflowServer;
import org.springframework.stereotype.Service;

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

    private static final String versionDict = "1004";

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
        for (DictApiRes dictApiRes : dictApiResList){
            if (dictApiRes.getItemKey().equals(versionCode)){
                accountInfoRes.setVersion(dictApiRes.getItemValue());
            }
        }
        // 获取流量
        List<BusFlowRes> busFlowResList = FenbiflowServer.getBusFlowsByUserId(busUser.getId()).getData();
        int flowNum = 0;
        for (BusFlowRes busFlowRes : busFlowResList){
            flowNum += busFlowRes.getCount();
        }
        accountInfoRes.setFlowNum(flowNum);
        return accountInfoRes;
    }

    /**
     * 获取账号对应的行业列表
     *
     * @param busUser
     * @return
     */
    @Override
    public List<IndustryRes> listIndustry(BusUser busUser) throws Exception {
        ErpApiReq erpApiReq = new ErpApiReq();
        erpApiReq.setLoginStyle(1);
        erpApiReq.setUserId(busUser.getId());
        List<MenusLevelList> menusLevelLists = ErpServer.getErpListApi(erpApiReq).getData();
        List<IndustryRes> industryResList = new ArrayList<>();
        for (MenusLevelList menusLevelList : menusLevelLists){
            IndustryRes industryRes = new IndustryRes();
            industryRes.setCode(menusLevelList.getErpmodel());
            industryRes.setName(menusLevelList.getErpname());
            industryResList.add(industryRes);
        }
        return industryResList;
    }
}
