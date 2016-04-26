package project;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JFrame;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class forgotPassword extends JFrame{
	private static final long serialVersionUID = 1L;

	public forgotPassword() {
		// creating register table
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));

	}

	void pswd() {
		JTextField newEnterPass = new JPasswordField(15);
		JTextField user = new JTextField(15);
		forgotPassword fg = new forgotPassword();
		fg.add(new JLabel("username"));
		fg.add(user);
		fg.add(new JLabel("                                      "));
		fg.add(new JLabel("Security question"));
		String[] itemComboBox = { "What's your mother's maiden name?",
				"What's your pet's name?",
				"What city were you at when you are 12?",
				"Who was your favorite professor?",
				"What college do you go to?" };
		JComboBox<String> itembox = new JComboBox<String>(itemComboBox);
		fg.add(itembox);
		fg.add(new JLabel("answer security question"));
		JTextField security = new JTextField(20);
		fg.add(security);
		JLabel newPass = new JLabel("enter new password");
		fg.add(newPass);
		fg.add(newEnterPass);

		JButton update = new JButton("update");
		JButton cancel = new JButton("cancel");
		fg.setTitle("Changing Password");
		fg.setSize(550, 300);
		fg.setLocationRelativeTo(null);
		fg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fg.add(update);
		fg.add(cancel);

		fg.setVisible(true);

		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String jdbcUrl = "jdbc:mysql://localhost:3306/java_project?useSSL=false";
					String userId = "root";
					String userPass = "java";
					//System.out.println("0"); //testing out where it gives error
					Connection conn = DriverManager.getConnection(jdbcUrl,
							userId, userPass);
					Statement stmt = conn.createStatement();
					//System.out.println("1"); //testing out where it gives error
					ResultSet rs = stmt.executeQuery("SELECT username, itemBox, "
							+ "security_question "
							+ "FROM user "
							+ "WHERE username = '"
							+ user.getText().trim()
							+ "'");
					//System.out.println("2"); //testing out where it gives error
					while (rs.next()) {
						String rs_username = rs.getString("username");
						String rs_security = rs.getString("security_question");
						String rs_question = rs.getString("itemBox");
						if (user.getText().trim().equalsIgnoreCase(rs_username)
								&& itemComboBox[itembox.getSelectedIndex()]
										.trim().equalsIgnoreCase(rs_question)
								&& security.getText().trim()
										.equalsIgnoreCase(rs_security)) {
							String jdbcUrl_admins = "jdbc:mysql://localhost:3306/java_project?useSSL=false";
							String userId_admins = "root";
							String userPass_admins = "java";
							Connection conn_admins = DriverManager
									.getConnection(jdbcUrl_admins,
											userId_admins, userPass_admins);
							Statement stmt1 = conn_admins.createStatement();
							stmt1.executeUpdate("UPDATE user SET password = '"
									+ newEnterPass.getText().trim()
									+ "' WHERE username= '"
									+ user.getText().trim() + "';");
							JOptionPane.showMessageDialog(null,
									"your password has been changed ");
							fg.dispose();
						} else {

							JOptionPane
									.showMessageDialog(null,
											"your security answer for your username is incorrect!");
						}
					}

				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "check your answer");
				}

			}
		});

		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fg.dispose();
			}
		});

	}
}

	
