package project;
import java.awt.*;


import javax.swing.*;

public class MainMenu extends JFrame {
private static final long serialVersionUID = 1L;
	private JFrame main;
	private JPanel mainsource;
	private JLabel title_cus = new JLabel("Welcome Customer!");
	private JLabel title_admin = new JLabel("Welcome Administrator!");
	private JButton listFlight = new JButton("List Flights");
	private JButton myFlight = new JButton("My Flight");
	private JButton listPlane = new JButton("List Planes");
	private JButton userFlight = new JButton("Users Flight");
	private JButton bookFlight = new JButton("Add/Update Flight");
	private JButton logout = new JButton("Logout");
	private JButton userprofile = new JButton("Users profile");

	public void customerRun() {
		main = new JFrame();
		mainsource = new JPanel();
		mainsource.setLayout(new GridLayout(5, 1, 5, 5));
		mainsource.add(title_cus);
		mainsource.add(listFlight);
		mainsource.add(bookFlight);
		mainsource.add(myFlight);
		mainsource.add(logout);
		mainsource.setVisible(true);
		main.setSize(600, 400);
		main.add(mainsource);
		main.setVisible(true);

		listFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				main.dispose();
				new flight_info();
			}
		});

		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				JOptionPane.showMessageDialog(null, "logged out- Good bye");
				System.exit(0);

			}
		});

	}

	public void adminRun() {
		main = new JFrame();
		mainsource = new JPanel();
		mainsource.setLayout(new GridLayout(7, 1, 5, 5));
		mainsource.add(title_admin);
		mainsource.add(listPlane);
		mainsource.add(listFlight);
		mainsource.add(userFlight);
		mainsource.add(userprofile);
		mainsource.add(logout);
		mainsource.setVisible(true);
		main.setSize(600, 400);
		main.add(mainsource);
		main.setVisible(true);

		listFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				main.dispose();
				new flight_info();
			}
		});
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				JOptionPane.showMessageDialog(null, "logged out- Good bye");
				System.exit(0);

			}
		});

	}

	public MainMenu(char a) {
		System.out.println("hello user");
		customerRun();
	}

	public MainMenu(String a) {
		System.out.println("hello administrator");
		adminRun();
	}

}
