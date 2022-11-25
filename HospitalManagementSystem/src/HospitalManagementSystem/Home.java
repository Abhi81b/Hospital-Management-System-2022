package HospitalManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Frame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Home {

	public JFrame FrameHome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.FrameHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		FrameHome = new JFrame();
		FrameHome.setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/HospitalManagementSystem/HMS Logo.png")));
		FrameHome.setUndecorated(true);
		FrameHome.setTitle("HMS | Home");
		FrameHome.setExtendedState(Frame.MAXIMIZED_BOTH);
		FrameHome.setSize(new Dimension(1366, 729));
		FrameHome.setMinimumSize(new Dimension(1366, 768));
		FrameHome.getContentPane().setMinimumSize(new Dimension(1366, 768));
		FrameHome.getContentPane().setPreferredSize(new Dimension(1366, 768));
		FrameHome.getContentPane().setLayout(null);
		
		JButton btn_add_patient_record = new JButton("Add New Patient Record");
		btn_add_patient_record.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddNewPatientRecord().FrameAddNewPatientRecord.setVisible(true);
			}
		});
		btn_add_patient_record.setBackground(SystemColor.inactiveCaptionBorder);
		btn_add_patient_record.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_add_patient_record.setIcon(new ImageIcon(Home.class.getResource("/HospitalManagementSystem/add new patient.png")));
		btn_add_patient_record.setBounds(149, 188, 305, 150);
		FrameHome.getContentPane().add(btn_add_patient_record);
		
		JButton btn_update_patient_record = new JButton("Update Patient Record");
		btn_update_patient_record.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdatePatientRecord().FrameUpdatePatientRecord.setVisible(true);
			}
		});
		btn_update_patient_record.setBackground(SystemColor.inactiveCaptionBorder);
		btn_update_patient_record.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_update_patient_record.setIcon(new ImageIcon(Home.class.getResource("/HospitalManagementSystem/rsz_update_details.png")));
		btn_update_patient_record.setBounds(149, 400, 305, 150);
		FrameHome.getContentPane().add(btn_update_patient_record);
		
		JButton btn_add_diagnosis_information = new JButton("Add Diagnosis Information");
		btn_add_diagnosis_information.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddDiagnosisInformation().FrameAddDiagnosisInformation.setVisible(true);
			}
		});
		btn_add_diagnosis_information.setBackground(SystemColor.inactiveCaptionBorder);
		btn_add_diagnosis_information.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_add_diagnosis_information.setIcon(new ImageIcon(Home.class.getResource("/HospitalManagementSystem/add diag.png")));
		btn_add_diagnosis_information.setBounds(526, 188, 305, 150);
		FrameHome.getContentPane().add(btn_add_diagnosis_information);
		
		JButton btn_hospital_information = new JButton("Hospital Information");
		btn_hospital_information.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HospitalInformation().FrameHospitalInformation.setVisible(true);
			}
		});
		btn_hospital_information.setBackground(SystemColor.inactiveCaptionBorder);
		btn_hospital_information.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_hospital_information.setIcon(new ImageIcon(Home.class.getResource("/HospitalManagementSystem/rsz_hospital_information.png")));
		btn_hospital_information.setBounds(526, 400, 305, 150);
		FrameHome.getContentPane().add(btn_hospital_information);
		
		JButton btn_full_history_of_patient = new JButton("Full History of Patient");
		btn_full_history_of_patient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FullHistoryOfPatient().setVisible(true);
		}});
		btn_full_history_of_patient.setBackground(SystemColor.inactiveCaptionBorder);
		btn_full_history_of_patient.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_full_history_of_patient.setIcon(new ImageIcon(Home.class.getResource("/HospitalManagementSystem/Patient History icon.png")));
		btn_full_history_of_patient.setBounds(913, 188, 305, 150);
		FrameHome.getContentPane().add(btn_full_history_of_patient);
		
		JButton btn_logout = new JButton("Logout");
		btn_logout.setBackground(SystemColor.inactiveCaptionBorder);
		btn_logout.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_logout.setIcon(new ImageIcon(Home.class.getResource("/HospitalManagementSystem/exit icon.png")));
		btn_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(null, "Do you really want to logout?", "Select", JOptionPane.YES_NO_OPTION);
				if(a==0) {
					FrameHome.setVisible(false);
					new Login().FrameLogin.setVisible(true);
				}
			}
		});
		btn_logout.setBounds(913, 400, 305, 150);
		FrameHome.getContentPane().add(btn_logout);
		
		JLabel lblNewLabel = new JLabel("Welcome, Admin");
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/HospitalManagementSystem/admin1.png")));
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
		lblNewLabel.setBounds(48, 32, 349, 90);
		FrameHome.getContentPane().add(lblNewLabel);
		
		JLabel background_image = new JLabel("");
		background_image.setIcon(new ImageIcon(HospitalManagementSystem.Home.class.getResource("/HospitalManagementSystem/Home background image.png")));
		background_image.setBounds(0, 0, 1366, 768);
		FrameHome.getContentPane().add(background_image);
		FrameHome.setBounds(100, 100, 723, 483);
		FrameHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
