package com.gt.app.common.config;

import com.gt.app.common.enums.IndustryEnums;
import com.gt.app.core.service.manage.industry.IndustryInfoFactory;
import com.gt.app.core.service.manage.industry.IndustryInfoService;
import com.gt.app.core.service.manage.industry.impl.CarInfoServiceImpl;
import com.gt.app.core.service.manage.industry.impl.PropertyInfoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 工厂模式配置文件
 * @author psr
 * Created by psr on 2017/12/4 0004.
 */
@Configuration
public class FactoryConfig {

    /**
     * 行业信息工厂
     * 1：小馋猫
     * 2：车小算
     * 3：样子
     * 4：未知
     * 5：揽胜家园
     * 6：小红十
     * 7：翼店
     * 8：敏库
     * 9：客来驿
     * 10：翼店（重复）
     * 11：小盼
     */
    @Bean
    public Map<String, IndustryInfoService> industryInfoFactoryBean(){
        Map<String, IndustryInfoService> serviceMap = new HashMap<>();
        serviceMap.put(IndustryEnums.CAR.getCode(), new CarInfoServiceImpl());
        serviceMap.put(IndustryEnums.PROPERTY.getCode(), new PropertyInfoServiceImpl());
        IndustryInfoFactory.setServiceMap(serviceMap);
        return serviceMap;
    }

}
