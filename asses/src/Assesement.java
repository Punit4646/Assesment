import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;	

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

// Create Class AddCourse for Performed Add Course Action.
class AddCourse implements ActionListener {
	JLabel l1, l2, l3, l4, l5, l6;
	JTextField t1, t2, t3, t4, t5;
	JButton b6;

	// Create Constructor
	AddCourse() {
		// Set Frame Dimension, Visibility & Layout
		JFrame fr1 = new JFrame("Add Course");
		fr1.setVisible(true);
		fr1.setLayout(null);
		fr1.setSize(1000, 700);

		l1 = new JLabel("Course ID");
		l1.setBounds(100, 100, 150, 20);
		fr1.add(l1);
		l2 = new JLabel("Course Name");
		l2.setBounds(100, 130, 150, 20);
		fr1.add(l2);
		l3 = new JLabel("Course Fees");
		l3.setBounds(100, 160, 150, 20);
		fr1.add(l3);
		l4 = new JLabel("Course Duration");
		l4.setBounds(100, 190, 150, 20);
		fr1.add(l4);
		l5 = new JLabel("Course Detail");
		l5.setBounds(100, 220, 150, 20);
		fr1.add(l5);
		l6 = new JLabel("");
		l6.setBounds(175, 300, 200, 20);
		fr1.add(l6);

		t1 = new JTextField();
		t1.setBounds(250, 100, 150, 20);
		fr1.add(t1);
		t2 = new JTextField();
		t2.setBounds(250, 130, 150, 20);
		fr1.add(t2);
		t3 = new JTextField();
		t3.setBounds(250, 160, 150, 20);
		fr1.add(t3);
		t4 = new JTextField();
		t4.setBounds(250, 190, 150, 20);
		fr1.add(t4);
		t5 = new JTextField();
		t5.setBounds(250, 220, 150, 20);
		fr1.add(t5);

		b6 = new JButton("Submit");
		b6.setBounds(175, 260, 150, 20);
		fr1.add(b6);

		// Make Button Clicked To EventTable
		b6.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// If User Clicked Submit Button Than Registration Action Performed.
		if (e.getSource() == b6) {
			System.out.println("Submit button clicked.");

			// Fetch Data From User Input
			int ID = Integer.parseInt(t1.getText());
			String Name = t2.getText();
			int Fees = Integer.parseInt(t3.getText());
			String Duration = t4.getText();
			String Detail = t5.getText();

			try {
				// Provide Connectivity : User Input Is Stored Into Database Table
				Connection connection = Assesement.createconnection();
				String sql = "insert into course (ID, Name, Fees, Duration, Detail) values (?,?,?,?,?)";
				PreparedStatement pst = connection.prepareStatement(sql);

				// Data Set Into Table
				pst.setInt(1, ID);
				pst.setString(2, Name);
				pst.setInt(3, Fees);
				pst.setString(4, Duration);
				pst.setString(5, Detail);
				pst.executeUpdate();

				// If Registration Successfully, than Print Message & SetText Empty.
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				l6.setText("Registration Succesfully.");
			} catch (Exception e2) {
				// If Exception Is Generated Than Handle by printStackTrace.
				e2.printStackTrace();
			}
		}
	}
}

//Create Class ViewCourse for Performed View all Course on Console Screen.
class ViewCourse implements ActionListener {

	JLabel l1;
	JButton b1;

