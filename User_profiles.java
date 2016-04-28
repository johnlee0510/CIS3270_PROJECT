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

public class User_profiles {

	User_profiles() throws SQLException{
		
		run();	
	}
	

		
	public void run() throws SQLException{
		String jdbcUrl = "jdbc:mysql://localhost:3306/java_project?useSSL=false";
		String userId = "root";
		String userPass = "java";
		Connection conn = DriverManager
				.getConnection(jdbcUrl, userId, userPass);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE admin_flag = 'N'");
		
		String a = "",b = "",c ="",d = "",e ="",f = "",g ="",h = "",i ="",j = "",k ="";    

		DefaultTableModel model;
		model = new DefaultTableModel(); 
		

		model.addColumn("username");
		model.addColumn("password");
		model.addColumn("firstName");
		model.addColumn("lastName");
		model.addColumn("SSN");
		model.addColumn("emailAddress");
		model.addColumn("address");
		model.addColumn("state");
		model.addColumn("zip");
		model.addColumn("security question");
		model.addColumn("security answer");
		

		while(rs.next())  
		{
		    a = rs.getString("username");    
		    b= rs.getString("password");   
		    c= rs.getString("firstName");
		    d= rs.getString("lastName");
		    e= rs.getString("SSN");
		    f= rs.getString("emailAddress");
		    g= rs.getString("address");
		    h= rs.getString("state");
		    i= rs.getString("zip");
		    j= rs.getString("itemBox");
		    k= rs.getString("security_question");
		    
		    model.addRow(new Object[]{a,b,c,d,e,f,g,h,i,j,k});
		}
		JTable table = new JTable(model);
	    table.setPreferredScrollableViewportSize(new Dimension(1000, 200));
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
		jf.setSize(1000,200);
		jf.add(scrollPane, BorderLayout.CENTER);
		jf.add(panelSouth, BorderLayout.SOUTH);
		jf.setVisible(true);
	}
}
