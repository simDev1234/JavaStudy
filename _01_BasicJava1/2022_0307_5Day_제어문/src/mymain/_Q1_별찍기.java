package mymain;

public class _Q1_����� {

	public static void main(String[] args) {
		
		int row = 5;
		int col = 5;
		
		//����1_���簢�� ���
		for(int i = 0; i < col; i++) {
			for(int j = 0; j < row; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		//����2_���Ƕ�̵� ���
		/*
		*
		**
		***
		****
		*****
		*/
		for(int i = 0; i < col; i++) {
			for(int j = 0; j < row; j++) {
				if(i >= j) System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		//����3_�� ���Ƕ�̵� ���
		/*
		*****
		****
		***
		**
		*
		 */
		for(int i = 0; i < col; i++) {
			for(int j = 0; j < row; j++) {
				if(i <= j) System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		
		//����4_�ٶ����� ���
		for(int i = 0; i < col; i++) {
			for(int j = 0; j < row; j++) {
				if((i == j) || j == (row-1)-i) 
					System.out.print("X");
				else
					System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}

}
