package by.tc.library.controller.command.filter;

import javax.servlet.*;
import java.io.IOException;

public class Filter implements javax.servlet.Filter {
    private static final String SCHERSET_SET_MESSAGE = "Charset has been set";
    private static final String ENCODING_PARAM = "characterEncoding";

    private String encoding;
    private ServletContext context;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter(ENCODING_PARAM);
        context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encoding);
        servletResponse.setCharacterEncoding(encoding);
        context.log(SCHERSET_SET_MESSAGE);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
