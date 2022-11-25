package HospitalManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Point;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Project.ConnectionProvider;
import net.proteanit.sql.DbUtils;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class AddDiagnosisInformation {
	public int flag = 0;
	public JFrame FrameAddDiagnosisInformation;
	private JTextField textPatientID;
	private JTable table;
	private JTextField textSymptoms;
	private JTextField textDiagnosis;
	private JTextField textMedicines;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDiagnosisInformation window = new AddDiagnosisInformation();
					window.FrameAddDiagnosisInformation.setVisible(true);
					window.FrameAddDiagnosisInformation.setLocation(280, 80);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddDiagnosisInformation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		
		FrameAddDiagnosisInformation = new JFrame();
		FrameAddDiagnosisInformation.setIconImage(Toolkit.getDefaultToolkit().getImage(AddDiagnosisInformation.class.getResource("/HospitalManagementSystem/HMS Logo.png")));
		FrameAddDiagnosisInformation.setUndecorated(true);
		FrameAddDiagnosisInformation.setResizable(false);
		FrameAddDiagnosisInformation.setName("FrameAddDiagnosisInformation");
		FrameAddDiagnosisInformation.setMinimumSize(new Dimension(900, 600));
		FrameAddDiagnosisInformation.setLocation(new Point(280, 80));
		FrameAddDiagnosisInformation.setBounds(100, 100, 450, 300);
		FrameAddDiagnosisInformation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FrameAddDiagnosisInformation.getContentPane().setLayout(null);
		
		JLabel lblPatientID = new JLabel("PatientID    :");
		lblPatientID.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPatientID.setBounds(134, 107, 101, 30);
		FrameAddDiagnosisInformation.getContentPane().add(lblPatientID);
		
		textPatientID = new JTextField();
		textPatientID.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPatientID.setBounds(245, 105, 210, 35);
		FrameAddDiagnosisInformation.getContentPane().add(textPatientID);
		textPatientID.setColumns(10);
		
		JLabel msgNotFound = new JLabel("Patient ID Does Not Exists !");
		msgNotFound.setVisible(false);
		msgNotFound.setForeground(Color.RED);
		msgNotFound.setFont(new Font("Tahoma", Font.BOLD, 14));
		msgNotFound.setBounds(257, 164, 362, 29);
		FrameAddDiagnosisInformation.getContentPane().add(msgNotFound);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String patientID = textPatientID.getText();
				
				//JDBC code to fetch the data from patient on a table
				try {
					msgNotFound.setVisible(false);
					//Class.forName("com.mysql.cj.jdbc.Driver");)
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					String query = "select * from patient where patientID = '" + patientID + "'";
					ResultSet rs = st.executeQuery(query);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					if(table.getRowCount() == 0) {
						msgNotFound.setVisible(true);
					}else {
						msgNotFound.setVisible(false);
						textPatientID.setEditable(false);
						flag = 1;
					}
					st.close();
					con.close();
					
					//Manual table creation code below
					/*
					ResultSet rs = st.executeQuery(query);
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					
					int col = rsmd.getColumnCount();
					String[] colName = new String[col];
					for(int i = 0; i< col; i++) {
						colName[i] = rsmd.getColumnName(i+1);
					}
					model.setColumnIdentifiers(colName);
					String patient_id, name, contactNumber, age, gender, bloodGroup, address, anyMajorDisease;
					while(rs.next()) {
						patient_id = rs.getString(1);
						name = rs.getString(2);
						contactNumber = rs.getString(3);
						age = rs.getString(4);
						gender = rs.getString(5);
						bloodGroup = rs.getString(6);
						address = rs.getString(7);
						anyMajorDisease = rs.getString(8);
						String[] row = {patient_id, name, contactNumber, age, gender, bloodGroup, address, anyMajorDisease	};
						model.addRow(row);
				}
				st.close();
				con.close();
				*/
				
				}catch(Exception E) {
					JOptionPane.showMessageDialog(null, E.getMessage());
				}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setIcon(new ImageIcon(AddDiagnosisInformation.class.getResource("/hospitalManagementSystem/search.png")));
		btnSearch.setBounds(508, 105, 111, 35);
		FrameAddDiagnosisInformation.getContentPane().add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 204, 801, 84);
		FrameAddDiagnosisInformation.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		JLabel lblSymptoms = new JLabel("Symptom's");
		lblSymptoms.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSymptoms.setBounds(55, 355, 108, 30);
		FrameAddDiagnosisInformation.getContentPane().add(lblSymptoms);
		
		JLabel lblDiagnosis = new JLabel("Diagnosis");
		lblDiagnosis.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDiagnosis.setBounds(55, 415, 108, 30);
		FrameAddDiagnosisInformation.getContentPane().add(lblDiagnosis);
		
		JLabel lblMedicines = new JLabel("Medicines");
		lblMedicines.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMedicines.setBounds(55, 472, 108, 29);
		FrameAddDiagnosisInformation.getContentPane().add(lblMedicines);
		
		textSymptoms = new JTextField();
		textSymptoms.setFont(new Font("Tahoma", Font.BOLD, 14));
		textSymptoms.setBounds(173, 355, 250, 33);
		FrameAddDiagnosisInformation.getContentPane().add(textSymptoms);
		textSymptoms.setColumns(10);
		
		textDiagnosis = new JTextField();
		textDiagnosis.setMinimumSize(new Dimension(5, 20));
		textDiagnosis.setFont(new Font("Tahoma", Font.BOLD, 14));
		textDiagnosis.setColumns(10);
		textDiagnosis.setBounds(173, 412, 250, 35);
		FrameAddDiagnosisInformation.getContentPane().add(textDiagnosis);
		
		textMedicines = new JTextField();
		textMedicines.setFont(new Font("Tahoma", Font.BOLD, 14));
		textMedicines.setColumns(10);
		textMedicines.setBounds(173, 470, 250, 35);
		FrameAddDiagnosisInformation.getContentPane().add(textMedicines);
		
		JLabel lblWardRequired = new JLabel("Ward Required");
		lblWardRequired.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWardRequired.setBounds(585, 356, 111, 30);
		FrameAddDiagnosisInformation.getContentPane().add(lblWardRequired);
		
		JLabel lblTypeOfWard = new JLabel("Type of Ward");
		lblTypeOfWard.setVisible(false);
		lblTypeOfWard.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTypeOfWard.setBounds(585, 416, 111, 30);
		FrameAddDiagnosisInformation.getContentPane().add(lblTypeOfWard);
		
		JComboBox comboBoxTypeOfWard = new JComboBox();
		comboBoxTypeOfWard.setVisible(false);
		comboBoxTypeOfWard.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxTypeOfWard.setModel(new DefaultComboBoxModel(new String[] {"General", "Single", "Duo"}));
		comboBoxTypeOfWard.setBounds(735, 412, 119, 34);
		FrameAddDiagnosisInformation.getContentPane().add(comboBoxTypeOfWard);
		
		JCheckBox chckbxWordRequired = new JCheckBox("Yes");
		chckbxWordRequired.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxWordRequired.isSelected()) {
					lblTypeOfWard.setVisible(true);
					comboBoxTypeOfWard.setVisible(true);
					
				}else {
					lblTypeOfWard.setVisible(false);
					comboBoxTypeOfWard.setVisible(false);
				}
			}
		});
		chckbxWordRequired.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxWordRequired.setBounds(735, 358, 119, 28);
		FrameAddDiagnosisInformation.getContentPane().add(chckbxWordRequired);
		
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameAddDiagnosisInformation.setVisible(false);
			}
		});
		btnClose.setBackground(new Color(255, 0, 0));
		btnClose.setForeground(new Color(255, 255, 255));
		btnClose.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 17));
		btnClose.setBounds(746, 531, 108, 43);
		FrameAddDiagnosisInformation.getContentPane().add(btnClose);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(flag == 1) {
					String patientID = textPatientID.getText();
					String symptoms = textSymptoms.getText();
					String diagnosis = textDiagnosis.getText();
					String medicines = textMedicines.getText();
					if(symptoms == "" || diagnosis == "" || medicines == "") {
						JOptionPane.showMessageDialog(null, "Please Fill Form!");
					}
					String wardRequired;
					String typeOfWard;
					if(chckbxWordRequired.isSelected()) {
						wardRequired = "Yes";
						typeOfWard = (String) comboBoxTypeOfWard.getSelectedItem();
					}else {
						wardRequired = "No";
						typeOfWard = "";
					}
					
					//JDBC code for save the data at patientRecord
					try {
						String query = "insert into patientRecord values (?, ?, ?, ?, ?, ?);";
						Connection con = ConnectionProvider.getCon();
						PreparedStatement st = con.prepareStatement(query);
						st.setString(1, patientID);
						st.setString(2, symptoms);
						st.setString(3, diagnosis);
						st.setString(4, medicines);
						st.setString(5, wardRequired);
						st.setString(6, typeOfWard);
						st.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "Successfully Updated");
						FrameAddDiagnosisInformation.setVisible(false);
						new AddDiagnosisInformation().FrameAddDiagnosisInformation.setVisible(true);
					}catch(Exception f) {
						JOptionPane.showMessageDialog(null, f.getMessage());
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Patient ID Field is Empty!");
				}
				
			}
		});
		btnSave.setForeground(new Color(255, 255, 255));
		btnSave.setBackground(new Color(0, 128, 0));
		btnSave.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 17));
		btnSave.setBounds(585, 531, 119, 43);
		FrameAddDiagnosisInformation.getContentPane().add(btnSave);
		
		JLabel lblHeading = new JLabel("ADD DIAGNOSIS INFORMATION");
		lblHeading.setIcon(new ImageIcon(AddDiagnosisInformation.class.getResource("/HospitalManagementSystem/add diag.png")));
		lblHeading.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblHeading.setBounds(229, 24, 409, 48);
		FrameAddDiagnosisInformation.getContentPane().add(lblHeading);
		
		JLabel lblBackgroundImage = new JLabel("New label");
		lblBackgroundImage.setIcon(new ImageIcon(AddDiagnosisInformation.class.getResource("/HospitalManagementSystem/AddDiagnosisInformationBG.jpg")));
		lblBackgroundImage.setBounds(0, 0, 900, 600);
		FrameAddDiagnosisInformation.getContentPane().add(lblBackgroundImage);
	}
}
