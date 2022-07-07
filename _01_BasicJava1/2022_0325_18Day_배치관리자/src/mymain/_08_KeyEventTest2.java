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
public class _08_KeyEventTest2 extends JFrame {
	
	//화면 크기
	int screen_w, screen_h;
	
	//키 상수
	public static final int NONE = 0;
	
	public static final int LEFT = 1;  //0001(2)
	public static final int RIGHT = 2; //0010
	public static final int UP = 4;    //0100
	public static final int DOWN = 8;  //1000
	
	public static final int LEFTUP = LEFT | UP;  //0001 | 0100 = 0101
	public static final int LEFTDOWN = LEFT | DOWN;
	public static final int RIGHTUP = RIGHT | UP;
	public static final int RIGHTDOWN = RIGHT | DOWN;
	
	//키 눌림 상태
	int key_state = NONE;

	public _08_KeyEventTest2() {
		super("KeyEvent 연습");
		
		//키 이벤트 초기화
		init_key_event();
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		screen_w = d.width;
		screen_h = d.height;
		
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

	private void init_key_event() {
		KeyAdapter adapter = new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode(); //눌린 키 값
				
				if(key==KeyEvent.VK_LEFT) {
					key_state = key_state | LEFT;
				}else if(key==KeyEvent.VK_RIGHT) {
					key_state = key_state | RIGHT;
				}else if(key==KeyEvent.VK_UP) {
					key_state = key_state | UP;
				}else if(key==KeyEvent.VK_DOWN) {
					key_state = key_state | DOWN;
				}
				
				//눌린 후 키 상태에 따라 윈도우 움직이기
				move_window();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode(); //떼었을때 키 값
				
				if(key==KeyEvent.VK_LEFT) {
					key_state = key_state ^ LEFT;
				}else if(key==KeyEvent.VK_RIGHT) {
					key_state = key_state ^ RIGHT;
				}else if(key==KeyEvent.VK_UP) {
					key_state = key_state ^ UP;
				}else if(key==KeyEvent.VK_DOWN) {
					key_state = key_state ^ DOWN;
				}
				
				//떼어진 후 키 상태에 따라 윈도우 움직이기
				move_window();
			}
			
		};
		
		this.addKeyListener(adapter);
	}
	

	protected void move_window() {
		//키 눌림 상태에 따라서 윈도우 이동
		
		//현재 위치 알아내기
		Point pt = this.getLocation();
		
		if((key_state & LEFTUP) == LEFTUP) {
			pt.x = pt.x - 10;
			pt.y = pt.y - 10;
		}else if((key_state & LEFTDOWN) == LEFTDOWN) {
			pt.x = pt.x - 10;
			pt.y = pt.y + 10;
		}else if((key_state & RIGHTUP) == RIGHTUP) {
			pt.x = pt.x + 10;
			pt.y = pt.y - 10;
		}else if((key_state & RIGHTDOWN) == RIGHTDOWN) {
			pt.x = pt.x + 10;
			pt.y = pt.y + 10;
		}else if(key_state==LEFT) {
			pt.x -= 10;
		}else if(key_state==RIGHT) {
			pt.x += 10;
		}else if(key_state==UP) {
			pt.y -= 10;
		}else if(key_state==DOWN) {
			pt.y += 10;
		}
		
		//화면 밖으로 나갔나?
		
		if(pt.x < -this.getWidth()) {
			pt.x = pt.x + screen_w;
		}else if(pt.x > this.getWidth()) {
			pt.x = pt.x - screen_w;
		}else if(pt.y < -this.getHeight()) {
			pt.y = pt.y + screen_h;
		}else if(pt.y > this.getHeight()) {
			pt.y = pt.y - screen_h;
		}
		
		this.setLocation(pt);
	}

	public static void main(String[] args) {
		new _08_KeyEventTest2();
	}
}
