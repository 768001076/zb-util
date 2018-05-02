package filter;

import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.net.URLDecoder;

/**
 * @Description: 编码过滤
 *
 * @Author:shijialei
 * @Version:1.0
 * @Date:2018/4/24
 */
@WebFilter(filterName = "EncodingFilter", urlPatterns = "/*")
@Component
public class EncodingFilter implements Filter {

    @Override public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        boolean decodeURI = Boolean.valueOf(request.getHeader("decodeURI")) == null ? true : Boolean.valueOf(request
                .getHeader("decodeURI"));
        String requestURI = request.getRequestURI();
        if (true) {
            requestURI = URLDecoder.decode(requestURI,"UTF-8");
        }
        request.setAttribute("URI",requestURI);
        response.setCharacterEncoding("UTF-8");
        filterChain.doFilter(request,response);
    }

    @Override public void destroy() {

    }

}
