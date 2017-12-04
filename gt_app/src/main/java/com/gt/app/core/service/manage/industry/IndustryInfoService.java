package com.gt.app.core.service.manage.industry;

import com.gt.app.common.dto.ResponseDTO;
import com.gt.axis.bean.wxmp.bus.BusUser;

/**
 * 行业信息接口
 * @author psr
 * Created by psr on 2017/12/4 0004.
 */
public interface IndustryInfoService {

    /**
     * 根据行业Code，获取行业信息
     * @param busUser
     * @return
     */
    ResponseDTO getIndustryInfoByCode(BusUser busUser);

}
