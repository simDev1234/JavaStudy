package mymain;

public class _01_MyMain_�迭1_�⺻ {
	
	static void display_array(int[] mr2) {
		System.out.print("[");
		for(int i = 0; i < mr2.length; i++) {
			System.out.printf("mr2[%d] : %d\n",0,mr2[i]);
		}
		System.out.print("]");
	}

	public static void main(String[] args) {
		//�������� = new �迭��ü
		int[] mr = new int[4];
		
		System.out.printf("mr�� ���� : %d\n",mr.length);
		
		mr[0] = 1;
		mr[1] = 2;
		mr[2] = 3;
		mr[3] = 4;
		
		System.out.println("-----[mr �迭 ���]-----");
		
		display_array(mr); //static�޼��� �ȿ��� �޼ҵ� ������ static �ٿ�����
	}

}
