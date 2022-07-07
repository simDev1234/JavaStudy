package myutil;

public class Child extends Parent {
	int c_money; //자식돈
	
	//기본생성
	public Child() {
		//super(); 생략시, 컴파일할 때 default로 추가
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
