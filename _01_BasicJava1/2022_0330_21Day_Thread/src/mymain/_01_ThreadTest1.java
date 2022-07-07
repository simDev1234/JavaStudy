package mymain;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class _01_ThreadTest1 extends JFrame{
	//�ü���� �����ٷ��� ����, � �����带 ���� �������� ��������.
	
	JProgressBar jpb_red, jpb_green, jpb_blue;
	
	Thread t_red, t_green, t_blue;

	boolean bRedRunning, bGreenRunning, bBlueRunning;

	public _01_ThreadTest1() {
		super("MyThread extends Thread");
		
		this.setLayout(new GridLayout(3,1));
		jpb_red = new JProgressBar(); //default : ����/0/100
		jpb_red.setValue(30);
		jpb_red.setForeground(Color.red);
		
		jpb_green = new JProgressBar(); //default : ����/0/100
		jpb_green.setValue(50);
		jpb_green.setForeground(Color.green);
		
		jpb_blue = new JProgressBar(); //default : ����/0/100
		jpb_blue.setValue(70);
		jpb_blue.setForeground(Color.blue);
		
		this.add(jpb_red);
		this.add(jpb_green);
		this.add(jpb_blue);
		
		//�� �����带 ���۽�Ű�� Thread����
		init_red_thread(0);
		init_green_thread();
		init_blue_thread();
		
		//Ű���� �̺�Ʈ �ʱ�ȭ
		init_key_event();

		//��ġ             x   y
		super.setLocation(200, 200);

		//ũ��
		super.setSize(400, 200);

		//�����ֱ�
		this.setVisible(true);

		//����
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void init_blue_thread() {
		//Thread ��ӹ޾� ���� - �͸�Ŭ����
		t_blue = new Thread() {

			@Override
			public void run() {
				String name = this.currentThread().getName();
				System.out.printf("[%s] Thread�� �����Ǿ����ϴ�.%n",name);
				
				while(true) {
					int pos = jpb_blue.getValue(); //���� �� ���ϱ�
					pos++;
					//�ִ밪 ���� ũ�� ������ ������
					if(pos > jpb_blue.getMaximum()) pos = 0;
					
					jpb_blue.setValue(pos);
					
					try {
						//10/1000�� ��� > �� �ð��� ��� ���ϸ� ����� ����ó��
						Thread.sleep(800);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
				}//end while
			}
			
		}; //end Thread
		
		t_blue.setName("�Ķ�");
		t_blue.start();
		bRedRunning = t_blue.isAlive();
	}

	private void init_green_thread() {
		//Thread ��ӹ޾� �����ϱ� - �͸�Ŭ����
		t_green = new Thread() {

			@Override
			public void run() {
				String name = this.currentThread().getName();
				System.out.printf("[%s] Thread�� �����Ǿ����ϴ�.%n",name);
				
				while(true) {
					int pos = jpb_green.getValue(); //���� �� ���ϱ�
					pos++;
					//�ִ밪 ���� ũ�� ������ ������
					if(pos > jpb_green.getMaximum()) pos = 0;
					
					jpb_green.setValue(pos);
					
					try {
						//10/1000�� ��� > �� �ð��� ��� ���ϸ� ����� ����ó��
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
				}//end while
			}
			
		};
		
		//Thread�̸� �ο�
		t_green.setName("�ʷ�");
		t_green.start();
		bGreenRunning = t_green.isAlive();
	}

	private void init_red_thread(int n) {
		//Thread ��ӹ޾� �����ϱ� - ���ó���Ŭ����. ��ȸ��
		class RedThread extends Thread{

			public RedThread(String name) {
				super(name);
			}

			//run : Thread Procedure
			public void run() {
				String name = this.currentThread().getName();
				System.out.printf("[%s] Thread�� �����Ǿ����ϴ�.%n",name);
				
				while(true) {
					int pos = jpb_red.getValue()+n; //���� �� ���ϱ�
					pos++;
					//�ִ밪 ���� ũ�� ������ ������
					if(pos > jpb_red.getMaximum()) pos = 0;
					
					jpb_red.setValue(pos);
					
					try {
						//10/1000�� ��� > �� �ð��� ��� ���ϸ� ����� ����ó��
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
				}
				
			}//end-run : Thread�� �Ҹ�ȴ�.
			
		}
		
		t_red = new RedThread("����");
		t_red.start(); //Thread ���� 
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
		System.out.printf("�����ڵ带 �����ϴ� ������ : %s%n",Thread.currentThread().getName());
		//�޼ҵ尡 �ƴ϶�, Primary Thread(=���� ������=�� ������)�� ����ǰ� ����
		//                 : �� ó��, CPU�� �Ҵ�� ������(�۾��� 1��)
		new _01_ThreadTest1();
	}
}

