package fr.dawan.demomvc.intercepteurs;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoginIntercepteur implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//Vérifier si user connecté:
		
		if(request.getRequestURI().contains("/utilisateurs") || request.getRequestURI().contains("/produits")) {
			if(request.getSession().getAttribute("email") == null) {
				response.sendRedirect(request.getContextPath()+"/login"); 
				
				// request.getContextPath(): renvoie la racine de l'application: http://domaine:port
			}
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	
	
	
}
