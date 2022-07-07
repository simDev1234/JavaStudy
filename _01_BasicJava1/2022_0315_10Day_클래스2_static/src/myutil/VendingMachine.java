package myutil;

public class VendingMachine {
	//Drink�� �ܰ� ��� ����
	public static final int COLA  = 500;
	public static final int JUICE = 800;
	public static final int CYDER = 600;
	public static final int MILK  = 400;
	
	//Drink ������ ��� ����
	public static final int DRINK_COLA = 1;
	public static final int DRINK_JUICE = 2;
	public static final int DRINK_CYDER = 3;
	public static final int DRINK_MILK = 4;
	
	//�Է¹��� ��
	private int money;
	private int drink;
	
	//getInstance
	static VendingMachine v;
	public static VendingMachine getInstance() {
		if(v == null) {
			v = new VendingMachine();
		}
		return v;
	}
	
	public void insertCoin(int money) {
		this.money = money;
	}

	public void selectDrink(int drink) {
		this.drink = drink;
	}

	public void displayResult() {
		int price = 0;
		String product;
		
		if(drink==DRINK_COLA) {
			price = COLA;
			product = "�ݶ�";
		}else if(drink==DRINK_JUICE) {
			price =  JUICE;
			product = "�꽺";
		}else if(drink==DRINK_CYDER) {
			price =  CYDER;
			product = "���̴�";
		}else{
			price =  MILK;
			product = "����";
		}
		
		if(money < price) {
			System.out.println("�ܾ��� �����ϴ�.");
			System.out.printf("�ܾ� : %d\n",money);
			return;
		}
		
		System.out.printf("���� �ݾ� : %d\n",money);
		System.out.printf("���� ���� : %s(%d)\n",product,price);
		System.out.printf("�Ž����� : %d\n",money-price);
		
		money -= price;
	}
}
