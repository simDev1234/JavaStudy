package myutil;

public class Save {
	//Member field
	String name; //저축자명
	int money; //저축액
	
	//프로그램 시작 시 생성
	public static double rate;
	
	//인스턴스 생성자
	public Save(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}
	
	//인스턴스 메소드
	public void display() {
		int interest = (int)(money*rate);
		System.out.printf("[%s]-[%d]-[%d]\n",name,money,interest);
	}
}
