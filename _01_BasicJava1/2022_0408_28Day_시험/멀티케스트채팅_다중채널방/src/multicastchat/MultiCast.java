package multicastchat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class MultiCast extends JFrame{
	
	//����� nickname
	String nickName = "���ɳ�����";
	
	//�������
	boolean bConnect;
	
	/* LNB : ä�� ��ư*/
	//���� ���
	final String[] CHANNEL_NAME = {"��ü ����","ROOM_01","ROOM_02","ROOM_03","ROOM_04","ROOM_05"};
	//���� ��IP
	final String[] CHANNEL_IP = {"255.255.255.255","224.0.0.1","224.0.0.2","224.0.0.3","224.0.0.4","224.0.0.5"};
	//�� ��ư on/off����
	List<Boolean> buttonCount;
	
	//����
	MulticastSocket socket;
	
	//���� �� & ip
	String channelName;
	String channelIP;
	
	/* ���� ���� : ä�ü������ + ä��â + �ؽ�Ʈinput */
	//ä�ü������
	JLabel jlb_channelName;
	JButton jbt_connect;
	//ä��â
	JTextArea jta_chat;
	//�ؽ�Ʈinput
	JTextField jtf_input;
	
	
	MultiCast(){
		
		readMessage();
		init_lnbArea();
		init_chatArea();
		
		setTitle("chatRoom");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLocation(300,300);
		
		pack();
	}
	
	////////////////////////////////////////////////////////////
	/*  UI Design  */

	private void init_lnbArea() {
		JPanel jpl = new JPanel(new BorderLayout(5,5));
		JPanel jpl_channel = new JPanel(new GridLayout(7,1,5,5));
		JLabel title = new JLabel("��ü ���·�",JLabel.CENTER);
		JButton channel0 = new JButton(CHANNEL_NAME[0]);
		JButton channel1 = new JButton(CHANNEL_NAME[1]);
		JButton channel2 = new JButton(CHANNEL_NAME[2]);
		JButton channel3 = new JButton(CHANNEL_NAME[3]);
		JButton channel4 = new JButton(CHANNEL_NAME[4]);
		JButton channel5 = new JButton(CHANNEL_NAME[5]);
		JPanel blank = new JPanel();
		//��ư ��ġ Ƚ�� 
		buttonCount = new ArrayList<Boolean>(6);
		for(int i = 0; i < 6; i++)
			buttonCount.add(false);
		
		jpl_channel.add(title);
		jpl_channel.add(channel0);
		jpl_channel.add(channel1);
		jpl_channel.add(channel2);
		jpl_channel.add(channel3);
		jpl_channel.add(channel4);
		jpl_channel.add(channel5);
		jpl_channel.setPreferredSize(new Dimension(100,200));
		jpl.add(jpl_channel,"North");
		jpl.add(blank);
		blank.setPreferredSize(new Dimension(100,120));
		jpl_channel.setBackground(new Color(0xDECDBE));
		blank.setBackground(new Color(0xDECDBE));
		jpl.setBackground(new Color(0xDECDBE));
		this.add(jpl,"West");
		
		channel0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(bConnect) {
					JOptionPane.showMessageDialog(MultiCast.this, "�̹� �ٸ� �뿡 ���� ���Դϴ�. ���� ���� �������ּ���.");
					return;
				}
				jbt_connect.setVisible(true);
				channelLabeling(0);
				channelSet(0);
			}

		});
		
		channel1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(bConnect) {
					JOptionPane.showMessageDialog(MultiCast.this, "�̹� �ٸ� �뿡 ���� ���Դϴ�. ���� ���� �������ּ���.");
					return;
				}
				jbt_connect.setVisible(true);
				channelLabeling(1);
				channelSet(1);
			}

		});
		
		channel2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(bConnect) {
					JOptionPane.showMessageDialog(MultiCast.this, "�̹� �ٸ� �뿡 ���� ���Դϴ�. ���� ���� �������ּ���.");
					return;
				}
				jbt_connect.setVisible(true);
				channelLabeling(2);
				channelSet(2);
			}

		});
		
		channel3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(bConnect) {
					JOptionPane.showMessageDialog(MultiCast.this, "�̹� �ٸ� �뿡 ���� ���Դϴ�. ���� ���� �������ּ���.");
					return;
				}
				jbt_connect.setVisible(true);
				channelLabeling(3);
				channelSet(3);
			}

		});
		
		channel4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(bConnect) {
					JOptionPane.showMessageDialog(MultiCast.this, "�̹� �ٸ� �뿡 ���� ���Դϴ�. ���� ���� �������ּ���.");
					return;
				}
				jbt_connect.setVisible(true);
				channelLabeling(4);
				channelSet(4);
			}

		});
		
		channel5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(bConnect) {
					JOptionPane.showMessageDialog(MultiCast.this, "�̹� �ٸ� �뿡 ���� ���Դϴ�. ���� ���� �������ּ���.");
					return;
				}
				jbt_connect.setVisible(true);
				channelLabeling(5);
				channelSet(5);
			}

		});
	}//init_lnbArea()

	private void init_chatArea() {
		JPanel jpl = new JPanel(new BorderLayout());
		
		//�뼳�����
		JPanel jpl_area = new JPanel(new BorderLayout());
		jlb_channelName = new JLabel("���� �����ϼ���.");
		jbt_connect = new JButton("����");
		jbt_connect.setVisible(false);
		jpl_area.add(jlb_channelName,"West");
		jpl_area.add(jbt_connect,"East");
		jpl_area.setPreferredSize(new Dimension(400,30));
		
		//���� ��ư Action
		jbt_connect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bConnect = !bConnect;
				if(bConnect) {
					on_button_join();
				}else {
					on_button_leave();
				}
					
			}//actionPerformed()
		});//addActionListener()
		
		//ä��â
		jta_chat = new JTextArea();
		JScrollPane jsp_scroll = new JScrollPane(jta_chat);
		jsp_scroll.setPreferredSize(new Dimension(400,300));
		jta_chat.setEditable(false);
		jta_chat.setVisible(false);
		
		jpl.add(jpl_area,"North");
		jpl.add(jsp_scroll);
		
		this.add(jpl);
		
		//�Է�â
		jtf_input = new JTextField("�ƹ� �����̳� �Է��� ���͸� ġ����.");
		jpl.add(jtf_input,"South");
		jtf_input.setVisible(false);
		
		jtf_input.addCaretListener(new CaretListener() {
			
			@Override
			public void caretUpdate(CaretEvent e) {
				if(jtf_input.getText().trim().equals("�ƹ� �����̳� �Է��� ���͸� ġ����."))
					jtf_input.setText("");
			}
		});
		
		jtf_input.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key==KeyEvent.VK_ENTER) {
					sendMessage();
					jtf_input.setText("");
				}
			}
			 
		});
	}

	

	///////////////////////////////////////////////////////////////////////
	/*  Network Connect  */

	private void channelSet(int index) {
		//���� ��, IP�� ����
		this.channelName = CHANNEL_NAME[index];
		this.channelIP = CHANNEL_IP[index];
	}
	
	private void sendMessage() {
		
		String message = jtf_input.getText().trim();
		if(message.isEmpty())
			return;
		
		//��Ʈ��ũ �۽�
		try {
			InetAddress ip = InetAddress.getByName(channelIP);
			
			String data = String.format("%s#%s", nickName,jtf_input.getText());
			byte[] byteArr = data.getBytes();
			DatagramPacket packet = new DatagramPacket(byteArr,0,byteArr.length,ip,5000);
			socket.send(packet);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "������ ����ƽ��ϴ�.");
		}
	}
	
	protected void readMessage() {
		//��Ʈ��ũ ���� ���(�ټ��� ����ڿ��Լ� ���� ����)
		try {
			socket = new MulticastSocket(5000);
			new Thread() {
				@Override
				public void run() {
					while(true) {
						byte[] byteArr = new byte[512];
						DatagramPacket packet = new DatagramPacket(byteArr,512);
						try {
							socket.receive(packet);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						String[] data_raw = new String(packet.getData()).trim().split("#");
						String data = String.format("[%s] %s", data_raw[0],data_raw[1]);
						jta_chat.append(data+"\n");
						
						int position = jta_chat.getDocument().getLength();
						jta_chat.setCaretPosition(position);
					}	
				}
			}.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}//readMessage()
	
	protected void on_button_join() {
		jbt_connect.setText("����");
		jta_chat.setVisible(true);
		jtf_input.setVisible(true);
		
		try {
			socket.joinGroup(InetAddress.getByName(channelIP));
		} catch (Exception e) {
			
		}
	}
	
	protected void on_button_leave() {
		jbt_connect.setText("����");
		jta_chat.setVisible(false);
		jtf_input.setVisible(false);
		
		try {
			socket.leaveGroup(InetAddress.getByName(channelIP));
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(this, "IP�ּ� �Է¹��� ����");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "���� ����");
		}
		
		jta_chat.setText("");
	}
	
	private void channelLabeling(int index) {
		String channelName = CHANNEL_NAME[index];
		jlb_channelName.setText(String.format("  %s", channelName));
	}
	
	/////////////////////////////////////////////////////////////////////
	/* main method */
	public static void main(String[] args) {
		new MultiCast();
	}//end main
	
}
