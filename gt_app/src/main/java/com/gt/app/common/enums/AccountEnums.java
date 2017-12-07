package com.gt.app.common.enums;

/**
 * 账号类型
 * @author psr
 * Created by psr on 2017/12/7 0007.
 */
public enum AccountEnums {

    BOOS(1, "老板"),
    STAFF(0, "员工"),;

    private final Integer code;
    private final String desc;

    AccountEnums(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
