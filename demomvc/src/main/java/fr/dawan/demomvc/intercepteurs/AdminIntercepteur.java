package fr.dawan.demomvc.intercepteurs;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@Component
public class AdminIntercepteur implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//Vérifier si user connecté:
		
		if(request.getRequestURI().contains("/produits/delete") || request.getRequestURI().contains("/produits/update")) {
			if((Boolean)request.getSession().getAttribute("admin") == false) {
				response.sendRedirect(request.getContextPath()+"/adminError"); 
				
				// request.getContextPath(): renvoie la racine de l'application: http://domaine:port
			}
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}

