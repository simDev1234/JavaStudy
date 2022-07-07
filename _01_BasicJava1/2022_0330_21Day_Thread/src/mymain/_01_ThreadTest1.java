package mymain;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class _01_ThreadTest1 extends JFrame{
	//운영체제의 스케줄러에 따라서, 어떤 스레드를 먼저 시작할지 정해진다.
	
	JProgressBar jpb_red, jpb_green, jpb_blue;
	
	Thread t_red, t_green, t_blue;

	boolean bRedRunning, bGreenRunning, bBlueRunning;

	public _01_ThreadTest1() {
		super("MyThread extends Thread");
		
		this.setLayout(new GridLayout(3,1));
		jpb_red = new JProgressBar(); //default : 수평/0/100
		jpb_red.setValue(30);
		jpb_red.setForeground(Color.red);
		
		jpb_green = new JProgressBar(); //default : 수평/0/100
		jpb_green.setValue(50);
		jpb_green.setForeground(Color.green);
		
		jpb_blue = new JProgressBar(); //default : 수평/0/100
		jpb_blue.setValue(70);
		jpb_blue.setForeground(Color.blue);
		
		this.add(jpb_red);
		this.add(jpb_green);
		this.add(jpb_blue);
		
		//각 쓰레드를 동작시키는 Thread생성
		init_red_thread(0);
		init_green_thread();
		init_blue_thread();
		
		//키보드 이벤트 초기화
		init_key_event();

		//위치             x   y
		super.setLocation(200, 200);

		//크기
		super.setSize(400, 200);

		//보여주기
		this.setVisible(true);

		//종료
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void init_blue_thread() {
		//Thread 상속받아 구현 - 익명클래스
		t_blue = new Thread() {

			@Override
			public void run() {
				String name = this.currentThread().getName();
				System.out.printf("[%s] Thread가 구동되었습니다.%n",name);
				
				while(true) {
					int pos = jpb_blue.getValue(); //현재 값 구하기
					pos++;
					//최대값 보다 크면 앞으로 보내기
					if(pos > jpb_blue.getMaximum()) pos = 0;
					
					jpb_blue.setValue(pos);
					
					try {
						//10/1000초 대기 > 이 시간에 대기 못하면 어떻할지 예외처리
						Thread.sleep(800);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
				}//end while
			}
			
		}; //end Thread
		
		t_blue.setName("파랑");
		t_blue.start();
		bRedRunning = t_blue.isAlive();
	}

	private void init_green_thread() {
		//Thread 상속받아 구현하기 - 익명클래스
		t_green = new Thread() {

			@Override
			public void run() {
				String name = this.currentThread().getName();
				System.out.printf("[%s] Thread가 구동되었습니다.%n",name);
				
				while(true) {
					int pos = jpb_green.getValue(); //현재 값 구하기
					pos++;
					//최대값 보다 크면 앞으로 보내기
					if(pos > jpb_green.getMaximum()) pos = 0;
					
					jpb_green.setValue(pos);
					
					try {
						//10/1000초 대기 > 이 시간에 대기 못하면 어떻할지 예외처리
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
				}//end while
			}
			
		};
		
		//Thread이름 부여
		t_green.setName("초록");
		t_green.start();
		bGreenRunning = t_green.isAlive();
	}

	private void init_red_thread(int n) {
		//Thread 상속받아 구현하기 - 로컬내부클래스. 일회성
		class RedThread extends Thread{

			public RedThread(String name) {
				super(name);
			}

			//run : Thread Procedure
			public void run() {
				String name = this.currentThread().getName();
				System.out.printf("[%s] Thread가 구동되었습니다.%n",name);
				
				while(true) {
					int pos = jpb_red.getValue()+n; //현재 값 구하기
					pos++;
					//최대값 보다 크면 앞으로 보내기
					if(pos > jpb_red.getMaximum()) pos = 0;
					
					jpb_red.setValue(pos);
					
					try {
						//10/1000초 대기 > 이 시간에 대기 못하면 어떻할지 예외처리
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
				}
				
			}//end-run : Thread는 소멸된다.
			
		}
		
		t_red = new RedThread("빨강");
		t_red.start(); //Thread 구동 
		bRedRunning = t_red.isAlive();
		
	}//end init_red_thread()
	
	private void init_key_event() {
		KeyAdapter adapter = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				int speed = 1;
				
				bRedRunning = !bRedRunning;
				bGreenRunning = !bGreenRunning;
				bBlueRunning = !bBlueRunning;
				
				final int KeyR = 2;
				final int KeyG = 4;
				final int KeyB = 6;
				final int KeyPlus = 8;
				int keyActive = 0;
				
				if(key == KeyEvent.VK_R) {
					if(bRedRunning) {
						t_red.resume();
					}else {
						t_red.suspend();
					}
				}else if(key == KeyEvent.VK_G) {
					if(bGreenRunning) {
						t_green.resume();
					}else {
						t_green.suspend();
					}
				}else if(key == KeyEvent.VK_B) {
					if(bBlueRunning) {
						t_blue.resume();
					}else {
						t_blue.suspend();
					}
				}else if(key == KeyEvent.VK_PLUS)
					_01_ThreadTest1.this.init_red_thread(speed++);
			
			}//end keyPressed;
			
		};
		
		this.addKeyListener(adapter);
	}

	public static void main(String[] args) {
		System.out.printf("현재코드를 수행하는 쓰레드 : %s%n",Thread.currentThread().getName());
		//메소드가 아니라, Primary Thread(=메인 쓰레드=주 쓰레드)가 실행되고 있음
		//                 : 맨 처음, CPU에 할당된 쓰레드(작업자 1명)
		new _01_ThreadTest1();
	}
}

