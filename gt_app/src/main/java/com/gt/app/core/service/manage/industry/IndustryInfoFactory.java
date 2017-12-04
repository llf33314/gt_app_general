package com.gt.app.core.service.manage.industry;

import com.gt.app.common.enums.ResponseEnums;
import com.gt.app.core.exception.manage.IndustryException;
import com.gt.app.core.util.CommonUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 行业信息工厂类
 *
 * @author psr
 *         Created by psr on 2017/12/4 0004.
 */
public class IndustryInfoFactory {

    /**
     * 对应接口实现类集合
     */
    private static Map<String, IndustryInfoService> serviceMap = new HashMap<>();

    /**
     * 工厂实例
     */
    private static IndustryInfoFactory industryInfoFactory = null;

    private IndustryInfoFactory() {

    }

    /**
     * 单例模式
     *
     * @return
     */
    public static IndustryInfoFactory getInstance() {
        if (industryInfoFactory == null) {
            create();
        }
        return industryInfoFactory;
    }

    private static synchronized void create() {
        if (industryInfoFactory == null) {
            industryInfoFactory = new IndustryInfoFactory();
        }
    }

    /**
     * 获取对应实现类
     *
     * @param key
     * @return
     * @exception Exception
     */
    public IndustryInfoService getService(String key) throws Exception {
        if (CommonUtil.isEmpty(key)) {
            throw new IndustryException(ResponseEnums.PARAM_NULL);
        }
        return serviceMap.get(key);
    }

    public static Map<String, IndustryInfoService> getServiceMap() {
        return serviceMap;
    }

    public static void setServiceMap(Map<String, IndustryInfoService> serviceMap) {
        IndustryInfoFactory.serviceMap = serviceMap;
    }
}
