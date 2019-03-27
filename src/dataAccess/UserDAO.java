package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;
import dataAccess.DBConnection;

public class UserDAO {
	public static String viewUser(int iduser){
		String result=null;
		
		try {
		Connection myCon = DBConnection.getConnection();
		Statement mS = myCon.createStatement();
		String query="select * from user where iduser="+iduser;
		ResultSet myR = mS.executeQuery(query); 
		while (myR.next()) 
			{				
			result=myR.getString("iduser")+","+myR.getString("username")+","+myR.getString("password")+","+myR.getString("tip");
		    System.out.println(myR.getString("iduser")+","+myR.getString("username")+","+myR.getString("password")+","+myR.getString("tip"));
			}
			
		}catch(Exception ext){
			System.out.println("Not working!");
		}
		
		return result;
	}
	public static int findId(String username) {
		int id=0;
		try {
			Connection myCon = DBConnection.getConnection();
			Statement mS = myCon.createStatement();
			String query="select iduser from user where username='"+username+"'";
			//System.out.println(query);
			ResultSet myR = mS.executeQuery(query); 
			while (myR.next()) 
				{				
				id=Integer.parseInt(myR.getString("iduser"));
				//System.out.println(id);
			    //System.out.println(myR.getString("iduser")+","+myR.getString("username")+","+myR.getString("password")+","+myR.getString("tip"));
				}
				
			}catch(Exception ext){
				System.out.println("Not working!");
			}
			
			return id;
	}
	
	public static List<User> findAll(){
		List<User> list=new ArrayList<>();
		
		try {
		Connection myCon = DBConnection.getConnection();
		Statement mS = myCon.createStatement();
		String query="Select * From user";
		ResultSet myR = mS.executeQuery(query); 
		while (myR.next()) 
			{
			User result=new User(Integer.parseInt(myR.getString("iduser")),myR.getString("username"),myR.getString("password"),Integer.parseInt(myR.getString("tip")));
			list.add(result);
			}
			
		}catch(Exception ext){
			System.out.println("Not working!");
		}
		
		return list;
	}
	
		public static void addUser(User u){
		
		try {
		Connection myCon = DBConnection.getConnection();
		Statement ms=myCon.createStatement();
		String s1=Integer.toString(u.iduser);
		String s2="'"+u.username+"'";
		String s3= "'"+u.password+"'";
		String s4= Integer.toString(u.tip);
		
		
		String query="insert into user"			     
				     +" values("+s1+","+s2+","+s3+","+s4+")";
		
		ms.executeUpdate(query);
		System.out.println("User inserted");
		}catch(Exception ext){
			System.out.println("Eroare addUser");
		}
	}
		
		
}
