package mymain;

import java.util.Arrays;

public class _10_Question_Mabanjin {
	public static void main(String[] args) {
		/*
		[������ ����]

		�밢������ �̵��϶�(plus -1 on row +1 on col)

		���� �ٵ����� ��� ���� ��� ��� ���(row<0,col>Max) �ڱ��ڽ��� �Ʒ��� ����
		�׷��� �ʰ� �ٵ����� ���� ������(row<0) row�� ���� �Ʒ��� ����
		�׷��� �ʰ� ���� ��� ���(col>Max), col�� ���� �������� ���� 
		�׷��� �ʰ� (�밢�� �̵��� �����ϳ�) �� �ڸ��� �ٸ� ���� ���� ��� �ڱ� �ڽ��� �Ʒ��� ���� 
		
		�ش� ��ġ�� ���� ���ڸ� �־��
		
		*/
		int[][] testArr = new int[5][5];
		Mabanjin.makeStartPoint(testArr);
		for(int i = 0; i < testArr.length; i++) {
			System.out.println(Arrays.toString(testArr[i]));
		}
		System.out.println();
		Mabanjin.mabanjin(testArr);
		for(int i = 0; i < testArr.length; i++) {
			System.out.println(Arrays.toString(testArr[i]));
		}
	}
	
}

class Mabanjin{
	public static void makeStartPoint(int[][] arr) {
		//�迭 �� �ʱ�ȭ, ���� ����Ʈ 1�� ���
		for(int i = 0; i < arr.length; i++) {
			Arrays.fill(arr[i], 0);
		}
		arr[0][arr[0].length/2] = 1;
	}
	public static int[][] mabanjin(int[][] arr) {
		final int ROW_MAX = arr.length;
		final int COL_MAX = arr[0].length;
		
		//�迭 �ȿ� ���� ���ͷ�(1���� ~ n)
		int n = 1;
		
		//�̵� ����Ʈ
		int r = 0;
		int c = arr[0].length/2;
		
		for(int i = 0; i < ROW_MAX*COL_MAX-1; i++) {
			r -= 1;
			c += 1;
			if(r < 0 && c > COL_MAX-1) {
				r = r + 2;
				c = c - 1;
			}else if(r < 0) {
				r = r+ROW_MAX;
			}else if(c > COL_MAX-1) {
				c = COL_MAX-c;
			}else if(arr[r][c] > 0) {
				r = r + 2;
				c = c - 1;
			}
			
			arr[r][c] = ++n;
			
		}
		
		return arr;
	}
	
}