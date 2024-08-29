package fr.dawan.demomvc.intercepteurs;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyGlobalExceptionHandler {

	//avec la possiblité de fournir des données à la page d'erreur
	/*
	@ExceptionHandler(Exception.class)
	public String displayErrorPage(Model model, Exception ex) {
		
		model.addAttribute("message", ex.getMessage());
		return "error";
	}
	*/
	
	@ExceptionHandler(Exception.class)
	public String displayErrorPage() {
		return "error";
	}
	
	/*
	 * Soit 1 seule page pour toutes les exceptions possibles
	 * Soit 1 page d'erreur pour chaque type d'exception
	 * 
	 */
	/*
	@ExceptionHandler(NullPointerException.class)
	public String ErrorNullpointer() {
		return "ErrorNullpointer";
	}
	*/
}
