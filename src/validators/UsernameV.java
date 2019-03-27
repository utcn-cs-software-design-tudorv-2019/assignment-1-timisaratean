package validators;

import model.User;

public class UsernameV implements Validator<User>{

	@Override
	public void validate(User t) {
		// TODO Auto-generated method stub
		int ok=0;
		int ok2=0;
		String nume=t.getUsername().toLowerCase();
		for (int i=0;i<nume.length();i++) {
			if(nume.charAt(i)=='@') {
				ok=1;
				System.out.println(ok);
			}
			else {
			if(nume.charAt(i)=='.') { 
				ok2=1;
				System.out.println(ok2);
			}
			}
		}
		if (ok==0 || ok2==0) throw new IllegalArgumentException("The username is not valid!");
		
	}
	
}
