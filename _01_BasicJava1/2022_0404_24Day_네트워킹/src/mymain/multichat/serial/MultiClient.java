package mymain.multichat.serial;

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
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiClient extends JFrame {
	
	//채팅창
	JTextArea jta_chatMonitor;
	
	//메시지 텍스트필드
	JTextField jtf_message;
	
	//목록창
	JList<String> jlist_userList;
	
	//서버 연결 버튼
	JButton jbt_connect;
		//버튼 토글
	boolean bConnect;
	
	//네트워크
	Socket client;
	//BufferedReader br;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	String nickname = "천사같은 악마";
	
	//더블 버퍼링 
	//화면상의 그림판
	JPanel grimPan;
	
	//메모리상 그림판(주의사항 : setVisible(true) 이후에 생성해야함)
	Image memPan;
	
	//선 정보
	int line_thick = 5;
	//int line_color = 0; //검정
	
	Color local_color = Color.red;

	//폰트
	Font font_regular = new Font("굴림체",Font.PLAIN,16);
	Font font_bold = new Font("굴림체",Font.BOLD,16);

	public MultiClient() {
		super("MultiChatRoom for Client");
		
		//채팅창 초기화
		init_charMonitor();
		
		//사용자 리스트 초기화
		init_userList();
		
		//입력창 초기화
		init_inputMessage();
		
		//그림판 초기화
		init_grimPan();
		
		//마우스 이벤트 초기화
		init_mouseEvent();

		//위치             x   y
		super.setLocation(200, 200);

		//크기
		pack();
		
		//크기변경 불가
		setResizable(false);

		//보여주기
		this.setVisible(true);

		//종료
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//메모리그림판 생성(grimPan과 호환되는 메모리상의 그림판)
		//시각적으로 볼 수 없는 메모리상의 그림판
		memPan = grimPan.createImage(400,400);

	}

	private void init_mouseEvent() {
		//그림판에서 마우스가 드래그되면(클릭 후 드래그)
		grimPan.addMouseMotionListener(new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				
				//네트워크 접속이 안되어 있으면 끝내라
				if(bConnect==false) {
					return;
				}
				
				//눌린좌표
				Point pt = e.getPoint();
				//Color -> int
				int line_color = local_color.getRGB();
				
				//네트워크로 전송
				//데이터 포장 
				try {
					String message = String.format("DRAW#%d#%d#%d#%d\n",pt.x,pt.y,line_thick,line_color);
					client.getOutputStream().write(message.getBytes());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				/*
				//메모리 그림판에 그릴 도구 구한다.
				Graphics g = memPan.getGraphics();
				g.setColor(local_color);
				g.fillOval(pt.x-line_thick,pt.y-line_thick,line_thick*2,line_thick);
				
				//그림판에 다시 출력
				grimPan.repaint(); //paintComponent(g)가 호출됨
				*/
			}
			
		});
	}

	private void init_grimPan() {
		//JComponent의 상태가 변경될 때마다 painComponent가 호출된다.
		grimPan = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				
				//메모리 그림판 -> 현재화면으로 복사
				g.drawImage(memPan, 0, 0, this);
			}
		};
		grimPan.setPreferredSize(new Dimension(400,400));
		this.add(grimPan,"West");
	}

	private void init_charMonitor() {
		JPanel jpl = new JPanel();
		jta_chatMonitor = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta_chatMonitor);
		jsp.setPreferredSize(new Dimension(400,400));
		jsp.setFont(font_regular);
		
		
		jta_chatMonitor.setEditable(false);
		jta_chatMonitor.setBackground(new Color(0xDECDBE));
		
		this.add(jsp);
	}
	
	private void init_userList() {
		jlist_userList = new JList<String>();
		
		JScrollPane jsp = new JScrollPane(jlist_userList);
		
		jsp.setPreferredSize(new Dimension(120,0));
		
		this.add(jsp,"East");
	}
	
	private void init_inputMessage() {
		
		//Bottom UI (default)
		JPanel jpl = new JPanel(new BorderLayout());
		
//		JTextField jtf_nickname = new JTextField("닉네임");
//		jpl.add(jtf_nickname,"West");
		
		jtf_message = new JTextField();
		jbt_connect = new JButton("연결");
		jbt_connect.setPreferredSize(new Dimension(120,0));
		jpl.add(jtf_message,"Center");
		jpl.add(jbt_connect,"East");
		
		//그림판 메뉴
		JPanel p1 = new JPanel(new GridLayout(1,3));
		p1.setPreferredSize(new Dimension(400,0));
		jpl.add(p1,"West");
		
		//1. 선굵기 메뉴
		Integer[] thick_array = {5,10,15,20,25,30};
		JComboBox<Integer> jcb_thick = new JComboBox<Integer>(thick_array);
		p1.add(jcb_thick);
		jcb_thick.setFont(font_bold);
		
		//2. 선색상
		JButton jbt_color = new JButton("선 색상");
		jbt_color.setFont(font_bold);
		p1.add(jbt_color);
		
		//3. 지우기
		JButton jbt_clear = new JButton("지우기");
		jbt_clear.setFont(font_bold);
		p1.add(jbt_clear);
		
		this.add(jpl,"South");
		
		//콤보박스 이벤트
		jcb_thick.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					line_thick = (Integer)jcb_thick.getSelectedItem();
				}	
			}
		});
		
		//선 색상 버튼 이벤트
		jbt_color.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				on_button_color();
			}
		});
		
		//지우기 버튼 눌렀을 때, 이벤트
		jbt_clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				on_button_clear();
			}
		});
		
		//연결버튼 눌렀을 때, 이벤트
		jbt_connect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//on_xxxx : callback method
				on_button_connect();
			}
		});//button ActionListener
		
		//메세지 창에서 입력시 이벤트
		jtf_message.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode(); //눌린 키 값
				if(key == KeyEvent.VK_ENTER) {
					send_message();
				}
			}
			
		});//KeyListener
		
	}//init_bottom()

	protected void send_message() {
		//연결되어 있지 않으면 (미연결 상태 안내하고) 끝내라
		String message = jtf_message.getText().trim();
		if(!bConnect) {
			JOptionPane.showMessageDialog(this, "연결하신 후 채팅을 이용할 수 있습니다.");
			return;
		}else {
			if(message.isEmpty()) {
				jtf_message.setText("");
				return;
			}
		}
		
		//전송메세지 포장
		try {
			String send_data = String.format("MSG#%s#%s\n", nickname,message);
			client.getOutputStream().write(send_data.getBytes());
			//이전 입력된 메세지 지우기
			jtf_message.setText("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void on_button_color() {
		Color tmp_color = JColorChooser.showDialog(this, "선색상을 선택하세요.", local_color);
		if(tmp_color != null) { //선택한 color가 있음
			local_color = tmp_color;
		}
	}
	
	protected void on_button_clear() {
		//메모리판을 지우기
		Graphics g = memPan.getGraphics();
		
		//지우기
		g.clearRect(0, 0, 400, 400);
		
		//메모리->화면복사
		grimPan.repaint();
	}

	protected void on_button_connect() {
		//toggle처리 : true(연결) <-> false(끊기);
		
		bConnect = !bConnect;
		
		if(bConnect) {  //연결
			try {
				client = new Socket("localhost",8000);
				
				oos = new ObjectOutputStream(client.getOutputStream());
				ois = new ObjectInputStream(client.getInputStream());
				
				Data data = new Data();
				data.protocol = Data.IN;
				data.nickname = nickname;
				
				oos.writeObject(data);
				oos.flush();
				
				read_message();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this,"연결실패");
				bConnect = false;
				return;
			}
		}else { //끊기
			try {
				client.close();
			} catch (IOException e) {
				// 
				e.printStackTrace();
			}
		}
		
		//버튼의 캡션(타이틀) 변경
		jbt_connect.setText(bConnect? "끊기" : "연결");
		
	}
	
	private void display_message(String message) {
		jta_chatMonitor.append(message);
		jta_chatMonitor.setFont(font_bold);
	}

	private void read_message() {
		try {
			InputStream is = client.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			//데이터 수신대기용 쓰레드 형성
			new Thread() {
				public void run() {
					while(true) {
						try {
							
							String readData = br.readLine();
							if(readData==null)break; //정상종료
							
							//사용자 프로토콜 종류에 따라 코드 진행
							String[] msg_array = readData.split("#");
							if(msg_array[0].equals("IN")) {
								String message = String.format("▶▶▶[%s]님이 입장하셨습니다.\n",msg_array[1]);
								display_message(message);
							}else if(msg_array[0].equals("OUT")) {
								String message = String.format("◀◀◀[%s]님이 퇴장하셨습니다.\n",msg_array[1]);
								display_message(message);
							}else if(msg_array[0].equals("LIST")) {
								display_userList(msg_array);
							}else if(msg_array[0].equals("MSG")) {
								String message = String.format("[%s님] %s\n",msg_array[1],msg_array[2]);
								display_message(message);
							}else if(msg_array[0].equals("DRAW")) {
								int x=0, y=0, thick=0, color=0;
								
								try {
									x = Integer.parseInt(msg_array[1]);
								} catch (Exception e) {
									//만약 사용자가 x값을 "x10"으로 보낸 경우, 날리기
									//(초기값으로 남기기)
								}
								
								try {
									y = Integer.parseInt(msg_array[2]);
								} catch (Exception e) {
									
								}
								
								try {
									thick = Integer.parseInt(msg_array[3]);
								} catch (Exception e) {
									
								}
								
								try {
									color = Integer.parseInt(msg_array[4]);
								} catch (Exception e) {
									
								}
								
								//메모리판에 그리기
								Graphics g = memPan.getGraphics();
								g.setColor(new Color(color));
								g.fillOval(x-thick, y-thick, thick*2, thick*2);
								
								//화면에 복사해라
								grimPan.repaint();
							}
							
						} catch (IOException e) {
							break; //서버에서 소켓 연결 끊겨서
						}
					}//end while
					
					//상대방 소켓이 끊긴 경우에 대한 코드
					bConnect = false; //끊어진 상태
					jbt_connect.setText("연결");
					
					//채팅창 지우기
					jta_chatMonitor.setText("");
					
					//유저목록초기화
					String[] user_array = new String[0]; 
					jlist_userList.setListData(user_array); //or null
					
					JOptionPane.showMessageDialog(MultiClient.this, "연결이 끊어졌습니다.");
					
				};//end run()
			}.start();
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}//try-catch
	}//read_message()

	protected void display_userList(String[] msg_array) {
		/*
		String[] user_array = new String[msg_array.length];
		for(int i =  msg_array.length-1; i > 0; i--) {
			user_array[i-1] = msg_array[i];
		}
		jlist_userList.setListData(user_array);
		*/
		msg_array[0] = "";
		jlist_userList.setListData(msg_array);
	}

	public static void main(String[] args) {
		new MultiClient();
	}//main
}//class