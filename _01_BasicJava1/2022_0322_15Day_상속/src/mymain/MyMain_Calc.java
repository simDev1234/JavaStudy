package mymain;

import java.util.ArrayList;

import myutil.AdvanceCalc;
import myutil.BaseCalc;

public class MyMain_Calc {
	
	//Up-Casting
	static void use_baseCalc(BaseCalc bc) {
		//input ) BaseCalc bc = ac;
		int x = 10, y = 5, res;
		res = bc.multiply(x, y);
		System.out.println("10 x 5 = "+res);
		//AdvanceCalc�� �޼ҵ� ��� �Ұ�
		//res = bc.hap(x);
	}
	
	//Down-Casting       : Up-casting
	static void use_object(Object ob) {
		//input ) Object ob = ac;
		System.out.println(ob.toString());
		/*
		//������ �Ѿ(Object(o), AdvanceCalc(x))
		int x = 10, res;
		res = ob.hap();
		*/
		int x = 10, res;//Down-casting(��� ���� Ȯ��)
		AdvanceCalc ac = (AdvanceCalc)ob;
		res = ac.hap(x);
		System.out.printf("%d���� �� = %d%n",x,res);
	}

	public static void main(String[] args) {
		AdvanceCalc ac = new AdvanceCalc();
		
		int a = 10, b = 3, res;
		
		res = ac.plus(a, b);
		System.out.printf("%d + %d = %d%n",a,b,res);
		
		res = ac.hap(a);
		System.out.printf("%d������ = %d%n",a,res);
		
		//use.basecalc�̿�
		use_baseCalc(ac);
		
		//use.object�̿�
		use_object(ac);
		
		Object obj = new Object();
		//use_object(obj); //����� casting ����
				
		//Collection : ���������ü <= �ڹ��� ��� ��ü(��) ���� *ObjectŸ������ �ڵ�����ȯ
		//���� �迭
		ArrayList list = new ArrayList();
		list.add("�ڹ� ��Ʈ�� ��ü"); 
		list.add(10); //10(int) -> new Integer(10) *Auto-Boxing
		list.add(true); //      -> new Boolean(true)
		list.add(10.5); //      -> new Double(10.5)
		
		String s1 = (String)list.get(0);
		
		//Wrapper class(JDK 5.0)
		//Integer     int -> Integer�� �ٲ�(�ڵ�����ȯ)
		//Integer nOb = 10;
		//Auto-Boxing : �ڹٰ� �˾Ƽ� ��ü�� �����ؼ� �־���(JDK 5.0 Later)
		Integer nOb = new Integer(10);
		//Integer nOb2 = Integer.valueOf(10); //�굵 ��ȯ���� new Integer(10)
		
		int n = nOb; //*Auto-Unboxing(�ڵ���ü)
		//int n = nOb.intValue();
		double d = nOb;
		//double d = nOb.doubleValue();
		float f = nOb;
		//float f = nOb.floatValue();
		long l = nOb;
		//long l = nOb.longValue();
		
		
		//�迭�� ����� �� Up-casint�Ǹ鼭 �����
		Object[] array = {new String("��Ʈ��"), new Integer(10), new Boolean(true), new Double(10.5)};
		
		//String s = array[0]; //���� �߻�(array[0]�� ObjectŸ��)
		String s2 = (String)array[0]; //down-casting
		Integer n1 = (Integer)array[1];
	}

}
