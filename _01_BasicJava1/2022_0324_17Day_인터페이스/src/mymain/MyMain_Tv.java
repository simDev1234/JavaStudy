package mymain;

import myutil.RemoteCon;
import myutil.Tv;
import myutil.Volume;


public class MyMain_Tv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//메뉴얼               설계서
		RemoteCon remoteCon = new Tv();
		
		remoteCon.onOff(); //켜기
		remoteCon.volumeZero(); //음소거
		remoteCon.volumeZero(); //음소거 해제
		for(int i = 0; i < 30; i++)
			remoteCon.volumeUp();
		remoteCon.volumeDown();
		remoteCon.setChannel();
		remoteCon.channelDown();
		
		//리모컨으로부터 볼륨 기능을 때오기
		Volume volume = remoteCon; //Up-casting. 
		
	}

}
