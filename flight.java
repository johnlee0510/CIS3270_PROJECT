package project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class flight extends JFrame {
	private static final long serialVersionUID = 1L;

	// public static void main(String[] args) {

	flight() {
		JFrame c = new JFrame();
		c.setLayout(new BorderLayout());
		String[] frominfo = { "", "Atlanta" };
		String[] toinfo = { "", "Buenos Aires", "Jacksonville, F",
				"Charlotte, Nc", "Cincinnati", "Oklahoma City", "Greensboro",
				"Birmingham", "Austin", "Chicago-Mdw", "Detroit",
				"Dallas (Love)", "Chattanooga", "Newport News", "Albany, Ny",
				"Omaha", "Ft.Lauderdale", "Fort Myers", "Augusta", "Orlando",
				"Allentown", "Ft.Walton Beach", "Akron/Canton",
				"Charleston, Sc", "Charlottesville", "Norfolk", "Dallas - Dfw",
				"Fayetteville, N", "Dublin", "Flint Michigan", "Newark",
				"Orange County", "Baltimore", "Des Moines", "Boston",
				"Chicago-O`Hare", "Gainesville", "New York-Lga", "Albuquerque",
				"Cleveland", "Green Bay", "El Paso", "Dayton", "Daytona Beach",
				"Panama City, Fl", "Buffalo", "Asheville", "Grand Rapids",
				"Appleton", "Northwest, Ar", "Evansville", "Ft Wayne",
				"Fort Hood", "Cedar Rapids", "Baton Rouge", "Dothan",
				"Albany, Ga", "Alexandria, La", "Burlington", "Bloomington",
				"Fort Smith", "Brunswick", "Amsterdam", "Charleston, Wv",
				"Denver" };
		String[] classinfo = { "", "Economic", "Business", "First" };
		String[] dateinfo = { "", "5/2/16", "5/3/16", "5/4/16", "5/5/16",
				"5/6/16" };

		c.setSize(new Dimension(1280, 800));

		JLabel bookingDetails = new JLabel("Booking Details     ");
		JLabel From = new JLabel("        From          :");
		JComboBox<String> from = new JComboBox<String>(frominfo);
		JLabel To = new JLabel("        To               :");
		JComboBox<String> to = new JComboBox<String>(toinfo);
		JLabel bookingDate = new JLabel("        Available Date:");
		JLabel Class = new JLabel("        Class         :");
		JComboBox<String> cls = new JComboBox<String>(classinfo);
		JComboBox<String> textBookingdate = new JComboBox<String>(dateinfo);
		// JTextField textBookingdate = new JTextField(6);
		// JLabel exDate = new JLabel("(DD/MM/YYYY)");
		JButton ticketInfo = new JButton("ticket info");
		bookingDetails.setBounds(200, 3, 100, 20);
		From.setBounds(10, 40, 100, 20);
		To.setBounds(10, 100, 100, 20);
		bookingDate.setBounds(10, 160, 100, 20);
		textBookingdate.setBounds(10, 160, 100, 20);
		Class.setBounds(10, 500, 100, 20);
		;
		ticketInfo.setSize(10, 10);

		JPanel panelLeft = new JPanel();
		c.add(panelLeft, BorderLayout.WEST);
		panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
		panelLeft.add(bookingDetails);
		panelLeft.add(From);
		panelLeft.add(from);
		panelLeft.add(To);
		panelLeft.add(to);
		panelLeft.add(bookingDate);
		panelLeft.add(textBookingdate);
		panelLeft.add(Class);
		panelLeft.add(cls);

		JPanel panelSouth = new JPanel();
		c.add(panelSouth, BorderLayout.SOUTH);
		panelSouth.add(ticketInfo);

		JPanel panelCenter = new JPanel();
		c.add(panelCenter, BorderLayout.CENTER);

		JTable table = new JTable();
		// setLayout(new FlowLayout());
		String[] column = { "Flight ID", "Departure From", "Arrival To",
				"Dep. Time", "Arrival Time", "Date" };

		Object[][] data = {
				{"AL 1011","Atlanta","Buenos Aires","10:13 PM","8:13 AM","05/04/16"},
				{"AL 1070","Atlanta","Jacksonville, F","11:25 PM","12:25 AM","05/04/16"},
				{"AL 1076","Atlanta","Charlotte, Nc","9:00 PM","9:00 PM","05/03/16"},
				{"AL 1126","Atlanta","Cincinnati","10:20 PM","12:56 AM","05/06/16"},
				{"AL 1184","Atlanta","Oklahoma City","9:05 PM","11:05 PM","05/04/16"},
				{"AL 1202","Atlanta","Greensboro","7:16 PM","8:30 PM","05/04/16"},
				{"AL 1224","Atlanta","Birmingham","10:10 PM","11:00 PM","05/02/16"},
				{"AL 1273","Atlanta","Austin","9:18 PM","11:51 PM","05/04/16"},
				{"AL 1282","Atlanta","Chicago-Mdw","9:46 PM","11:46 PM","05/03/16"},
				{"AL 1290","Atlanta","Detroit","10:15 PM","12:15 AM","05/03/16"},
				{"AL 1299","Atlanta","Birmingham","11:18 PM","12:18 AM","05/03/16"},
				{"AL 1309","Atlanta","Dallas (Love)","9:12 PM","11:12 PM","05/04/16"},
				{"AL 1339","Atlanta","Chattanooga","7:42 PM","8:12 PM","05/05/16"},
				{"AL 1346","Atlanta","Newport News","9:20 PM","10:55 PM","05/06/16"},
				{"AL 1368","Atlanta","Albany, Ny","7:56 PM","11:56 PM","05/02/16"},
				{"AL 1376","Atlanta","Omaha","9:16 PM","11:16 PM","05/04/16"},
				{"AL 1417","Atlanta","Cincinnati","7:35 PM","10:15 PM","05/03/16"},
				{"AL 1427","Atlanta","Ft.Lauderdale","10:00 PM","11:55 PM","05/04/16"},
				{"AL 1433","Atlanta","Fort Myers","7:49 PM","10:00 PM","05/04/16"},
				{"AL 1441","Atlanta","Charlotte, Nc","11:15 PM","12:25 AM","05/02/16"},
				{"AL 1451","Atlanta","Augusta","7:40 PM","8:40 PM","05/04/16"},
				{"AL 1461","Atlanta","Ft.Lauderdale","11:15 PM","1:15 AM","05/02/16"},
				{"AL 1465","Atlanta","Detroit","8:57 PM","11:00 PM","05/04/16"},
				{"AL 1469","Atlanta","Orlando","8:55 PM","11:10 PM","05/04/16"},
				{"AL 1472","Atlanta","Allentown","9:08 PM","10:08 PM","05/02/16"},
				{"AL 1497","Atlanta","Ft.Walton Beach","10:25 PM","11:25 PM","05/03/16"},
				{"AL 1571","Atlanta","Akron/Canton","9:20 PM","10:00 PM","05/02/16"},
				{"AL 1607","Atlanta","Charleston, Sc","7:29 PM","8:35 PM","05/02/16"},
				{"AL 1624","Atlanta","Charlottesville","7:56 PM","9:30 PM","05/04/16"},
				{"AL 1657","Atlanta","Ft.Lauderdale","8:45 PM","10:45 PM","05/06/16"},
				{"AL 1669","Atlanta","Jacksonville, F","10:25 PM","11:45 PM","05/02/16"},
				{"AL 1698","Atlanta","Norfolk","7:31 PM","11:00 PM","05/04/16"},
				{"AL 1711","Atlanta","Dallas - Dfw","10:20 PM","12:20 AM","05/02/16"},
				{"AL 1742","Atlanta","Fayetteville, N","9:16 PM","10:36 PM","05/05/16"},
				{"AL 176","Atlanta","Dublin","7:30 PM","2:30 AM","05/02/16"},
				{"AL 1765","Atlanta","Charlotte, Nc","7:50 PM","9:00 PM","05/03/16"},
				{"AL 1766","Atlanta","Flint Michigan","9:20 PM","11:38 PM","05/03/16"},
				{"AL 1769","Atlanta","Orlando","11:15 PM","12:50 AM","05/03/16"},
				{"AL 1798","Atlanta","Newark","8:45 PM","10:45 PM","05/06/16"},
				{"AL 1819","Atlanta","Orange County","8:25 PM","12:45 AM","05/06/16"},
				{"AL 1861","Atlanta","Orlando","7:25 PM","9:25 PM","05/02/16"},
				{"AL 1911","Atlanta","Dallas - Dfw","8:50 PM","10:50 PM","05/04/16"},
				{"AL 1924","Atlanta","Baltimore","10:06 PM","12:06 AM","05/03/16"},
				{"AL 1953","Atlanta","Des Moines","9:06 PM","11:06 PM","05/03/16"},
				{"AL 1968","Atlanta","Charleston, Sc","8:52 PM","9:52 PM","05/03/16"},
				{"AL 1980","Atlanta","Norfolk","10:24 PM","12:00 AM","05/03/16"},
				{"AL 2024","Atlanta","Baltimore","7:09 PM","9:09 PM","05/04/16"},
				{"AL 2063","Atlanta","Jacksonville, F","9:00 PM","10:15 PM","05/06/16"},
				{"AL 2100","Atlanta","Boston","7:25 PM","10:25 PM","05/03/16"},
				{"AL 2112","Atlanta","Chicago-O`Hare","7:25 PM","9:25 PM","05/02/16"},
				{"AL 2158","Atlanta","Gainesville","7:39 PM","8:39 PM","05/06/16"},
				{"AL 2173","Atlanta","Detroit","7:05 PM","9:15 PM","05/06/16"},
				{"AL 2186","Atlanta","New York-Lga","7:45 PM","9:00 PM","05/03/16"},
				{"AL 2207","Atlanta","Charleston, Sc","11:15 PM","12:30 AM","05/04/16"},
				{"AL 2216","Atlanta","Albuquerque","7:41 PM","10:41 PM","05/02/16"},
				{"AL 2228","Atlanta","Austin","7:56 PM","10:56 PM","05/02/16"},
				{"AL 2241","Atlanta","Chicago-O`Hare","9:00 PM","11:30 PM","05/03/16"},
				{"AL 2254","Atlanta","Cleveland","8:57 PM","11:17 PM","05/02/16"},
				{"AL 2275","Atlanta","Norfolk","8:59 PM","10:59 PM","05/02/16"},
				{"AL 2286","Atlanta","Green Bay","7:24 PM","9:30 PM","05/06/16"},
				{"AL 2291","Atlanta","Cleveland","7:27 PM","9:00 PM","05/03/16"},
				{"AL 2293","Atlanta","El Paso","7:50 PM","11:00 PM","05/02/16"},
				{"AL 2300","Atlanta","Boston","10:11 PM","1:11 AM","05/04/16"},
				{"AL 2306","Atlanta","Dayton","10:08 PM","12:08 AM","05/02/16"},
				{"AL 2327","Atlanta","Ft.Lauderdale","7:15 PM","9:15 PM","05/03/16"},
				{"AL 2383","Atlanta","Birmingham","7:29 PM","8:29 PM","05/04/16"},
				{"AL 2386","Atlanta","New York-Lga","9:30 PM","11:30 PM","05/03/16"},
				{"AL 2408","Atlanta","Daytona Beach","8:00 PM","10:20 PM","05/02/16"},
				{"AL 2415","Atlanta","Newark","10:05 PM","11:59 PM","05/04/16"},
				{"AL 2431","Atlanta","Panama City, Fl","7:41 PM","8:41 PM","05/03/16"},
				{"AL 2473","Atlanta","Buffalo","9:08 PM","11:08 PM","05/03/16"},
				{"AL 251","Atlanta","Asheville","10:28 PM","12:28 AM","05/04/16"},
				{"AL 2516","Atlanta","Ft.Walton Beach","7:35 PM","8:35 PM","05/04/16"},
				{"AL 2519","Atlanta","Grand Rapids","9:10 PM","11:00 PM","05/04/16"},
				{"AL 2529","Atlanta","Cleveland","10:09 PM","12:09 AM","05/02/16"},
				{"AL 2562","Atlanta","Appleton","7:20 PM","9:20 PM","05/02/16"},
				{"AL 257","Atlanta","Chattanooga","9:16 PM","9:46 PM","05/03/16"},
				{"AL 2586","Atlanta","Orlando","10:15 PM","12:15 AM","05/06/16"},
				{"AL 2587","Atlanta","Daytona Beach","10:18 PM","12:48 AM","05/03/16"},
				{"AL 2606","Atlanta","Fort Myers","9:15 PM","11:15 PM","05/06/16"},
				{"AL 2608","Atlanta","Northwest, Ar","9:16 PM","11:16 PM","05/06/16"},
				{"AL 2612","Atlanta","Evansville","9:21 PM","10:45 PM","05/03/16"},
				{"AL 2655","Atlanta","Fort Myers","11:15 PM","1:15 AM","05/03/16"},
				{"AL 2816","Atlanta","Augusta","9:12 PM","10:12 PM","05/03/16"},
				{"AL 2837","Atlanta","Oklahoma City","7:19 PM","9:19 PM","05/06/16"},
				{"AL 29","Atlanta","Dallas - Dfw","7:15 PM","9:15 PM","05/03/16"},
				{"AL 4801","Atlanta","Ft Wayne","7:44 PM","8:44 PM","05/06/16"},
				{"AL 504","Atlanta","Newark","7:25 PM","9:25 PM","05/04/16"},
				{"AL 5048","Atlanta","Fort Hood","7:22 PM","9:42 PM","05/03/16"},
				{"AL 5063","Atlanta","Cedar Rapids","7:44 PM","9:50 PM","05/05/16"},
				{"AL 507","Atlanta","Panama City, Fl","10:18 PM","11:45 PM","05/03/16"},
				{"AL 5081","Atlanta","Baton Rouge","8:50 PM","11:50 PM","05/02/16"},
				{"AL 5093","Atlanta","Dothan","7:46 PM","9:00 PM","05/04/16"},
				{"AL 5096","Atlanta","Albany, Ga","9:21 PM","10:21 PM","05/03/16"},
				{"AL 5137","Atlanta","Baton Rouge","7:15 PM","9:15 PM","05/04/16"},
				{"AL 5142","Atlanta","Asheville","8:54 PM","10:54 PM","05/05/16"},
				{"AL 5156","Atlanta","Alexandria, La","9:07 PM","11:07 PM","05/02/16"},
				{"AL 5159","Atlanta","Chattanooga","11:15 PM","11:50 PM","05/06/16"},
				{"AL 5247","Atlanta","Baton Rouge","10:08 PM","1:11 AM","05/05/16"},
				{"AL 5274","Atlanta","Augusta","11:16 PM","12:16 AM","05/04/16"},
				{"AL 5316","Atlanta","Burlington","7:31 PM","10:05 PM","05/05/16"},
				{"AL 5328","Atlanta","Gainesville","10:30 PM","11:30 PM","05/03/16"},
				{"AL 5329","Atlanta","Bloomington","9:27 PM","10:37 PM","05/06/16"},
				{"AL 5520","Atlanta","Fort Smith","9:26 PM","11:26 PM","05/04/16"},
				{"AL 5529","Atlanta","Brunswick","7:48 PM","8:48 PM","05/02/16"},
				{"AL 736","Atlanta","Chicago-O`Hare","10:25 PM","12:25 AM","05/05/16"},
				{"AL 74","Atlanta","Amsterdam","7:35 PM","9:35 PM","05/03/16"},
				{"AL 880","Atlanta","Baltimore","8:50 PM","11:50 PM","05/02/16"},
				{"AL 903","Atlanta","Boston","8:50 PM","12:10 AM","05/02/16"},
				{"AL 916","Atlanta","Chicago-Mdw","7:45 PM","9:45 PM","05/02/16"},
				{"AL 9375","Atlanta","Amsterdam","10:30 PM","11:30 PM","05/04/16"},
				{"AL 993","Atlanta","Charleston, Wv","9:22 PM","10:50 PM","05/04/16"},
				{"AL 996","Atlanta","Denver","9:04 PM","12:04 AM","05/05/16"} };
		table = new JTable(data, column);
		table.setPreferredScrollableViewportSize(new Dimension(640, 400));
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		panelCenter.add(scrollPane);

		// panelCenter.add();
		c.setVisible(true);

	}
}
