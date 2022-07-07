package mymain;

import myutil.MyArrays2;
import myutil.MyTransfer;

public class _09_Question_Transfer {

	public static void main(String[] args) {
		int[][] src = new int[5][5];
		MyArrays2.set_array2(src);
		
		//����
		System.out.println("--------[����]--------");
		MyArrays2.display_array2(src);
		
		//90�� ȸ��
		System.out.println("--------[Right Rotate 90]--------");
		int[][] res = MyTransfer.right_rotate(src);
		MyArrays2.display_array2(res);
		
		//�¿�flip
		System.out.println("--------[Flip left-right]--------");
		res = MyTransfer.flip_left_right(src);
		MyArrays2.display_array2(res);
		
		//���Ʒ�
		System.out.println("--------[Flip up_down]--------");
		res = MyTransfer.flip_up_down(src);
		MyArrays2.display_array2(res);
		
		//diagonal2
		System.out.println("--------[Flip diagonal1]--------");
		res = MyTransfer.flip_diagonal1(src);
		MyArrays2.display_array2(res);
		
		//diagonal2
		System.out.println("--------[Flip diagonal2]--------");
		res = MyTransfer.flip_diagonal2(src);
		MyArrays2.display_array2(res);
		
		//double cross
		System.out.println("--------[Flip doubleCross]--------");
		res = MyTransfer.flip_doubleCross(src);
		MyArrays2.display_array2(res);
	}

}
