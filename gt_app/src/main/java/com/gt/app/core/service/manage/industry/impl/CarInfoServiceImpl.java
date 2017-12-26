package com.gt.app.core.service.manage.industry.impl;

import com.gt.app.common.dto.ResponseDTO;
import com.gt.app.core.bean.manage.res.industryinfo.CarInfoRes;
import com.gt.app.core.service.manage.industry.IndustryInfoService;
import com.gt.axis.bean.wxmp.bus.BusUser;
import com.psr.tool.agile.AnalyticClass;
import org.springframework.stereotype.Service;

/**
 * 汽车行业（车小算）信息
 * @author psr
 * Created by psr on 2017/12/4 0004.
 */
@Service("carInfoServiceImpl")
public class CarInfoServiceImpl implements IndustryInfoService {

    /**
     * 根据行业Code，获取行业信息
     *
     * @param busUser
     * @return
     */
    @Override
    public ResponseDTO getIndustryInfoByCode(BusUser busUser) {
        AnalyticClass<CarInfoRes> analyticClass = new AnalyticClass<>();
        CarInfoRes carInfoRes = analyticClass.build(CarInfoRes.class);
        return ResponseDTO.createBySuccess("获取汽车行业（车小算）信息成功", carInfoRes);
    }
}
