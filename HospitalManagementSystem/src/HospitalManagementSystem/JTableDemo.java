package HospitalManagementSystem;
import java.sql.*;
import Project.ConnectionProvider;
import net.proteanit.sql.DbUtils;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JTableDemo extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTableDemo frame = new JTableDemo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JTableDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setBounds(23, 121, 656, 112);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnShow = new JButton("Display Data");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
//					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/patient_details", "root", "password");
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select * from student");
					table.setModel(DbUtils.resultSetToTableModel(rs));
//					ResultSetMetaData rsmd = rs.getMetaData();
//					DefaultTableModel model = (DefaultTableModel) table.getModel();
//					
//					int col = rsmd.getColumnCount();
//					String[] colName = new String[col];
//					for(int i = 0; i< col; i++) {
//						colName[i] = rsmd.getColumnName(i+1);
//					}
//					model.setColumnIdentifiers(colName);
//					String id, name, marks, age;
//					while(rs.next()) {
//						id = rs.getString(1);
//						name = rs.getString(2);
//						marks = rs.getString(3);
//						age = rs.getString(4);
//						String[] row = {id, name, marks, age};
//						model.addRow(row);
//					}
//					st.close();
//					con.close();
				} catch (Exception f) {
					// TODO Auto-generated catch block
					f.printStackTrace();
				}
				
			}
		});
		btnShow.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnShow.setBounds(68, 43, 154, 32);
		contentPane.add(btnShow);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel());
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(304, 43, 147, 32);
		contentPane.add(btnNewButton);
	}
}
