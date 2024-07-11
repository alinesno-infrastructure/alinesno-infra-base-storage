package com.alinesno.infra.base.fileshow.core.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Configuration
public class SecurityFilterProxy extends OncePerRequestFilter {


    private String NOT_ALLOW_METHODS = "TRACE";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        if(("," + NOT_ALLOW_METHODS + ",").contains("," + request.getMethod().toUpperCase() + ",")) {
            response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
            response.setHeader("Content-Type", "text/html; charset=iso-8859-1");
            response.getWriter().println("Method Not Allowed");
            return;
        }
        super.doFilter(request, response, filterChain);
    }
}
