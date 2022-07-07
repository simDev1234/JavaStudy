package myutil;

public class VendingMachine {
	//Drink별 단가 상수 선언
	public static final int COLA  = 500;
	public static final int JUICE = 800;
	public static final int CYDER = 600;
	public static final int MILK  = 400;
	
	//Drink 종류별 상수 선언
	public static final int DRINK_COLA = 1;
	public static final int DRINK_JUICE = 2;
	public static final int DRINK_CYDER = 3;
	public static final int DRINK_MILK = 4;
	
	//입력받을 값
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
			product = "콜라";
		}else if(drink==DRINK_JUICE) {
			price =  JUICE;
			product = "쥬스";
		}else if(drink==DRINK_CYDER) {
			price =  CYDER;
			product = "사이다";
		}else{
			price =  MILK;
			product = "우유";
		}
		
		if(money < price) {
			System.out.println("잔액이 없습니다.");
			System.out.printf("잔액 : %d\n",money);
			return;
		}
		
		System.out.printf("받은 금액 : %d\n",money);
		System.out.printf("선택 음료 : %s(%d)\n",product,price);
		System.out.printf("거스름돈 : %d\n",money-price);
		
		money -= price;
	}
}
