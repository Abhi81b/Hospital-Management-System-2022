package HospitalManagementSystem;
import java.awt.EventQueue;
import java.sql.*;
import Project.ConnectionProvider;
import net.proteanit.sql.DbUtils;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import HospitalManagementSystem.FullHistoryOfPatient;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class UpdatePatientRecord {

	 JFrame FrameUpdatePatientRecord;
	private JTextField textPatientID;
	private JTextField textName;
	private JTextField textContactNo;
	private JTextField textAge;
	private JTextField textGender;
	private JTextField textBloodGroup;
	private JTextField textAddress;
	private JTextField textSymptoms;
	private JTextField textDiagnosis;
	private JTextField textMedicine;
	private JTextField textWardReq;
	private JTextField textTypeOfWard;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdatePatientRecord window = new UpdatePatientRecord();
					window.FrameUpdatePatientRecord.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UpdatePatientRecord() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		FrameUpdatePatientRecord = new JFrame();
		FrameUpdatePatientRecord.setIconImage(Toolkit.getDefaultToolkit().getImage(UpdatePatientRecord.class.getResource("/HospitalManagementSystem/HMS Logo.png")));
		FrameUpdatePatientRecord.setUndecorated(true);
		FrameUpdatePatientRecord.setMinimumSize(new Dimension(1000, 573));
		FrameUpdatePatientRecord.setBounds(100, 100, 450, 300);
		FrameUpdatePatientRecord.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FrameUpdatePatientRecord.getContentPane().setLayout(null);
		
		JLabel lblPatientID = new JLabel("Patient ID :");
		lblPatientID.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPatientID.setBounds(60, 118, 108, 35);
		FrameUpdatePatientRecord.getContentPane().add(lblPatientID);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(60, 164, 93, 26);
		FrameUpdatePatientRecord.getContentPane().add(lblName);
		
		JLabel lblContactNo = new JLabel("Contact No");
		lblContactNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContactNo.setBounds(60, 201, 93, 26);
		FrameUpdatePatientRecord.getContentPane().add(lblContactNo);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAge.setBounds(60, 233, 93, 26);
		FrameUpdatePatientRecord.getContentPane().add(lblAge);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGender.setBounds(60, 270, 93, 26);
		FrameUpdatePatientRecord.getContentPane().add(lblGender);
		
		JLabel lblBloodGroup = new JLabel("Blood Group");
		lblBloodGroup.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBloodGroup.setBounds(60, 307, 93, 26);
		FrameUpdatePatientRecord.getContentPane().add(lblBloodGroup);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddress.setBounds(60, 344, 93, 26);
		FrameUpdatePatientRecord.getContentPane().add(lblAddress);
		
		JLabel lblAnyMajorDisease = new JLabel("Any Major Disease Suffer Earlier");
		lblAnyMajorDisease.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAnyMajorDisease.setBounds(60, 372, 268, 26);
		FrameUpdatePatientRecord.getContentPane().add(lblAnyMajorDisease);
		
		textPatientID = new JTextField();
		textPatientID.setFont(new Font("Tahoma", Font.BOLD, 16));
		textPatientID.setBounds(178, 118, 250, 34);
		FrameUpdatePatientRecord.getContentPane().add(textPatientID);
		textPatientID.setColumns(10);
		
		textName = new JTextField();
		textName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textName.setColumns(10);
		textName.setBounds(178, 164, 250, 26);
		FrameUpdatePatientRecord.getContentPane().add(textName);
		
		textContactNo = new JTextField();
		textContactNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		textContactNo.setColumns(10);
		textContactNo.setBounds(178, 201, 250, 26);
		FrameUpdatePatientRecord.getContentPane().add(textContactNo);
		
		textAge = new JTextField();
		textAge.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAge.setColumns(10);
		textAge.setBounds(178, 236, 250, 25);
		FrameUpdatePatientRecord.getContentPane().add(textAge);
		
		textGender = new JTextField();
		textGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		textGender.setColumns(10);
		textGender.setBounds(178, 270, 250, 25);
		FrameUpdatePatientRecord.getContentPane().add(textGender);
		
		textBloodGroup = new JTextField();
		textBloodGroup.setFont(new Font("Tahoma", Font.BOLD, 14));
		textBloodGroup.setColumns(10);
		textBloodGroup.setBounds(178, 307, 250, 25);
		FrameUpdatePatientRecord.getContentPane().add(textBloodGroup);
		
		textAddress = new JTextField();
		textAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAddress.setColumns(10);
		textAddress.setBounds(178, 344, 250, 25);
		FrameUpdatePatientRecord.getContentPane().add(textAddress);
		
		JTextArea textAnyMajorDisease = new JTextArea();
		textAnyMajorDisease.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAnyMajorDisease.setBounds(60, 409, 368, 64);
		FrameUpdatePatientRecord.getContentPane().add(textAnyMajorDisease);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setIcon(new ImageIcon(UpdatePatientRecord.class.getResource("/HospitalManagementSystem/search.png")));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String patientID = textPatientID.getText();
				try {
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					String queryForSearch = "select * from patient p join patientrecord pr on p.patientID = pr.patientID where p.patientID = '" + patientID  + "';";
					ResultSet rs = st.executeQuery(queryForSearch);
					if(rs.next()) {
						textName.setText(rs.getString(2));
						textContactNo.setText(rs.getString(3));
						textAge.setText(rs.getString(4));
						textGender.setText(rs.getString(5));
						textBloodGroup.setText(rs.getString(6));
						textAddress.setText(rs.getString(7));
						textAnyMajorDisease.setText(rs.getString(8));
						
						textSymptoms.setText(rs.getString(10));
						textDiagnosis.setText(rs.getString(11));
						textMedicine.setText(rs.getString(12));
						textWardReq.setText(rs.getString(13));
						textTypeOfWard.setText(rs.getString(14));
						textPatientID.setEditable(false);
					}else {
						JOptionPane.showMessageDialog(null, "Patient ID does not Exist!");
					}
				}catch(Exception f){
					JOptionPane.showMessageDialog(null, "Connection Error!");
				}
			}
		});
		btnSearch.setBounds(546, 118, 162, 41);
		FrameUpdatePatientRecord.getContentPane().add(btnSearch);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(0, 204, 51));
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String patientID = textPatientID.getText();
				String name = textName.getText();
				String contactNo = textContactNo.getText();
				String age = textAge.getText();
				String gender = textGender.getText();
				String bloodGroup = textBloodGroup.getText();
				String address = textAddress.getText();
				String anyMajorDisease = textAnyMajorDisease.getText();
				String symptoms = textSymptoms.getText();
				String diagnosis = textDiagnosis.getText();
				String medicine = textMedicine.getText();
				String wardReq = textWardReq.getText();
				String typeOfWard = textTypeOfWard.getText();
				
				try {
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					String queryForUpdate = "update patient p join patientrecord pr on p.patientID = pr.patientID "
							+ "set name = '" + name + "',"
							+ "contactNumber = '" + contactNo + "',"
							+ "age = '" + age + "',"
							+ "gender = '" + gender + "',"
							+ "bloodGroup = '" + bloodGroup + "',"
							+ "address = '" + address + "'," 
							+ "anyMajorDisease = '" + anyMajorDisease + "',"
							+ "symptoms = '" + symptoms + "',"
							+ "diagnosis = '" + diagnosis + "'," 
							+ "medicine = '" + medicine + "',"
							+ "wardReq = '" + wardReq + "',"
							+ "typeOfWard = '" + typeOfWard + "'"
							+ "where p.patientID = '" + patientID + "';";

					st.executeUpdate(queryForUpdate);
					JOptionPane.showMessageDialog(null, "Successfully Updated");
					FrameUpdatePatientRecord.setVisible(false);
					new UpdatePatientRecord().FrameUpdatePatientRecord.setVisible(true);
				}catch(Exception f) {
					JOptionPane.showMessageDialog(null, "Please enter data in Correct Format!");
				}
			}
		});
		btnUpdate.setBounds(679, 499, 104, 34);
		FrameUpdatePatientRecord.getContentPane().add(btnUpdate);
		
		JButton btnClose = new JButton("Close");
		btnClose.setForeground(new Color(255, 255, 255));
		btnClose.setBackground(new Color(255, 0, 0));
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameUpdatePatientRecord.setVisible(false);
			}
		});
		btnClose.setBounds(827, 499, 104, 34);
		FrameUpdatePatientRecord.getContentPane().add(btnClose);
		
		JLabel lblSymptoms = new JLabel("Symptoms");
		lblSymptoms.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSymptoms.setBounds(546, 198, 93, 26);
		FrameUpdatePatientRecord.getContentPane().add(lblSymptoms);
		
		JLabel lblDiagnosis = new JLabel("Diagnosis");
		lblDiagnosis.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDiagnosis.setBounds(546, 238, 93, 26);
		FrameUpdatePatientRecord.getContentPane().add(lblDiagnosis);
		
		JLabel lblMedicine = new JLabel("Medicine");
		lblMedicine.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMedicine.setBounds(546, 275, 93, 26);
		FrameUpdatePatientRecord.getContentPane().add(lblMedicine);
		
		JLabel lblWardReq = new JLabel("Ward Required");
		lblWardReq.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWardReq.setBounds(546, 312, 110, 26);
		FrameUpdatePatientRecord.getContentPane().add(lblWardReq);
		
		textSymptoms = new JTextField();
		textSymptoms.setFont(new Font("Tahoma", Font.BOLD, 14));
		textSymptoms.setColumns(10);
		textSymptoms.setBounds(682, 198, 250, 25);
		FrameUpdatePatientRecord.getContentPane().add(textSymptoms);
		
		textDiagnosis = new JTextField();
		textDiagnosis.setFont(new Font("Tahoma", Font.BOLD, 14));
		textDiagnosis.setColumns(10);
		textDiagnosis.setBounds(682, 238, 250, 25);
		FrameUpdatePatientRecord.getContentPane().add(textDiagnosis);
		
		textMedicine = new JTextField();
		textMedicine.setFont(new Font("Tahoma", Font.BOLD, 14));
		textMedicine.setColumns(10);
		textMedicine.setBounds(682, 275, 250, 25);
		FrameUpdatePatientRecord.getContentPane().add(textMedicine);
		
		textWardReq = new JTextField();
		textWardReq.setFont(new Font("Tahoma", Font.BOLD, 14));
		textWardReq.setColumns(10);
		textWardReq.setBounds(682, 312, 250, 25);
		FrameUpdatePatientRecord.getContentPane().add(textWardReq);
		
		JLabel lblTypeOfWard = new JLabel("Type of Ward");
		lblTypeOfWard.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTypeOfWard.setBounds(546, 349, 93, 26);
		FrameUpdatePatientRecord.getContentPane().add(lblTypeOfWard);
		
		textTypeOfWard = new JTextField();
		textTypeOfWard.setFont(new Font("Tahoma", Font.BOLD, 14));
		textTypeOfWard.setColumns(10);
		textTypeOfWard.setBounds(682, 348, 250, 27);
		FrameUpdatePatientRecord.getContentPane().add(textTypeOfWard);
		
		JLabel lblNewLabel = new JLabel("UPDATE PATIENT RECORD");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setIcon(new ImageIcon(UpdatePatientRecord.class.getResource("/HospitalManagementSystem/rsz_update_details.png")));
		lblNewLabel.setBounds(233, 25, 406, 64);
		FrameUpdatePatientRecord.getContentPane().add(lblNewLabel);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String patientID  = textPatientID.getText();
				try {
				Connection con = ConnectionProvider.getCon();
				Statement st = con.createStatement();
				String query1 = "delete from patient where patientID = '" + patientID + "';";
				String query2 = "delete from patientrecord where patientID = '" + patientID + "';";
				st.executeUpdate(query1);
				st.executeUpdate(query2);
				st.close();
				con.close();
				JOptionPane.showMessageDialog(null, "Delete Successfully");
				FrameUpdatePatientRecord.setVisible(false);
				new UpdatePatientRecord().FrameUpdatePatientRecord.setVisible(true);
				}catch(Exception h) {
					JOptionPane.showMessageDialog(null, "Connection Error!");
				}
			}
		});
		btnDelete.setIcon(new ImageIcon(UpdatePatientRecord.class.getResource("/HospitalManagementSystem/Delete logo.png")));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDelete.setBounds(757, 118, 162, 41);
		FrameUpdatePatientRecord.getContentPane().add(btnDelete);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(UpdatePatientRecord.class.getResource("/HospitalManagementSystem/UpdatePatientRecord1.jpg")));
		lblBackground.setBounds(0, 0, 1000, 600);
		FrameUpdatePatientRecord.getContentPane().add(lblBackground);
	}
}
