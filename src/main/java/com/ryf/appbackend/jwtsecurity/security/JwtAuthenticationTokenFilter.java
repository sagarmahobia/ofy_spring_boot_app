package com.ryf.appbackend.jwtsecurity.security;

import com.ryf.appbackend.jwtsecurity.model.JwtAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {


    public JwtAuthenticationTokenFilter() {
        super("/api/v1/protected/**");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {

//        httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
//todo
        String key = httpServletRequest.getHeader("Authorization");
        if (key == null) {
            key = httpServletRequest.getParameter("key");

            if (key == null) {
                throw new AuthenticationException("Token is required") {
                };
            }
        }


        JwtAuthenticationToken token = new JwtAuthenticationToken(key);
        return getAuthenticationManager().authenticate(token);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }
}
