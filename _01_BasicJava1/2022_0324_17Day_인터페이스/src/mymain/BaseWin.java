package mymain;

import javax.swing.JFrame;

public class BaseWin extends JFrame{
	
	public BaseWin() {
		super("");
		
		//��ġ             x   y
		super.setLocation(200,200);
		
		//ũ��
		super.setSize(400,400);

		//�����ֱ�
		this.setVisible(true);
		
		//����
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new BaseWin();
	}
}
