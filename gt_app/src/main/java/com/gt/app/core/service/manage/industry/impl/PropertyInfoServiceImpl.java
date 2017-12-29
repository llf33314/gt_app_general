package com.gt.app.core.service.manage.industry.impl;

import com.alibaba.fastjson.JSON;
import com.gt.api.exception.SignException;
import com.gt.api.util.sign.SignHttpUtils;
import com.gt.app.common.dto.ResponseDTO;
import com.gt.app.core.bean.manage.res.industryinfo.PropertyInfoRes;
import com.gt.app.core.service.manage.industry.IndustryInfoService;
import com.gt.app.core.util.CommonUtil;
import com.gt.axis.bean.wxmp.bus.BusUser;
import com.gt.axis.content.AxisContent;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * 物业行业（揽胜家园）信息
 *
 * @author psr
 *         Created by psr on 2017/12/4 0004.
 */
@Service("propertyInfoServiceImpl")
public class PropertyInfoServiceImpl implements IndustryInfoService {

    private static final Logger logger = Logger.getLogger(PropertyInfoServiceImpl.class);

    @Value("${gt.app.propertyUrl}")
    private String propertyUrl;

    @Autowired
    RestTemplate restTemplate;

    /**
     * 根据行业Code，获取行业信息
     *
     * @param busUser
     * @return
     */
    @Override
    public ResponseDTO getIndustryInfoByCode(BusUser busUser) {
        String url = propertyUrl + "/propertyStaff/propertyCountData.do";
        logger.debug(url);
        Integer busId = busUser.getId();
        logger.debug(busId);
        Map<String, Object> resultMap;
        try {
            Map<String, Object> postMap = new HashMap<>();
            postMap.put("busId", busId);
            String resutl = SignHttpUtils.WxmppostByHttp(url, postMap, AxisContent.getInstance().getWxmpSignKey());
            logger.debug(resutl);
            resultMap = JSON.parseObject(resutl, Map.class);
        } catch (SignException e) {
            return ResponseDTO.createByError();
        }
        if ((Integer) resultMap.get("code") != 0 || resultMap.get("data") == null) {
            return ResponseDTO.createByErrorMessage((String) resultMap.get("message"));
        }
        Map<String, Object> dataMap = (Map<String, Object>) resultMap.get("data");
        PropertyInfoRes propertyInfoRes = new PropertyInfoRes();
        if (CommonUtil.isNotEmpty(dataMap.get("Ingoing"))) {
            Object inGoing = dataMap.get("Ingoing");
            propertyInfoRes.setMonthNewCheck(Integer.valueOf(inGoing.toString())); // 新入住
        }
        if (CommonUtil.isNotEmpty(dataMap.get("realityMoney"))) {
            Object realityMoney = dataMap.get("realityMoney");
            propertyInfoRes.setMonthReceipts(Double.valueOf(realityMoney.toString())); // 实收
        }
        if (CommonUtil.isNotEmpty(dataMap.get("receivable"))) {
            Object receivable = dataMap.get("receivable");
            propertyInfoRes.setMonthReceivable(Double.valueOf(receivable.toString())); // 应收
        }
        propertyInfoRes.setInfoUrl((String) dataMap.get("returnUrl")); // 详情链接
        return ResponseDTO.createBySuccess("获取物业行业（揽胜家园）信息成功", propertyInfoRes);
    }
}
