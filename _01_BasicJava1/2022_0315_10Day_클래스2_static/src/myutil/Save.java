package myutil;

public class Save {
	//Member field
	String name; //�����ڸ�
	int money; //�����
	
	//���α׷� ���� �� ����
	public static double rate;
	
	//�ν��Ͻ� ������
	public Save(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}
	
	//�ν��Ͻ� �޼ҵ�
	public void display() {
		int interest = (int)(money*rate);
		System.out.printf("[%s]-[%d]-[%d]\n",name,money,interest);
	}
}
