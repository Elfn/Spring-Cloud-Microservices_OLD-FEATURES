package com.ms.zuulapigatewayserver.utils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Elimane on Oct, 2020, at 23:01
 */
//IS TO LOG EACH REQUESTS GOING THROUGH GATEWAY(REQUEST INTERCEPTION)
@Component
public class ZuulLoggingFilter extends ZuulFilter {

    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    //WHAT KIND OF FILTER WE WANT TO USE
    @Override
    public String filterType() {
        return "pre";//All the requests before execution
       // return "post";//All the requests after execution
      //  return "error";//Only error requests
    }

    //PRIOR FILTER
    @Override
    public int filterOrder() {
        return 1;
    }

    //SHOULD THIS FILTER BE EXECUTED OR NOT
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        //Current request which is being handled
        HttpServletRequest request =  RequestContext.getCurrentContext().getRequest();

        logger.info("Request: {}, RequestUri: {}",request,request.getRequestURI());

        return null;
    }
}
