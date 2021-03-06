package mymain.multicast;

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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MulticastChat extends JFrame {

	//출력창
	JTextArea jta_display;
	
	//입력창
	JTextField jtf_message; //메시지 입력창
	
	JTextField jtf_address; //주소창
	
	
	JComboBox<String> jcb_dept;
	
	
	
	//미리 정해놓고 작업                 0          1           2           3            4        5
	String [] dept_name_array =     {"총무부",   "인사부",   "경리부",   "영업부"   ,"기획실",   "전체전송",};
	String [] dept_group_ip_array = {"224.0.0.1","224.0.0.2","224.0.0.3","224.0.0.4","224.0.0.5","255.255.255.255",};
	
	
	
	
	
	//대화명
	String nickname = "홍길동";
	
	Font font = new Font("굴림체", Font.BOLD, 16);
	//DatagramSockt     <- unicast / broadcast 
	//ㄴMulticastSocket <- multicast 
	MulticastSocket multicastSocket;
	
	//multicast group에 가입된 주소
	List<String> groupList = new ArrayList<String>();
	
	//group명에 대한 리스트
	List<String> groupNameList = new ArrayList<String>();
	
	
	//East쪽에 목록출력용 컴포넌트
	JList<String> jlist_group = new JList<String>();
	
	
	public MulticastChat() {
		// TODO Auto-generated constructor stub
		super("멀티캐스트 연습");

		//출력창 초기화
		init_display();
		
		
		//입력창 초기화
		init_inputs();
		
		//그룹목록창 초기화
		init_group_list();
		
		
		//키이벤트 초기화
		init_key_event();
		
		//소켓초기화
		init_socket();
		
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
		
		jlist_group.setFont(font);
		
		JScrollPane jsp = new JScrollPane(jlist_group);
		jsp.setPreferredSize(new Dimension(150,0));
		
		this.add(jsp,"East");
		
		//JList에 데이터 넣는 방법
		//String [] ip_array = {"224.0.0.1" , "224.0.0.2", "224.0.0.3"};
		//jlist_group.setListData(ip_array);
		
		
	}

	private void init_socket() {
		// TODO Auto-generated method stub
		
		try {
			//데이터 송수신
			multicastSocket = new MulticastSocket(5000);
			
			/*
			class ReadThread extends Thread{
				void run() {} 
			}
			Thread t = new ReadThread();
			t.start();
			*/
			
			//별도의 작업자(쓰레드)생성
			new Thread() {
				
				public void run() {
			
					//데이터 수신
					while(true)
					{
						read_message();
					}
				}
				
			}.start();
			
						
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	protected void read_message() {
		// TODO Auto-generated method stub
		
		try {
			
			byte [] read_buff = new byte[512];
			// 읽어온 데이터를 넣을 버퍼를 지정
			DatagramPacket dp = new DatagramPacket(read_buff, read_buff.length);
			//소켓을 통해서 수신
			multicastSocket.receive(dp);//메시지가 도착할때까지 대기중
			
			//전송지 주소
			InetAddress  you_ia = dp.getAddress();
			
			//읽어온 데이터 가져오기=> String객체로 생성 =>"홍길동#안녕하세요"
			String read_data =  new  String( dp.getData() ).trim();
			
			//#을 기준으로 분리                0          1
			//String [] read_data_array = { "홍길동","안녕하세요"};
			String [] read_data_array = read_data.split("#");
			
			
			//출력메시지 생성
			String display_message = String.format("[%s]님 말씀 : %s\r\n", 
					                           read_data_array[0],read_data_array[1]);
			
			jta_display.append(display_message);
			
			int position = jta_display.getDocument().getLength();//전체길이 구하기
			jta_display.setCaretPosition(position);
			
			System.out.printf("[%s]%s", you_ia.getHostAddress(), display_message);
					
			
			
		} catch (IOException e) {
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
		
		//입력메시지 읽어온다 : 공백제거...
		String message = jtf_message.getText().trim();
		
		//비어있냐?
		if(message.isEmpty()) {
			JOptionPane.showMessageDialog(this, "메시지를 입력하세요");
			jtf_message.setText("");//값비우기
			return;
		}
		
		//네트워크로 전송
		String ip = jtf_address.getText().trim();
		if(ip.isEmpty()) {
			JOptionPane.showMessageDialog(this, "전송지 주소를 입력하세요");
			jtf_address.setText("255.255.255.255");
			return;
		}
		
		// DatagramPacket :  Data + 주소(InetAddress)
		try {
			InetAddress ia = InetAddress.getByName(ip);
			
			//전송데이터 포장 :   send_data= "nickname#message"
			String send_data = String.format("%s#%s", nickname, message);
			//     String -> byte [] 추출
			byte []  send_bytes = send_data.getBytes();
			DatagramPacket dp = new DatagramPacket(send_bytes, send_bytes.length, ia, 5000);
			
			//소켓을 통해서 전송
			multicastSocket.send(dp);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*
		//출력
		//[홍길동]님 말씀: 안녕하세요..
		String display_message = String.format("[%s]님 말씀: %s\r\n", nickname, message);
		jta_display.append(display_message);
		//전체문서의 길이를 구한다
		int position  = jta_display.getDocument().getLength();
		jta_display.setCaretPosition(position);
		*/
		
		
		
		
		jtf_message.setText("");//입력메시지 지우기
		
		
	}
	

	private void init_inputs() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new GridLayout(4, 1));
		
		//0번째 줄 :
		jcb_dept = new JComboBox<String>(dept_name_array);
		
		
		//1번째 줄  : 주소
		//jtf_address = new JTextField("255.255.255.255"); // Global Broadcast주소
		jtf_address = new JTextField("224.0.0.1"); // Multicast 주소
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
		
		p.add(jcb_dept);
		p.add(jtf_address);
		p.add(p1);
		p.add(jtf_message);
		
		this.add(p,"South");
		
		
		//버튼이벤트 등록 
		jbt_join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//on_xxxx : callback(자동호출) 메소드
				on_button_join();
			}
		});
		
		//탈퇴버튼 클릭
		//lamdba식
		jbt_leave.addActionListener( e -> {  on_button_leave();  });
		
		
	}

	protected void on_button_join() {
		// TODO Auto-generated method stub
		//System.out.println("가입하기");
		int index = jcb_dept.getSelectedIndex();
		String dept_name = dept_name_array[index];
		String ip        = dept_group_ip_array[index];
		
		System.out.printf("%s/%s\n", dept_name, ip);
		
				
		
		//(기)가입여부 확인=> ArrayList내에 ip가 존재하냐?
		if(groupList.contains(ip)) {
			JOptionPane.showMessageDialog(this, "이미 가입된 주소입니다");
			return;
		}
		
		
		
		
		//가입하기
		try {
			
			//네트워크상 가입성공
			InetAddress ia = InetAddress.getByName(ip);
			multicastSocket.joinGroup(ia);
			
			//가입된 주소를 ArrayList넣는다
			groupList.add(ip);
			
			//가입된 그룹명을 ArrayList넣는다
			groupNameList.add(dept_name);
			
			//오른쪽 JList창 갱신
			update_group_list();
						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	private void update_group_list() {
		// TODO Auto-generated method stub
		
		//ArrayList -> Array추출
		String [] group_array = new String[groupNameList.size()];
		groupNameList.toArray(group_array);
		
		jlist_group.setListData(group_array);
		
		
	}

	protected void on_button_leave() {
		// TODO Auto-generated method stub
		//System.out.println("탈퇴하기");
		
		//JList로 부터 선택된 값(item)
		//String ip = jlist_group.getSelectedValue();
		
		int index = jlist_group.getSelectedIndex();
				
		
		//System.out.println(ip);
		if(index==-1) {
			JOptionPane.showMessageDialog(this, "탈퇴할 그룹주소를 선택하세요!!");
			return;
		}
		
		//System.out.println(index);
		//System.out.println(groupList.get(index));
		
		String ip = groupList.get(index); 
				
		
		//삭제 확인작업
		int result = JOptionPane.showConfirmDialog(this, 
				                                   "정말 탈퇴하시겠습니까",
				                                   "그룹탈퇴", 
				                                   JOptionPane.YES_NO_OPTION);
		//System.out.println(result);
		
		//삭제의사가 없으면(YES를 누루지 않았으면) 끝내라
		if(result != JOptionPane.YES_OPTION) return;
		
		
		try {
			//탈퇴작업
			InetAddress ia = InetAddress.getByName(ip);
			multicastSocket.leaveGroup(ia);
			
			//ArrayList에서 제거
			//int delete_index = groupList.indexOf(ip);
			
			groupList.remove(index);
			
			groupNameList.remove(index);
			
			//우측화면 갱신
			update_group_list();
						
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		
		
		
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
		new MulticastChat();
	}

}