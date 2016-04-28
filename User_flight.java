package project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class User_flight {
	public User_flight() throws SQLException{
		run();
	}
	public void run() throws SQLException{
		String jdbcUrl = "jdbc:mysql://localhost:3306/java_project?useSSL=false";
		String userId = "root";
		String userPass = "java";
		Connection conn = DriverManager
				.getConnection(jdbcUrl, userId, userPass);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ticket_info");
		
		String a = "",b = "",c ="",d = "",e ="",f = "",g ="",h = "",i ="",j = "";    

		DefaultTableModel model;
		model = new DefaultTableModel(); 
		

		model.addColumn("username");
		model.addColumn("flight id");
		model.addColumn("firstName");
		model.addColumn("lastName");
		model.addColumn("departure from");
		model.addColumn("arrival to");
		model.addColumn("departure time");
		model.addColumn("arrival time");
		model.addColumn("date");
		model.addColumn("plane name");

		while(rs.next())  
		{
		    a = rs.getString("username");    
		    b= rs.getString("flight_id");   
		    c= rs.getString("firstName");
		    d= rs.getString("lastName");
		    e= rs.getString("departure_from");
		    f= rs.getString("arrival_to");
		    g= rs.getString("departure");
		    h= rs.getString("arrival");
		    i= rs.getString("date_info");
		    j= rs.getString("plane_name");
		   
		    model.addRow(new Object[]{a,b,c,d,e,f,g,h,i,j});
		}
		JTable table = new JTable(model);
	    table.setPreferredScrollableViewportSize(new Dimension(1000, 200));
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);   
	    table.setVisible(true);
	    JFrame jf = new JFrame();
	    jf.setTitle("Users flight informations");
	    JButton goback = new JButton("Main Menu");
	    
	    goback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
			}
		});
		goback.setSize(40, 80);
		JPanel panelSouth = new JPanel();
		panelSouth.add(goback);
		panelSouth.setVisible(true);
		jf.setSize(1000,200);
		jf.add(scrollPane, BorderLayout.CENTER);
		jf.add(panelSouth, BorderLayout.SOUTH);
		jf.setVisible(true);
	}
}
