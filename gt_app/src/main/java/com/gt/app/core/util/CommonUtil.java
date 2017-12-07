package com.gt.app.core.util;


import com.gt.api.bean.session.TCommonStaff;
import com.gt.api.util.SessionUtils;
import com.gt.app.common.enums.AccountEnums;
import com.gt.app.common.enums.ResponseEnums;
import com.gt.app.common.exception.SystemException;
import com.gt.axis.bean.wxmp.bus.BusUser;
import com.gt.axis.bean.wxmp.bus.BusUserApiReq;
import com.gt.axis.server.wxmp.BusServer;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * 获取登录用户信息
 *
 * @author Administrator
 */
public class CommonUtil {
    private static final Logger log = Logger.getLogger(CommonUtil.class);

    /**
     * 获取session中的登录的bus用户
     *
     * @param request
     * @return
     */
    public static BusUser getLoginUser(HttpServletRequest request) {
        try {
            com.gt.api.bean.session.BusUser apiBusUser = SessionUtils.getLoginUser(request);
            BusUserApiReq busUserApiReq = new BusUserApiReq();
//            busUserApiReq.setUserId(apiBusUser.getId());
            busUserApiReq.setUserId(36);
            return BusServer.getBusUserApi(busUserApiReq).getData();
        } catch (Exception e) {
            log.info(e.getLocalizedMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取session中的登录的员工账号
     *
     * @param request
     * @return
     */
    public static TCommonStaff getLoginStaff(HttpServletRequest request) {
        try {
            TCommonStaff tCommonStaff = SessionUtils.getCommonStaff(request);
            return tCommonStaff;
        } catch (Exception e) {
            log.info(e.getLocalizedMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取session中的登录的账号类型
     *
     * @param request
     * @return
     */
    public static Integer getLoginAccount(HttpServletRequest request) {
        try {
            Integer loginStyle = SessionUtils.getLoginStyle(request);
//            return loginStyle;
            return 1;
        } catch (Exception e) {
            log.info(e.getLocalizedMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据busId查询bus信息
     *
     * @param busId
     * @return
     */
    public static BusUser getBusUserById(Integer busId) throws Exception {
        BusUserApiReq busUserApiReq = new BusUserApiReq();
        // 查询busId
        busUserApiReq.setUserId(busId);
        BusUser busUser = BusServer.getBusUserApi(busUserApiReq).getData();
        if (CommonUtil.isEmpty(busId)) {
            throw new SystemException(ResponseEnums.BUS_NULL.getCode(), ResponseEnums.BUS_NULL.getDesc());
        }
        return busUser;
    }

    /**
     * 判断对象是否为空
     *
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        boolean b = false;
        try {
            if (obj == null || "".equals(obj)) {
                b = true;
            } else {
                b = false;
            }
        } catch (Exception e) {
            b = false;
            e.printStackTrace();
        }
        return b;
    }

    /**
     * 判断对象是否不为空
     *
     * @param obj
     * @return
     */
    public static boolean isNotEmpty(Object obj) {
        boolean b = false;
        try {
            if (obj == null || "".equals(obj)) {
                b = false;
            } else {
                b = true;
            }
        } catch (Exception e) {
            b = false;
            e.printStackTrace();
        }
        return b;
    }

    /**
     * 转Integer
     *
     * @param obj
     */
    public static Integer toInteger(Object obj) {
        try {
            if (!isEmpty(obj)) {
                return Integer.parseInt(obj.toString());
            } else {
                throw new Exception("对象为空，转换失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 转string
     *
     * @param obj
     * @return
     */
    public static String Blob2String(Object obj) {
        String string = null;
        try {
            if (obj == null || "".equals(obj)) {
                return "";
            }
            byte[] bytes = (byte[]) obj;
            string = new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return string;
    }
}
