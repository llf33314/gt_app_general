package com.gt.app.core.service.manage.industry.impl;

import com.gt.app.common.dto.ResponseDTO;
import com.gt.app.core.bean.manage.res.industryinfo.PropertyInfoRes;
import com.gt.app.core.service.manage.industry.IndustryInfoService;
import com.gt.axis.bean.wxmp.bus.BusUser;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
        Map<String, Object> resultMap = restTemplate.postForObject(url, null, Map.class);
        logger.debug(resultMap);
        if ((Integer) resultMap.get("code") != 0 || resultMap.get("data") == null) {
            return ResponseDTO.createByErrorMessage((String) resultMap.get("message"));
        }
        Map<String, Object> dataMap = (Map<String, Object>) resultMap.get("data");
        PropertyInfoRes propertyInfoRes = new PropertyInfoRes();
        propertyInfoRes.setMonthNewCheck((Integer) dataMap.get("Ingoing")); // 新入住
        propertyInfoRes.setMonthReceipts((Double) dataMap.get("realityMoney")); // 实收
        propertyInfoRes.setMonthReceivable((Double) dataMap.get("receivable")); // 应收
        propertyInfoRes.setInfoUrl((String) dataMap.get("returnUrl")); // 详情链接
        return ResponseDTO.createBySuccess("获取物业行业（揽胜家园）信息成功", propertyInfoRes);
    }
}
