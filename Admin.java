// admin will be already created with admin_flag Y
package project;

public class Admin extends Customer {
	Admin() {
		super();
	}

	Admin(String username, String password, String firstName, String lastName,
			String SSN, String emailAddress, String address, String state,
			String zip, String itemBox, String security_question, String admin_flag) {
		super(username, password, firstName, lastName, SSN, emailAddress,
				address, state, zip, itemBox, security_question, "Y");

	}

}
