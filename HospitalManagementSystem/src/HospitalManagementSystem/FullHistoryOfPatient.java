package HospitalManagementSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Project.ConnectionProvider;
import net.proteanit.sql.DbUtils;

import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class FullHistoryOfPatient extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private JButton btnClose;
	private JLabel lblHeading;
	private JLabel lblBackgroundImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FullHistoryOfPatient frame = new FullHistoryOfPatient();
					frame.setVisible(true);
					frame.setLocation(170, 100);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FullHistoryOfPatient() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FullHistoryOfPatient.class.getResource("/HospitalManagementSystem/HMS Logo.png")));
		setLocation(new Point(300, 100));
		setUndecorated(true);
		setName("");
		setMinimumSize(new Dimension(1040, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1039, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setName("table");
		scrollPane.setBounds(32, 84, 978, 412);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		try {
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			String query = "select p.patientID as 'Patient ID', name as Name, contactNumber as 'Contact Number', age as Age, gender as Gender,"
					+ " bloodGroup as 'Blood Group', address as Address, anyMajorDisease as 'Any Major Disease', symptoms as Symptoms, "
					+ "diagnosis as Diagnosis, medicine as Medicines, wardReq as 'Ward Required', typeOfWard as 'Type of Ward' "
					+ "from patient p join patientRecord pr on p.patientID = pr.patientID";
			ResultSet rs = st.executeQuery(query);
//			table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			st.close();
			con.close();
		}catch(Exception g) {
			JOptionPane.showMessageDialog(null, "Connection Error!");
		}
		
		btnClose = new JButton("Close");
		btnClose.setBackground(Color.RED);
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnClose.setBounds(842, 529, 168, 38);
		contentPane.add(btnClose);
		
		lblHeading = new JLabel("FULL DETAILS OF PATIENTS");
		lblHeading.setIcon(new ImageIcon(FullHistoryOfPatient.class.getResource("/HospitalManagementSystem/Patient History icon.png")));
		lblHeading.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblHeading.setName("FULL HISTORY OF PATIENTS");
		lblHeading.setBounds(32, 25, 409, 48);
		contentPane.add(lblHeading);
		
		lblBackgroundImage = new JLabel("");
		lblBackgroundImage.setIcon(new ImageIcon(FullHistoryOfPatient.class.getResource("/HospitalManagementSystem/FullHistoryOfPatientBG.jpg")));
		lblBackgroundImage.setBounds(0, 0, 1040, 600);
		contentPane.add(lblBackgroundImage);
	}
}
