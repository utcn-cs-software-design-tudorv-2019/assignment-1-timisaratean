package businessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import dataAccess.ProfileCourseDAO;
import dataAccess.ProfileDAO;
import model.Profile;
import model.ProfileCourse;


public class ProfileCourseBLL {
	private ProfileCourseDAO p;
	public ProfileCourseBLL() {
		p=new ProfileCourseDAO();
	}
	public static List<Integer> findbyidStudent(int idu) {
		List<Integer> list= new ArrayList<>();
		list=ProfileCourseDAO.findbyStudentid(idu);
		return list;
		
	}
	public static void insertProfile(ProfileCourse u) {
		ProfileCourseDAO.create(u);
	}
	
	public static ProfileCourse findProfile(int id) {
		ProfileCourse u=ProfileCourseDAO.readProfile(id);
		if (u == null) {
			throw new NoSuchElementException("The client with id  = " + id + " was not found!");
		}
		return u;
	}
	public static List<ProfileCourse> list() {
		return ProfileCourseDAO.findAll();
	}
}
