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

	
	//����� â
	JTextArea  jta_display;
	
	//�޽���â 
	JTextField  jtf_message;
	
	//������ ���
	JList<String> jlist_user_list;
	
	
	Font  font = new Font("����ü", Font.BOLD, 16);
	
	//�����ư
	JButton jbt_connect;
	
	boolean bConnect = false;//������������� �����ϴ� ����
		
	//��Ʈ��ũ
	Socket  client;
	
	
	//BufferedReader br;
	ObjectInputStream  ois;//��ü���Ž�Ʈ��
	ObjectOutputStream oos;//��ü�۽Ž�Ʈ��
	
	
	
	String  nickname="ä�ø�";
	
	
	//ȭ����� �׸���
	JPanel grimPan;
	
	//�޸𸮻� �׸���(���ǻ��� : setVisible(true)���Ŀ� ����)
	Image  memPan;
	
	//������
	int line_thick = 5;
	//int line_color = 0;
	Color local_color = Color.red;
	
	
	
	
	public MultiClient() {
		// TODO Auto-generated constructor stub
		super("��Ƽ Ŭ���̾�Ʈ");
		
		//���â �ʱ�ȭ
		init_display();
		
		//�޽��� �Է�â
		init_input_message();
		
		//������ ��� �ʱ�ȭ
		init_user_list();

		//�׸��� �ʱ�ȭ
		init_grimpan();
		
		//���콺 �̺�Ʈ �ʱ�ȭ
		init_mouse_event();
		

		//��ġ       x    y 
		this.setLocation(1000, 100);

		//ũ��
		//this.setSize(400, 400);
		pack();

		//ũ�⺯��Ұ�
		setResizable(false);
		
		//�����ֱ�
		this.setVisible(true);

		//����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�޸𸮱׸��� ����(grimPan�� ȣȯ�Ǵ� �޸𸮻��� �׸��� ����)
		memPan = grimPan.createImage(400, 400);

	}

	
	
	private void init_mouse_event() {
		// TODO Auto-generated method stub
		//�׸��ǿ��� ���콺�� �巡�׵Ǹ� 
		
		grimPan.addMouseMotionListener(new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				//super.mouseDragged(e);
				//System.out.println(e);
				
				//��Ʈ��ũ ������ �ȵǾ� ������ ������
				if(bConnect==false) {
					System.out.println("--��Ʈ��ũ ������ �̿��ϼ���--");
					return;
				}
				
				
				//������ǥ
				Point pt = e.getPoint();
								//��Ʈ��ũ ����
				
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
				
				//�޸� �׸���->����ȭ������ �����Ѵ�
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
		
		jbt_connect = new JButton("����");
		jbt_connect.setPreferredSize(new Dimension(120, 0));
		
		jtf_message.setFont(font);
		jbt_connect.setFont(font);
		
		
		p.add(jtf_message, "Center");
		p.add(jbt_connect, "East");
		
		//�׸��� �޴�
		JPanel p1 = new JPanel(new GridLayout(1, 3));
		p1.setPreferredSize(new Dimension(400, 0));
		p.add(p1,"West");
		
		//1.������޴�
		Integer [] thick_array = { 5,10,15,20,25,30 };
		JComboBox<Integer> jcb_thick = new JComboBox<Integer>(thick_array);
		p1.add(jcb_thick);
		jcb_thick.setFont(font);
		
		//2.������
		JButton jbt_color = new JButton("������");
		jbt_color.setFont(font);
		p1.add(jbt_color);
		
		//3.�����
		JButton jbt_clear = new JButton("�����");
		jbt_clear.setFont(font);
		p1.add(jbt_clear);
		
		
		//�޺��ڽ� �̺�Ʈ
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
		
		//������ ��ư
		jbt_color.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				on_button_color();
			}
		});
		
		
		
		//����� ��ư
		jbt_clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		        on_button_clear(); 		
			}
		});
		
		
		
		
		
		this.add(p,"South");
		
		
		//�����ư �������� �̺�Ʈ
		jbt_connect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//on_xxxx   : callback method
				on_button_connect();
			}
		});
		
		
		//�޽���â���� �Է½� �̺�Ʈ
		jtf_message.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				//super.keyPressed(e);
				int key = e.getKeyCode();//���� Ű��
				
				if(key==KeyEvent.VK_ENTER) {
										
					send_message();
					
				}
				
			}
			
		});
		
		
	}

	protected void on_button_clear() {
		// TODO Auto-generated method stub
		//�޸����� �����
		Graphics g = memPan.getGraphics();
		
		//������..
		g.clearRect(0, 0, 400, 400);
		
		//�޸�->ȭ�麹��
		grimPan.repaint();		
		
		
	}



	protected void on_button_color() {
		// TODO Auto-generated method stub
		
		Color im_color = JColorChooser.showDialog(this, "�������� �����ϼ���", local_color);
		
		//������ Į�� ������
		if(im_color != null) local_color = im_color;
		
		
	}



	protected void send_message() {
		// TODO Auto-generated method stub
		//����Ǿ����� ������ (�˷��ּ�)������
		if(bConnect==false) {
			
			jtf_message.setText("");
			
			JOptionPane.showMessageDialog(this, "�����Ͻ��� �̿��Ͻ� �� �ֽ��ϴ�!!");
			return;
		}
		
		//�Է� �޽��� �о����
		String message = jtf_message.getText().trim();
		if(message.isEmpty()) {
			jtf_message.setText("");
			return;
		}
		
		try {
			
			//���۸޽��� ���� : "MSG#��ȭ��#����\n"
			//String send_data = String.format("MSG#%s#%s\n", nickname, message);
			//client.getOutputStream().write(send_data.getBytes());
			
			Data data = new Data();
			data.protocol = Data.MSG;
			data.nickname = nickname;
			data.message  = message;
			
			oos.writeObject(data);
 
			//�����Էµ� �޽��� �����
			jtf_message.setText("");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}



	protected void on_button_connect() {
		// TODO Auto-generated method stub
		//toggle ó�� : true <-> false
		bConnect  = !bConnect;
		
		if(bConnect) {//����
			
			
			try {
				client = new Socket("localhost", 8000 );
				//client = new Socket("192.168.0.9", 8000 );
				
				//��ü��Ʈ�� �ʱ�ȭ:�����ϰ� Cross���·� (��:oos<->��:ois)
				oos = new ObjectOutputStream(client.getOutputStream());
				ois = new ObjectInputStream(client.getInputStream());
				
				
				//ù��° ���� �޽��� ���� -> "IN#ȫ�浿\n"
				//String send_message = String.format("IN#%s\n", nickname);
				//client.getOutputStream().write(send_message.getBytes());
				Data  data = new Data();
				data.protocol = Data.IN;
				data.nickname = nickname;
				
				oos.writeObject(data);//����
				
				
				
				//�޽��� ���Ŵ��
				read_message();
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				JOptionPane.showMessageDialog(this, "�������");
				bConnect = false;
				return;
			}
			
			
		}else {//����
			
			try {
				//������ �ݴ´�
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		//��ư�� ĸ��(Ÿ��Ʋ) ����
		jbt_connect.setText( bConnect ? "����" : "����" );
		
		
		
		
	}



	private void read_message() {
		// TODO Auto-generated method stub
		
		
			//������ ���Ŵ��� ������ ����
			new Thread() {
				
				public void run() {
					
					while(true) {
						
						try {
							
							Data data = (Data) ois.readObject();
							
							if(data==null)break;
							
							
							if(data.protocol == Data.IN) { //�����̸�..
								
								String message = String.format("��[%s]�� �����ϼ̽��ϴ�", data.nickname);
								display_message(message);
								
							}else if(data.protocol==Data.OUT) { //�����̸�..
								
								String message = String.format("��[%s]�� �����ϼ̽��ϴ�", data.nickname);
								display_message(message);
								
							}else if(data.protocol==Data.LIST) { //�����ڸ���̸�..
								
								display_user_list(data.userArray);
								
							}else if(data.protocol==Data.MSG) { //ä���̸�..
								
								String message = String.format("[%s]�� ����:\r\n   %s", 
										                    data.nickname, data.message  );
								display_message(message);
								
							}else if(data.protocol==Data.DRAW) { //�׸����..
																
								//�޸��ǿ� �׸���
								Graphics g = memPan.getGraphics();
								g.setColor( data.color );
								g.fillOval( data.pt.x - data.thick, data.pt.y-data.thick, data.thick*2, data.thick*2);
								
                                //ȭ�鿡 �����ض�
								grimPan.repaint();
																
								
							}
							
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
							break;
						}
						
					}//end-while
					
					//���� ������ �����쿡 ���� �ڵ�
					
					bConnect = false;//������ ����
					jbt_connect.setText("����");
					
					//ä��â �����
					jta_display.setText("");
					
					
					//��������ʱ�ȭ
					String [] user_array = new String[0];
					jlist_user_list.setListData(user_array);
					
					//JOptionPane.showMessageDialog(MultiClient.this, "������ ���������ϴ�");
					
					
					
					
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
		
		//�б�����
		jta_display.setEditable(false);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MultiClient();
	}

}