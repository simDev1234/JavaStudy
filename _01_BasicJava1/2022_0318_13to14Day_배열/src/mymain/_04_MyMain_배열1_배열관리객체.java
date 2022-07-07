package mymain;

import java.util.Arrays;

public class _04_MyMain_배열1_배열관리객체 {

	public static void main(String[] args) {
		int[] nr = new int[10];
		Arrays.fill(nr, 3);
		System.out.println("nr : "+Arrays.toString(nr));
		//3에서부터 4개의 인덱스를 5로 채운다.
		Arrays.fill(nr, 3, 3+4, 5);
		System.out.println("nr : "+Arrays.toString(nr));
		
		int[] mr = {6,2,4,3,6,1,2,5};
		
		//부분 정렬
		Arrays.sort(mr, 3, 7);
		System.out.println("mr : "+Arrays.toString(mr));
		
		//오름차순 정렬 (ascending) 
		Arrays.sort(mr); 
		System.out.println("mr : "+Arrays.toString(mr));
		
		//내림차순 정렬 (descending) - 내림차순 정렬은 Arrays에 없음
		
		
	}

}
