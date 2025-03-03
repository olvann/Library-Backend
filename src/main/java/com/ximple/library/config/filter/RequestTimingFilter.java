package com.ximple.library.config.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Log4j2
public class RequestTimingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        long startTime = System.nanoTime();
        log.info("Incoming Request - Query params: {}", request.getParameterMap());
        filterChain.doFilter(request, response);
        log.info("Response code: {} - Response time: {} ms", response.getStatus(),
                (System.nanoTime() - startTime) / 1_000_000);
    }
}
