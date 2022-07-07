package mymain;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class _03_GridLayoutTest extends JFrame {

	public _03_GridLayoutTest() {
		super("");
		
		//Layout����
		GridLayout gl = new GridLayout(3, 4);
		this.setLayout(gl);
		
		//GridLayout�� ��켱���� ������
		for(int i = 1; i <= 12; i++) {
			String title = String.format("%02d", i);
			JButton jbt = new JButton(title);
			this.add(jbt);
		}

		//��ġ             x   y
		super.setLocation(200, 200);

		//ũ��
		super.setSize(400, 400);

		//�����ֱ�
		this.setVisible(true);

		//����
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new _03_GridLayoutTest();
	}
}
