
//main class
package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public  class login extends JPanel {

	public ResultSet rs = null;
	 
	private static final long serialVersionUID = 1L;
	public login(){
		run();
		}

	public void run() {

		JFrame jf = new JFrame();
		jf.setLayout(new BorderLayout());
		jf.setSize(500, 150);
		jf.setName("Java Airline");
		JLabel title = new JLabel("Welcome to Java Airline");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		// putting the title label into the pane
		jf.add("North", title);

		JLabel user = new JLabel("username");
		JLabel pass = new JLabel("password");
		JTextField username = new JTextField(10);
		JTextField password = new JPasswordField(10);

		JPanel panelCenter = new JPanel();
		JPanel panelSouth = new JPanel();
		JButton task1 = new JButton("login");
		JButton task2 = new JButton("register");
		JButton task3 = new JButton("forgot pswd?");
		JButton task4 = new JButton("cancel");

		panelCenter.add(user);
		panelCenter.add(username);
		panelCenter.add(pass);
		panelCenter.add(password);
		panelSouth.setVisible(true);
		panelCenter.setVisible(true);
		jf.add(panelCenter, BorderLayout.CENTER);
		jf.add(panelSouth, BorderLayout.SOUTH);
		panelSouth.add(task1);
		task1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				try {
					String jdbcUrl = "jdbc:mysql://localhost:3306/java_project?useSSL=false";
					 String userId = "root";
					 String userPass = "java";
					Connection conn = DriverManager.getConnection(jdbcUrl,
							userId, userPass);
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt
							.executeQuery("SELECT username, password FROM user WHERE username = '"
									+ username.getText() + "'");
					
					while (rs.next()) {
						String rs_username = rs.getString("username");
						String rs_password = rs.getString("password");
						String rs_admin = rs.getString("admin_flag");
						if (username.getText().equalsIgnoreCase(rs_username)
								&& password.getText().equals(rs_password)
								&& rs_admin.equals("N")) {
							JOptionPane.showMessageDialog(null, "Hi "
									+ username.getText());
							// new flight();
							new MainMenu('a');
							jf.dispose();
						} else if (username.getText().equalsIgnoreCase(
								rs_username)
								&& password.getText().equals(rs_password)
								&& rs_admin.equals("Y")) {
							JOptionPane.showMessageDialog(null,
									"Hi administrator");
							
						new	MainMenu("a");
						} else {
							JOptionPane.showMessageDialog(null,
									"invalid id or password");
						}
					}
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null,
							"Something is wrong");
				}
			}
		});

		panelSouth.add(task2);

		task2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				register reg = new register();
				reg.run();

			}
		});
		panelSouth.add(task3);
		task3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
			forgotPassword fg = new forgotPassword();
				fg.pswd();
			}
		});

		panelSouth.add(task4);
		task4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				System.exit(0);
			}
		});
		jf.setVisible(true);
	}
}
