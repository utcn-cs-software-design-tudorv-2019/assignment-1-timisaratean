package model;

public class Course {
	public int id;
	public String cname;
	public String teacher;
	public Course(int id, String name,String teacher) {
		this.id=id;
		this.cname=name;
		this.teacher=teacher;
	}
	
	public int getID() {
		return this.id;
	}
	public String getName() {
		return this.cname;
	}
	public String getTeacher() {
		return this.teacher;
	}
	public void setID(int id) {
		this.id=id;
	}
	public void setName(String name) {
		this.cname=name;
	}
	public void setTeacher(String teacher) {
		this.teacher=teacher;
	}
	public String toString() {
		return (id+" "+cname+" "+teacher);
	}
}
