package com.gt.app.core.bean.manage.res.industryinfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 汽车行业
 * @author psr
 * Created by psr on 2017/12/4 0004.
 */
@ApiModel(value = "汽车行业（车小算）信息")
public class CarInfoRes {

    @ApiModelProperty(value = "今日预约")
    private Integer todayAppointment; // 今日预约

    @ApiModelProperty(value = "7日内已开订单")
    private Integer openOrder7Day; // 7日内已开订单

    @ApiModelProperty(value = "今日提醒")
    private Integer todayRemind; // 今日提醒

    @ApiModelProperty(value = "今日营收")
    private Double todayRevenue; // 今日营收

    @ApiModelProperty(value = "新增会员")
    private Integer newMembers7Day; // 新增会员

    @ApiModelProperty(value = "新增车主")
    private Integer newCarOwner7Day; // 新增车主

    public Integer getTodayAppointment() {
        return todayAppointment;
    }

    public void setTodayAppointment(Integer todayAppointment) {
        this.todayAppointment = todayAppointment;
    }

    public Integer getOpenOrder7Day() {
        return openOrder7Day;
    }

    public void setOpenOrder7Day(Integer openOrder7Day) {
        this.openOrder7Day = openOrder7Day;
    }

    public Integer getTodayRemind() {
        return todayRemind;
    }

    public void setTodayRemind(Integer todayRemind) {
        this.todayRemind = todayRemind;
    }

    public Double getTodayRevenue() {
        return todayRevenue;
    }

    public void setTodayRevenue(Double todayRevenue) {
        this.todayRevenue = todayRevenue;
    }

    public Integer getNewMembers7Day() {
        return newMembers7Day;
    }

    public void setNewMembers7Day(Integer newMembers7Day) {
        this.newMembers7Day = newMembers7Day;
    }

    public Integer getNewCarOwner7Day() {
        return newCarOwner7Day;
    }

    public void setNewCarOwner7Day(Integer newCarOwner7Day) {
        this.newCarOwner7Day = newCarOwner7Day;
    }
}
