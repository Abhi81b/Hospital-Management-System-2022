package HospitalManagementSystem;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Frame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;

import Project.ConnectionProvider;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

import java.sql.*;
public class Login {

	public JFrame FrameLogin;
	private JTextField text_username;
	private JPasswordField text_password;

	/**
	 * Launch the application.
	 */
	private static String username = "";
	private static String password = "";
	
	public static void initializeAdminDetails() {
		try {
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			String query = "select username, password from admin where id = 1;";
			ResultSet rs = st.executeQuery(query);
			rs.next();
			username = rs.getString(1);
			password = rs.getString(2);
			st.close();
			con.close();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Connection Error!");
		}

	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.FrameLogin.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		initializeAdminDetails();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		FrameLogin = new JFrame();
		FrameLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/HospitalManagementSystem/HMS Logo.png")));
		FrameLogin.setUndecorated(true);
		FrameLogin.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		FrameLogin.setName("login_page");
		FrameLogin.setTitle("HMS - Login Page");
		FrameLogin.setExtendedState(Frame.MAXIMIZED_BOTH);
		FrameLogin.setResizable(false);
		FrameLogin.setMinimumSize(new Dimension(1366, 768));
		FrameLogin.setBounds(100, 100, 1382, 760);
		FrameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FrameLogin.getContentPane().setLayout(null);
		
		JLabel label_username = new JLabel("Username     :");
		label_username.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_username.setBounds(193, 239, 114, 30);
		FrameLogin.getContentPane().add(label_username);
		
		JLabel label_password = new JLabel("Password      :");
		label_password.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_password.setBounds(193, 314, 114, 26);
		FrameLogin.getContentPane().add(label_password);
		
		text_username = new JTextField();
		text_username.setFont(new Font("Tahoma", Font.BOLD, 16));
		text_username.setBounds(331, 239, 250, 30);
		FrameLogin.getContentPane().add(text_username);
		text_username.setColumns(10);
		
		JButton btn_login = new JButton("login");
		btn_login.setForeground(new Color(255, 255, 255));
		btn_login.setBackground(new Color(0, 153, 51));
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text_username.getText().equals(username) && text_password.getText().equals(password)) {
					FrameLogin.setVisible(false);
					 new Home().FrameHome.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
				}
			}
		});
		btn_login.setIcon(null);
		btn_login.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_login.setBounds(331, 405, 114, 30);
		FrameLogin.getContentPane().add(btn_login);
		
		JButton btn_close = new JButton("close");
		btn_close.setBackground(new Color(255, 0, 0));
		btn_close.setForeground(new Color(255, 255, 255));
		btn_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(null, "Do you really want to close application?", "Select", JOptionPane.YES_NO_OPTION);
				if(a==0) 
					System.exit(0);
			}
		});
		btn_close.setIcon(null);
		btn_close.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_close.setBounds(479, 405, 102, 30);
		FrameLogin.getContentPane().add(btn_close);
		
		text_password = new JPasswordField();
		text_password.setFont(new Font("Tahoma", Font.BOLD, 16));
		text_password.setBounds(331, 314, 250, 30);
		FrameLogin.getContentPane().add(text_password);
		
		JButton btnNewButton = new JButton("Change Admin Details");
		btnNewButton.setForeground(new Color(0, 51, 204));
		btnNewButton.setIcon(new ImageIcon(Login.class.getResource("/HospitalManagementSystem/setting logo.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChangeAdminDetails().FrameChangeAdminDetails.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(1029, 658, 229, 39);
		FrameLogin.getContentPane().add(btnNewButton);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(Login.class.getResource("/HospitalManagementSystem/login_background.png")));
		lblBackground.setBounds(0, 0, 1372, 768);
		FrameLogin.getContentPane().add(lblBackground);
	}
}
