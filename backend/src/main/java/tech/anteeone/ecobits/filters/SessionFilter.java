//package tech.anteeone.ecobits.filters;
//
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.*;
//
//import javax.servlet.*;
//import java.io.IOException;
//
//@WebFilter("/home")
//public class SessionFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
//        if(session.getAttribute("user_session")==null){
//            HttpServletResponse response = (HttpServletResponse) servletResponse;
//            response.sendRedirect("/");
//        }
//        filterChain.doFilter(servletRequest,servletResponse);
//    }
//
//}
