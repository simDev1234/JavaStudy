package mymain;

public class _02_����ó����� {

	public static void main(String[] args){
		int a = 10;
		int b = 1;
		int res;
		
		String str = "3";
		int len = 0;
		int[] ar = new int[5];
		
		try {
			//�����ؾ��� �� �ڵ�
			//Java���ο��� 0�϶� ���, ���ܸ� ������.
			/*
			 if(b==0) throw new ArithmeticException("0���� ��������.");
			*/
			res = a / b;
			len = str.length();
			int index = 10;
			if(index<0 || index>=ar.length) throw new ArrayIndexOutOfBoundsException();
			ar[index] = 3;
		}catch(ArithmeticException e) {
			//�����Ǵ� ����
			e.printStackTrace(); //ȣ�⽺�ÿ� �־��� �޼��� ������ ���ܸ޼��� ���
			System.out.println("���ܸ޼���:"+e.getMessage());	
			/*System.out.println(ae.getMessage());�� �ϸ� "0���� ��������" ��Ÿ��*/
		}catch(NullPointerException e) {
			e.printStackTrace();
			System.out.println("str is null? : "+e.getMessage());
		}
		/* �Ʒ��� �ڵ带 ���� ���� ���, main�Լ����� ����ó���� ���ش�.
		catch(Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		*/
		System.out.println("----end----");
	}//end main()

}
