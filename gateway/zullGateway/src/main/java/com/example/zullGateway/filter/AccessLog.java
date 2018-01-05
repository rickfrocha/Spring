package com.example.zullGateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ricardo on 27/12/17.
 */
@Component
public class AccessLog extends ZuulFilter {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        HttpServletResponse response = RequestContext.getCurrentContext().getResponse();

        logger.info("REQUEST :: < " + request.getScheme() + " " + request.getLocalAddr() + ":" + request.getLocalPort());
        logger.info("REQUEST :: < " + request.getMethod() + " " + request.getRequestURI() + " " + request.getProtocol());
        logger.info("RESPONSE:: > HTTP:" + response.getStatus());

        return null;
    }
}
