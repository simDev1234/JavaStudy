package mymain;

public class _16_Ex_break1 {

	public static void main(String[] args) {
		//break : �ݺ��������� ���(���� Ż�⹮)
		//break label : label������ �ݺ����� Ż��(JDK 5.0 later)
		//continue,break label�� �빮�ڷ� ���� ��
		
		int sum = 0;
		int i = 1;
		
		while(true) {
			//break ���� ���� ��, stack overflow�߻�(sum�������� �ѱ�)
			sum += i;
			i++;
			
			if(i > 10) break;
		}
		System.out.println("sum : "+sum);
		
		System.out.println();
		
		//��ø for��(���)_break
		for(int k = 1; k <=5; k++) {
			for(int j = 1; j <= 5; j++) {
				if(k == j) {
					System.out.printf("(  ,  ) ",k,j);
					break;
				}
				System.out.printf("(%d , %d) ",k,j);
			}
			System.out.println();
		}
		
		System.out.println();
		
		//��ø for��(���)_break label
		OUT_FOR : 
		for(int k = 1; k <=5; k++) {
			for(int j = 1; j <= 5; j++) {
				if(k == j) {
					System.out.printf("(  ,  ) ",k,j);
					break OUT_FOR;
				}
				System.out.printf("(%d , %d) ",k,j);
			}
			System.out.println();
		}
		
		System.out.println();
		
	}

}
