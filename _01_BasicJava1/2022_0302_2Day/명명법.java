package mymain;

public class ���� {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//�����         : �̹� ������ ���(�ڷ���/���/��Ÿ)
		//��������Ǹ�Ī : Ŭ������/�޼ҵ��/������/�����... 
		
		System.out.println("--[��������� ��Ī �ο��� ���(����)����]--");
		System.out.println("1.���ڷ� �����ϸ� �ȵȴ�");
		//int 1kor;(X)    int kor1;(0)
		System.out.println("2.�߰��� ������� �ȵȴ�");
		//int my money; (X)   int mymoney; (0)   
		//                    int myMoney; (0) <- camelǥ��� 
		//                    int my_money;(0) <- snakeǥ���  
		System.out.println("3.Ư������ �����Ѵ�(��, $  _ ����)");
		System.out.println("  (Ư������:Ű���忡�� ������/����/�ѱ��� ������ ��繮��)");
		//int email$;  		int _;
		System.out.println("4.����� ��� ���Ѵ�");
		//int public;
		
		
		System.out.println("---[Ŭ������ ����(�ǰ����)]---");
		System.out.println("1.�빮�ڷ� �����Ѵ�");
		System.out.println("2.2���̻��� �ܾ ���յǸ� �Ŵܾ� ù���ڴ� �빮�ڷ� �ۼ�");
		//    class MyProfile
		//    ���� 1,2��Ģ��� �ۼ��Ǵ� ǥ��� : Pascalǥ���
		System.out.println("3.Pascal + Snakeǥ��");
		//    class My_Profile  
		
		
		System.out.println("---[�޼ҵ��/������ ����(�ǰ����)]---");
		System.out.println("1.�ҹ��ڷ� �����Ѵ�");
		System.out.println("2.2���̻��� �ܾ ���յǸ� �Ŵܾ� ù���ڴ� �빮�ڷ� �ۼ�(camel)");
		// String  myFamilyName;		String  myGivenName;    <- camel
		System.out.println("3.2���̻��� �ܾ ���յǸ� �Ŵܾ� ������ _ �Ѵ�(snake)");
		//String my_family_name;        String  my_given_name;  <- snake
		
		//���� : ���ϴ� ��(��)
		int age = 10;
		age = 30;
		//��� : ������ �ʴ� ��(��)
		final String MY_NAME = "ȫ�浿";
		
		//MY_NAME="�ڱ浿"; (X)
		
		
		System.out.println("---[��� ����(�ǰ����)]---");
		System.out.println("1.��� �빮�ڷ� ���");
		System.out.println("2.2���̻��� �ܾ ���յǸ� �Ŵܾ� ������ _ �Ѵ�(snake)");
		
		
		
		System.out.println(Math.PI);
		System.out.println(Byte.MAX_VALUE);
		
		System.out.println(Byte.MIN_VALUE);
		
		
		//�Ǽ��� ���е� ��
		double  d = 1.23456789012345678901234567;
		float   f = 1.23456789012345678901234567F;
		
		System.out.printf("%.20f\n", d); //double
		System.out.printf("%.20f\n", f); //float
		
		
		//  2�� ������ ���ϴ� ���
		//  1.����bit�������� ù��° 1�� ���ö������� �״�� ������
		//  2.�״������ʹ� 1������ ���Ѵ�  512 + 256 + 128 + 4 : 900
		//  001110000100
		//  110001111011  <- 1����
		//            +1
		//  110001111100 
		//  110001111100
		
		//2���� ���
		System.out.printf("[%32s]\n", Integer.toBinaryString(900) );
		System.out.printf("[%32s]\n", Integer.toBinaryString(-900) );
		
		
	}

}
