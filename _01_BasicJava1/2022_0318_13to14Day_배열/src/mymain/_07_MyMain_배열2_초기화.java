package mymain;

import java.util.Arrays;

import myutil.MyArrays2;

public class _07_MyMain_�迭2_�ʱ�ȭ {

	public static void main(String[] args) {
		//�迭�� �ʱ�ȭ�� ����(��/��)�κ� ����
		int[][] mm = new int[][] {
			{ 1, 2, 3, 4},
			{ 5, 6, 7, 8},
			{ 9,10,11,12}
		};
		System.out.println(Arrays.toString(mm));
		System.out.println(Arrays.toString(mm[0]));
		MyArrays2.display_array2(mm);
		
		int[][] block_t = {
				{1,1,1},
				{0,1,0},
				{0,1,0}
		};
		
		int[][] block_l = {
				{1,0,0},
				{1,0,0},
				{1,1,1}
		};
		
		System.out.println("-----[T-Block]-----");
		MyArrays2.display_block(block_t);
		System.out.println("-----[L-Block]-----");
		MyArrays2.display_block(block_l);
	}

}
