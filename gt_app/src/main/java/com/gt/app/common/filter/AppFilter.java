package com.gt.app.common.filter;

import com.alibaba.fastjson.JSONObject;
import com.gt.app.common.dto.ResponseDTO;
import com.gt.app.common.enums.ResponseEnums;
import com.gt.app.core.util.CommonUtil;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 项目过滤器
 * Created by psr on 2017/9/13 0013.
 */
public class AppFilter implements Filter {

    private static Logger logger = Logger.getLogger(AppFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Accept, Origin, XRequestedWith, Content-Type, LastModified, token, Cookie");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");

        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("application/json; charset=utf-8");

        logger.debug("app filter");

        Cookie[] cookies = httpServletRequest.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                logger.debug(cookie.getName() + " --> " + cookie);
            }
        }

        Integer loginStyle = CommonUtil.getLoginAccount(httpServletRequest);
        if (loginStyle == null) {
            servletResponse.getWriter().write(JSONObject.toJSONString(ResponseDTO.createByErrorCodeMessage(ResponseEnums.LOGIN.getCode(), ResponseEnums.LOGIN.getDesc())));
            return;
        } else {
            //不为空
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {

    }

}
