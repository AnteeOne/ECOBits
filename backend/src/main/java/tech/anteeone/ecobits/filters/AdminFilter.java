package tech.anteeone.ecobits.filters;

import tech.anteeone.ecobits.configs.RolesRepository;
import tech.anteeone.ecobits.models.User;
import tech.anteeone.ecobits.repositories.UserRepository;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin")
public class AdminFilter implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        try {
            HttpSession session = req.getSession(false);
            User user = (User) new UserRepository().getUserFromSession(session.getAttribute("user_session").toString());
            if(user.getRole().equals(RolesRepository.admin)){
                filterChain.doFilter(servletRequest,servletResponse);
            }
            else {
                resp.sendRedirect(req.getContextPath());
            }
        }
        catch (NullPointerException e){
            resp.sendRedirect(req.getContextPath());
        }
    }

    @Override
    public void destroy() {

    }
}
