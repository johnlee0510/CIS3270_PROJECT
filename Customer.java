package project;

import java.sql.Connection;
import java.sql.SQLException;

public class Customer extends User {

	Customer() {
		super();
	}

	Customer(String username, String password, String firstName,
			String lastName, String SSN, String emailAddress, String address,
			String state, String zip, String itemBox, String security_question,
			String admin_flag) {
		
		super(username, password, firstName, lastName, SSN, emailAddress,
				address, state, zip, itemBox, security_question,"N");
	}

	@Override
	public void add() throws SQLException {
		Connection connection = DBconnect();
		try {
			String sql = "insert into customer(username, password, firstName, lastName, SSN, emailAddress,"
					+ " address, state, zip, itemBox, security_question,admin_flag)"
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?)";

			prestmt = connection.prepareStatement(sql);

			prestmt.setString(1, getUsername());
			prestmt.setString(2, getPassword());
			prestmt.setString(3, getFirstName());
			prestmt.setString(4, getLastName());
			prestmt.setString(5, getSSN());
			prestmt.setString(6, getEmailAddress());
			prestmt.setString(7, getAddress());
			prestmt.setString(8, getState());
			prestmt.setString(9, getZip());
			prestmt.setString(10, getItemBox());
			prestmt.setString(11, getSecurity_question());
			prestmt.setString(12, getAdmin_flag());

			prestmt.execute();

		} catch (SQLException ex) {

			ex.printStackTrace();

		} catch (Exception ex) {

			ex.printStackTrace();

		} finally {

			connection.close();

		}
	}
}
