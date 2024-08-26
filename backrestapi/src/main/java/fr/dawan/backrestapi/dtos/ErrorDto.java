package fr.dawan.backrestapi.dtos;

import java.time.LocalDateTime;

public class ErrorDto {
	
	private int code;
	private String message;
	private LocalDateTime timeStamp;
	private String path;
	
	public enum ErrorLevel{
		DEBUG,INFO,WARNING,ERROR
	}
	
	public enum ErrorType{
		ACCESS, CLIENT_APP,EXCEPTION
	}
	
	private ErrorLevel errorLevel;
	private ErrorType errorType;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public ErrorLevel getErrorLevel() {
		return errorLevel;
	}
	public void setErrorLevel(ErrorLevel errorLevel) {
		this.errorLevel = errorLevel;
	}
	public ErrorType getErrorType() {
		return errorType;
	}
	public void setErrorType(ErrorType errorType) {
		this.errorType = errorType;
	}
	
	

}
