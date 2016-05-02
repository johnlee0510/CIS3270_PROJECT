package project;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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
	private JButton editUserFlight = new JButton("Edit Users Flight");
	private JButton logout = new JButton("Logout");
	private JButton userprofile = new JButton("Users profile");
	public String username;
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
				new flight_info();
			}
		});
		myFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				try {
					new Myflight(username);
				} catch (SQLException e) {
					//if something went wrong with SQL connection give error
					e.printStackTrace();
				}
			}
		});
		bookFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				new reservation();
			}
		});
		
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				JOptionPane.showMessageDialog(null, "logged out- Good bye");
				main.dispose();
				new login();
				

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
		mainsource.add(editUserFlight);
		mainsource.add(userprofile);
		mainsource.add(logout);
		mainsource.setVisible(true);
		main.setSize(600, 400);
		main.add(mainsource);
		main.setVisible(true);

		userFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				try {
					new User_flight();
				} catch (SQLException e) {
					//if something went wrong with SQL connection give error
					e.printStackTrace();
				}
			}
		});
		
		userprofile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				try {
					new User_profiles();
				} catch (SQLException e) {
					//if something went wrong with SQL connection give error
					e.printStackTrace();
				}
			}
		});
		
		listPlane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				try {
					new plane();
				} catch (SQLException e) {
					//if something went wrong with SQL connection give error
					e.printStackTrace();
				}
			}
		});
		
		listFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				new flight_info();
			}
		});
		
		editUserFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				new reservation();
			}
		});
		
		
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				JOptionPane.showMessageDialog(null, "logged out- Good bye");
				main.dispose();
				new login();

			}
		});

	}

	public MainMenu(String a) {
		System.out.println("hello user");
		customerRun();
	}


	public MainMenu(String rs_username, char a) {
		System.out.println("hello administrator");
		adminRun();
	}

}