	// Create Constructor
	ViewCourse() {
		// Set Frame Dimension, Visibility & Layout
		JFrame fr1 = new JFrame("View Course");
		fr1.setVisible(true);
		fr1.setLayout(null);
		fr1.setSize(1000, 700);

		l1 = new JLabel("Click on Below Button to See All Course are Printed on Your Console Screen");
		l1.setBounds(100, 100, 500, 20);
		fr1.add(l1);

		b1 = new JButton("View Console Screen");
		b1.setBounds(200, 140, 200, 20);
		fr1.add(b1);
		
		b1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
//			System.out.println("View Console Screen Button Clicked.");
			try {				
				Connection connection = Assesement.createconnection();
				String sql = "select Name from course";
				PreparedStatement pst = connection.prepareStatement(sql);

				ResultSet rs = pst.executeQuery();
			// Fetch Data from Table and Print all Courses on your Console Screen.
				while(rs.next()) {
					String Name = rs.getString("Name");
					System.out.println(Name);
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}

//Create Class SearchCourse for Performed Search Course Details.
class SearchCourse implements ActionListener {
	JLabel l1, l2, l3, l4, l5, l6;
	JTextField t1, t2, t3, t4, t5;
	JButton b6;

	// Create Constructor
	SearchCourse() {
		// Set Frame Dimension, Visibility & Layout
		JFrame fr1 = new JFrame("Search Coruse");
		fr1.setVisible(true);
		fr1.setLayout(null);
		fr1.setSize(1000, 700);

		l1 = new JLabel("Course ID for Search");
		l1.setBounds(100, 100, 250, 20);
		fr1.add(l1);
		l2 = new JLabel("");
		l2.setBounds(100, 230, 150, 20);
		fr1.add(l2);
		l3 = new JLabel("");
		l3.setBounds(100, 260, 150, 20);
		fr1.add(l3);
		l4 = new JLabel("");
		l4.setBounds(100, 290, 150, 20);
		fr1.add(l4);
		l5 = new JLabel("");
		l5.setBounds(100, 320, 150, 20);
		fr1.add(l5);
		l6 = new JLabel("");
		l6.setBounds(210, 180, 150, 20);
		fr1.add(l6);

		t1 = new JTextField();
		t1.setBounds(250, 100, 150, 20);
		fr1.add(t1);
		t2 = new JTextField();
		fr1.add(t2);
		t3 = new JTextField();
		fr1.add(t3);
		t4 = new JTextField();
		fr1.add(t4);
		t5 = new JTextField();
		fr1.add(t5);

		b6 = new JButton("Search");
		b6.setBounds(200, 140, 100, 20);
		fr1.add(b6);

		b6.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// If User Clicked Search Button Than Search & Print all Details of Existing User.
		if (e.getSource() == b6) {
			System.out.println("Search button clicked.");

			// Fetch Data From User Input
			int ID = Integer.parseInt(t1.getText());

			try {
				// Provide Connectivity : User Input Is Stored Into Database Table
				Connection connection = Assesement.createconnection();
				String sql = "select * from course where id = ?";
				PreparedStatement pst = connection.prepareStatement(sql);

				pst.setInt(1, ID);
				ResultSet rs = pst.executeQuery();

				// If Course Id Exists, Than Fetch Data OtherWise Print ID Does't Exist screen Message.
				if (rs.next()) {
					l2.setText("Course Name");
					l3.setText("Course Fees");
					l4.setText("Course Duration");
					l5.setText("Course Detail");
					l6.setText("");

					t2.setBounds(250, 230, 150, 20);
					t3.setBounds(250, 260, 150, 20);
					t4.setBounds(250, 290, 150, 20);
					t5.setBounds(250, 320, 150, 20);

					t2.setText(rs.getString("Name"));
					t3.setText(String.valueOf(rs.getString("Fees")));
					t4.setText(rs.getString("Duration"));
					t5.setText(rs.getString("Detail"));
				} 
				else {
					l2.setText("");
					l3.setText("");
					l4.setText("");
					l5.setText("");
					l6.setText("ID Does't Exist.");

					t2.setBounds(0, 0, 0, 0);
					t3.setBounds(0, 0, 0, 0);
					t4.setBounds(0, 0, 0, 0);
					t5.setBounds(0, 0, 0, 0);
				}
			} catch (Exception e2) {
				// If Exception Is Generated Than Handle by printStackTrace.
				e2.printStackTrace();
			}
		}
	}
}

//Create Class EditCourse for Performed Edit Course Details.
class EditCourse implements ActionListener {
	JLabel l1, l2, l3, l4, l5, l6, l7, l8;
	JTextField t1, t2, t3, t4, t5, t6;
	JButton b6, b7;

	// Create Constructor
	EditCourse() {
		// Set Frame Dimension, Visibility & Layout
		JFrame fr1 = new JFrame("Edit Coruse");
		fr1.setVisible(true);
		fr1.setLayout(null);
		fr1.setSize(1000, 700);

		l1 = new JLabel("Course ID for Update");
		l1.setBounds(100, 100, 250, 20);
		fr1.add(l1);
		l2 = new JLabel("");
		l2.setBounds(100, 230, 150, 20);
		fr1.add(l2);
		l3 = new JLabel("");
		l3.setBounds(100, 260, 150, 20);
		fr1.add(l3);
		l4 = new JLabel("");
		l4.setBounds(100, 290, 150, 20);
		fr1.add(l4);
		l5 = new JLabel("");
		l5.setBounds(100, 320, 150, 20);
		fr1.add(l5);
		l6 = new JLabel("");
		l6.setBounds(100, 350, 150, 20);
		fr1.add(l6);
		l7 = new JLabel("");
		l7.setBounds(210, 180, 150, 20);
		fr1.add(l7);
		l8 = new JLabel("");
		l8.setBounds(180, 440, 200, 20);
		fr1.add(l8);

		t1 = new JTextField();
		t1.setBounds(250, 100, 150, 20);
		fr1.add(t1);
		t2 = new JTextField();
		fr1.add(t2);
		t3 = new JTextField();
		fr1.add(t3);
		t4 = new JTextField();
		fr1.add(t4);
		t5 = new JTextField();
		fr1.add(t5);
		t6 = new JTextField();
		fr1.add(t6);

		b6 = new JButton("Search");
		b6.setBounds(200, 140, 100, 20);
		fr1.add(b6);
		b7 = new JButton("Update");
		fr1.add(b7);

		b6.addActionListener(this);
		b7.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// If User Clicked Search Button Than Search & Print all Details of Existing User.
		if (e.getSource() == b6) {
			System.out.println("Search button clicked.");

			// Fetch Data From User Input
			int ID = Integer.parseInt(t1.getText());

			try {
				// Provide Connectivity : User Input Is Stored Into Database Table
				Connection connection = Assesement.createconnection();
				String sql = "select * from course where id = ?";
				PreparedStatement pst = connection.prepareStatement(sql);

				pst.setInt(1, ID);
				ResultSet rs = pst.executeQuery();

				// If Course Id Exists, Than Fetch Data OtherWise Print ID Does't Exist screen Message.
				if (rs.next()) {
					l2.setText("Course ID");
					l2.disable();
					l3.setText("Course Name");
					l4.setText("Course Fees");
					l5.setText("Course Duration");
					l6.setText("Course Detail");
					l7.setText("");

					b7.setBounds(200, 400, 100, 20);

					t2.setBounds(250, 230, 150, 20);
					t3.setBounds(250, 260, 150, 20);
					t4.setBounds(250, 290, 150, 20);
					t5.setBounds(250, 320, 150, 20);
					t6.setBounds(250, 350, 150, 20);

					t2.setText(String.valueOf(rs.getString("ID")));
					t2.disable();
					t3.setText(rs.getString("Name"));
					t4.setText(String.valueOf(rs.getString("Fees")));
					t5.setText(rs.getString("Duration"));
					t6.setText(rs.getString("Detail"));
				} else {
					l2.setText("");
					l3.setText("");
					l4.setText("");
					l5.setText("");
					l6.setText("");
					l7.setText("ID Does't Exist.");
					l8.setText("");

					b7.setBounds(0, 0, 0, 0);
					t2.setBounds(0, 0, 0, 0);
					t3.setBounds(0, 0, 0, 0);
					t4.setBounds(0, 0, 0, 0);
					t5.setBounds(0, 0, 0, 0);
					t6.setBounds(0, 0, 0, 0);
				}
			} catch (Exception e2) {
				// If Exception Is Generated Than Handle by printStackTrace.
				e2.printStackTrace();
			}
		}

		// After Fetch Data & Than Updated by User Input.
		else if (e.getSource() == b7) {
			System.out.println("Update button clicked.");

			// Fetch Data From User Input
			int ID = Integer.parseInt(t2.getText());
			String Name = t3.getText();
			int Fees = Integer.parseInt(t4.getText());
			String Duration = t5.getText();
			String Detail = t6.getText();

			try {
				// Provide Connectivity : User Input Is Stored Into Database Table
				Connection connection = Assesement.createconnection();
				String sql = "update course set Name=?, Fees=?, Duration=?,Detail=? where ID=?";
				PreparedStatement pst = connection.prepareStatement(sql);

				pst.setString(1, Name);
				pst.setInt(2, Fees);
				pst.setString(3, Duration);
				pst.setString(4, Detail);
				pst.setInt(5, ID);
				pst.executeUpdate();

				// Data Updated Than Show Message on Screen & other filed Empty.
				l8.setText("Data Updated Succesfully.");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}

//Create Class DeleteCourse for Performed Delete all Details
class DeleteCourse implements ActionListener {
	JLabel l1, l2;
	JTextField t1;
	JButton b6;

	// Create Constructor
	DeleteCourse() {
		// Set Frame Dimension, Visibility & Layout
		JFrame fr1 = new JFrame("Delete Coruse");
		fr1.setVisible(true);
		fr1.setLayout(null);
		fr1.setSize(1000, 700);

		l1 = new JLabel("Course ID for Delete");
		l1.setBounds(100, 100, 250, 20);
		fr1.add(l1);
		l2 = new JLabel("");
		l2.setBounds(180, 190, 250, 20);
		fr1.add(l2);

		t1 = new JTextField();
		t1.setBounds(250, 100, 150, 20);
		fr1.add(t1);

		b6 = new JButton("DELETE");
		b6.setBounds(200, 140, 100, 20);
		fr1.add(b6);

		b6.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// If User Clicked Delete Button Than Delete all Details of Existing User.
		if (e.getSource() == b6) {
			System.out.println("Delete button clicked.");

			// Fetch Data From User Input
			int ID = Integer.parseInt(t1.getText());

			try {
				// Provide Connectivity : User Input Is Stored Into Database Table
				Connection connection = Assesement.createconnection();
				String sql = "delete from course where id = ?";
				PreparedStatement pst = connection.prepareStatement(sql);

				pst.setInt(1, ID);
				pst.executeUpdate();

				t1.setText("");
				l2.setText("Data Deleted Succesfully.");
			} catch (Exception e2) {
				// If Exception Is Generated Than Handle by printStackTrace.
				e2.printStackTrace();
			}
		}
	}
}

public class Assesement implements ActionListener {

	JButton b1, b2, b3, b4, b5;

	// Create Constructor
	Assesement() {

		// Set Frame Dimension, Visibility & Layout
		JFrame fr = new JFrame("Coruses CRUD Operation");
		fr.setVisible(true);
		fr.setLayout(null);
		fr.setSize(500, 500);

		b1 = new JButton("Add Course");
		b1.setBounds(100, 100, 200, 20);
		fr.add(b1);
		b2 = new JButton("View Course");
		b2.setBounds(100, 140, 200, 20);
		fr.add(b2);
		b3 = new JButton("Search Course");
		b3.setBounds(100, 180, 200, 20);
		fr.add(b3);
		b4 = new JButton("Edit Course");
		b4.setBounds(100, 220, 200, 20);
		fr.add(b4);
		b5 = new JButton("Delete Course");
		b5.setBounds(100, 260, 200, 20);
		fr.add(b5);

		// Make Button Clicked To EventTable
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
	}

	public static void main(String[] args) {
		// Create Object of Assessment Method
		new Assesement();
	}

	// Create Connection With Database
	public static Connection createconnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rdbms_jdbc", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// If User Clicked AddCourse Button Than Registration Action Performed.
		if (e.getSource() == b1) {
			System.out.println("Add Course Button Clicked. ");
			try {
				// Create Object & Called Method AddCourse
				new AddCourse();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		// If User clicked ViewCourse Button Than View All Course.
		else if (e.getSource() == b2) {
			System.out.println("View Course Button Clicked. ");
			try {
				// Create Object & Called Method ViewCourse
				new ViewCourse();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		// If User clicked SearchCourse Button Than Search Course by Id Performed.
		else if (e.getSource() == b3) {
			System.out.println("Search Course Button Clicked. ");
			try {
				// Create Object & Called Method SearchCourse
				new SearchCourse();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		// If User clicked EditCourse Button Than Edit Course Details.
		else if (e.getSource() == b4) {
			System.out.println("Edit Course Button Clicked. ");
			try {
				// Create Object & Called Method EditCourse
				new EditCourse();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		// If User clicked DeleteCourse Button Than Delete Specified Course.
		else if (e.getSource() == b5) {
			System.out.println("Delete Course Button Clicked. ");
			try {
				// Create Object & Called Method DeleteCourse
				new DeleteCourse();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}