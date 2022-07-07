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
	Font font_regular = new Font("굴림체",Font.PLAIN,16);
	Font font_bold = new Font("굴림체",Font.BOLD,16);
	
	//네트워크 (서버 소켓)
	ServerSocket server;
	
	//쓰레드 동기화 관리 객체
	Object syncObj = new Object();
	
	//자소켓을 관리할 객체
	List<ReadThread> socketList = new ArrayList<ReadThread>();
	
	//유저 관리할 객체
	List<String> userList = new ArrayList<String>();

	public MultiServer2() {
		super("MultiChatRoom");
		
		init_chatMonitor();
		init_userListPane();
		init_bottom();
		
		//서버초기화
		init_server();

		//위치             x   y
		super.setLocation(800, 200);

		//크기
		pack();

		//보여주기
		this.setVisible(true);

		//종료
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//생성자

	private void init_server() {
		try {
			server = new ServerSocket(8000);
			display_message("서버 대기중\n");
			
			//별도 쓰레드 생성 : 접속 대기 용도
			new Thread() {
				public void run() {
					while(true) {
						try {
							Socket child = server.accept();//동기메소드(정지)
							
							synchronized (syncObj) 
							{ //이 과정이 끝날 때까지 아무것도 하지 말아라
								//접속과정
								ReadThread rt = new ReadThread(child);
								rt.start();
								//자소켓을 포함한 쓰레드 객체를 ArrayList에 추가
								socketList.add(rt);
								
								//접속자 수 출력 메소드
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
		new MultiServer2();
	}//main

//////////////////////////////////////////////////////////////	
	
	//MultiServer내부 클래스 선언 영역
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
		}//생성자


		//child소켓의 수신대기용도 이용
		@Override
		public void run() {
			while(true) {
				try {
					//역직렬화.
					Data data = (Data)ois.readObject();
					
					if(data==null) break; 
					
					//서버 모니터링
					display_message(
						String.format("[%d]-[%s]-[%s]", 
							data.getProtocol(), data.getNickname(), data.getMessage()
						)
					);
					
					//사용자 프로토콜에 따라 메세지 분류
					
					if(data.getProtocol()==Data.IN) {
						synchronized (syncObj) 
						{
							//새로 접속한 유저명을 등록
							userList.add(data.getNickname());
							//유저 목록을 JList에 출력
							display_userList();
							//현재 메세지(입장)를 접속된 모든 사용자에게 전송
							send_message_all(data); //엔터를 추가
							//현재 접속자 목록을 모든 사용자에게 전송
							send_userList_all();
						}//synchronized()
					}else {
						synchronized(syncObj) {
							//현재 메세지를 접속된 모든 사용자에게 전송
							send_message_all(data); //엔터를 추가
						}
					}
					
				} catch (Exception e) {
					//비정상 종료 시 (정전/프로그램 강제 종료...)
					break;
				}
			}// end-while
			
			int index = socketList.indexOf(this);
			
			//퇴장한 사용자의 닉네임
			String out_nickname = userList.get(index);
			
			synchronized(syncObj) {
				//소켓 종료 시 처리
				//>>소켓리스트에서 빼기
				socketList.remove(this);
				//>>유저 카운트 --
				display_userCount();
				
				//접속자 목록 갱신
				userList.remove(index);
				display_userList();
				
				//퇴장 정보 전송
				Data data = new Data();
				data.setProtocol(Data.OUT);
				data.setNickname(out_nickname);
				send_message_all(data);
				
				//현재 접속자 목록을 모든 사용자에게 전송
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