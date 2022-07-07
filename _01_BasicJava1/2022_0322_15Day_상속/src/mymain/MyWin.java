package mymain;

import javax.swing.JButton;
//AWT(Abstract Window Toolkit)->Swing
//import java.awt.Frame;
import javax.swing.JFrame; //Frame상속

public class MyWin extends JFrame{
	
	//생성자 역할 : 초기화
	public MyWin() {
		//타이틀
		//super.setTitle("내가 만든 첫번째 윈도우");
		super("내가 만든 첫번째 윈도우");
		/*
		    super   : 부모객체를 지칭할 때 사용되는 명칭(대명사)
		    super() : 부모객체의 생성자 메소드
		*/
		
		//Container기능 (적재기능)
		JButton jbt1 = new JButton("안녕");
		super.add(jbt1, "South");
		JButton jbt2 = new JButton("Hello Everyone, i need peace");
		super.add(jbt2, "North");
		
		//위치(FRAME)      x    y  <- 모니터 기준(0,0은 좌측상단모서리)
		super.setLocation(100, 100);
		
		//크기(FRAME)
		super.setSize(400, 300);
		
		//보여주기(FRAME)
		super.setVisible(true); //false:감추기
		
		//종료(JFRAME)
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MyWin();
	}
}
