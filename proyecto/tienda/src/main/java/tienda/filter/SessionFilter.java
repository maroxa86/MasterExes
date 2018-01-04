package tienda.filter;

import java.io.IOException;

import javax.faces.bean.ManagedProperty;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tienda.service.LoginService;

@WebFilter(filterName = "SessionFilter", urlPatterns = { "/*" })
public class SessionFilter implements Filter {

	@ManagedProperty("#{loginService}")
	private LoginService loginBean;
	private FilterConfig filterConfig = null;

	public SessionFilter() {
	}

	public LoginService getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginService loginBean) {
		this.loginBean = loginBean;
	}

	@Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        try{
            HttpServletRequest reqt = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;
            HttpSession ses = reqt.getSession(false);

            String reqURI = reqt.getRequestURI();
            if (reqURI.indexOf("/login.xhtml") >= 0 || (ses != null && ses.getAttribute("username") != null)
                || reqURI.indexOf("/public/") >= 0  || reqURI.contains("javax.faces.resource")){
                chain.doFilter(request, response);
            }       
            else{
                resp.sendRedirect(reqt.getContextPath() + "/faces/login.xhtml");
            }
        } catch (Exception e) {
                System.out.println(e.getMessage());
        }
    }

	public FilterConfig getFilterConfig() {
		return (this.filterConfig);
	}

	public void setFilterConfig(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}

	public void destroy() {
	}

	public void init(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}

}