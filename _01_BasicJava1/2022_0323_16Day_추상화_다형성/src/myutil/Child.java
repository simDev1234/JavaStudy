package myutil;

public class Child extends Parent{

	
	//Method Override(������)
	//:�θ��� �޼��带 �ڽ��� �ٽ� ������ �޼ҵ�
	
	//@Override : JVM�� ���� �ּ�(@ : annotation) - ��� ��
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
