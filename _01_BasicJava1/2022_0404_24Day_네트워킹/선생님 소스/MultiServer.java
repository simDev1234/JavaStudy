package mymain.multichat_serial;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiServer extends JFrame {

	
	//모니터 창
	JTextArea  jta_display;
	
	//접속자수
	JTextField  jtf_user_count;
	
	//접속자 목록
	JList<String> jlist_user_list;
	
	
	Font  font = new Font("굴림체", Font.BOLD, 16);
	
	
	//네트워크
	ServerSocket server;
	
	//쓰레드 동기화 관리객체
	Object syncObj = new Object();
	
	//자소켓을 관리할 객체
	List<ReadThread> socketList = new ArrayList<ReadThread>();
	
	//유저관리가 객체
	List<String>     userList   = new ArrayList<String>();
	
	
	public MultiServer() {
		// TODO Auto-generated constructor stub
		super("멀티서버");
		
		//출력창 초기화
		init_display();
		
		//접속자수 초기화
		init_user_count();
		
		//접속자 목록 초기화
		init_user_list();
		
		
		//display_message("서버 대기중...");
		//서버 초기화
		init_server();
		
		

		//위치            x    y 
		this.setLocation(600, 100);

		//크기
		//this.setSize(400, 400);
		pack();

		//보여주기
		this.setVisible(true);

		//종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_server() {
		// TODO Auto-generated method stub
		
		try {
			//8000 열기
			server = new ServerSocket(8000);
			
			display_message("--서버 대기중...--");
			//별도 쓰레드생성 : 접속대기용도
			// anonymous class
			new Thread() {
			
				@Override
				public void run() {
					
					while(true) {
						
						try {
							Socket child = server.accept();

							synchronized (syncObj) 
							{
								//접속과정
								ReadThread rt = new ReadThread(child);
								rt.start();
								//자소켓을 포함한 쓰레드객체를 ArrayList에 추가
								socketList.add(rt);
								
								//접속자수 출력
								display_user_count();
							}
							
							
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
					}//end-while
					
				}
				
			}.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void display_user_count() {
		// TODO Auto-generated method stub
		jtf_user_count.setText( socketList.size()+"" );
		
	}

	public void  display_message(String message) {
		
		jta_display.append(message);
		jta_display.append("\r\n");
		
		int position = jta_display.getDocument().getLength();
		jta_display.setCaretPosition(position);
				
	}
	
	
	private void init_user_list() {
		// TODO Auto-generated method stub
		jlist_user_list = new JList<String>();
		
		JScrollPane jsp = new JScrollPane(jlist_user_list); 
		
		jsp.setPreferredSize(new Dimension(120, 0));
		
		this.add(jsp, "East");
		
		
	}

	private void init_user_count() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new GridLayout(1, 3));
		
		JLabel jlb_user = new JLabel("접속자수:", JLabel.RIGHT);
		jlb_user.setFont(font);
		
		jtf_user_count = new JTextField("0");
		jtf_user_count.setFont(font);
		jtf_user_count.setHorizontalAlignment(JTextField.CENTER);
		
		
		JLabel jlb_count = new JLabel("(명)"); 
		jlb_count.setFont(font);
		
		p.add(jlb_user);
		p.add(jtf_user_count);
		p.add(jlb_count);
		
		this.add(p, "South");
	}

	private void init_display() {
		// TODO Auto-generated method stub
		jta_display = new JTextArea();
		jta_display.setFont(font);
		
		JScrollPane jsp = new JScrollPane(jta_display);
		jsp.setPreferredSize(new Dimension(400, 400));
		
		this.add(jsp , "Center");
		
		//읽기전송
		jta_display.setEditable(false);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MultiServer();
	}
	
	
//MultiServer내부클래스 선언영역.............//////
	class ReadThread extends Thread
	{
		Socket child;
		
		//BufferedReader br;
		ObjectInputStream  ois;
		ObjectOutputStream oos;
		
		public ReadThread(Socket child) {
			super();
			this.child = child;
			
			try {
				
				//client측에서   ObjectOutputStream을 먼저생성
				//server측에서는 ObjectInputStream먼저 생성
				ois = new ObjectInputStream(child.getInputStream());
				oos = new ObjectOutputStream(child.getOutputStream());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		//child소켓의 수신대기용도 이용
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				
				try {
					
					//객체로 수신(역직렬화)
					Data data = (Data) ois.readObject();
					
					if(data==null) break;
					
					
					//서버모니터링...
					display_message(String.format("[%d]-[%s]-[%s]", 
							      data.protocol,data.nickname,data.message));
					
					
					
					if(data.protocol==Data.IN) {//입장이면..
						
						synchronized (syncObj) 
						{
							//새로 접속한 유저명을 등록
							userList.add(data.nickname);
							//유저목록 JList출력
							display_user_list();
							
							//현재 메시지를 접속된 모든 사용자에게 전송
							send_message_all(data);
							
							//현재 접속자 목록을 모든 사용자에게 전송
							send_user_list_all();
						}
						
						
					}else {
						synchronized (syncObj) 
						{
						    //현재 메시지를 접속된 모든 사용자에게 전송
							send_message_all(data);
						
						}
					}
				
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					// 비정상 종료시(정전/프로그램강제종료.....)
					//System.out.println("--비정상종료--");
					break;
				}
				
			}//end-while
			
			
			
			synchronized (syncObj) 
			{
				//소켓종료시 처리...
				
				//현재 ArrayList에서 this의 위치를 구한다
				int index = socketList.indexOf(this);
				
				//퇴장한 사용자의 닉네임
				String out_nickname = userList.get(index);
				
				
				//현재쓰레드를 소켓리스트로부터 제거
				socketList.remove(index);
				display_user_count();//인원수 갱신정보 출력
				
				
				//접속자목록 갱신
				userList.remove(index);
				display_user_list();
				
				//퇴장정보 전송
								
				Data data = new Data();
				data.protocol = Data.OUT;
				data.nickname = out_nickname;
				
				send_message_all(data);
				
				//현재 접속자 목록을 모든 사용자에게 전송
				send_user_list_all();
						
			}
			
		}		
	}
//end-ReadThread////////////////////////////////////	

	
	public void display_user_list() {
		// TODO Auto-generated method stub
		String [] user_array = new String[userList.size()];
		userList.toArray(user_array);
		
		jlist_user_list.setListData(user_array);
		
	}

	
	public void send_user_list_all() {
	// TODO Auto-generated method stub
	
		//ArrayList - > Array
		String [] userArray = new String[userList.size()];
		userList.toArray(userArray);
		
		//현재접속자목록를 저장할데이터를 생성
		Data data = new Data();
		data.protocol = Data.LIST;//목록데이터
		data.userArray = userArray;
		
		//System.out.println(sb.toString());
		send_message_all(data);
		
		
	}

	public void send_message_all(Data data) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<socketList.size();i++) { //i = 0 1 2
			
			try {
				
				ReadThread rt = socketList.get(i);
				
				rt.oos.writeObject(data);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
	}
	
	
	
	
	

}