package com.gt.app.core.bean.manage.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 账号信息
 *
 * @author psr
 *         Created by psr on 2017/12/1 0001.
 */
@ApiModel(value = "员工账号信息")
public class AccountInfoStaffRes {

    @ApiModelProperty(value = "员工名")
    private String name; // 员工名

    @ApiModelProperty(value = "部门名称")
    private String branchName; // 部门名称

    @ApiModelProperty(value = "职位名称")
    private String posName; // 职位名称

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }
}
