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
	
	//ä��â
	JTextArea jta_chatMonitor;
	
	//�޽��� �ؽ�Ʈ�ʵ�
	JTextField jtf_message;
	
	//���â
	JList<String> jlist_userList;
	
	//���� ���� ��ư
	JButton jbt_connect;
		//��ư ���
	boolean bConnect;
	
	//��Ʈ��ũ
	Socket client;
	//BufferedReader br;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	String nickname = "õ�簰�� �Ǹ�";
	
	//���� ���۸� 
	//ȭ����� �׸���
	JPanel grimPan;
	
	//�޸𸮻� �׸���(���ǻ��� : setVisible(true) ���Ŀ� �����ؾ���)
	Image memPan;
	
	//�� ����
	int line_thick = 5;
	//int line_color = 0; //����
	
	Color local_color = Color.red;

	//��Ʈ
	Font font_regular = new Font("����ü",Font.PLAIN,16);
	Font font_bold = new Font("����ü",Font.BOLD,16);

	public MultiClient() {
		super("MultiChatRoom for Client");
		
		//ä��â �ʱ�ȭ
		init_charMonitor();
		
		//����� ����Ʈ �ʱ�ȭ
		init_userList();
		
		//�Է�â �ʱ�ȭ
		init_inputMessage();
		
		//�׸��� �ʱ�ȭ
		init_grimPan();
		
		//���콺 �̺�Ʈ �ʱ�ȭ
		init_mouseEvent();

		//��ġ             x   y
		super.setLocation(200, 200);

		//ũ��
		pack();
		
		//ũ�⺯�� �Ұ�
		setResizable(false);

		//�����ֱ�
		this.setVisible(true);

		//����
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//�޸𸮱׸��� ����(grimPan�� ȣȯ�Ǵ� �޸𸮻��� �׸���)
		//�ð������� �� �� ���� �޸𸮻��� �׸���
		memPan = grimPan.createImage(400,400);

	}

	private void init_mouseEvent() {
		//�׸��ǿ��� ���콺�� �巡�׵Ǹ�(Ŭ�� �� �巡��)
		grimPan.addMouseMotionListener(new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				
				//��Ʈ��ũ ������ �ȵǾ� ������ ������
				if(bConnect==false) {
					return;
				}
				
				//������ǥ
				Point pt = e.getPoint();
				//Color -> int
				int line_color = local_color.getRGB();
				
				//��Ʈ��ũ�� ����
				//������ ���� 
				try {
					String message = String.format("DRAW#%d#%d#%d#%d\n",pt.x,pt.y,line_thick,line_color);
					client.getOutputStream().write(message.getBytes());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				/*
				//�޸� �׸��ǿ� �׸� ���� ���Ѵ�.
				Graphics g = memPan.getGraphics();
				g.setColor(local_color);
				g.fillOval(pt.x-line_thick,pt.y-line_thick,line_thick*2,line_thick);
				
				//�׸��ǿ� �ٽ� ���
				grimPan.repaint(); //paintComponent(g)�� ȣ���
				*/
			}
			
		});
	}

	private void init_grimPan() {
		//JComponent�� ���°� ����� ������ painComponent�� ȣ��ȴ�.
		grimPan = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				
				//�޸� �׸��� -> ����ȭ������ ����
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
		
//		JTextField jtf_nickname = new JTextField("�г���");
//		jpl.add(jtf_nickname,"West");
		
		jtf_message = new JTextField();
		jbt_connect = new JButton("����");
		jbt_connect.setPreferredSize(new Dimension(120,0));
		jpl.add(jtf_message,"Center");
		jpl.add(jbt_connect,"East");
		
		//�׸��� �޴�
		JPanel p1 = new JPanel(new GridLayout(1,3));
		p1.setPreferredSize(new Dimension(400,0));
		jpl.add(p1,"West");
		
		//1. ������ �޴�
		Integer[] thick_array = {5,10,15,20,25,30};
		JComboBox<Integer> jcb_thick = new JComboBox<Integer>(thick_array);
		p1.add(jcb_thick);
		jcb_thick.setFont(font_bold);
		
		//2. ������
		JButton jbt_color = new JButton("�� ����");
		jbt_color.setFont(font_bold);
		p1.add(jbt_color);
		
		//3. �����
		JButton jbt_clear = new JButton("�����");
		jbt_clear.setFont(font_bold);
		p1.add(jbt_clear);
		
		this.add(jpl,"South");
		
		//�޺��ڽ� �̺�Ʈ
		jcb_thick.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					line_thick = (Integer)jcb_thick.getSelectedItem();
				}	
			}
		});
		
		//�� ���� ��ư �̺�Ʈ
		jbt_color.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				on_button_color();
			}
		});
		
		//����� ��ư ������ ��, �̺�Ʈ
		jbt_clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				on_button_clear();
			}
		});
		
		//�����ư ������ ��, �̺�Ʈ
		jbt_connect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//on_xxxx : callback method
				on_button_connect();
			}
		});//button ActionListener
		
		//�޼��� â���� �Է½� �̺�Ʈ
		jtf_message.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode(); //���� Ű ��
				if(key == KeyEvent.VK_ENTER) {
					send_message();
				}
			}
			
		});//KeyListener
		
	}//init_bottom()

	protected void send_message() {
		//����Ǿ� ���� ������ (�̿��� ���� �ȳ��ϰ�) ������
		String message = jtf_message.getText().trim();
		if(!bConnect) {
			JOptionPane.showMessageDialog(this, "�����Ͻ� �� ä���� �̿��� �� �ֽ��ϴ�.");
			return;
		}else {
			if(message.isEmpty()) {
				jtf_message.setText("");
				return;
			}
		}
		
		//���۸޼��� ����
		try {
			String send_data = String.format("MSG#%s#%s\n", nickname,message);
			client.getOutputStream().write(send_data.getBytes());
			//���� �Էµ� �޼��� �����
			jtf_message.setText("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void on_button_color() {
		Color tmp_color = JColorChooser.showDialog(this, "�������� �����ϼ���.", local_color);
		if(tmp_color != null) { //������ color�� ����
			local_color = tmp_color;
		}
	}
	
	protected void on_button_clear() {
		//�޸����� �����
		Graphics g = memPan.getGraphics();
		
		//�����
		g.clearRect(0, 0, 400, 400);
		
		//�޸�->ȭ�麹��
		grimPan.repaint();
	}

	protected void on_button_connect() {
		//toggleó�� : true(����) <-> false(����);
		
		bConnect = !bConnect;
		
		if(bConnect) {  //����
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
				JOptionPane.showMessageDialog(this,"�������");
				bConnect = false;
				return;
			}
		}else { //����
			try {
				client.close();
			} catch (IOException e) {
				// 
				e.printStackTrace();
			}
		}
		
		//��ư�� ĸ��(Ÿ��Ʋ) ����
		jbt_connect.setText(bConnect? "����" : "����");
		
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
			
			//������ ���Ŵ��� ������ ����
			new Thread() {
				public void run() {
					while(true) {
						try {
							
							String readData = br.readLine();
							if(readData==null)break; //��������
							
							//����� �������� ������ ���� �ڵ� ����
							String[] msg_array = readData.split("#");
							if(msg_array[0].equals("IN")) {
								String message = String.format("������[%s]���� �����ϼ̽��ϴ�.\n",msg_array[1]);
								display_message(message);
							}else if(msg_array[0].equals("OUT")) {
								String message = String.format("������[%s]���� �����ϼ̽��ϴ�.\n",msg_array[1]);
								display_message(message);
							}else if(msg_array[0].equals("LIST")) {
								display_userList(msg_array);
							}else if(msg_array[0].equals("MSG")) {
								String message = String.format("[%s��] %s\n",msg_array[1],msg_array[2]);
								display_message(message);
							}else if(msg_array[0].equals("DRAW")) {
								int x=0, y=0, thick=0, color=0;
								
								try {
									x = Integer.parseInt(msg_array[1]);
								} catch (Exception e) {
									//���� ����ڰ� x���� "x10"���� ���� ���, ������
									//(�ʱⰪ���� �����)
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
								
								//�޸��ǿ� �׸���
								Graphics g = memPan.getGraphics();
								g.setColor(new Color(color));
								g.fillOval(x-thick, y-thick, thick*2, thick*2);
								
								//ȭ�鿡 �����ض�
								grimPan.repaint();
							}
							
						} catch (IOException e) {
							break; //�������� ���� ���� ���ܼ�
						}
					}//end while
					
					//���� ������ ���� ��쿡 ���� �ڵ�
					bConnect = false; //������ ����
					jbt_connect.setText("����");
					
					//ä��â �����
					jta_chatMonitor.setText("");
					
					//��������ʱ�ȭ
					String[] user_array = new String[0]; 
					jlist_userList.setListData(user_array); //or null
					
					JOptionPane.showMessageDialog(MultiClient.this, "������ ���������ϴ�.");
					
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