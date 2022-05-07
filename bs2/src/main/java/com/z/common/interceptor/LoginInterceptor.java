package com.z.common.interceptor;

import cn.hutool.jwt.JWTUtil;
import com.z.exception.LoginException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Configuration
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 验证登录状态
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)) {
            log.error("token为空或token已过期");
            throw new LoginException(400,"token为空或token已过期");
        }
        if (!JWTUtil.verify(token,"zhang".getBytes())) {
            log.error("token不正确");
            throw new LoginException(400, "token不正确");
        }

        return true;
    }
}