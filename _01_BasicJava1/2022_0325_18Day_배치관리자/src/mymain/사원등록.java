package mymain;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ������ extends JFrame {

	public ������() {
		super("������");
		
		//�Է� ��Ʈ�� �ʱ�ȭ
		init_north_input_components();
		
		//�ڱ�Ұ�â �ʱ�ȭ
		init_center_textarea();	
		
		//���� ����
		init_south_buttons();

		//��ġ             x   y
		super.setLocation(200, 200);

		//ũ��
		//super.setSize(400, 400);
		pack(); //�ڽ� �����̳ʸ� �θ� ���μ� ����

		//�����ֱ�
		this.setVisible(true);

		//����
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	

	private void init_north_input_components() {
		JPanel northPanel = new JPanel(new GridLayout(6,1));
		
		//add Panels in northPanel with FlowLayout (total:6)
		FlowLayout fl = new FlowLayout(FlowLayout.LEFT);
		
		//First Panel
		JPanel p1 = new JPanel(fl);
		JLabel jlb_name = new JLabel("��    ��");
		JTextField jtf_name = new JTextField(20);
		JLabel jlb_gender = new JLabel("��    ��");
		JRadioButton jrb_man = new JRadioButton("��",true);
		JRadioButton jrb_woman = new JRadioButton("��");
		JRadioButton jrb_extra = new JRadioButton("��Ÿ");
		
		p1.add(jlb_name);
		
		//Second Panel
		JPanel p2 = new JPanel(fl);
		
		
		JPanel p3 = new JPanel(fl);
		JPanel p4 = new JPanel(fl);
		JPanel p5 = new JPanel(fl);
		JPanel p6 = new JPanel(fl);
		
		northPanel.add(p1);
		northPanel.add(p2);
		northPanel.add(p3);
		northPanel.add(p4);
		northPanel.add(p5);
		northPanel.add(p6);
		
		
		this.add(northPanel,"North");
	}



	private void init_center_textarea() {
		// TODO Auto-generated method stub
		
	}



	private void init_south_buttons() {
		// TODO Auto-generated method stub
		
	}



	public static void main(String[] args) {
		new ������();
	}
}
