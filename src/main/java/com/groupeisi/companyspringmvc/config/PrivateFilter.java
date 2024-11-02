package com.groupeisi.companyspringmvc.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class PrivateFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		// on recupere le nom de la session
		String username = (String)session.getAttribute("username");
		// on recupere le chemin demande par l’utilisateur
		String chemin = req.getServletPath();
		// on recupere la methode HTTP utilisee (GET ou POST)
		String method = req.getMethod();
		if (username != null || chemin.equals("/") || chemin.equals("/login")|| chemin.equals("/signup") || chemin.equals("/logout") || chemin.equals("/index.jsp") || chemin.equals("/login") && method.equalsIgnoreCase("POST") || chemin.equals("/signup") && method.equalsIgnoreCase("POST") || chemin.startsWith("/public/"))
			chain.doFilter(request, response);
		else
			res.sendRedirect(req.getContextPath());//re
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
