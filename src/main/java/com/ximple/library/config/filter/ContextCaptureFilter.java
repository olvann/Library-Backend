package com.ximple.library.config.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import static com.ximple.library.utils.Constants.X_REQUEST_ID;

public class ContextCaptureFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        var requestId = Optional.ofNullable(request.getHeader(X_REQUEST_ID))
                .filter(StringUtils::isNotBlank)
                .orElse(UUID.randomUUID().toString());
        ThreadContext.put(X_REQUEST_ID, requestId);
        ThreadContext.put("URI", request.getRequestURI());
        ThreadContext.put("METHOD", request.getMethod());
        filterChain.doFilter(request, response);
    }
}
