package com.text.Li;

public class User {
   private String time;
   private String ip;
   private String sessionId;
   public User(){
	   
   }
public User(String time, String ip, String sessionId) {
	this.time = time;
	this.ip = ip;
	this.sessionId = sessionId;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getIp() {
	return ip;
}
public void setIp(String ip) {
	this.ip = ip;
}
public String getSessionId() {
	return sessionId;
}
public void setSessionId(String sessionId) {
	this.sessionId = sessionId;
}
   
}
