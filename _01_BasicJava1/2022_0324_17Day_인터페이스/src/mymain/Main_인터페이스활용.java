package mymain;

import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class Main_인터페이스활용 extends JFrame {

	public Main_인터페이스활용() {
		super("");

		//위치             x   y
		this.setLocation(200, 200);

		//크기
		this.setSize(400, 400);

		//보여주기
		this.setVisible(true);

		//종료
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//윈도우이벤트 등록
		//this : 이벤트 소스(주체)
		//addXXXListener : 이벤트 종류
		//addXXXListener(인자) <= 인자 : 이벤트 메소드를 구현한 이벤트 처리할 객체
		
		//위임 이벤트 모델(Delegation Event Model)
		
		WindowListener listener = new MyWindowEventListener(); 
		
		this.addWindowListener(listener);
		
		//종료
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Main_인터페이스활용();
	}
}