package businessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import dataAccess.UserDAO;
import model.User;
import validators.UsernameV;
import validators.Validator;

public class UserBLL {
	private UserDAO user;
	private static List<Validator<User>> validators;
	public UserBLL() {
		user=new UserDAO();
		validators=new ArrayList<Validator<User>>();
		validators.add(new UsernameV());
	}
	public String findUser(int idu) {
		String u=UserDAO.viewUser(idu);
		if (u == null) {
			throw new NoSuchElementException("The client with id  = " + idu + " was not found!");
		}
		return u;
	}
	public void insertClient(User u) {
		for (Validator<User> v : validators) {
			v.validate(u);
		}
		UserDAO.addUser(u);
	}
	public static List<User> list() {
		return UserDAO.findAll();
	}
	
	public static int findId(String username) {
		int i=UserDAO.findId(username);
		return i;
	}
	
	public static int login(String name, String password) {
		List<User> users=list();
		for (User user:users) {
			if (user.getUsername().equals(name)) {
				if(user.getPass().equals(password)) {
					if (user.tip==1) {
						return 1;
					}
					return 0;
				}
			}
		}
		return -1;
	}
	
		
	
}
