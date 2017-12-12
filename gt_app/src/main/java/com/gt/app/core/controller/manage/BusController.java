package com.gt.app.core.controller.manage;

import com.gt.api.bean.session.TCommonStaff;
import com.gt.app.common.base.BaseController;
import com.gt.app.common.dto.ResponseDTO;
import com.gt.app.common.enums.AccountEnums;
import com.gt.app.common.enums.ResponseEnums;
import com.gt.app.core.bean.manage.res.AccountInfoRes;
import com.gt.app.core.bean.manage.res.AccountInfoStaffRes;
import com.gt.app.core.bean.manage.res.IndustryRes;
import com.gt.app.core.bean.manage.res.LoginAccountRes;
import com.gt.app.core.bean.manage.res.industryinfo.CarInfoRes;
import com.gt.app.core.bean.manage.res.industryinfo.PropertyInfoRes;
import com.gt.app.core.exception.manage.BusException;
import com.gt.app.core.exception.manage.IndustryException;
import com.gt.app.core.service.manage.bus.BusManageService;
import com.gt.app.core.service.manage.industry.IndustryInfoFactory;
import com.gt.app.core.util.CommonUtil;
import com.gt.axis.bean.wxmp.bus.BusUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 商家信息-包含概况和行业选择
 *
 * @author psr
 *         Created by psr on 2017/12/1 0001.
 */
@Api(value = "/app/manage/bus", description = "商家信息")
@RestController
@RequestMapping(value = "/app/manage/bus")
public class BusController extends BaseController {

    private static Logger logger = Logger.getLogger(BusController.class);

    @Autowired
    BusManageService busManageService;

    // 获取账号信息
    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
            @ApiResponse(code = 1, message = "data对象", response = LoginAccountRes.class),
    })
    @ApiOperation(value = "获取登录账号信息（APP使用）", notes = "获取登录账号信息（APP使用）")
    @RequestMapping(value = "/getLoginAccount", method = RequestMethod.POST)
    public ResponseDTO getLoginAccount(HttpServletRequest request) {
        try {
            LoginAccountRes loginAccountRes = busManageService.getLoginAccount(request);
            return ResponseDTO.createBySuccess("获取登录账号信息成功", loginAccountRes);
        } catch (BusException e) {
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    // 获取账号信息
    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
            @ApiResponse(code = 1, message = "data对象（老板）", response = AccountInfoRes.class),
            @ApiResponse(code = 2, message = "data对象（员工）", response = AccountInfoStaffRes.class),
    })
    @ApiOperation(value = "获取账号信息", notes = "获取账号信息")
    @RequestMapping(value = "/getAccountInfo", method = RequestMethod.POST)
    public ResponseDTO getAccountInfo(HttpServletRequest request) {
        try {
            Integer loginStyle = CommonUtil.getLoginAccount(request);
            if (CommonUtil.isEmpty(loginStyle)) {
                throw new BusException(ResponseEnums.SESSION_ACCOUNT_NULL);
            }
            if (AccountEnums.STAFF.getCode().equals(loginStyle)) {
                TCommonStaff tCommonStaff = CommonUtil.getLoginStaff(request);
                AccountInfoStaffRes accountInfoStaffRes = busManageService.getAccountInfo(tCommonStaff);
                return ResponseDTO.createBySuccess("获取账号信息成功", accountInfoStaffRes);
            }
            BusUser busUser = CommonUtil.getLoginUser(request);
            AccountInfoRes accountInfoRes = busManageService.getAccountInfo(busUser);
            return ResponseDTO.createBySuccess("获取账号信息成功", accountInfoRes);
        } catch (BusException e) {
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    // 获取账号可展示行业列表
    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
            @ApiResponse(code = 1, message = "data对象（数组对象）", response = List.class),
            @ApiResponse(code = 2, message = "数组对象", response = IndustryRes.class),
    })
    @ApiOperation(value = "获取账号对应的行业列表", notes = "获取账号对应的行业列表")
    @RequestMapping(value = "/listIndustry", method = RequestMethod.POST)
    public ResponseDTO listIndustry(HttpServletRequest request) {
        try {
            Integer loginStyle = CommonUtil.getLoginAccount(request);
            if (CommonUtil.isEmpty(loginStyle)) {
                throw new BusException(ResponseEnums.SESSION_ACCOUNT_NULL);
            }
            Integer userId = -1;
            if (AccountEnums.STAFF.getCode().equals(loginStyle)) {
                TCommonStaff tCommonStaff = CommonUtil.getLoginStaff(request);
                userId = tCommonStaff.getId();
            } else if (AccountEnums.BOOS.getCode().equals(loginStyle)) {
                BusUser busUser = CommonUtil.getLoginUser(request);
                userId = busUser.getId();
            }
            List<IndustryRes> industryResList = busManageService.listIndustry(loginStyle, userId);
            return ResponseDTO.createBySuccess("获取账号对应的行业列表成功", industryResList);
        } catch (BusException e) {
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    // 获取账号行业信息详情
    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象（code对应行业code）", response = ResponseDTO.class),
            @ApiResponse(code = 2, message = "data对象（车小算）", response = CarInfoRes.class),
            @ApiResponse(code = 5, message = "data对象（揽胜家园）", response = PropertyInfoRes.class),
    })
    @ApiOperation(value = "根据行业code获取各行业信息", notes = "根据行业code获取各行业信息")
    @RequestMapping(value = "/getIndustryInfo/{industryCode}", method = RequestMethod.POST)
    public ResponseDTO getIndustryInfo(@PathVariable String industryCode, HttpServletRequest request) {
        try {
            BusUser busUser = CommonUtil.getLoginUser(request);
            ResponseDTO responseDTO = IndustryInfoFactory.getInstance().getService(industryCode).getIndustryInfoByCode(busUser);
            return responseDTO;
        } catch (IndustryException e) {
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

}
