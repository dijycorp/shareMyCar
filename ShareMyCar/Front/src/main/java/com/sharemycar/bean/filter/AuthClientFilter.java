package com.sharemycar.bean.filter;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sharemycar.bean.UserConnexionBean;
import com.sharemycar.bean.nav.NavigationBean;

public class AuthClientFilter implements Serializable, Filter {

	 private static final long serialVersionUID = 1L;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// rien

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// Get the loginBean from session attribute
		UserConnexionBean userConnexionBean = (UserConnexionBean) ((HttpServletRequest) request).getSession().getAttribute("userConnexionBean");
		NavigationBean navigationBean = new NavigationBean();

		if (userConnexionBean == null || !userConnexionBean.getLogguer()) {
			String contextPath = ((HttpServletRequest) request).getContextPath();
			((HttpServletResponse) response).sendRedirect(contextPath + navigationBean.goConnexion());
		}

		System.out.println(((HttpServletRequest) request).getRequestURL());
		
		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
