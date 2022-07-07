package mymain.multichat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import mymain.multichat.serial.Data;

public class MultiServer2 extends JFrame {
	
	JTextArea jta_chatMonitor;
	JTextField jtf_userCount;
	JList<String> jlist_userList;
	Font font_regular = new Font("����ü",Font.PLAIN,16);
	Font font_bold = new Font("����ü",Font.BOLD,16);
	
	//��Ʈ��ũ (���� ����)
	ServerSocket server;
	
	//������ ����ȭ ���� ��ü
	Object syncObj = new Object();
	
	//�ڼ����� ������ ��ü
	List<ReadThread> socketList = new ArrayList<ReadThread>();
	
	//���� ������ ��ü
	List<String> userList = new ArrayList<String>();

	public MultiServer2() {
		super("MultiChatRoom");
		
		init_chatMonitor();
		init_userListPane();
		init_bottom();
		
		//�����ʱ�ȭ
		init_server();

		//��ġ             x   y
		super.setLocation(800, 200);

		//ũ��
		pack();

		//�����ֱ�
		this.setVisible(true);

		//����
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//������

	private void init_server() {
		try {
			server = new ServerSocket(8000);
			display_message("���� �����\n");
			
			//���� ������ ���� : ���� ��� �뵵
			new Thread() {
				public void run() {
					while(true) {
						try {
							Socket child = server.accept();//����޼ҵ�(����)
							
							synchronized (syncObj) 
							{ //�� ������ ���� ������ �ƹ��͵� ���� ���ƶ�
								//���Ӱ���
								ReadThread rt = new ReadThread(child);
								rt.start();
								//�ڼ����� ������ ������ ��ü�� ArrayList�� �߰�
								socketList.add(rt);
								
								//������ �� ��� �޼ҵ�
								display_userCount();
							
							}//synchronized()
						} catch (IOException e) {
							e.printStackTrace();
						}
					}//end while
				};
			}.start();
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}//end try-catch
	}//end init_server

	protected void display_userCount() {
		jtf_userCount.setText(String.valueOf(socketList.size()));
	}

	private void init_chatMonitor() {
		JPanel jpl = new JPanel();
		jta_chatMonitor = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta_chatMonitor);
		jsp.setPreferredSize(new Dimension(400,400));
		jsp.setFont(font_regular);
		
		jta_chatMonitor.setEditable(false);
		jta_chatMonitor.setBackground(new Color(0xDECDBE));
		
		this.add(jsp);
	}
	
	private void display_message(String message) {
		jta_chatMonitor.append(message);
		jta_chatMonitor.setFont(font_bold);
	}
	
	private void init_userListPane() {
		jlist_userList = new JList<String>();
		
		JScrollPane jsp = new JScrollPane(jlist_userList);
		
		jsp.setPreferredSize(new Dimension(120,0));
		
		this.add(jsp,"East");
	}
	
	private void init_bottom() {
		JPanel jpl_bottom = new JPanel(new GridLayout(1,3));
		JLabel jlb_user = new JLabel("�����ڼ� ",JLabel.RIGHT);
		jlb_user.setFont(new Font("����ü",Font.BOLD,12));
		
		jtf_userCount = new JTextField("0");
		jtf_userCount.setFont(font_bold);
		jtf_userCount.setHorizontalAlignment(JTextField.CENTER);
		
		JLabel jlb_myong = new JLabel("(��)",JLabel.LEFT);
		jlb_myong.setFont(new Font("����ü",Font.BOLD,12));
		
		jpl_bottom.add(jlb_user);
		jpl_bottom.add(jtf_userCount);
		jpl_bottom.add(jlb_myong);
		
		
		this.add(jpl_bottom,"South");
	}

	public static void main(String[] args) {
		new MultiServer2();
	}//main

//////////////////////////////////////////////////////////////	
	
	//MultiServer���� Ŭ���� ���� ����
	class ReadThread extends Thread{
		Socket child;
		
		ObjectOutputStream oos;
		ObjectInputStream ois;
		
		public ReadThread(Socket child) {
			super();
			this.child = child;
			
			try {
				ois = new ObjectInputStream(child.getInputStream());
				oos = new ObjectOutputStream(child.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//������


		//child������ ���Ŵ��뵵 �̿�
		@Override
		public void run() {
			while(true) {
				try {
					//������ȭ.
					Data data = (Data)ois.readObject();
					
					if(data==null) break; 
					
					//���� ����͸�
					display_message(
						String.format("[%d]-[%s]-[%s]", 
							data.getProtocol(), data.getNickname(), data.getMessage()
						)
					);
					
					//����� �������ݿ� ���� �޼��� �з�
					
					if(data.getProtocol()==Data.IN) {
						synchronized (syncObj) 
						{
							//���� ������ �������� ���
							userList.add(data.getNickname());
							//���� ����� JList�� ���
							display_userList();
							//���� �޼���(����)�� ���ӵ� ��� ����ڿ��� ����
							send_message_all(data); //���͸� �߰�
							//���� ������ ����� ��� ����ڿ��� ����
							send_userList_all();
						}//synchronized()
					}else {
						synchronized(syncObj) {
							//���� �޼����� ���ӵ� ��� ����ڿ��� ����
							send_message_all(data); //���͸� �߰�
						}
					}
					
				} catch (Exception e) {
					//������ ���� �� (����/���α׷� ���� ����...)
					break;
				}
			}// end-while
			
			int index = socketList.indexOf(this);
			
			//������ ������� �г���
			String out_nickname = userList.get(index);
			
			synchronized(syncObj) {
				//���� ���� �� ó��
				//>>���ϸ���Ʈ���� ����
				socketList.remove(this);
				//>>���� ī��Ʈ --
				display_userCount();
				
				//������ ��� ����
				userList.remove(index);
				display_userList();
				
				//���� ���� ����
				Data data = new Data();
				data.setProtocol(Data.OUT);
				data.setNickname(out_nickname);
				send_message_all(data);
				
				//���� ������ ����� ��� ����ڿ��� ����
				send_userList_all();
			}//synchronized()
		}//run()	
		
	}//end ReadThread class
	
	private void display_userList() {
		
		String[] user_array = new String[userList.size()];
		userList.toArray(user_array);
		
		jlist_userList.setListData(user_array);
		
	}//display_userList()

	public void send_userList_all() {
		
		String[] userArray = new String[userList.size()];
		userList.toArray(userArray);
		
		Data data = new Data();
		data.setProtocol(Data.LIST);
		
		send_message_all(data);
	}

	public void send_message_all(Data data) {
		
		for(int i = 0; i < socketList.size(); i++) {
			try {
				ReadThread rt = socketList.get(i);
				rt.oos.writeObject(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}//send_message_all()
	
}//end 