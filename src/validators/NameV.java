package validators;

import model.Profile;

public class NameV implements Validator<Profile> {

	@Override
	public void validate(Profile t) {
		// TODO Auto-generated method stub
		String nume=t.getName().toLowerCase();
		for (int i=0; i<nume.length(); i++) {
			if ((nume.charAt(i)<'a' || nume.charAt(i)>'z') && nume.charAt(i)!=' ')
				throw new IllegalArgumentException("The client name is not valid!");
		}
	}

}
