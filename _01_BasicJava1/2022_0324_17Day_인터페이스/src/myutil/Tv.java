package myutil;

import java.util.Scanner;

public class Tv implements RemoteCon {
	
	int volume = 10; //볼륨값 저장
	int channel = 9; //채널정보
	
	boolean bOnOff = false; //꺼짐/켜짐 상태
	boolean bVolumeZero = false; //음소거 상태
	
	

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
		bVolumeZero = !bVolumeZero; //음소거 설정 <-> 음소거 해제
		
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
			System.out.print("채널 입력 : ");
			this.channel = scanner.nextInt();
			
			if(channel > Channel.MAX) {
				System.out.printf("최대 채널은 %d입니다.\n",Channel.MAX);
				continue;
			}else if(channel < Channel.MIN) {
				System.out.printf("최소 채널은 %d입니다.\n",Channel.MIN);
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
		//Toggle처리 : true < - > false
		bOnOff = !bOnOff;
		
		display();
	}
	
	private void display() {
		if(bOnOff) {
			//켜진 상태
			System.out.println("-------------------------");
			System.out.println("        [TV 켜짐]        ");
			System.out.println("-------------------------");
			System.out.printf("      채널 : %d    \n",channel);
			if(bVolumeZero) {
				System.out.println("      음량 : 음소거  ");
			}else {
				System.out.printf("      음량 : %d\n",volume);
			}
		}else {
			//꺼진 상태
			System.out.println("-------------------------");
			System.out.println("        [TV 꺼짐]        ");
			System.out.println("-------------------------");
		}
	}

}
