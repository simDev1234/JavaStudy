package mymain;

public class _15_Ex_continue1 {

	public static void main(String[] args) {
		//continue : ���� ��ɱ��� �Ϸ� ��, (����)�ݺ����� ���� ��������� �̵�
		//continue label : ���� ��ɱ��� �Ϸ� ��, (label������)�ݺ����� ���� ��������� �̵�
		
		//continue����_Ȧ���� �� ���ϱ�
		int sum = 0;
		for(int i = 1; i <= 10; i++) {
			if(i % 2 == 0) continue; //¦������
			sum += i;
		}
		System.out.println("sum : "+sum);
		
		System.out.println();
		
		int row = 5;
		int col = 5;
		
		//��ø�� for��(���)_continue
		for(int i = 1; i <= col; i++) {
			for(int j = 1; j <= row; j++) {
				if(j == i) {
					System.out.printf("(  ,  ) ",i,j);
					continue; 
				}
				System.out.printf("(%d , %d) ",i,j);
			}
			System.out.println();
		}
		
		System.out.println();
		
		//��ø�� for��(���)_continue label
		OUT_FOR : 
		for(int i = 1; i <= col; i++) {
			for(int j = 1; j <= row; j++) {
				if(j == i) {
					System.out.printf("(  ,  ) ",i,j);
					System.out.println();
					continue OUT_FOR; 
				}
				System.out.printf("(%d , %d) ",i,j);
			}
			System.out.println();
		}
	}

}
