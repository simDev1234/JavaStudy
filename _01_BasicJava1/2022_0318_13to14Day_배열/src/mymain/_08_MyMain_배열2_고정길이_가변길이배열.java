package mymain;

import java.util.Arrays;

import myutil.MyArrays2;

public class _08_MyMain_�迭2_��������_�������̹迭 {

	public static void main(String[] args) {
		//�������̹迭 : ���̰� ������ �迭 (�簢�����)
		int[][] mm = new int[3][4];
		
		//�������̹迭 : ���̰� ���� Ʋ�� �迭
		int[][] nn = new int[3][];
		nn[0] = new int[2];
		nn[1] = new int[3];
		nn[2] = new int[4];
		MyArrays2.set_array2(nn);
		MyArrays2.display_array2(nn);
		
		int[][] qq = {
				{1,2},
				{3,4,5},
				{6,7,8,9}
		};
		
		//�������� �ʱ�ȭ
		
		int[][] rr = new int[3][];
		rr[0] = new int[] {1, 2};
		//rr[1] = {3, 4, 5}  (x) -- ����(ġȯ)����(�ʱ�ȭ������ �ƴ�)
		rr[1] = new int[] {3, 4, 5};
	}

}
