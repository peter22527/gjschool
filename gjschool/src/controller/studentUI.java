package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.studentDaoImpl;
import model.student;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class studentUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField chi;
	private JTextField eng;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentUI frame = new studentUI();
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
	public studentUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 446, 55);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("學員管理系統");
		lblNewLabel.setBounds(183, 10, 88, 15);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 107, 446, 116);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("名");
		lblNewLabel_1.setBounds(33, 10, 24, 15);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("國文");
		lblNewLabel_2.setBounds(164, 10, 72, 15);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("英文");
		lblNewLabel_3.setBounds(304, 10, 72, 15);
		panel_1.add(lblNewLabel_3);
		
		name = new JTextField();
		name.setBounds(67, 7, 65, 21);
		panel_1.add(name);
		name.setColumns(10);
		
		chi = new JTextField();
		chi.setColumns(10);
		chi.setBounds(196, 7, 65, 21);
		panel_1.add(chi);
		
		eng = new JTextField();
		eng.setColumns(10);
		eng.setBounds(338, 7, 65, 21);
		panel_1.add(eng);
		
		JTextArea output = new JTextArea();
		output.setBounds(24, 276, 416, 93);
		contentPane.add(output);
		
		
		JButton btnNewButton_1 = new JButton("查詢string");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				output.setText(new studentDaoImpl().queryAll1());
				
			}
		});
		btnNewButton_1.setBounds(54, 238, 87, 23);
		contentPane.add(btnNewButton_1);
		
		
		JButton add = new JButton("新增");
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name=name.getText();
				int CHI=Integer.parseInt(chi.getText());
				int ENG=Integer.parseInt(eng.getText());
				
				student s=new student(Name,CHI,ENG);
				new studentDaoImpl().add(s);;
				
				
				
			}
		});
		add.setBounds(45, 65, 87, 23);
		panel_1.add(add);
		
		JButton btnNewButton_1_1 = new JButton("查詢Array");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<student> l=new studentDaoImpl().queryAll2();
				String show="";
				int sum=0;
				int i=0;
				for(student o:l)
				{
					i++;
					sum=sum+(o.getChi()+o.getEng());
					
					
					show=show+"id:"+o.getId()+
					"\t名:"+o.getName()+
					"\t國文:"+o.getChi()+
					"\t英文:"+o.getEng()+
					"\t總分:"+(o.getChi()+o.getEng())+
					"\n";
					
					
				}
				
				show=show+"\n總分合計="+sum+"\t平均="+(sum/i);
				output.setText(show);
			}
		});
		btnNewButton_1_1.setBounds(230, 238, 87, 23);
		contentPane.add(btnNewButton_1_1);
		
	
		
		
	
		
	}
}
