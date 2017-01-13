package com.text.bean;

import com.mysql.jdbc.BlobFromLocator;

public class Student1 {
	private int number;
    private String name;
    private boolean sex;
    private String src;
    

   public Student1(int number, String name,Boolean sex,String src) {
	   
	   this.number = number;
	   this.name = name;
	   this.sex = sex;
	   this.src = src;
   }
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
public boolean isSex(){
	return sex;
}
public void setSex(boolean sex){
	this.sex = sex;
}
public String getSrc() {
	return src;
}
public void setSrc(String src) {
	this.src = src;
}
}
