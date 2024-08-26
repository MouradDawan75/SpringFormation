package fr.dawan.backrestapi.intercepteurs;

import javax.security.sasl.AuthenticationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.core.JsonProcessingException;

import fr.dawan.backrestapi.dtos.ErrorDto;
import fr.dawan.backrestapi.dtos.ErrorDto.ErrorLevel;
import fr.dawan.backrestapi.dtos.ErrorDto.ErrorType;

@ControllerAdvice
public class MyGlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	//On peut définir des méthodes qui capturent des exceptions en fonction de leur type
	
	@ExceptionHandler(value = AuthenticationException.class)
	protected ResponseEntity<?> handleAuthenticationException(Exception ex, WebRequest request){
		
		ErrorDto dto = new ErrorDto();
		dto.setCode(401);
		dto.setMessage("Authentication error........");
		dto.setErrorLevel(ErrorLevel.ERROR);
		dto.setErrorType(ErrorType.ACCESS);
		
		return handleExceptionInternal(ex, dto, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
		
	}
	
	
	@ExceptionHandler(value = NullPointerException.class)
	protected ResponseEntity<?> handleNullPointerException(Exception ex, WebRequest request){
		
		ErrorDto dto = new ErrorDto();
		dto.setCode(400);
		dto.setMessage("Null object........");
		dto.setErrorLevel(ErrorLevel.ERROR);
		dto.setErrorType(ErrorType.CLIENT_APP);
		
		return handleExceptionInternal(ex, dto, new HttpHeaders(), HttpStatus.NO_CONTENT, request);
		
	}
	
	@ExceptionHandler(value = RuntimeException.class)
	protected ResponseEntity<?> handleRuntimeException(Exception ex, WebRequest request){
		
		ErrorDto dto = new ErrorDto();
		dto.setCode(500);
		dto.setMessage("Null object. Contact Admin.......");
		dto.setErrorLevel(ErrorLevel.ERROR);
		dto.setErrorType(ErrorType.CLIENT_APP);
		
		return handleExceptionInternal(ex, dto, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
		
	}
	
	@ExceptionHandler(value = JsonProcessingException.class)
	protected ResponseEntity<?> handleJsonProcessingException(Exception ex, WebRequest request){
		
		ErrorDto dto = new ErrorDto();
		dto.setCode(500);
		dto.setMessage("ObjectMapper: Echec conversion en JSON.......");
		dto.setErrorLevel(ErrorLevel.ERROR);
		dto.setErrorType(ErrorType.EXCEPTION);
		
		return handleExceptionInternal(ex, dto, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
		
	}
	


}
