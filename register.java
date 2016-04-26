package project;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class register extends JFrame implements DBconnector {
	private static final long serialVersionUID = 1L;
	// statement for executing queries
	private JTextField username = new JTextField(20);
	private JTextField password = new JPasswordField(15);
	private JTextField firstName = new JTextField(10);
	private JTextField lastName = new JTextField(10);
	private JTextField SSN = new JPasswordField(12);
	private JTextField emailAddress = new JTextField(40);
	private JTextField address = new JTextField(45);
	private JTextField state = new JTextField(2);
	private JTextField zip = new JTextField(5);
	private JTextField security_question = new JTextField(30);
	private Statement stmt = null;
	public ResultSet rs = null;
	private String[] itemComboBox = { "What's your mother's maiden name?",
			"What's your pet's name?",
			"What city were you at when you are 12?",
			"Who was your favorite professor?", "What college do you go to?" };
	private JComboBox<String> itembox = new JComboBox<String>(itemComboBox);

	public register() {
		// creating register table
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));

	}

	public void run() {
		register frame = new register();
		frame.add(new JLabel("username"));
		frame.add(username);
		frame.add(new JLabel("password"));
		frame.add(password);
		frame.add(new JLabel("First Name"));
		frame.add(firstName);
		frame.add(new JLabel("Last Name"));
		frame.add(lastName);
		frame.add(new JLabel("SSN"));
		frame.add(SSN);
		frame.add(new JLabel("emailAddress"));
		frame.add(emailAddress);
		frame.add(new JLabel("Address"));
		frame.add(address);
		frame.add(new JLabel("state"));
		frame.add(state);
		frame.add(new JLabel(" zip"));
		frame.add(zip);
		frame.add(new JLabel("security question"));
		frame.add(itembox);
		frame.add(new JLabel("answer security question"));
		frame.add(security_question);
		frame.setTitle("Register");
		frame.setSize(650, 420);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		JButton comfirm = new JButton("Comfirm");
		JButton cancel = new JButton("Cancel");

		comfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = username.getText().trim();
				String pass = password.getText().trim();
				String first = firstName.getText().trim();
				String last = lastName.getText().trim();
				String s = SSN.getText().trim();
				String ea = emailAddress.getText().trim();
				String a = address.getText().trim();
				String st = state.getText().trim();
				String z = zip.getText().trim();
				String ib = itemComboBox[itembox.getSelectedIndex()].trim();
				String se = security_question.getText().trim();
				String af = "N";
				Customer c1 = new Customer(user, pass, first, last, s, ea, a,
						st, z, ib, se, af);

				try {
					c1.add();
				} catch (SQLException e1) {
					System.out.println("error!");
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		comfirm.setSize(400, 800);
		cancel.setSize(400, 800);
		JPanel panelSouth = new JPanel();
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout(100, 200));
		panelSouth.add(comfirm);
		panelSouth.add(cancel);
		panelSouth.setVisible(true);

		frame.add(panelCenter, BorderLayout.CENTER);
		frame.add(panelSouth, BorderLayout.SOUTH);
		frame.setVisible(true);

	}

	@Override
	public Connection DBconnect() throws SQLException {
		System.out.println("Connecting Database");
		String jdbcUrl = "jdbc:mysql://localhost:3306/java_project?useSSL=false";
		String userId = "root";
		String userPass = "java";
		// Connection
		Connection conn = DriverManager
				.getConnection(jdbcUrl, userId, userPass);
		return conn;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void add() throws SQLException {
		try {

			stmt = DBconnect().createStatement();

			String sql = "INSERT INTO user(username, password, firstName, lastName, SSN, emailAddress,"
					+ " address, state, zip, itemBox, security_question, admin_flag)"
					+ "VALUES ('"
					+ username.getText().trim()
					+ "','"
					+ password.getText().trim()
					+ "','"
					+ firstName.getText().trim()
					+ "','"
					+ lastName.getText().trim()
					+ "','"
					+ SSN.getText().trim()
					+ "','"
					+ emailAddress.getText().trim()
					+ "','"
					+ address.getText().trim()
					+ "','"
					+ state.getText().trim()
					+ "','"
					+ zip.getText().trim()
					+ "','"
					+ itemComboBox[itembox.getSelectedIndex()].trim()
					+ "','"
					+ security_question.getText().trim() + "', 'N')";

			String ssn_reg = "[\\d]{3}-?[\\d]{2}-?[\\d]{4}";
			String email_reg = ".+@.+[\\.].+";
			if (SSN.getText().matches(ssn_reg)
					&& emailAddress.getText().matches(email_reg)) {
				stmt.execute(sql);
				JOptionPane.showMessageDialog(null,
						"Account created, please login");
				stmt.close();

			} else {
				JOptionPane.showMessageDialog(null,
						"your information is invalid");
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "your code is wrong.");
		}
	}

}
