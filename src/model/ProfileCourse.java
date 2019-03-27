package model;

public class ProfileCourse {
	public int id;
	public int idstudent;
	public int idcourse;
	public int nota;
	public int prezente;
	
	public ProfileCourse(int id, int idstudent,int idcourse,int nota, int prezente) {
		this.id=id;
		this.idstudent=idstudent;
		this.idcourse=idcourse;
		this.nota=nota;
		this.prezente=prezente;
	}
	public int getid() {
		return this.id;
	}
	public int getidC() {
		return this.idcourse;
	}
	public int getidS() {
		return this.idstudent;
	}
	public int getnota() {
		return this.nota;
	}
	public int getprezente() {
		return this.prezente;
	}
	public void setid(int id) {
		this.id=id;
	}
	public void setidC(int idc) {
		this.idcourse=idc;
	}
	public void setidS(int ids) {
		this.idstudent=ids;
	}
	public void setnota(int nota) {
		this.nota=nota;
	}
	public void setprezente(int prezente) {
		this.prezente=prezente;
	}
	public String toString() {
		return (id+" "+idcourse+" "+idstudent+" "+nota+" "+prezente);
	}
}
