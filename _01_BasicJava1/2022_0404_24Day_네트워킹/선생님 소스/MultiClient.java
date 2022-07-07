package mymain.multichat_serial;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiClient extends JFrame {

	
	//모니터 창
	JTextArea  jta_display;
	
	//메시지창 
	JTextField  jtf_message;
	
	//접속자 목록
	JList<String> jlist_user_list;
	
	
	Font  font = new Font("굴림체", Font.BOLD, 16);
	
	//연결버튼
	JButton jbt_connect;
	
	boolean bConnect = false;//연결상태정보를 저장하는 변수
		
	//네트워크
	Socket  client;
	
	
	//BufferedReader br;
	ObjectInputStream  ois;//객체수신스트림
	ObjectOutputStream oos;//객체송신스트림
	
	
	
	String  nickname="채팅맨";
	
	
	//화면상의 그림판
	JPanel grimPan;
	
	//메모리상 그림판(주의사항 : setVisible(true)이후에 생성)
	Image  memPan;
	
	//선정보
	int line_thick = 5;
	//int line_color = 0;
	Color local_color = Color.red;
	
	
	
	
	public MultiClient() {
		// TODO Auto-generated constructor stub
		super("멀티 클라이언트");
		
		//출력창 초기화
		init_display();
		
		//메시지 입력창
		init_input_message();
		
		//접속자 목록 초기화
		init_user_list();

		//그림판 초기화
		init_grimpan();
		
		//마우스 이벤트 초기화
		init_mouse_event();
		

		//위치       x    y 
		this.setLocation(1000, 100);

		//크기
		//this.setSize(400, 400);
		pack();

		//크기변경불가
		setResizable(false);
		
		//보여주기
		this.setVisible(true);

		//종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//메모리그림판 생성(grimPan가 호환되는 메모리상의 그림판 생성)
		memPan = grimPan.createImage(400, 400);

	}

	
	
	private void init_mouse_event() {
		// TODO Auto-generated method stub
		//그림판에서 마우스가 드래그되면 
		
		grimPan.addMouseMotionListener(new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				//super.mouseDragged(e);
				//System.out.println(e);
				
				//네트워크 접속이 안되어 있으면 끝내라
				if(bConnect==false) {
					System.out.println("--네트워크 연결후 이용하세요--");
					return;
				}
				
				
				//눌린좌표
				Point pt = e.getPoint();
								//네트워크 전송
				
				try {
					
					Data data = new Data();
					data.protocol = Data.DRAW;
					data.pt       = pt;
					data.thick    = line_thick;
					data.color    = local_color;
					
					oos.writeObject(data);
										
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
								
				
				
				
			}
			
		});
		
		
	}



	private void init_grimpan() {
		// TODO Auto-generated method stub
		
		grimPan = new JPanel() {
			
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				//super.paintComponent(g);
				
				//메모리 그림판->현재화면으로 복사한다
				g.drawImage(memPan, 0, 0, this);
				
			}
			
		};
		
		grimPan.setPreferredSize(new Dimension(400, 400));
		
		this.add(grimPan, "West");
		
	}



	private void init_input_message() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new BorderLayout());
		
		jtf_message = new JTextField();
		
		jbt_connect = new JButton("연결");
		jbt_connect.setPreferredSize(new Dimension(120, 0));
		
		jtf_message.setFont(font);
		jbt_connect.setFont(font);
		
		
		p.add(jtf_message, "Center");
		p.add(jbt_connect, "East");
		
		//그림판 메뉴
		JPanel p1 = new JPanel(new GridLayout(1, 3));
		p1.setPreferredSize(new Dimension(400, 0));
		p.add(p1,"West");
		
		//1.선굵기메뉴
		Integer [] thick_array = { 5,10,15,20,25,30 };
		JComboBox<Integer> jcb_thick = new JComboBox<Integer>(thick_array);
		p1.add(jcb_thick);
		jcb_thick.setFont(font);
		
		//2.선색상
		JButton jbt_color = new JButton("선색상");
		jbt_color.setFont(font);
		p1.add(jbt_color);
		
		//3.지우기
		JButton jbt_clear = new JButton("지우기");
		jbt_clear.setFont(font);
		p1.add(jbt_clear);
		
		
		//콤보박스 이벤트
		jcb_thick.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(e);
				if(e.getStateChange()==ItemEvent.SELECTED) {
				  
					line_thick = (Integer)jcb_thick.getSelectedItem();
				}
			}
		});
		
		//선색상 버튼
		jbt_color.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				on_button_color();
			}
		});
		
		
		
		//지우기 버튼
		jbt_clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		        on_button_clear(); 		
			}
		});
		
		
		
		
		
		this.add(p,"South");
		
		
		//연결버튼 눌렀을때 이벤트
		jbt_connect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//on_xxxx   : callback method
				on_button_connect();
			}
		});
		
		
		//메시지창에서 입력시 이벤트
		jtf_message.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				//super.keyPressed(e);
				int key = e.getKeyCode();//눌린 키값
				
				if(key==KeyEvent.VK_ENTER) {
										
					send_message();
					
				}
				
			}
			
		});
		
		
	}

	protected void on_button_clear() {
		// TODO Auto-generated method stub
		//메모리판을 지우기
		Graphics g = memPan.getGraphics();
		
		//지워라..
		g.clearRect(0, 0, 400, 400);
		
		//메모리->화면복사
		grimPan.repaint();		
		
		
	}



	protected void on_button_color() {
		// TODO Auto-generated method stub
		
		Color im_color = JColorChooser.showDialog(this, "선색상을 선택하세요", local_color);
		
		//선택한 칼라가 있으면
		if(im_color != null) local_color = im_color;
		
		
	}



	protected void send_message() {
		// TODO Auto-generated method stub
		//연결되어있지 않으면 (알려주소)끝내라
		if(bConnect==false) {
			
			jtf_message.setText("");
			
			JOptionPane.showMessageDialog(this, "연결하신후 이용하실 수 있습니다!!");
			return;
		}
		
		//입력 메시지 읽어오기
		String message = jtf_message.getText().trim();
		if(message.isEmpty()) {
			jtf_message.setText("");
			return;
		}
		
		try {
			
			//전송메시지 포장 : "MSG#대화명#내용\n"
			//String send_data = String.format("MSG#%s#%s\n", nickname, message);
			//client.getOutputStream().write(send_data.getBytes());
			
			Data data = new Data();
			data.protocol = Data.MSG;
			data.nickname = nickname;
			data.message  = message;
			
			oos.writeObject(data);
 
			//이전입력된 메시지 지우기
			jtf_message.setText("");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}



	protected void on_button_connect() {
		// TODO Auto-generated method stub
		//toggle 처리 : true <-> false
		bConnect  = !bConnect;
		
		if(bConnect) {//연결
			
			
			try {
				client = new Socket("localhost", 8000 );
				//client = new Socket("192.168.0.9", 8000 );
				
				//객체스트림 초기화:상대소켓과 Cross형태로 (나:oos<->너:ois)
				oos = new ObjectOutputStream(client.getOutputStream());
				ois = new ObjectInputStream(client.getInputStream());
				
				
				//첫번째 입장 메시지 전송 -> "IN#홍길동\n"
				//String send_message = String.format("IN#%s\n", nickname);
				//client.getOutputStream().write(send_message.getBytes());
				Data  data = new Data();
				data.protocol = Data.IN;
				data.nickname = nickname;
				
				oos.writeObject(data);//전송
				
				
				
				//메시지 수신대기
				read_message();
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				JOptionPane.showMessageDialog(this, "연결실패");
				bConnect = false;
				return;
			}
			
			
		}else {//끊기
			
			try {
				//소켓을 닫는다
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		//버튼의 캡션(타이틀) 변경
		jbt_connect.setText( bConnect ? "끊기" : "연결" );
		
		
		
		
	}



	private void read_message() {
		// TODO Auto-generated method stub
		
		
			//데이터 수신대기용 쓰레드 생성
			new Thread() {
				
				public void run() {
					
					while(true) {
						
						try {
							
							Data data = (Data) ois.readObject();
							
							if(data==null)break;
							
							
							if(data.protocol == Data.IN) { //입장이면..
								
								String message = String.format("▶[%s]님 입장하셨습니다", data.nickname);
								display_message(message);
								
							}else if(data.protocol==Data.OUT) { //퇴장이면..
								
								String message = String.format("◀[%s]님 퇴장하셨습니다", data.nickname);
								display_message(message);
								
							}else if(data.protocol==Data.LIST) { //접속자목록이면..
								
								display_user_list(data.userArray);
								
							}else if(data.protocol==Data.MSG) { //채팅이면..
								
								String message = String.format("[%s]님 말씀:\r\n   %s", 
										                    data.nickname, data.message  );
								display_message(message);
								
							}else if(data.protocol==Data.DRAW) { //그리기면..
																
								//메모리판에 그리기
								Graphics g = memPan.getGraphics();
								g.setColor( data.color );
								g.fillOval( data.pt.x - data.thick, data.pt.y-data.thick, data.thick*2, data.thick*2);
								
                                //화면에 복사해라
								grimPan.repaint();
																
								
							}
							
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
							break;
						}
						
					}//end-while
					
					//상대방 소켓이 끊긴경우에 대한 코드
					
					bConnect = false;//끊어진 상태
					jbt_connect.setText("연결");
					
					//채팅창 지우기
					jta_display.setText("");
					
					
					//유저목록초기화
					String [] user_array = new String[0];
					jlist_user_list.setListData(user_array);
					
					//JOptionPane.showMessageDialog(MultiClient.this, "연결이 끊어졌습니다");
					
					
					
					
				}//end-run
				
			}.start();
		
		
	}



	protected void display_user_list(String[] user_array) {
		// TODO Auto-generated method stub
		
		jlist_user_list.setListData(user_array);
		
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
		new MultiClient();
	}

}