package mymain;

import java.io.IOException;

//import java.util.*;

public class _03_MyMain_배열1_활용 {

	public static void main(String[] args) throws IOException {
		//각 월의 마지막 날 배열로 생성
		//                   0   1   2   3   4   5   6    7   8  9   10  11
		int[] month_array = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		System.out.print("월 입력 : ");
		int month = (char)(System.in.read())-'0';
		
		/*
		Random random = new Random();
		int month = random.nextInt(12)+1;
		*/
		int last_day = month_array[month-1];
		System.out.printf("[%02d월]은 [%02d일]까지 있습니다.\n", month, last_day);
	}

}
