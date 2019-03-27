package validators;

import model.Profile;

public class Cnpvalidator implements Validator<Profile> {

	@Override
	public void validate(Profile t) {
		// TODO Auto-generated method stub
		String cnp=t.getCnp();
		if (cnp.length() != 13 ) {
			throw new IllegalArgumentException("The cnp is not valid!");
		}
		
	}
	

}
