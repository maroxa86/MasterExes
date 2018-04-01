package tienda.filter;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tienda.managedBean.LoginManagedBean;

import tienda.service.LoginService;

@WebFilter(filterName = "SessionFilter", urlPatterns = {"/secured/*"})
public class SessionFilter implements Filter {

    public static final String LOGIN_PAGE = "/login.xhtml";
    
    @EJB
    private LoginService loginBean;
    private FilterConfig filterConfig = null;

    public SessionFilter() {
    }

    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
            
        HttpServletRequest reqt = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        
        LoginManagedBean login = (LoginManagedBean) reqt.getSession().getAttribute("login");
        
        if(login != null){
            if(login.isLoggedIn()){
                chain.doFilter(request, response);
            }
            else{
                resp.sendRedirect(reqt.getContextPath() + LOGIN_PAGE);
            }
        }
        else{
            resp.sendRedirect(reqt.getContextPath() + LOGIN_PAGE);
        }
        /*try {
            HttpServletRequest reqt = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;
            HttpSession ses = reqt.getSession(false);

            String reqURI = reqt.getRequestURI();
            if (reqURI.indexOf("/login.xhtml") >= 0 || (ses != null && ses.getAttribute("username") != null)
                    || reqURI.indexOf("/public/") >= 0 || reqURI.contains("javax.faces.resource")) {
                chain.doFilter(request, response);
            } else {
                resp.sendRedirect(reqt.getContextPath() + "/faces/login.xhtml");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/
    }
    
    public void destroy() {
    }

    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }
    
    public LoginService getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginService loginBean) {
        this.loginBean = loginBean;
    }

}
