package myutil;

public class Parent {
	
	//Method Overload ���� : sub() <-> sub(int)
	public void sub() {
		System.out.println("--Parent.sub()--");
	}
	
	public void sub(int n) {
		System.out.println("--Parent.sub(int)--");
	}
}
