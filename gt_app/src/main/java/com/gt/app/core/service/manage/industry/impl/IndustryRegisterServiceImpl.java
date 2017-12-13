package com.gt.app.core.service.manage.industry.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gt.app.core.dao.manage.industry.IndustryRegisterDAO;
import com.gt.app.core.entity.manage.industry.IndustryRegister;
import com.gt.app.core.service.manage.industry.IndustryRegisterService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 行业注册表 服务实现类
 * </p>
 *
 * @author psr
 * @since 2017-12-13
 */
@Service
public class IndustryRegisterServiceImpl extends ServiceImpl<IndustryRegisterDAO, IndustryRegister> implements IndustryRegisterService {
    /**
     * 获取所有行业注册信息
     *
     * @return
     */
    @Override
    public List<IndustryRegister> selecAll() {
        EntityWrapper<IndustryRegister> entityWrapper = new EntityWrapper<>();
        return selectList(entityWrapper);
    }
}
