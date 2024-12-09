package com.jdbc.disadvantages;

public class Student {
      int id;
      String name;
      int age;
      int marks;
      String gender;
      
	public Student(int id, String name, int age, int marks, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.marks = marks;
		this.gender = gender;
	}
      public String toString() {
    	  return id+"  "+name+"  "+age+"  "+marks+"  "+gender;
      }
      
}
