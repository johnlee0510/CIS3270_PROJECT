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

public class plane {
	Statement stmt;
	public plane() throws SQLException {
		run();
	}
		
	public void run() throws SQLException{
		String jdbcUrl = "jdbc:mysql://localhost:3306/java_project?useSSL=false";
		String userId = "root";
		String userPass = "java";
		Connection conn = DriverManager
				.getConnection(jdbcUrl, userId, userPass);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM plane");

		
		String i = "",n = "",c ="";    

		DefaultTableModel model;
		model = new DefaultTableModel(); 
		

		model.addColumn("plane_id");
		model.addColumn("plane_name");
		model.addColumn("capacity");

		while(rs.next())  
		{
		    i = rs.getString("plane_id");    
		    n= rs.getString("plane_name");   
		    c= rs.getString("capacity");   
		    model.addRow(new Object[]{i,n,c});
		}
		JTable table = new JTable(model);
	    table.setPreferredScrollableViewportSize(new Dimension(350, 500));
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);   
	    table.setVisible(true);
	    JFrame jf = new JFrame();
	    jf.setTitle("java plane information");
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
		jf.setSize(350,200);
		jf.add(scrollPane, BorderLayout.CENTER);
		jf.add(panelSouth, BorderLayout.SOUTH);
		jf.setVisible(true);

	}
	}


