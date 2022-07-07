package myutil;

import java.util.Scanner;

public class Tv implements RemoteCon {
	
	int volume = 10; //������ ����
	int channel = 9; //ä������
	
	boolean bOnOff = false; //����/���� ����
	boolean bVolumeZero = false; //���Ұ� ����
	
	

	@Override
	public void volumeUp() {
		volume++;
		
		if(volume > Volume.MAX) {
			volume = Volume.MAX;
		}
		
		display();
	}

	@Override
	public void volumeDown() {
		volume--;
		
		if(volume < Volume.MIN) {
			volume = Volume.MIN;
		}
		
		display();
	}

	@Override
	public void volumeZero() {
		//Toggle
		bVolumeZero = !bVolumeZero; //���Ұ� ���� <-> ���Ұ� ����
		
		display();
	}

	@Override
	public void channelUp() {
		channel++;
		
		if(channel > Channel.MAX) {
			channel = Channel.MAX;
		}
		
		display();
	}

	@Override
	public void channelDown() {
		channel--;
		
		if(channel < Channel.MIN) {
			channel = Channel.MIN;
		}
		
		display();
	}

	@Override
	public void setChannel() {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.print("ä�� �Է� : ");
			this.channel = scanner.nextInt();
			
			if(channel > Channel.MAX) {
				System.out.printf("�ִ� ä���� %d�Դϴ�.\n",Channel.MAX);
				continue;
			}else if(channel < Channel.MIN) {
				System.out.printf("�ּ� ä���� %d�Դϴ�.\n",Channel.MIN);
				continue;
			}else {
				break;
			}
		}
		
		display();
		
		scanner.close();
	}

	@Override
	public void onOff() {
		//Toggleó�� : true < - > false
		bOnOff = !bOnOff;
		
		display();
	}
	
	private void display() {
		if(bOnOff) {
			//���� ����
			System.out.println("-------------------------");
			System.out.println("        [TV ����]        ");
			System.out.println("-------------------------");
			System.out.printf("      ä�� : %d    \n",channel);
			if(bVolumeZero) {
				System.out.println("      ���� : ���Ұ�  ");
			}else {
				System.out.printf("      ���� : %d\n",volume);
			}
		}else {
			//���� ����
			System.out.println("-------------------------");
			System.out.println("        [TV ����]        ");
			System.out.println("-------------------------");
		}
	}

}
