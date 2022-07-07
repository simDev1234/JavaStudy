package mymain;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

//각 회사의 키보드 -> OS/JVM에서 Virtual Key Code로 받음(각 회사 키보드 동일하게 인식)
public class _07_KeyEventTest extends JFrame {
	
	//화면 크기
	int screen_w, screen_h;

	public _07_KeyEventTest() {
		super("KeyEvent 연습");
		
		//키 이벤트 초기화
		//init_key_event();
		init_key_event2();
		
		//화면 해상도 구하기
		//            Toolkit : 자원(이미지등) 정보 구하는 객체
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		screen_w = d.width;   //폭
		screen_h = d.height; //높이 
		System.out.printf("화면 해상도 ) width : %d, height : %h\n",screen_w,screen_h);

		//위치             x   y
		super.setLocation(200, 200);

		//크기
		super.setSize(400, 400);

		//보여주기
		this.setVisible(true);

		//종료
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("--End--");
				System.exit(0);
			}
		});
		
		//크기조절불가
		this.setResizable(false);
	}

	private void init_key_event2() {
		//익명클래스 사용
		KeyAdapter adapter = new KeyAdapter() {

			//KeyAdapter는 KeyListener를 구현한 추상클래스 (메소드들 모두 재정의했음(구현부 비어있는 상태))
			//이 익명클래스는 KeyAdapter를 상속한다.
			//아래의 init_key_event처럼 모든 메소드들 다 재정의할 필요 없다.
			
			@Override
			public void keyPressed(KeyEvent e) {
				//System.out.println("--키를 눌렀을때--");
				
				//눌린 키 정보 얻어보기
				int key = e.getKeyCode();
				//System.out.println(key);
				//VK_xxx (Virtual Key)
				
				//현재 윈도우의 위치
				Point pt = _07_KeyEventTest.this.getLocation(); //Point pt = getLocation(); 하면 알아서 클래스 입력해줌
				System.out.printf("현재위치:(%d , %d)\n",pt.x,pt.y);
				
				//현재 객체의 너비/높이
				int sizeWidth = getWidth();
				int sizeHeight = getHeight();
				
				if(key==KeyEvent.VK_LEFT) {
					pt.x = pt.x - 10;
					if(pt.x < 0) {
						pt.x = 0;
					}
				}else if(key==KeyEvent.VK_RIGHT) {
					pt.x = pt.x + 10;
					if(pt.x+sizeWidth > screen_w) {
						pt.x = screen_w - sizeWidth;
					}
				}else if(key==KeyEvent.VK_UP) {
					pt.y = pt.y - 10;
					if(pt.y < 0) {
						pt.y = 0;
					}
				}else if(key==KeyEvent.VK_DOWN) {
					pt.y = pt.y + 10;
					if(pt.y+sizeHeight > screen_h) {
						pt.y = screen_h - sizeHeight;
					}
				}
				
				//바뀐 값(pt) -> 윈도우 위치 이동
				setLocation(pt.x,pt.y); //_07_KeyEventTest.this.setLocation(pt.x,pt.y);
			}
		};		
		
		this.addKeyListener(adapter);
	}
	/*
	private void init_key_event() {
		
		KeyListener listener = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println("--keyTyped--");
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("--키를 떼었을때--");
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("--키를 눌렀을때--");
			}
		};
		
		this.addKeyListener(listener);
	}
	*/

	public static void main(String[] args) {
		new _07_KeyEventTest();
	}
}
