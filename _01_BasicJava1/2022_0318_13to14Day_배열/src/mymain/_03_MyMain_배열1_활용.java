package mymain;

import java.io.IOException;

//import java.util.*;

public class _03_MyMain_�迭1_Ȱ�� {

	public static void main(String[] args) throws IOException {
		//�� ���� ������ �� �迭�� ����
		//                   0   1   2   3   4   5   6    7   8  9   10  11
		int[] month_array = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		System.out.print("�� �Է� : ");
		int month = (char)(System.in.read())-'0';
		
		/*
		Random random = new Random();
		int month = random.nextInt(12)+1;
		*/
		int last_day = month_array[month-1];
		System.out.printf("[%02d��]�� [%02d��]���� �ֽ��ϴ�.\n", month, last_day);
	}

}
