package mymain;

import myutil.MySingleTon;

public class MyMain_SingleTon {

	public static void main(String[] args) throws InterruptedException {
		
		while(true) {
			//�ܺο��� ���� ��û�� ���Դٰ� ����
			MySingleTon singleton = new MySingleTon();
			singleton.push_nail();
			
			Thread.sleep(2000);
		}
		//�ν��Ͻ������,���ڰ� ��� 
		//--> C��� : �����ڰ� �޸𸮴�������ؼ� ����(free())
		//--> �ڹ�  : ������ �÷��Ϳ��� �޸� ���� --- ������. ������ �� �߰��� ������ �÷��Ͱ� ����� 
		
		
	}

}
