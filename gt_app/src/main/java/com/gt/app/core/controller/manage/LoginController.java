package com.gt.app.core.controller.manage;

import com.gt.api.bean.sign.SignBean;
import com.gt.app.common.base.BaseController;
import com.gt.app.common.dto.ResponseDTO;
import com.gt.app.core.exception.manage.LoginException;
import com.gt.app.core.service.manage.login.LoginService;
import io.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 店员老板端APP登录
 *
 * @author psr
 *         Created by psr on 2017/12/7 0007.
 */
@Api(value = "/m/manage/login", description = "登录接口")
@RestController
@RequestMapping(value = "/m/manage/login")
public class LoginController extends BaseController {

    private static Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    LoginService loginService;

    // 获取登录签名
    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
            @ApiResponse(code = 1, message = "data对象", response = SignBean.class),
    })
    @ApiOperation(value = "获取登录签名", notes = "获取登录签名")
    @RequestMapping(value = "/getSign", method = RequestMethod.POST)
    public ResponseDTO getSign(@RequestParam @ApiParam("登录名") String loginName, @RequestParam @ApiParam("密码") String password, HttpServletRequest request) {
        try {
            SignBean signBean = loginService.getSign(loginName, password);
            return ResponseDTO.createBySuccess("获取登录签名成功", signBean);
        } catch (LoginException e) {
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

}
