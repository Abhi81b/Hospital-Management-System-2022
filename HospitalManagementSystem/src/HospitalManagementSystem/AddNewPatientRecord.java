package HospitalManagementSystem;
import Project.ConnectionProvider;
import java.sql.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.ComponentOrientation;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import java.awt.Toolkit;

public class AddNewPatientRecord {

	public JFrame FrameAddNewPatientRecord;
	private JTextField textPatientID;
	private JTextField textName;
	private JTextField textContactNumber;
	private JTextField textAge;
	private JTextField textBloodGroup;
	private JTextField textAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewPatientRecord window = new AddNewPatientRecord();
					window.FrameAddNewPatientRecord.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddNewPatientRecord() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		FrameAddNewPatientRecord = new JFrame();
		FrameAddNewPatientRecord.setIconImage(Toolkit.getDefaultToolkit().getImage(AddNewPatientRecord.class.getResource("/HospitalManagementSystem/HMS Logo.png")));
		FrameAddNewPatientRecord.setUndecorated(true);
		FrameAddNewPatientRecord.setMinimumSize(new Dimension(800, 600));
		FrameAddNewPatientRecord.getContentPane().setMinimumSize(new Dimension(700, 500));
		FrameAddNewPatientRecord.getContentPane().setPreferredSize(new Dimension(700, 500));
		FrameAddNewPatientRecord.setLocation(new Point(280, 150));
		FrameAddNewPatientRecord.setBounds(100, 100, 799, 600);
		FrameAddNewPatientRecord.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBackground(new Color(255, 0, 0));
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
		btnClose.setBounds(643, 558, 96, 31);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameAddNewPatientRecord.setVisible(false);
			}
		});
		FrameAddNewPatientRecord.getContentPane().setLayout(null);
		FrameAddNewPatientRecord.getContentPane().add(btnClose);
		
		JLabel lblPatientID = new JLabel("Patient ID      :");
		lblPatientID.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPatientID.setBounds(206, 100, 128, 31);
		FrameAddNewPatientRecord.getContentPane().add(lblPatientID);
		
		JLabel lblName = new JLabel("Name              :");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(206, 142, 128, 31);
		FrameAddNewPatientRecord.getContentPane().add(lblName);
		
		JLabel lblContactNo = new JLabel("Contact No    :");
		lblContactNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContactNo.setBounds(206, 184, 128, 31);
		FrameAddNewPatientRecord.getContentPane().add(lblContactNo);
		
		JLabel lblAge = new JLabel("Age                  :");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAge.setBounds(206, 226, 128, 31);
		FrameAddNewPatientRecord.getContentPane().add(lblAge);
		
		JLabel lblGender = new JLabel("Gender            :");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGender.setBounds(206, 268, 128, 31);
		FrameAddNewPatientRecord.getContentPane().add(lblGender);
		
		JLabel lblBloodGroup = new JLabel("Blood Group   :");
		lblBloodGroup.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBloodGroup.setBounds(206, 314, 128, 31);
		FrameAddNewPatientRecord.getContentPane().add(lblBloodGroup);
		
		JLabel lblAddress = new JLabel("Address           :");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddress.setBounds(206, 356, 128, 31);
		FrameAddNewPatientRecord.getContentPane().add(lblAddress);
		
		JLabel lblPatientId = new JLabel("Any Major Disease Suffered Earlier");
		lblPatientId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPatientId.setBounds(206, 398, 310, 31);
		FrameAddNewPatientRecord.getContentPane().add(lblPatientId);
		
		JLabel Heading = new JLabel("Add New Patient Record");
		Heading.setIcon(new ImageIcon(AddNewPatientRecord.class.getResource("/HospitalManagementSystem/add new patient.png")));
		Heading.setFont(new Font("Times New Roman", Font.BOLD, 24));
		Heading.setBounds(233, 18, 425, 50);
		FrameAddNewPatientRecord.getContentPane().add(Heading);
		
		textPatientID = new JTextField();
		textPatientID.setFont(new Font("Tahoma", Font.BOLD, 15));
		textPatientID.setBounds(339, 100, 400, 31);
		FrameAddNewPatientRecord.getContentPane().add(textPatientID);
		textPatientID.setColumns(10);
		
		textName = new JTextField();
		textName.setFont(new Font("Tahoma", Font.BOLD, 15));
		textName.setColumns(10);
		textName.setBounds(339, 142, 400, 31);
		FrameAddNewPatientRecord.getContentPane().add(textName);
		
		textContactNumber = new JTextField();
		textContactNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		textContactNumber.setColumns(10);
		textContactNumber.setBounds(339, 184, 400, 31);
		FrameAddNewPatientRecord.getContentPane().add(textContactNumber);
		
		textAge = new JTextField();
		textAge.setFont(new Font("Tahoma", Font.BOLD, 15));
		textAge.setColumns(10);
		textAge.setBounds(339, 226, 400, 31);
		FrameAddNewPatientRecord.getContentPane().add(textAge);
		
		textBloodGroup = new JTextField();
		textBloodGroup.setFont(new Font("Tahoma", Font.BOLD, 15));
		textBloodGroup.setColumns(10);
		textBloodGroup.setBounds(339, 314, 400, 31);
		FrameAddNewPatientRecord.getContentPane().add(textBloodGroup);
		
		textAddress = new JTextField();
		textAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		textAddress.setColumns(10);
		textAddress.setBounds(339, 356, 400, 31);
		FrameAddNewPatientRecord.getContentPane().add(textAddress);
		
		JComboBox comboGender = new JComboBox();
		comboGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Others"}));
		comboGender.setBounds(339, 268, 400, 35);
		FrameAddNewPatientRecord.getContentPane().add(comboGender);
		
		JTextPane textAnyMajorDisease = new JTextPane();
		textAnyMajorDisease.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAnyMajorDisease.setBounds(206, 440, 533, 91);
		FrameAddNewPatientRecord.getContentPane().add(textAnyMajorDisease);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String patientID = textPatientID.getText();
				String name = textName.getText();
				String contactNumber = textContactNumber.getText();
				String age = textAge.getText();
				String gender = (String)comboGender.getSelectedItem();
				String bloodGroup = textBloodGroup.getText();
				String address = textAddress.getText();
				String anyMajorDisease = textAnyMajorDisease.getText();
				
				try {
					String query = "insert into patient values (?, ?, ?, ?, ?, ?, ?, ?)";
					Connection con = ConnectionProvider.getCon();
					PreparedStatement st = con.prepareStatement(query);
					st.setString(1, patientID);
					st.setString(2, name);
					st.setString(3, contactNumber);
					st.setString(4, age);
					st.setString(5, gender);
					st.setString(6, bloodGroup);
					st.setString(7, address);
					st.setString(8, anyMajorDisease);
					st.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Successfully Updated");
					FrameAddNewPatientRecord.setVisible(false);
					new AddNewPatientRecord().FrameAddNewPatientRecord.setVisible(true);
				}catch(Exception E) {
					JOptionPane.showMessageDialog(null, E);
				}
			}
		});
		btnSave.setBackground(new Color(0, 153, 0));
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
		btnSave.setBounds(507, 558, 103, 31);
		FrameAddNewPatientRecord.getContentPane().add(btnSave);
		
		
		JLabel backgroundImage = new JLabel("");
		backgroundImage.setIcon(new ImageIcon(AddNewPatientRecord.class.getResource("/HospitalManagementSystem/AddPatientBackground.png")));
		backgroundImage.setBounds(0, 0, 800, 600);
		FrameAddNewPatientRecord.getContentPane().add(backgroundImage);
	}
}
