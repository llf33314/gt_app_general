package com.gt.app.core.bean.manage.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 登录账号信息
 * @author psr
 * Created by psr on 2017/12/1 0001.
 */
@ApiModel(value = "登录账号信息")
public class LoginAccountRes {

    @ApiModelProperty(value = "账号类型（0：员工，1：老板）")
    private Integer accountType; // 账号类型（0：员工，1：老板）

    @ApiModelProperty(value = "首页链接")
    private String homeUrl; // 首页链接

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public String getHomeUrl() {
        return homeUrl;
    }

    public void setHomeUrl(String homeUrl) {
        this.homeUrl = homeUrl;
    }
}
