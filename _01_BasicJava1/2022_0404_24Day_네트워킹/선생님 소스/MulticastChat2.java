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

	//���â
	JTextArea jta_display;
	
	//�Է�â
	JTextField jtf_message; //�޽��� �Է�â
	
	JTextField jtf_address; //�ּ�â
	
	
	JComboBox<String> jcb_dept;
	
	
	
	//�̸� ���س��� �۾�                 0          1           2           3            4        5
	String [] dept_name_array =     {"�ѹ���",   "�λ��",   "�渮��",   "������"   ,"��ȹ��",   "��ü����",};
	String [] dept_group_ip_array = {"224.0.0.1","224.0.0.2","224.0.0.3","224.0.0.4","224.0.0.5","255.255.255.255",};
	
	
	
	
	
	//��ȭ��
	String nickname = "ȫ�浿";
	
	Font font = new Font("����ü", Font.BOLD, 16);
	//DatagramSockt     <- unicast / broadcast 
	//��MulticastSocket <- multicast 
	MulticastSocket multicastSocket;
	
	//multicast group�� ���Ե� �ּ�
	List<String> groupList = new ArrayList<String>();
	
	//group�� ���� ����Ʈ
	List<String> groupNameList = new ArrayList<String>();
	
	
	//East�ʿ� �����¿� ������Ʈ
	JList<String> jlist_group = new JList<String>();
	
	
	public MulticastChat() {
		// TODO Auto-generated constructor stub
		super("��Ƽĳ��Ʈ ����");

		//���â �ʱ�ȭ
		init_display();
		
		
		//�Է�â �ʱ�ȭ
		init_inputs();
		
		//�׷���â �ʱ�ȭ
		init_group_list();
		
		
		//Ű�̺�Ʈ �ʱ�ȭ
		init_key_event();
		
		//�����ʱ�ȭ
		init_socket();
		
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
		
		jlist_group.setFont(font);
		
		JScrollPane jsp = new JScrollPane(jlist_group);
		jsp.setPreferredSize(new Dimension(150,0));
		
		this.add(jsp,"East");
		
		//JList�� ������ �ִ� ���
		//String [] ip_array = {"224.0.0.1" , "224.0.0.2", "224.0.0.3"};
		//jlist_group.setListData(ip_array);
		
		
	}

	private void init_socket() {
		// TODO Auto-generated method stub
		
		try {
			//������ �ۼ���
			multicastSocket = new MulticastSocket(5000);
			
			/*
			class ReadThread extends Thread{
				void run() {} 
			}
			Thread t = new ReadThread();
			t.start();
			*/
			
			//������ �۾���(������)����
			new Thread() {
				
				public void run() {
			
					//������ ����
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
			// �о�� �����͸� ���� ���۸� ����
			DatagramPacket dp = new DatagramPacket(read_buff, read_buff.length);
			//������ ���ؼ� ����
			multicastSocket.receive(dp);//�޽����� �����Ҷ����� �����
			
			//������ �ּ�
			InetAddress  you_ia = dp.getAddress();
			
			//�о�� ������ ��������=> String��ü�� ���� =>"ȫ�浿#�ȳ��ϼ���"
			String read_data =  new  String( dp.getData() ).trim();
			
			//#�� �������� �и�                0          1
			//String [] read_data_array = { "ȫ�浿","�ȳ��ϼ���"};
			String [] read_data_array = read_data.split("#");
			
			
			//��¸޽��� ����
			String display_message = String.format("[%s]�� ���� : %s\r\n", 
					                           read_data_array[0],read_data_array[1]);
			
			jta_display.append(display_message);
			
			int position = jta_display.getDocument().getLength();//��ü���� ���ϱ�
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
				
				//Enter Key�� ������
				if(key == KeyEvent.VK_ENTER) {
					send_message();
				}
			}
		});
	
	}

	protected void send_message() {
		// TODO Auto-generated method stub
		
		//�Է¸޽��� �о�´� : ��������...
		String message = jtf_message.getText().trim();
		
		//����ֳ�?
		if(message.isEmpty()) {
			JOptionPane.showMessageDialog(this, "�޽����� �Է��ϼ���");
			jtf_message.setText("");//������
			return;
		}
		
		//��Ʈ��ũ�� ����
		String ip = jtf_address.getText().trim();
		if(ip.isEmpty()) {
			JOptionPane.showMessageDialog(this, "������ �ּҸ� �Է��ϼ���");
			jtf_address.setText("255.255.255.255");
			return;
		}
		
		// DatagramPacket :  Data + �ּ�(InetAddress)
		try {
			InetAddress ia = InetAddress.getByName(ip);
			
			//���۵����� ���� :   send_data= "nickname#message"
			String send_data = String.format("%s#%s", nickname, message);
			//     String -> byte [] ����
			byte []  send_bytes = send_data.getBytes();
			DatagramPacket dp = new DatagramPacket(send_bytes, send_bytes.length, ia, 5000);
			
			//������ ���ؼ� ����
			multicastSocket.send(dp);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*
		//���
		//[ȫ�浿]�� ����: �ȳ��ϼ���..
		String display_message = String.format("[%s]�� ����: %s\r\n", nickname, message);
		jta_display.append(display_message);
		//��ü������ ���̸� ���Ѵ�
		int position  = jta_display.getDocument().getLength();
		jta_display.setCaretPosition(position);
		*/
		
		
		
		
		jtf_message.setText("");//�Է¸޽��� �����
		
		
	}
	

	private void init_inputs() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new GridLayout(4, 1));
		
		//0��° �� :
		jcb_dept = new JComboBox<String>(dept_name_array);
		
		
		//1��° ��  : �ּ�
		//jtf_address = new JTextField("255.255.255.255"); // Global Broadcast�ּ�
		jtf_address = new JTextField("224.0.0.1"); // Multicast �ּ�
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
		
		p.add(jcb_dept);
		p.add(jtf_address);
		p.add(p1);
		p.add(jtf_message);
		
		this.add(p,"South");
		
		
		//��ư�̺�Ʈ ��� 
		jbt_join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//on_xxxx : callback(�ڵ�ȣ��) �޼ҵ�
				on_button_join();
			}
		});
		
		//Ż���ư Ŭ��
		//lamdba��
		jbt_leave.addActionListener( e -> {  on_button_leave();  });
		
		
	}

	protected void on_button_join() {
		// TODO Auto-generated method stub
		//System.out.println("�����ϱ�");
		int index = jcb_dept.getSelectedIndex();
		String dept_name = dept_name_array[index];
		String ip        = dept_group_ip_array[index];
		
		System.out.printf("%s/%s\n", dept_name, ip);
		
				
		
		//(��)���Կ��� Ȯ��=> ArrayList���� ip�� �����ϳ�?
		if(groupList.contains(ip)) {
			JOptionPane.showMessageDialog(this, "�̹� ���Ե� �ּ��Դϴ�");
			return;
		}
		
		
		
		
		//�����ϱ�
		try {
			
			//��Ʈ��ũ�� ���Լ���
			InetAddress ia = InetAddress.getByName(ip);
			multicastSocket.joinGroup(ia);
			
			//���Ե� �ּҸ� ArrayList�ִ´�
			groupList.add(ip);
			
			//���Ե� �׷���� ArrayList�ִ´�
			groupNameList.add(dept_name);
			
			//������ JListâ ����
			update_group_list();
						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	private void update_group_list() {
		// TODO Auto-generated method stub
		
		//ArrayList -> Array����
		String [] group_array = new String[groupNameList.size()];
		groupNameList.toArray(group_array);
		
		jlist_group.setListData(group_array);
		
		
	}

	protected void on_button_leave() {
		// TODO Auto-generated method stub
		//System.out.println("Ż���ϱ�");
		
		//JList�� ���� ���õ� ��(item)
		//String ip = jlist_group.getSelectedValue();
		
		int index = jlist_group.getSelectedIndex();
				
		
		//System.out.println(ip);
		if(index==-1) {
			JOptionPane.showMessageDialog(this, "Ż���� �׷��ּҸ� �����ϼ���!!");
			return;
		}
		
		//System.out.println(index);
		//System.out.println(groupList.get(index));
		
		String ip = groupList.get(index); 
				
		
		//���� Ȯ���۾�
		int result = JOptionPane.showConfirmDialog(this, 
				                                   "���� Ż���Ͻðڽ��ϱ�",
				                                   "�׷�Ż��", 
				                                   JOptionPane.YES_NO_OPTION);
		//System.out.println(result);
		
		//�����ǻ簡 ������(YES�� ������ �ʾ�����) ������
		if(result != JOptionPane.YES_OPTION) return;
		
		
		try {
			//Ż���۾�
			InetAddress ia = InetAddress.getByName(ip);
			multicastSocket.leaveGroup(ia);
			
			//ArrayList���� ����
			//int delete_index = groupList.indexOf(ip);
			
			groupList.remove(index);
			
			groupNameList.remove(index);
			
			//����ȭ�� ����
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
		
		//jta_display �б�����
		jta_display.setEditable(false);
		
		jta_display.setFont(font);
		
		
		
				
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MulticastChat();
	}

}