package HospitalManagementSystem;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class HospitalInformation {

	public JFrame FrameHospitalInformation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HospitalInformation window = new HospitalInformation();
					window.FrameHospitalInformation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HospitalInformation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		FrameHospitalInformation = new JFrame();
		FrameHospitalInformation.setIconImage(Toolkit.getDefaultToolkit().getImage(HospitalInformation.class.getResource("/HospitalManagementSystem/HMS Logo.png")));
		FrameHospitalInformation.setUndecorated(true);
		FrameHospitalInformation.setMinimumSize(new Dimension(1000, 580));
		FrameHospitalInformation.setBounds(100, 100, 1000, 568);
		FrameHospitalInformation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FrameHospitalInformation.getContentPane().setLayout(null);
		
		JTextPane txtpnAHospitalManagement = new JTextPane();
		txtpnAHospitalManagement.setMargin(new Insets(3, 8, 3, 8));
		txtpnAHospitalManagement.setBackground(new Color(240, 248, 255));
		txtpnAHospitalManagement.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnAHospitalManagement.setText("\r\n  A Hospital Management System (HMS) is an element of health informatics that focuses mainly on the  administrational needs of hospitals. These systems enhance the ability of health care professionals to co-ordinate care by providing a patient's health information  and visit history at the place and time that is needed. The data is saved in digital form and  leads to very less paperwork which helps professional. \r\n\r\n  Improving the quality of one\u2019s life is an important benefit of technology in healthcare. Besides, it also reduces the burden of staff in the hospital and improves the health of the  patient easily and efficiently.\r\n \r\n  The quality of one\u2019s life is an important benefit of technology in healthcare. Besides, it also reduces the burden of staff in the hospital and improves the health of the patient  easily and efficiently.");
		txtpnAHospitalManagement.setBounds(119, 96, 773, 309);
		FrameHospitalInformation.getContentPane().add(txtpnAHospitalManagement);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameHospitalInformation.setVisible(false);
			}
		});
		btnClose.setForeground(new Color(255, 255, 255));
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnClose.setBackground(new Color(255, 0, 0));
		btnClose.setBounds(724, 492, 168, 38);
		FrameHospitalInformation.getContentPane().add(btnClose);
		
		JLabel lblHeading = new JLabel("About Hospital Management System");
		lblHeading.setIcon(new ImageIcon(HospitalInformation.class.getResource("/HospitalManagementSystem/rsz_hospital_information.png")));
		lblHeading.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblHeading.setBounds(119, 35, 773, 50);
		FrameHospitalInformation.getContentPane().add(lblHeading);
		
		JLabel lblBackgroundImage = new JLabel("");
		lblBackgroundImage.setIcon(new ImageIcon(HospitalInformation.class.getResource("/HospitalManagementSystem/Hospital Information bg.jpg")));
		lblBackgroundImage.setBounds(0, 0, 1000, 580);
		FrameHospitalInformation.getContentPane().add(lblBackgroundImage);
	}
}
