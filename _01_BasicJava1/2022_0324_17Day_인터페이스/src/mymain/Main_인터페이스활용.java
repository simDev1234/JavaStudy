package mymain;

import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class Main_�������̽�Ȱ�� extends JFrame {

	public Main_�������̽�Ȱ��() {
		super("");

		//��ġ             x   y
		this.setLocation(200, 200);

		//ũ��
		this.setSize(400, 400);

		//�����ֱ�
		this.setVisible(true);

		//����
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//�������̺�Ʈ ���
		//this : �̺�Ʈ �ҽ�(��ü)
		//addXXXListener : �̺�Ʈ ����
		//addXXXListener(����) <= ���� : �̺�Ʈ �޼ҵ带 ������ �̺�Ʈ ó���� ��ü
		
		//���� �̺�Ʈ ��(Delegation Event Model)
		
		WindowListener listener = new MyWindowEventListener(); 
		
		this.addWindowListener(listener);
		
		//����
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Main_�������̽�Ȱ��();
	}
}