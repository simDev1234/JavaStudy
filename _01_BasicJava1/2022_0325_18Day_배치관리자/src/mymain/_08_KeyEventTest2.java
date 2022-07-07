package mymain;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

//�� ȸ���� Ű���� -> OS/JVM���� Virtual Key Code�� ����(�� ȸ�� Ű���� �����ϰ� �ν�)
public class _08_KeyEventTest2 extends JFrame {
	
	//ȭ�� ũ��
	int screen_w, screen_h;
	
	//Ű ���
	public static final int NONE = 0;
	
	public static final int LEFT = 1;  //0001(2)
	public static final int RIGHT = 2; //0010
	public static final int UP = 4;    //0100
	public static final int DOWN = 8;  //1000
	
	public static final int LEFTUP = LEFT | UP;  //0001 | 0100 = 0101
	public static final int LEFTDOWN = LEFT | DOWN;
	public static final int RIGHTUP = RIGHT | UP;
	public static final int RIGHTDOWN = RIGHT | DOWN;
	
	//Ű ���� ����
	int key_state = NONE;

	public _08_KeyEventTest2() {
		super("KeyEvent ����");
		
		//Ű �̺�Ʈ �ʱ�ȭ
		init_key_event();
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		screen_w = d.width;
		screen_h = d.height;
		
		//��ġ             x   y
		super.setLocation(200, 200);

		//ũ��
		super.setSize(400, 400);

		//�����ֱ�
		this.setVisible(true);

		//����
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("--End--");
				System.exit(0);
			}
		});
		
		//ũ�������Ұ�
		this.setResizable(false);
	}

	private void init_key_event() {
		KeyAdapter adapter = new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode(); //���� Ű ��
				
				if(key==KeyEvent.VK_LEFT) {
					key_state = key_state | LEFT;
				}else if(key==KeyEvent.VK_RIGHT) {
					key_state = key_state | RIGHT;
				}else if(key==KeyEvent.VK_UP) {
					key_state = key_state | UP;
				}else if(key==KeyEvent.VK_DOWN) {
					key_state = key_state | DOWN;
				}
				
				//���� �� Ű ���¿� ���� ������ �����̱�
				move_window();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode(); //�������� Ű ��
				
				if(key==KeyEvent.VK_LEFT) {
					key_state = key_state ^ LEFT;
				}else if(key==KeyEvent.VK_RIGHT) {
					key_state = key_state ^ RIGHT;
				}else if(key==KeyEvent.VK_UP) {
					key_state = key_state ^ UP;
				}else if(key==KeyEvent.VK_DOWN) {
					key_state = key_state ^ DOWN;
				}
				
				//������ �� Ű ���¿� ���� ������ �����̱�
				move_window();
			}
			
		};
		
		this.addKeyListener(adapter);
	}
	

	protected void move_window() {
		//Ű ���� ���¿� ���� ������ �̵�
		
		//���� ��ġ �˾Ƴ���
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
		
		//ȭ�� ������ ������?
		
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
