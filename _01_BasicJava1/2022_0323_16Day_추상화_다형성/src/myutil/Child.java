package myutil;

public class Child extends Parent{

	
	//Method Override(재정의)
	//:부모의 메서드를 자식이 다시 정의한 메소드
	
	//@Override : JVM을 위한 주석(@ : annotation) - 없어도 됨
	@Override
	public void sub() {
		// TODO Auto-generated method stub
		//super.sub();
		System.out.println("---Child sub()---");
	}

	@Override
	public void sub(int n) {
		// TODO Auto-generated method stub
		super.sub(n);
	}
}
