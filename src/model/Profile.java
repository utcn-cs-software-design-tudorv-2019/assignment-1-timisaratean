package model;

public class Profile {
	public int id;
	public int iduser;
	public String name;
	public String address;
	public String cnp;
	
	public Profile(int id, int iduser, String name, String address, String cnp) {
		this.id=id;
		this.iduser=iduser;
		this.name=name;
		this.address=address;
		this.cnp=cnp;
	}
	
	public int getId() {
		return this.id;
	}
	public int getIdUser() {
		return this.iduser;
	}
	public String getName() {
		return this.name;
	}
	public String getAddress() {
		return this.address;
	}
	public String getCnp() {
		return this.cnp;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	public void setIdUser(int iduser) {
		this.iduser=iduser;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setAddress(String address) {
		this.address=address;
	}
	public void setCnp(String cnp) {
		this.cnp=cnp;
	}
	public String toString() {
		return(id+" "+iduser+" "+name+" "+address+" "+cnp);
	}
}
