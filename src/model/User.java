package model;

public class User {
	public int iduser;
	public String username;
	public String password;
	public int tip;
	
	public User(int idu, String username, String password, int tip) {
		this.iduser=idu;
		this.username=username;
		this.password=password;
		this.tip=tip;
	}
	
	public int getId() {
		return this.iduser;
	}
	public String getUsername() {
		return this.username;
	}
	public String getPass() {
		return this.password;
	}
	public int getTip() {
		return this.tip;
	}
	
	public void setId(int idu) {
		this.iduser=idu;
	}
	public void setUsername(String username) {
		this.username=username;
	}
	public void setPass(String password) {
		this.password=password;
	}
	public void setTip(int tip) {
		this.tip=tip;
	}
	public String toString() {
		return (iduser+" "+username+" "+password+" "+tip); 
	}
}
