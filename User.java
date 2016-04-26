package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class User implements DBconnector {
	PreparedStatement prestmt;
	private String username, password, firstName, lastName, SSN, emailAddress,
			address, state, zip, itemBox, security_question, admin_flag;

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSSN() {
		return SSN;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getAddress() {
		return address;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}

	public String getItemBox() {
		return itemBox;
	}

	public String getSecurity_question() {
		return security_question;
	}

	public String getAdmin_flag() {
		return admin_flag;
	}

	// default constructor
	User() {

	}

	User(String username, String password, String firstName, String lastName,
			String SSN, String emailAddress, String address, String state,
			String zip, String itemBox, String security_question,String admin_flag) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.SSN = SSN;
		this.emailAddress = emailAddress;
		this.address = address;
		this.state = state;
		this.zip = zip;
		this.itemBox = itemBox;
		this.security_question = security_question;
		this.admin_flag = admin_flag;
	}

	@Override
	public Connection DBconnect() throws SQLException {
		System.out.println("Connecting Database");
		String jdbcUrl = "jdbc:mysql://localhost:3306/java_project?useSSL=false";
		String userId = "user";
		String userPass = "java";
		// Connection
		Connection conn = DriverManager
				.getConnection(jdbcUrl, userId, userPass);
		return conn;
	}

	@Override
	public void add() throws SQLException {
		Connection connection = DBconnect();
		try {
			String sql = "insert into user(username, password, firstName, lastName, SSN, emailAddress,"
					+ " address, state, zip, itemBox, security_question,admin_flag) "
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

	@Override
	public void update() throws SQLException {
		DBconnect();
	}

	@Override
	public void delete() throws SQLException {
		DBconnect();

	}

}
