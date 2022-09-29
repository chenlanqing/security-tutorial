package com.qing.fan.config;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

/**
 * @author QingFan 2022/9/29
 * @version 1.0.0
 */
public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {

    private boolean isPassed;

    public CustomWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        String code = request.getParameter("code");
        String verify_code = (String) request.getSession().getAttribute("verify_code");
        if (code != null && code.equals(verify_code)) {
            isPassed = true;
        }
    }

    public boolean isPassed() {
        return isPassed;
    }
}
