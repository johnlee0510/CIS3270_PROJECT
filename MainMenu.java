package project;
import java.awt.*;


import javax.swing.*;

public class MainMenu extends JFrame {
	private static final long serialVersionUID = 1L;
	private JFrame main;
	private JPanel mainsource;
	private JLabel title = new JLabel("Welcome!"); 
	private JButton listFlight = new JButton("List Flight");
	private JButton myFlight = new JButton("My Flight");
	private JButton bookFlight = new JButton("Add/Update Flight");
	private JButton logout = new JButton("Logout");
	
	public void run(){
		main = new JFrame();
		mainsource = new JPanel();
		mainsource.setLayout(new GridLayout(5,1,5,5));
		mainsource.add(title);
		mainsource.add(listFlight);
		mainsource.add(myFlight);
		mainsource.add(bookFlight);
		mainsource.add(logout);
		mainsource.setVisible(true);
		main.setSize(600,400);
		main.add(mainsource);
		main.setVisible(true);
		
	}
	
	public MainMenu(String a) {
		System.out.println("hello administrator");
		
	}
	public MainMenu(char a){
		System.out.println("hello user");
		run();
	}


}
