import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TutorialCollection {
	
	Tutorial mockTutorial;
	public TutorialCollection(Tutorial mockTutorial) {
		this.mockTutorial = mockTutorial;
		
	}
	protected boolean checkPassword(String password) {
		if (password.equals("password")) {
			return true;
		}
		else {
			return false;
		}
	}

	
}
