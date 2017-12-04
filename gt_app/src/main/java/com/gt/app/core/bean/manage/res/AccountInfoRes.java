package com.gt.app.core.bean.manage.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 账号信息
 * @author psr
 * Created by psr on 2017/12/1 0001.
 */
@ApiModel(value = "账号信息")
public class AccountInfoRes {

    @ApiModelProperty(value = "账号名")
    private String name; // 账号名

    @ApiModelProperty(value = "账号版本code")
    private String versionCode; // 账号版本code

    @ApiModelProperty(value = "账号版本")
    private String version; // 账号版本

    @ApiModelProperty(value = "到期天数")
    private Integer expireDay; // 到期天数

    @ApiModelProperty(value = "到期时间")
    private Date expireDate; // 到期时间

    @ApiModelProperty(value = "粉币数量")
    private Double fanbiNum; // 粉币数量

    @ApiModelProperty(value = "短信数量")
    private Integer smsNum; // 短信数量

    @ApiModelProperty(value = "流量包数量")
    private Integer flowNum; // 流量包数量

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getExpireDay() {
        return expireDay;
    }

    public void setExpireDay(Integer expireDay) {
        this.expireDay = expireDay;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Double getFanbiNum() {
        return fanbiNum;
    }

    public void setFanbiNum(Double fanbiNum) {
        this.fanbiNum = fanbiNum;
    }

    public Integer getSmsNum() {
        return smsNum;
    }

    public void setSmsNum(Integer smsNum) {
        this.smsNum = smsNum;
    }

    public Integer getFlowNum() {
        return flowNum;
    }

    public void setFlowNum(Integer flowNum) {
        this.flowNum = flowNum;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }
}
