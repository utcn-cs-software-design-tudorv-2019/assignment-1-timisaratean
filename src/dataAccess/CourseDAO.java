package dataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Course;
import model.Profile;

public class CourseDAO {
	public static Course findbyId(int id){
		Course result=null;
		
		try {
		Connection myCon = DBConnection.getConnection();
		Statement mS = myCon.createStatement();
		String query="select * from course where id="+id;
		ResultSet myR = mS.executeQuery(query); 
		while (myR.next()) 
			{				
			result=new Course(Integer.parseInt(myR.getString("id")),myR.getString("cname"),myR.getString("teacher"));
			}
			
		}catch(Exception ext){
			System.out.println("Not working!");
		}
		
		return result;
	}
	public static List<Course> findAll(){
		List<Course> list=new ArrayList<>();
		
		try {
		Connection myCon = DBConnection.getConnection();
		Statement mS = myCon.createStatement();
		String query="Select * From course";
		ResultSet myR = mS.executeQuery(query); 
		while (myR.next()) 
			{
			Course result=new Course(Integer.parseInt(myR.getString("id")),myR.getString("cname"),myR.getString("teacher"));
			list.add(result);
			}
			
		}catch(Exception ext){
			System.out.println("Not working!");
		}
		
		return list;
	}
}
