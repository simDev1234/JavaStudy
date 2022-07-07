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

	//���â
	JTextArea jta_display;
	
	//�Է�â
	JTextField jtf_message; //�޽��� �Է�â
	
	JTextField jtf_address; //�ּ�â
	
	//��ȭ��
	String nickname = "ȫ�浿";
	
	//DataGram : uni-cast/broadcast �Ѵ� ��
	//Multicast Socket -> DatagramSocket
	//Multicast : uni-cast/broadcast/multicast �´� ��
	MulticastSocket multicastSocket;
	
	//multicast group�� ���Ե� �ּ�
	List<String> groupList = new ArrayList<String>();
	
	//group�� ���� ����Ʈ
	List<String> groupNameList = new ArrayList<String>();
	
	//East�ʿ� ��� ��¿� ������Ʈ
	JList<String> jlist_group = new JList<String>();
	
	Font font = new Font("����ü", Font.BOLD, 16);
	
	public MulticastChat2() {
		// TODO Auto-generated constructor stub
		super("��Ƽĳ��Ʈ ����");

		//���â �ʱ�ȭ
		init_display();
		
		//�Է�â �ʱ�ȭ
		init_inputs();
		
		//Ű�̺�Ʈ �ʱ�ȭ
		init_key_event();
		
		//��Ĺ�ʱ�ȭ (������Ĺ : �������ִ� ����)
		//OS�� ��Ʈ�� ���̺귯��(���)�� ���� �� �� �ְ� ����� ���� ���ᵵ��
		init_socket();
		
		//�׷���â �ʱ�ȭ
		init_group_list();
		
		//��ġ       x    y 
		this.setLocation(200, 100);

		//ũ��
		//this.setSize(400, 400);
		pack();
		

		//�����ֱ�
		this.setVisible(true);

		//����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_group_list() {
		// TODO Auto-generated method stub
		JScrollPane jsp = new JScrollPane(jlist_group);
		jsp.setPreferredSize(new Dimension(150,0)); // height�� ��ü ũ�⿡ ���� �޶����� 0���� �ص� ��
		this.add(jsp,"East");
		
		//JList�� ������ �ִ� ���
		/*
		String[] ip_array = {"224.0.0.1","224.0.0.2","224.0.0.3"};
		jlist_group.setListData(ip_array);
		jlist_group.setFont(font); */
		
	}

	private void init_socket() {
		// TODO Auto-generated method stub
		
		
		try {
			multicastSocket = new MulticastSocket(5000);
			
			//������ �۾���(������)����
			new Thread() {
				public void run() {
					//������ ����
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
//				//������ ���Ŵ��(Main-primary Thread-���� �۾�X << �ٸ� �۾��� ����)
//				
//			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void read_message() {
		// TODO Auto-generated method stub
		//UDC�� �ִ� ũ�� : 512
		try {
			byte[] read_buff = new byte[512];
			//�о�� �����͸� ���� ���۸� ����
			DatagramPacket dp = new DatagramPacket(read_buff,read_buff.length);
			//���� ���� ���� : [���� ����] --> ����
			multicastSocket.receive(dp); //�޼����� ������ ������ �����
			
			//������ �ּ�
			InetAddress you_ia = dp.getAddress();
			
			//�о�� ������ �������� => String ��ü�� ���� : "ȫ�浿#�ȳ��ϼ���   (����)"
			String read_data = new String(dp.getData()).trim(); //dp.getData() || read_buff
			
			//#�� �������� �и�
			//String[] read_data_array = {"ȫ�浿","�ȳ��ϼ���"};
			String[] read_data_array = read_data.split("#");
			
			//��� �޼��� ����
			String display_message = String.format("[%s]�� ���� : %s%n", read_data_array[0], read_data_array[1]);
			
			jta_display.append(display_message);
			int position = jta_display.getDocument().getLength(); //��ü ���� ���ϱ�
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
				
				//Enter Key�� ������
				if(key == KeyEvent.VK_ENTER) {
					send_message();
				}
			}
		});
	
	}

	protected void send_message() {
		// TODO Auto-generated method stub
		String message = jtf_message.getText().trim();
		
		//����ֳ�?
		if(message.isEmpty()) {
			JOptionPane.showMessageDialog(this, "�޼����� �Է��ϼ���.");
			jtf_message.setText(""); // �� ����
			return;
		}
		
		//��Ʈ��ũ�� ����
		String ip = jtf_address.getText().trim();
		if(ip.isEmpty()) {
			JOptionPane.showMessageDialog(this, "������ �ּҸ� �Է��ϼ���.");
			jtf_address.setText("255.255.255.255");
			return;
		}
		
		//DatagramPacket + �ּ�(InetAddress) 
		//*packet : ��Ʈ��ũ���� 1ȸ ������ ������ ũ��
		try {
			InetAddress ia = InetAddress.getByName(ip); //�� ip �ּҰ� �Ѹ��� ���� �Ÿ� uni-cast
			//���� ������ ���� : nickname#message << #�� �����ڷ� 
			String send_data = String.format("%s#%s", nickname,message);
			byte[] send_bytes = send_data.getBytes();
			DatagramPacket dp = new DatagramPacket(send_bytes, send_bytes.length, ia, 5000);
			
			//������ ���ؼ� ����
			multicastSocket.send(dp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		jtf_message.setText("");//�Է¸޼��� �����
		/*
		//���
		//[ȫ�浿]�� ���� : �ȳ��ϼ���..
		//TextArea�� ����� ���� \r\n �� �� �ľ� ENTER�� ��
		String display_message = String.format("[%s]�� ���� : %s\r\n", nickname,message);
		jta_display.append(display_message);
		
		//��ü������ ����
		int position = jta_display.getDocument().getLength();
		
		jta_display.setCaretPosition(position);
		
		jtf_message.setText("");//�Է¸޼��� �����
		*/
	}
	

	private void init_inputs() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new GridLayout(3, 1));
		
		//1��° ��  : �ּ�
		//jtf_address = new JTextField("255.255.255.255"); // Global Broadcast�ּ�
		jtf_address = new JTextField("224.0.0.1"); //Multicast �ּ�
		jtf_address.setFont(font);
		
		//2��° �� : ���� / Ż���ư
		JPanel  p1 = new JPanel(new GridLayout(1, 2));
		JButton jbt_join  = new JButton("����");
		JButton jbt_leave = new JButton("Ż��"); 
		jbt_join.setFont(font);
		jbt_leave.setFont(font);
				
		p1.add(jbt_join);
		p1.add(jbt_leave);
		
		//3��° �� : �޽���â
		jtf_message = new JTextField();
		jtf_message.setFont(font);
		
		
		p.add(jtf_address);
		p.add(p1);
		p.add(jtf_message);
		
		this.add(p,"South");
		
		//��ư�̺�Ʈ ���
		jbt_join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				on_button_join();
			}
		});
		
		//Ż�� ��ư Ŭ��
		//���ٽ�
		jbt_leave.addActionListener((e) -> {on_button_leave();});
	}

	private void on_button_leave() {
		// TODO Auto-generated method stub
		//JList�κ��� ���õ� ��
		String ip = jlist_group.getSelectedValue();
		
		if(ip==null) {
			JOptionPane.showMessageDialog(this, "Ż���� �ּҸ� �Է��ϼ���.");
			return;
		}
		
		//(��) ���� ���� Ȯ�� 
		if(groupList.contains(ip)) {
			int result = JOptionPane.showConfirmDialog(this, "������ Ż���Ͻðڽ��ϱ�?",
					"�׷�Ż��",JOptionPane.YES_NO_OPTION);
			if(result==JOptionPane.YES_OPTION) {
				//Ż�� 
				try {
					//��Ʈ��ũ�� Ż��
					InetAddress ia = InetAddress.getByName(ip);
					multicastSocket.leaveGroup(ia);
					
					//groupList���� ����
					groupList.remove(ip);
					
					//JList�ʱ�ȭ
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
		//1. �ּҸ� �о�´�.
		String ip = jtf_address.getText().trim();
		if(ip.isEmpty()) {
			JOptionPane.showMessageDialog(this,"������ �ּҸ� �Է��ϼ���.");
			jtf_address.setText("224.0.0.1");
			return;
		}
		
		//(��) ���Կ��� Ȯ�� => ArrayLIst���� ip�� �����ϳ�?
		if(groupList.contains(ip)) {
			JOptionPane.showMessageDialog(this, "�̹� ���Ե� �ּ��Դϴ�.");
			return;
		}
		
		//����
		try {
			
			//��Ʈ��ũ�� ���� ����
			InetAddress ia = InetAddress.getByName(ip);
			multicastSocket.joinGroup(ia);
			
			//���Ե� �ּҸ� ArrayList�� �ֱ�
			groupList.add(ip);
			
			//������ JListâ ����
			update_group_list();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void update_group_list() {
		// TODO Auto-generated method stub
		//ArrayList���� Array�� ����
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
		
		//jta_display �б�����
		jta_display.setEditable(false);
		
		jta_display.setFont(font);		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MulticastChat2();
	}

}