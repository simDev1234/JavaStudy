import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MulticastChat2 extends JFrame {

	//출력창
	JTextArea jta_display;
	
	//입력창
	JTextField jtf_message; //메시지 입력창
	
	JTextField jtf_address; //주소창
	
	//대화명
	String nickname = "홍길동";
	
	//DataGram : uni-cast/broadcast 둘다 됨
	//Multicast Socket -> DatagramSocket
	//Multicast : uni-cast/broadcast/multicast 셋다 됨
	MulticastSocket multicastSocket;
	
	//multicast group에 가입된 주소
	List<String> groupList = new ArrayList<String>();
	
	//group명에 대한 리스트
	List<String> groupNameList = new ArrayList<String>();
	
	//East쪽에 목록 출력용 컴포넌트
	JList<String> jlist_group = new JList<String>();
	
	Font font = new Font("굴림체", Font.BOLD, 16);
	
	public MulticastChat2() {
		// TODO Auto-generated constructor stub
		super("멀티캐스트 연습");

		//출력창 초기화
		init_display();
		
		//입력창 초기화
		init_inputs();
		
		//키이벤트 초기화
		init_key_event();
		
		//소캣초기화 (전구소캣 : 연결해주는 도구)
		//OS의 네트웍 라이브러리(기능)를 쉽게 쓸 수 있게 만들어 놓은 연결도구
		init_socket();
		
		//그룹목록창 초기화
		init_group_list();
		
		//위치       x    y 
		this.setLocation(200, 100);

		//크기
		//this.setSize(400, 400);
		pack();
		

		//보여주기
		this.setVisible(true);

		//종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_group_list() {
		// TODO Auto-generated method stub
		JScrollPane jsp = new JScrollPane(jlist_group);
		jsp.setPreferredSize(new Dimension(150,0)); // height는 전체 크기에 따라 달라져서 0으로 해도 됨
		this.add(jsp,"East");
		
		//JList에 데이터 넣는 방법
		/*
		String[] ip_array = {"224.0.0.1","224.0.0.2","224.0.0.3"};
		jlist_group.setListData(ip_array);
		jlist_group.setFont(font); */
		
	}

	private void init_socket() {
		// TODO Auto-generated method stub
		
		
		try {
			multicastSocket = new MulticastSocket(5000);
			
			//별도의 작업자(쓰레드)생성
			new Thread() {
				public void run() {
					//데이터 수신
					while(true) 
					{
						read_message();
					}
				};
			}.start();
			/*
			class ReadThread extends Thread{
				public void run() {}
			}
			Thread t = new ReadThread();
			t.start();
			*/
			
//			while(true) {
//				//데이터 수신대기(Main-primary Thread-에서 작업X << 다른 작업이 막힘)
//				
//			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void read_message() {
		// TODO Auto-generated method stub
		//UDC의 최대 크기 : 512
		try {
			byte[] read_buff = new byte[512];
			//읽어온 데이터를 넣을 버퍼를 지정
			DatagramPacket dp = new DatagramPacket(read_buff,read_buff.length);
			//소켓 통해 수신 : [수신 버퍼] --> 수신
			multicastSocket.receive(dp); //메세지가 도착할 때까지 대기중
			
			//전송지 주소
			InetAddress you_ia = dp.getAddress();
			
			//읽어온 데이터 가져오기 => String 객체로 생성 : "홍길동#안녕하세요   (공백)"
			String read_data = new String(dp.getData()).trim(); //dp.getData() || read_buff
			
			//#을 기준으로 분리
			//String[] read_data_array = {"홍길동","안녕하세요"};
			String[] read_data_array = read_data.split("#");
			
			//출력 메세지 생성
			String display_message = String.format("[%s]님 말씀 : %s%n", read_data_array[0], read_data_array[1]);
			
			jta_display.append(display_message);
			int position = jta_display.getDocument().getLength(); //전체 길이 구하기
			jta_display.setCaretPosition(position);
			
			System.out.printf("[%s]%s",you_ia,display_message);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void init_key_event() {
		// TODO Auto-generated method stub
		jtf_message.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				//super.keyPressed(e);
				int key = e.getKeyCode();
				
				//Enter Key가 눌리면
				if(key == KeyEvent.VK_ENTER) {
					send_message();
				}
			}
		});
	
	}

	protected void send_message() {
		// TODO Auto-generated method stub
		String message = jtf_message.getText().trim();
		
		//비어있냐?
		if(message.isEmpty()) {
			JOptionPane.showMessageDialog(this, "메세지를 입력하세요.");
			jtf_message.setText(""); // 값 비우기
			return;
		}
		
		//네트워크로 전송
		String ip = jtf_address.getText().trim();
		if(ip.isEmpty()) {
			JOptionPane.showMessageDialog(this, "전송지 주소를 입력하세요.");
			jtf_address.setText("255.255.255.255");
			return;
		}
		
		//DatagramPacket + 주소(InetAddress) 
		//*packet : 네트워크에서 1회 전송할 데이터 크기
		try {
			InetAddress ia = InetAddress.getByName(ip); //이 ip 주소가 한명이 쓰는 거면 uni-cast
			//전송 데이터 포장 : nickname#message << #를 구분자로 
			String send_data = String.format("%s#%s", nickname,message);
			byte[] send_bytes = send_data.getBytes();
			DatagramPacket dp = new DatagramPacket(send_bytes, send_bytes.length, ia, 5000);
			
			//소켓을 통해서 전송
			multicastSocket.send(dp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		jtf_message.setText("");//입력메세지 지우기
		/*
		//출력
		//[홍길동]님 말씀 : 안녕하세요..
		//TextArea에 출력할 때는 \r\n 둘 다 쳐야 ENTER가 됨
		String display_message = String.format("[%s]님 말씀 : %s\r\n", nickname,message);
		jta_display.append(display_message);
		
		//전체문서의 길이
		int position = jta_display.getDocument().getLength();
		
		jta_display.setCaretPosition(position);
		
		jtf_message.setText("");//입력메세지 지우기
		*/
	}
	

	private void init_inputs() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new GridLayout(3, 1));
		
		//1번째 줄  : 주소
		//jtf_address = new JTextField("255.255.255.255"); // Global Broadcast주소
		jtf_address = new JTextField("224.0.0.1"); //Multicast 주소
		jtf_address.setFont(font);
		
		//2번째 줄 : 가입 / 탈퇴버튼
		JPanel  p1 = new JPanel(new GridLayout(1, 2));
		JButton jbt_join  = new JButton("가입");
		JButton jbt_leave = new JButton("탈퇴"); 
		jbt_join.setFont(font);
		jbt_leave.setFont(font);
				
		p1.add(jbt_join);
		p1.add(jbt_leave);
		
		//3번째 줄 : 메시지창
		jtf_message = new JTextField();
		jtf_message.setFont(font);
		
		
		p.add(jtf_address);
		p.add(p1);
		p.add(jtf_message);
		
		this.add(p,"South");
		
		//버튼이벤트 등록
		jbt_join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				on_button_join();
			}
		});
		
		//탈퇴 버튼 클릭
		//람다식
		jbt_leave.addActionListener((e) -> {on_button_leave();});
	}

	private void on_button_leave() {
		// TODO Auto-generated method stub
		//JList로부터 선택된 값
		String ip = jlist_group.getSelectedValue();
		
		if(ip==null) {
			JOptionPane.showMessageDialog(this, "탈퇴할 주소를 입력하세요.");
			return;
		}
		
		//(기) 가입 여부 확인 
		if(groupList.contains(ip)) {
			int result = JOptionPane.showConfirmDialog(this, "정말로 탈퇴하시겠습니까?",
					"그룹탈퇴",JOptionPane.YES_NO_OPTION);
			if(result==JOptionPane.YES_OPTION) {
				//탈퇴 
				try {
					//네트워크상 탈퇴
					InetAddress ia = InetAddress.getByName(ip);
					multicastSocket.leaveGroup(ia);
					
					//groupList에서 삭제
					groupList.remove(ip);
					
					//JList초기화
					update_group_list();
					
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}else{
				return;
			}
		}
		
		
		
	}

	protected void on_button_join() {
		// TODO Auto-generated method stub
		//1. 주소를 읽어온다.
		String ip = jtf_address.getText().trim();
		if(ip.isEmpty()) {
			JOptionPane.showMessageDialog(this,"가입할 주소를 입력하세요.");
			jtf_address.setText("224.0.0.1");
			return;
		}
		
		//(기) 가입여부 확인 => ArrayLIst내에 ip가 존재하냐?
		if(groupList.contains(ip)) {
			JOptionPane.showMessageDialog(this, "이미 가입된 주소입니다.");
			return;
		}
		
		//가입
		try {
			
			//네트워크상 가입 성공
			InetAddress ia = InetAddress.getByName(ip);
			multicastSocket.joinGroup(ia);
			
			//가입된 주소를 ArrayList에 넣기
			groupList.add(ip);
			
			//오른쪽 JList창 갱신
			update_group_list();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void update_group_list() {
		// TODO Auto-generated method stub
		//ArrayList에서 Array로 추출
		String[] groupArray = new String[groupList.size()];
		groupList.toArray(groupArray);
		jlist_group.setListData(groupArray);
	}

	private void init_display() {
		// TODO Auto-generated method stub
		jta_display = new JTextArea();
		
		JScrollPane jsp= new JScrollPane(jta_display);
		
		jsp.setPreferredSize(new Dimension(400, 400));
		
		this.add(jsp,"Center");
		
		//jta_display 읽기전용
		jta_display.setEditable(false);
		
		jta_display.setFont(font);		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MulticastChat2();
	}

}