package mymain;

import javax.swing.JButton;
//AWT(Abstract Window Toolkit)->Swing
//import java.awt.Frame;
import javax.swing.JFrame; //Frame���

public class MyWin extends JFrame{
	
	//������ ���� : �ʱ�ȭ
	public MyWin() {
		//Ÿ��Ʋ
		//super.setTitle("���� ���� ù��° ������");
		super("���� ���� ù��° ������");
		/*
		    super   : �θ�ü�� ��Ī�� �� ���Ǵ� ��Ī(����)
		    super() : �θ�ü�� ������ �޼ҵ�
		*/
		
		//Container��� (������)
		JButton jbt1 = new JButton("�ȳ�");
		super.add(jbt1, "South");
		JButton jbt2 = new JButton("Hello Everyone, i need peace");
		super.add(jbt2, "North");
		
		//��ġ(FRAME)      x    y  <- ����� ����(0,0�� ������ܸ𼭸�)
		super.setLocation(100, 100);
		
		//ũ��(FRAME)
		super.setSize(400, 300);
		
		//�����ֱ�(FRAME)
		super.setVisible(true); //false:���߱�
		
		//����(JFRAME)
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MyWin();
	}
}
