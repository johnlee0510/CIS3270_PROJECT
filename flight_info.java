package project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class flight_info {
	private JFrame jf = new JFrame();
	private JPanel pn = new JPanel();
	private JPanel panelSouth = new JPanel();
	private JButton ok = new JButton("ok");
	private JLabel title = new JLabel("List of Flights: Please remember Flight ID for the booking");
	
	public flight_info(){
		list();
	}

	public void list() {
		pn.setLayout(new FlowLayout());
		String[] column = { "flight id", "Departure From", "Arrival To",
				"Dep Time", "Arrival Time", "Date", "plane id" };
		Object data[][] = {
				{ "AFX6134", "Atlanta", "Cincinnati", "7:56 PM", "11:56 PM",
						"05/03/16", "P001" },
				{ "AFE9135", "Atlanta", "Chicago-Mdw", "9:46 PM", "11:46 PM",
						"05/03/16", "P002" },
				{ "FEJ1251", "Atlanta", "Detroit", "10:15 PM", "12:15 AM",
						"05/03/16", "P003" },
				{ "GHR9123", "Atlanta", "Birmingham", "11:18 PM", "12:18 AM",
						"05/03/16", "P004" },
				{ "HHA8512", "Atlanta", "Cincinnati", "7:35 PM", "10:15 PM",
						"05/03/16", "P005" },
				{ "AXJ1238", "Atlanta", "Buenos Aires", "10:13 PM", "8:13 AM",
						"05/04/16", "P002" },
				{ "JGR0919", "Savannah", "Jacksonville, F", "11:25 PM",
						"12:25 AM", "05/04/16", "P001" },
				{ "KLJ1230", "Augusta", "Oklahoma City", "9:05 PM", "11:05 PM",
						"05/04/16", "P005" },
				{ "JFL9589", "Charlotte, Nc", "Birmingham", "10:10 PM",
						"11:00 PM", "05/04/16", "P002" },
				{ "JKL1209", "Augusta", "Austin", "9:18 PM", "11:51 PM",
						"05/04/16", "P003" },
				{ "FJE1514", "Augusta", "Cincinnati", "9:12 PM", "11:12 PM",
						"05/04/16", "P004" },
				{ "JFG9841", "Albany, Ny", "Omaha", "9:16 PM", "11:16 PM",
						"05/05/16", "P002" },
				{ "FEH9812", "Atlanta", "Ft.Lauderdale", "10:00 PM",
						"11:55 PM", "05/05/16", "P001" },
				{ "JXF2149", "Ft.Lauderdale", "Chattanooga", "7:42 PM",
						"8:12 PM", "05/05/16", "P002" },
				{ "HRF8916", "Atlanta", "Newport News", "9:20 PM", "10:55 PM",
						"05/05/16", "P004" } };
		JTable table = new JTable(data, column);
		table.setPreferredScrollableViewportSize(new Dimension(550, 200));
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		pn.add(title);
		pn.add(scrollPane);
		panelSouth.add(ok);
		panelSouth.setVisible(true);
		jf.add(pn);
		jf.add(panelSouth, BorderLayout.SOUTH);
		jf.setSize(600, 350);
		jf.setVisible(true);
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				jf.dispose();
			new MainMenu('a');
			}
		});
	}
}
