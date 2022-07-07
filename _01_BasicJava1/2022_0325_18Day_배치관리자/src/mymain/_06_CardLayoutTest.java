package mymain;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class _06_CardLayoutTest extends JFrame {
	
	JPanel mainPanel;
	CardLayout card;

	public _06_CardLayoutTest() {
		super("CardLayout 연습");
		
		//메뉴생성
		init_menubar();
		
		//카드레이아웃 초기화
		init_cardlayout();

		//위치             x   y
		super.setLocation(200, 200);

		//크기
		super.setSize(400, 400);

		//보여주기
		this.setVisible(true);

		//종료
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//end _06_CardLayoutTest()

	//최초 메뉴바 형성
	private void init_menubar() {
		JPanel p = new JPanel(new GridLayout(1,3));	
		JButton jbt1 = new JButton("화면1");
		JButton jbt2 = new JButton("화면2");
		JButton jbt3 = new JButton("화면3");
		
		//패널에 버튼 넣는다.
		p.add(jbt1);
		p.add(jbt2);
		p.add(jbt3);
		
		this.add(p,"North");
		
		//버튼 이벤트 등록
		jbt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.first(mainPanel);
			}
		});
		
		jbt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "s2");
			}
		});
		
		jbt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "s3");
			}
		});
	}//end init_menubar()

	//최초 카드레이아웃 형성
	private void init_cardlayout() {
		card = new CardLayout();
		mainPanel = new JPanel(card); //적재방식이 CardLayout을 사용
		
		//각각의 화면을 mainPanel에 넣는다.
		mainPanel.add(new Screen1(), "s1"); //panel.add(객체, 객체타이틀)
		mainPanel.add(new Screen2(), "s2");
		mainPanel.add(new Screen3(), "s3");
		
		
		//현재 frame의 Center에 넣는다.
		this.add(mainPanel);
	}//end init_carlayout()
	
	public static void main(String[] args) {
		new _06_CardLayoutTest();
	}//end main
}//end _06_CardLayoutTest
