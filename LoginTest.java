
import static org.junit.Assert.*;

import org.junit.Test;

public class LoginTest {

	@Test
	public void ResetTest() {
		Login login = new Login(); //Run the login method
		login.reset.doClick(); //Click the reset button to clear the text fields
	}
	
	@Test
	public void SuccessTest() {
		Login login = new Login(); //Run the login method
		login.name.setText("Keimmie"); // Set name text field
		login.password.setText("password123"); // Set password text field
		login.submit.doClick(); //Click the submit button

	}

	@Test
	public void FailTest() {
		Login login = new Login(); //Run the login method
		login.name.setText("Keimmie"); // Set name text field
		login.password.setText("sakjnt"); // Set password text field
		login.submit.doClick();
	}

	@Test
	public void FailTest2() {
		Login login = new Login(); //Run the login method
		login.name.setText("KeimmieBooth"); // Set name text field
		login.password.setText("password123"); // Set password text field
		login.submit.doClick();
	}
	
	@Test
	public void FailTest3() {
		Login login = new Login(); //Run the login method
		login.name.setText("Lebron"); // Set name text field
		login.password.setText("jamesteams234"); // Set password text field
		login.submit.doClick();
	}

}
