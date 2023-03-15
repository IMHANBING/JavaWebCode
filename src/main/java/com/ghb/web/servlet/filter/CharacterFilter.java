package com.ghb.web.servlet.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class CharacterFilter implements Filter {

    private String characterEncoding = "utf-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req,
                         ServletResponse resp,
                         FilterChain chain)
            throws IOException, ServletException {

        req.setCharacterEncoding(characterEncoding);
        resp.setCharacterEncoding(characterEncoding);
        resp.setContentType("text/html;charset=" + characterEncoding);

        chain.doFilter(req, resp);

    }

    @Override
    public void destroy() {

    }
}
