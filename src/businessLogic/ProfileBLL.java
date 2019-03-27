package businessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import dataAccess.ProfileDAO;
import dataAccess.UserDAO;
import model.Course;
import model.Profile;
import model.User;
import validators.Cnpvalidator;
import validators.NameV;
import validators.UsernameV;
import validators.Validator;

public class ProfileBLL {
	private ProfileDAO profile;
	UserBLL user=new UserBLL();
	private static List<Validator<Profile>> validators;
	public ProfileBLL() {
		profile=new ProfileDAO();
		validators=new ArrayList<Validator<Profile>>();
		validators.add(new Cnpvalidator());
		validators.add(new NameV());
		
	}
	public static Profile findProfile(int id) {
		Profile u=ProfileDAO.readProfile(id);
		if (u == null) {
			throw new NoSuchElementException("The client with id  = " + id + " was not found!");
		}
		return u;
	}
	public static Profile findProfilebyuser(int id) {
		Profile u=ProfileDAO.findbyiduser(id);
		return u;
	}
	public void insertProfile(Profile u) {
		for (Validator<Profile> v : validators) {
			v.validate(u);
		}
		ProfileDAO.createProfile(u);
	}
	public static List<Profile> list() {
		return ProfileDAO.findAll();
	}
	public static void deleteProfile(int id) {
		ProfileDAO.deleteProfile(id);
	}
	public static void updateProfile(Profile p) {
		for (Validator<Profile> v : validators) {
			v.validate(p);
		}
		ProfileDAO.updateUser(p);
	}
	
	public void register(Profile p,String username,String pass) {
		List<Profile> profiles=list();
		for (Profile s:profiles) {
			if (s.equals(p)) {
				System.out.println("Acest profil exista deja!");
			}
			else {
				insertProfile(p);
				User u=new User(p.iduser,username,pass,1);
				user.insertClient(u);
			}
		}
	}
}
