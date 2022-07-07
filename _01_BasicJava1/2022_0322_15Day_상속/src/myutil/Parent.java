package myutil;

public class Parent {
	int p_money;
	
	//기본 생성자
	public Parent() {
		p_money = 100;
		System.out.println("--Parent()--");
	}

	public Parent(int p_money) {
		super();
		this.p_money = p_money;
		System.out.println("--Parent(int)--");
	}	
}
