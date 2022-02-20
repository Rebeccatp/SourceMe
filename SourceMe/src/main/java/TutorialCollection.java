public class TutorialCollection {
	
	protected boolean ifAdmin(String role) {
		if (role.equals("Admin")) {
			return true;
		}
		else {
			return false;
		}
	}

	
}
