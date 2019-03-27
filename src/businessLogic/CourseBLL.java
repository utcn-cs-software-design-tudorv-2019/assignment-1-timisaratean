package businessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import dataAccess.CourseDAO;
import dataAccess.ProfileDAO;
import model.Course;
import model.Profile;

public class CourseBLL {
	private CourseDAO c;
	public CourseBLL() {
		c=new CourseDAO();
	}
	
	public static Course findCourse(int id) {
		Course u=CourseDAO.findbyId(id);
		if (u == null) {
			throw new NoSuchElementException("The course with id  = " + id + " was not found!");
		}
		return u;
	}
	public static List<Course> listCourses(int id){
		List<Integer> list1=ProfileCourseBLL.findbyidStudent(id);
		List<Course> list=new ArrayList<>();
		for (Integer c: list1) {
			list.add(findCourse(c)); 
			
		}
		return list;
	}
	public static List<Course> list() {
		return CourseDAO.findAll();
	}
}	
