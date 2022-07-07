package mymain.multichat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class MultiServer extends JFrame {
	
	JTextArea jta_chatMonitor;
	JTextField jtf_userCount;
	JList<String> jlist_userList;
	Font font_regular = new Font("굴림체",Font.PLAIN,16);
	Font font_bold = new Font("굴림체",Font.BOLD,16);

	public MultiServer() {
		super("MultiChatRoom for Server");
		
		init_charMonitor();
		init_userList();
		init_bottom();

		display_message("서버 대기중...");

		//위치             x   y
		super.setLocation(200, 200);

		//크기
		pack();

		//보여주기
		this.setVisible(true);

		//종료
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void init_charMonitor() {
		JPanel jpl = new JPanel();
		jta_chatMonitor = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta_chatMonitor);
		jsp.setPreferredSize(new Dimension(400,400));
		jsp.setFont(font_regular);
		
		jta_chatMonitor.setEditable(false);
		jta_chatMonitor.setBackground(new Color(0xDECDBE));
		
		this.add(jsp,"West");
	}
	
	private void display_message(String message) {
		jta_chatMonitor.append(message);
		jta_chatMonitor.setFont(font_bold);
	}
	
	private void init_userList() {
		jlist_userList = new JList<String>();
		
		JScrollPane jsp = new JScrollPane(jlist_userList);
		
		jsp.setPreferredSize(new Dimension(120,0));
		
		this.add(jsp,"East");
	}
	
	private void init_bottom() {
		JPanel jpl_bottom = new JPanel(new GridLayout(1,3));
		JLabel jlb_user = new JLabel("접속자수 ",JLabel.RIGHT);
		jlb_user.setFont(new Font("굴림체",Font.BOLD,12));
		
		jtf_userCount = new JTextField("0");
		jtf_userCount.setFont(font_bold);
		jtf_userCount.setHorizontalAlignment(JTextField.CENTER);
		
		JLabel jlb_myong = new JLabel("(명)",JLabel.LEFT);
		jlb_myong.setFont(new Font("굴림체",Font.BOLD,12));
		
		jpl_bottom.add(jlb_user);
		jpl_bottom.add(jtf_userCount);
		jpl_bottom.add(jlb_myong);
		
		
		this.add(jpl_bottom,"South");
	}

	public static void main(String[] args) {
		new MultiServer();
	}
}