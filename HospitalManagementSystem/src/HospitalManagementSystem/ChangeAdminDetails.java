package HospitalManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import HospitalManagementSystem.Login;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import Project.ConnectionProvider;
import java.sql.*;
import HospitalManagementSystem.Login;

public class ChangeAdminDetails {

	public JFrame FrameChangeAdminDetails;
	private JTextField textCurrentUsername;
	private JTextField textNewUsername;
	private JPasswordField textNewPassword;
	private JPasswordField textConfirmPassword;
	private JPasswordField textCurrentPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeAdminDetails window = new ChangeAdminDetails();
					window.FrameChangeAdminDetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChangeAdminDetails() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		FrameChangeAdminDetails = new JFrame();
		FrameChangeAdminDetails.getContentPane().setBackground(new Color(255, 255, 255));
		FrameChangeAdminDetails.setBackground(new Color(255, 255, 153));
		FrameChangeAdminDetails.setMaximumSize(new Dimension(700, 400));
		FrameChangeAdminDetails.setUndecorated(true);
		FrameChangeAdminDetails.setMinimumSize(new Dimension(700, 400));
		FrameChangeAdminDetails.setBounds(100, 100, 450, 300);
		FrameChangeAdminDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FrameChangeAdminDetails.getContentPane().setLayout(null);
		
		JLabel lblCurrentUsername = new JLabel("Current Username");
		lblCurrentUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurrentUsername.setBounds(138, 92, 129, 24);
		FrameChangeAdminDetails.getContentPane().add(lblCurrentUsername);
		
		JLabel lblCurrentPassword = new JLabel("Current Password");
		lblCurrentPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurrentPassword.setBounds(138, 127, 129, 24);
		FrameChangeAdminDetails.getContentPane().add(lblCurrentPassword);
		
		JLabel lblNewUsername = new JLabel("New Username");
		lblNewUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewUsername.setBounds(138, 162, 129, 24);
		FrameChangeAdminDetails.getContentPane().add(lblNewUsername);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewPassword.setBounds(138, 197, 129, 24);
		FrameChangeAdminDetails.getContentPane().add(lblNewPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConfirmPassword.setBounds(138, 232, 129, 24);
		FrameChangeAdminDetails.getContentPane().add(lblConfirmPassword);
		
		textCurrentUsername = new JTextField();
		textCurrentUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		textCurrentUsername.setBounds(304, 92, 250, 31);
		FrameChangeAdminDetails.getContentPane().add(textCurrentUsername);
		textCurrentUsername.setColumns(10);
		
		textNewUsername = new JTextField();
		textNewUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		textNewUsername.setColumns(10);
		textNewUsername.setBounds(304, 162, 250, 31);
		FrameChangeAdminDetails.getContentPane().add(textNewUsername);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentUsername = textCurrentUsername.getText();
				String currentPassword = textCurrentPassword.getText();
				String newUsername = textNewUsername.getText();
				String newPassword = textNewPassword.getText();
				String confirmPassword = textConfirmPassword.getText();
				
				String username = "";
				String password = "";
				try {
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					String query = "select username, password from admin where id = 1";
					ResultSet rs = st.executeQuery(query);
					rs.next();
					username = rs.getString(1);
					password = rs.getString(2);
				}catch(Exception f) {
					JOptionPane.showMessageDialog(null, "Connection Error!");
				}
				if(currentUsername.equals(username) && currentPassword.equals(password)) {
					if(newPassword.equals(confirmPassword)) {
						try {
//							Class.forName("com.mysql.cj.jdbc.com");
//							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/patient_details", "root", "password");
							Connection con = ConnectionProvider.getCon();
							Statement st = con.createStatement();
							String query = "update admin set username = '"  + newUsername + "', password = '" + newPassword + "' where id = 1";
							int count = st.executeUpdate(query);
							st.close();
							con.close();
							
							JOptionPane.showMessageDialog(null, "Username and Password Successfully Updated");
							FrameChangeAdminDetails.setVisible(false);
							new Login().FrameLogin.setVisible(true);
						}catch(Exception g) {
							JOptionPane.showMessageDialog(null, g);
						}
						
						
					}else {
						JOptionPane.showMessageDialog(null, "Password Mismatch");
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Current Username or Password is Invalid!");
				}
			}
		});
		btnSave.setBackground(new Color(0, 204, 0));
		btnSave.setForeground(new Color(255, 255, 255));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBounds(420, 305, 100, 31);
		FrameChangeAdminDetails.getContentPane().add(btnSave);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameChangeAdminDetails.setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(543, 305, 91, 31);
		FrameChangeAdminDetails.getContentPane().add(btnNewButton);
		
		textNewPassword = new JPasswordField();
		textNewPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		textNewPassword.setBounds(304, 197, 250, 28);
		FrameChangeAdminDetails.getContentPane().add(textNewPassword);
		
		textConfirmPassword = new JPasswordField();
		textConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		textConfirmPassword.setBounds(304, 228, 250, 28);
		FrameChangeAdminDetails.getContentPane().add(textConfirmPassword);
		
		JLabel lblHeading = new JLabel("Change Username and Password");
		lblHeading.setForeground(new Color(0, 0, 204));
		lblHeading.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblHeading.setIcon(new ImageIcon(ChangeAdminDetails.class.getResource("/HospitalManagementSystem/setting logo.png")));
		lblHeading.setBounds(187, 29, 319, 37);
		FrameChangeAdminDetails.getContentPane().add(lblHeading);
		
		textCurrentPassword = new JPasswordField();
		textCurrentPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		textCurrentPassword.setBounds(304, 127, 250, 31);
		FrameChangeAdminDetails.getContentPane().add(textCurrentPassword);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(ChangeAdminDetails.class.getResource("/HospitalManagementSystem/ChangeAdminDetailsBG.jpg")));
		lblBackground.setBounds(0, 0, 700, 400);
		FrameChangeAdminDetails.getContentPane().add(lblBackground);
	}
}
