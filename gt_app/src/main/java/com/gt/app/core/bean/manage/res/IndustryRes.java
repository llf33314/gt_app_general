package com.gt.app.core.bean.manage.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author psr
 *         Created by psr on 2017/12/1 0001.
 */
@ApiModel(value = "行业列表")
public class IndustryRes {

    @ApiModelProperty(value = "行业名称")
    private String name; // 行业名称

    @ApiModelProperty(value = "行业代码")
    private String code; // 行业代码

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
