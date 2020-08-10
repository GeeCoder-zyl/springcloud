package com.zyl.springcloud;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @className: PasswordFilter
 * @description: 过滤器password
 * @author: ZYL
 * @date: 2020/7/7 10:12
 */
public class PasswordFilter extends com.netflix.zuul.ZuulFilter {

    private final Logger LOGGER = LoggerFactory.getLogger(TokenFilter.class);

    @Override
    public String filterType() {
        return "post"; //请求处理完成后执行过滤器
    }

    @Override
    public int filterOrder() {
        return 1; //优先级为1，数字越大，优先级越低
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        return (boolean) ctx.get("isSuccess");//判断上一个过滤器结果是否为true，否则就不走下面过滤器，直接跳过后面的所有过滤器并返回
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        LOGGER.info("PasswordFilter {},{}", request.getMethod(), request.getRequestURL().toString());
        String password = request.getParameter("password");
        if (null != password && password.equals("123456")) {
            ctx.setSendZuulResponse(true);
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess", true);
            return null;
        } else {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(400);
            ctx.setResponseBody("The password cannot be empty");
            ctx.set("isSuccess", false);
            return null;
        }
    }
}
