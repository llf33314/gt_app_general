package com.gt.app.core.bean.manage.res.industryinfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 物业行业
 * @author psr
 * Created by psr on 2017/12/4 0004.
 */
@ApiModel(value = "物业行业（揽胜家园）信息")
public class PropertyInfoRes {

    @ApiModelProperty(value = "本月应收")
    private Double monthReceivable; // 本月应收款

    @ApiModelProperty(value = "本月实收")
    private Double monthReceipts; // 本月实收账款

    @ApiModelProperty(value = "本月新入住")
    private Integer monthNewCheck; // 本月新入住

    public Double getMonthReceivable() {
        return monthReceivable;
    }

    public void setMonthReceivable(Double monthReceivable) {
        this.monthReceivable = monthReceivable;
    }

    public Double getMonthReceipts() {
        return monthReceipts;
    }

    public void setMonthReceipts(Double monthReceipts) {
        this.monthReceipts = monthReceipts;
    }

    public Integer getMonthNewCheck() {
        return monthNewCheck;
    }

    public void setMonthNewCheck(Integer monthNewCheck) {
        this.monthNewCheck = monthNewCheck;
    }
}
