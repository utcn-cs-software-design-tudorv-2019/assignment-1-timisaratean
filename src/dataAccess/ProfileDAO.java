package dataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Profile;
import model.User;

public class ProfileDAO {
	public static Profile readProfile(int id){
		Profile result=null;
		
		try {
		Connection myCon = DBConnection.getConnection();
		Statement mS = myCon.createStatement();
		String query="select * from profile where id="+id;
		ResultSet myR = mS.executeQuery(query); 
		while (myR.next()) 
			{				
			result=new Profile(Integer.parseInt(myR.getString("id")),Integer.parseInt(myR.getString("iduser")),myR.getString("name"),myR.getString("address"),myR.getString("cnp"));
			}
			
		}catch(Exception ext){
			System.out.println("Not working!");
		}
		
		return result;
	}
	public static Profile findbyiduser(int iduser){
		Profile result=null;
		
		try {
		Connection myCon = DBConnection.getConnection();
		Statement mS = myCon.createStatement();
		String query="select * from profile where iduser="+iduser;
		ResultSet myR = mS.executeQuery(query); 
		while (myR.next()) 
			{				
			result=new Profile(Integer.parseInt(myR.getString("id")),Integer.parseInt(myR.getString("iduser")),myR.getString("name"),myR.getString("address"),myR.getString("cnp"));
			}
			
		}catch(Exception ext){
			System.out.println("Not working!");
		}
		
		return result;
	}
	public static List<Profile> findAll(){
		List<Profile> list=new ArrayList<>();
		
		try {
		Connection myCon = DBConnection.getConnection();
		Statement mS = myCon.createStatement();
		String query="Select * From profile";
		ResultSet myR = mS.executeQuery(query); 
		while (myR.next()) 
			{
			Profile result=new Profile(Integer.parseInt(myR.getString("id")),Integer.parseInt(myR.getString("iduser")),myR.getString("name"),myR.getString("address"),myR.getString("cnp"));
			list.add(result);
			}
			
		}catch(Exception ext){
			System.out.println("Not working!");
		}
		
		return list;
	}
		public static void createProfile(Profile u){
		
		try {
		Connection myCon = DBConnection.getConnection();
		Statement ms=myCon.createStatement();
		String s1=Integer.toString(u.id);
		String s2=Integer.toString(u.iduser);
		String s3="'"+u.name+"'";
		String s4= "'"+u.address+"'";
		String s5= "'"+u.cnp+"'";
		
		
		String query="insert into profile"			     
				     +" values("+s1+","+s2+","+s3+","+s4+","+s5+")";
		
		ms.executeUpdate(query);
		System.out.println("Profile inserted");
		}catch(Exception ext){
			System.out.println("Eroare insert");
		}
	}
		public static void deleteProfile(int id){
			
			try {
			Connection myCon = DBConnection.getConnection();
			Statement ms=myCon.createStatement();
			
			String query="delete from profile where id="+id;
			
			ms.executeUpdate(query);
			System.out.println("Profile deleted");
			}catch(Exception ext){
				System.out.println("Eroare delete");
			}
		}
		public static void updateUser(Profile u){
			
			try {
			Connection myCon = DBConnection.getConnection();
			Statement ms=myCon.createStatement();
			String s1=Integer.toString(u.id);
			String s2= Integer.toString(u.iduser)+",";
			String s3= "'"+u.name+"'"+",";
			String s4="'"+u.address+"'"+",";
			String s5="'"+u.cnp+"'";
			
			
			String query="update profile "
						+"set iduser="+s2
					     +"name="+s3
					     +"address="+s4
					     +"cnp="+s5
					     
					     +" where id ="+s1;
			ms.executeUpdate(query);
			System.out.println("Profile updated");
			}catch(Exception ext){
				System.out.println(ext);
			}
		}
}
