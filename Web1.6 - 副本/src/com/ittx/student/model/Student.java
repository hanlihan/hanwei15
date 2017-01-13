package com.ittx.student.model;

public class Student {
	    private int id;
		private String name;
		private int number;
		private boolean sex;
		private String src;
		public Student(String name, int number, boolean sex, String src) {
			super();
			this.name = name;
			this.number = number;
			this.sex = sex;
			this.src = src;
		}

		public Student(int id, String name, int number, boolean sex, String src) {
			this.id = id;
			this.name = name;
			this.number = number;
			this.sex = sex;
			this.src = src;
		}

		@Override
		public String toString() {
			return "Student [name=" + name + ", number=" + number + ", sex=" + sex + ", src=" + src + "]";
		}
		
		public Student() {

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
		public boolean isSex() {
			return sex;
		}
		public void setSex(boolean sex) {
			this.sex = sex;
		}
		public String getSrc() {
			return src;
		}
		public void setSrc(String src) {
			this.src = src;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
        
}
