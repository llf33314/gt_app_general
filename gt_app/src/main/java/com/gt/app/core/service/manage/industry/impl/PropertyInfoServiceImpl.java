package com.gt.app.core.service.manage.industry.impl;

import com.gt.app.common.dto.ResponseDTO;
import com.gt.app.core.bean.manage.res.industryinfo.PropertyInfoRes;
import com.gt.app.core.service.manage.industry.IndustryInfoService;
import com.gt.axis.bean.wxmp.bus.BusUser;
import com.psr.tool.agile.AnalyticClass;

/**
 * 物业行业（揽胜家园）信息
 * @author psr
 * Created by psr on 2017/12/4 0004.
 */
public class PropertyInfoServiceImpl implements IndustryInfoService{

    /**
     * 根据行业Code，获取行业信息
     *
     * @param busUser
     * @return
     */
    @Override
    public ResponseDTO getIndustryInfoByCode(BusUser busUser) {
        AnalyticClass<PropertyInfoRes> analyticClass = new AnalyticClass<>();
        PropertyInfoRes propertyInfoRes = analyticClass.build(PropertyInfoRes.class);
        return ResponseDTO.createBySuccess("获取物业行业（揽胜家园）信息成功", propertyInfoRes);
    }
}
