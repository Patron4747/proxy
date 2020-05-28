package com.business.proxy.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: mmustafin@context-it.ru
 * @created: 28.05.2020
 */

public class ZuulPreFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(ZuulPreFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        // Add a custom header in the request
        ctx.addZuulRequestHeader("Authorization",
                request.getHeader("Authorization"));
        log.info(String.format("%s request to %s", request.getMethod(),
                request.getRequestURL().toString()));
        return null;
    }
}
