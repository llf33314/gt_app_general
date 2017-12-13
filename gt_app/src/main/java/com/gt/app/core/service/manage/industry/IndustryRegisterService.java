package com.gt.app.core.service.manage.industry;

import com.baomidou.mybatisplus.service.IService;
import com.gt.app.core.entity.manage.industry.IndustryRegister;

import java.util.List;

/**
 * <p>
 * 行业注册表 服务类
 * </p>
 *
 * @author psr
 * @since 2017-12-13
 */
public interface IndustryRegisterService extends IService<IndustryRegister> {
    /**
     * 获取所有行业注册信息
     *
     * @return
     */
    List<IndustryRegister> selecAll();
}
