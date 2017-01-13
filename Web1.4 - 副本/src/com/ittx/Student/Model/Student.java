package com.ittx.Student.Model;

public class Student {
		private String name;
		private int number;
		private boolean sex;
		private String src;
		@Override
		public String toString() {
			return "Student [name=" + name + ", number=" + number + ", sex=" + sex + ", src=" + src + "]";
		}
		public Student(String name, int number, boolean sex, String src) {
			this.name = name;
			this.number = number;
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
        
}
