package mymain;

import java.util.Arrays;

public class _04_MyMain_�迭1_�迭������ü {

	public static void main(String[] args) {
		int[] nr = new int[10];
		Arrays.fill(nr, 3);
		System.out.println("nr : "+Arrays.toString(nr));
		//3�������� 4���� �ε����� 5�� ä���.
		Arrays.fill(nr, 3, 3+4, 5);
		System.out.println("nr : "+Arrays.toString(nr));
		
		int[] mr = {6,2,4,3,6,1,2,5};
		
		//�κ� ����
		Arrays.sort(mr, 3, 7);
		System.out.println("mr : "+Arrays.toString(mr));
		
		//�������� ���� (ascending) 
		Arrays.sort(mr); 
		System.out.println("mr : "+Arrays.toString(mr));
		
		//�������� ���� (descending) - �������� ������ Arrays�� ����
		
		
	}

}
