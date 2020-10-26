package tech.anteeone.ecobits.filters;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

import javax.servlet.*;
import java.io.IOException;

@WebFilter({"/quests",
            "/shop",
            "/home"})
public class SessionFilter implements Filter {

    private ServletContext context;

    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        try {
            HttpSession session = req.getSession(false);

            if (session.getAttribute("user_session") == null) {
                resp.sendRedirect(req.getContextPath());
            }
            else {
                chain.doFilter(request, response);
            }
        }
        catch (NullPointerException e){
            resp.sendRedirect(req.getContextPath());
        }

    }

    public void destroy() {
        //close any resources here
    }

}
