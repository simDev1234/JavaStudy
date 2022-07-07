package myutil;

public class MySingleTon2 {
	
	//sigle-ton pattern
	//single : �ڱ� �ڽ��� ��ü �ּҸ� ������ �� �ִ� �������� 
	//static : ���α׷� �����ϸ� �������. �ϳ��� �������
	static MySingleTon2 single = null;
	public static MySingleTon2 getInstance() {
		//������ �����ض�
		if(single == null)
			single = new MySingleTon2();
		
		//2ȸ ȣ�����ĺ��� ����������ü���� ��ȯ
		return single;
	}
	
	//�ܺο��� �������ϵ���
	private MySingleTon2(){
		System.out.println("--MySingleTon()--");
	}
	
	public void push_nail() {
		System.out.println("--���ڱ�--");
	}
}
