package dataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Profile;
import model.ProfileCourse;

public class ProfileCourseDAO {
	public static List<Integer> findbyStudentid(int id){
		List <Integer> result=new ArrayList<>();
		
		try {
		Connection myCon = DBConnection.getConnection();
		Statement mS = myCon.createStatement();
		String query="select idcourse from profilecourse where idstudent="+id;
		ResultSet myR = mS.executeQuery(query); 
		while (myR.next()) 
			{	
			int id1=Integer.parseInt(myR.getString("idcourse"));
			result.add(id1);
			}
			
		}catch(Exception ext){
			System.out.println("Not working!");
		}
		
		return result;
	}
	public static void create(ProfileCourse u){
		
		try {
		Connection myCon = DBConnection.getConnection();
		Statement ms=myCon.createStatement();
		String s1=Integer.toString(u.id);
		String s2=Integer.toString(u.idstudent);
		String s3=Integer.toString(u.idcourse);
		String s4= Integer.toString(u.nota);
		String s5= Integer.toString(u.prezente);
		
		
		String query="insert into profilecourse"			     
				     +" values("+s1+","+s2+","+s3+","+s4+","+s5+")";
		
		ms.executeUpdate(query);
		System.out.println("Profile inserted");
		}catch(Exception ext){
			System.out.println("Eroare insert");
		}
	}
	public static ProfileCourse readProfile(int id){
		ProfileCourse result=null;
		
		try {
		Connection myCon = DBConnection.getConnection();
		Statement mS = myCon.createStatement();
		String query="select * from profilecourse where id="+id;
		ResultSet myR = mS.executeQuery(query); 
		while (myR.next()) 
			{				
			result=new ProfileCourse(Integer.parseInt(myR.getString("id")),Integer.parseInt(myR.getString("idstudent")),Integer.parseInt(myR.getString("idcourse")),Integer.parseInt(myR.getString("nota")),Integer.parseInt(myR.getString("prezente")));
			}
			
		}catch(Exception ext){
			System.out.println("Not working!");
		}
		
		return result;
	}
	public static List<ProfileCourse> findAll(){
		List<ProfileCourse> list=new ArrayList<>();
		
		try {
		Connection myCon = DBConnection.getConnection();
		Statement mS = myCon.createStatement();
		String query="Select * From profilecourse";
		ResultSet myR = mS.executeQuery(query); 
		while (myR.next()) 
			{
			ProfileCourse result=new ProfileCourse(Integer.parseInt(myR.getString("id")),Integer.parseInt(myR.getString("idstudent")),Integer.parseInt(myR.getString("idcourse")),Integer.parseInt(myR.getString("nota")),Integer.parseInt(myR.getString("prezente")));
			list.add(result);
			}
			
		}catch(Exception ext){
			System.out.println("Not working!");
		}
		
		return list;
	}
	
}
