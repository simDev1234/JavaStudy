package mymain;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class 사원등록 extends JFrame {

	public 사원등록() {
		super("사원등록");
		
		//입력 컨트롤 초기화
		init_north_input_components();
		
		//자기소개창 초기화
		init_center_textarea();	
		
		//저장 종료
		init_south_buttons();

		//위치             x   y
		super.setLocation(200, 200);

		//크기
		//super.setSize(400, 400);
		pack(); //자식 컨테이너를 부모가 감싸서 생성

		//보여주기
		this.setVisible(true);

		//종료
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	

	private void init_north_input_components() {
		JPanel northPanel = new JPanel(new GridLayout(6,1));
		
		//add Panels in northPanel with FlowLayout (total:6)
		FlowLayout fl = new FlowLayout(FlowLayout.LEFT);
		
		//First Panel
		JPanel p1 = new JPanel(fl);
		JLabel jlb_name = new JLabel("성    명");
		JTextField jtf_name = new JTextField(20);
		JLabel jlb_gender = new JLabel("성    명");
		JRadioButton jrb_man = new JRadioButton("남",true);
		JRadioButton jrb_woman = new JRadioButton("여");
		JRadioButton jrb_extra = new JRadioButton("기타");
		
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
		new 사원등록();
	}
}
