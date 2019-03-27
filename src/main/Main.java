package main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import businessLogic.CourseBLL;
import businessLogic.ProfileBLL;
import businessLogic.ProfileCourseBLL;
import businessLogic.UserBLL;
import model.Course;
import model.Profile;
import model.ProfileCourse;
import model.User;
import presentation.Login; 

public class Main {
	public static void main(String[] args) {
		/*UserBLL user=new UserBLL();
		User u= new User(88,"catalin23","cata",1);
		user.insertClient(u);*/
		//System.out.println(user.findId("mimiprata"));
		/*List<User> list= new ArrayList<User>();
		//String u=user.findUser(2);
		//System.out.println(u);
		list=user.list();
		for (User u: list) {
			System.out.println(u.toString());
		}*/
		//System.out.println(user.login("catalin", "catalin123"));
		Login l=new Login();
	
	
		/*ProfileBLL profile=new ProfileBLL();
		Profile p=profile.findProfilebyuser(2);
		System.out.println(p.toString());*/
		/*List <Profile> list = new ArrayList<Profile>();
		list=profile.list();
		for (Profile p:list) {
			System.out.println(p.toString());
		}*/
		/*Profile p=new Profile(2,3,"Prata Mirela","strada Observatorului","2971113555555");
		profile.register(p, "mimiprata", "alo" );*/
		
		
		/*List <ProfileCourse> list=new ArrayList<>();
		list=p.list();
		for (ProfileCourse c: list) {
			System.out.println(c);
		}*/
		
		
		/*CourseBLL c=new CourseBLL();
		List<Course> list=new ArrayList<>();
		list=c.listCourses(1);
		for (Course c1: list) {
			System.out.println(c1.toString());
		}*/
		
	}
}
