package mymain;

import myutil.RemoteCon;
import myutil.Tv;
import myutil.Volume;


public class MyMain_Tv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//�޴���               ���輭
		RemoteCon remoteCon = new Tv();
		
		remoteCon.onOff(); //�ѱ�
		remoteCon.volumeZero(); //���Ұ�
		remoteCon.volumeZero(); //���Ұ� ����
		for(int i = 0; i < 30; i++)
			remoteCon.volumeUp();
		remoteCon.volumeDown();
		remoteCon.setChannel();
		remoteCon.channelDown();
		
		//���������κ��� ���� ����� ������
		Volume volume = remoteCon; //Up-casting. 
		
	}

}
