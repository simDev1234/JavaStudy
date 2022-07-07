package myutil;

public class Child extends Parent {
	int c_money; //�ڽĵ�
	
	//�⺻����
	public Child() {
		//super(); ������, �������� �� default�� �߰�
		c_money = 1000;
		System.out.println("--Child()--");
	}

	public Child(int c_money) {
		super();
		this.c_money = c_money;
		System.out.println("--Child(int)--");
	}
	
	public Child(int c_money, int p_money) {
		super(p_money);
		this.c_money = c_money;
		System.out.println("--Child(int,int)--");
	}
}
