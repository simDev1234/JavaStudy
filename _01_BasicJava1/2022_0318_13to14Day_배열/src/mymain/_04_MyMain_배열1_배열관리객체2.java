package mymain;

import myutil.MyArrays;

public class _04_MyMain_�迭1_�迭������ü2 {

	public static void main(String[] args) {
		int[] arr_num = new int[10];
		MyArrays.fill(arr_num, 11, 3, 4);
		MyArrays.fill(arr_num, 0);
		MyArrays.display_array(arr_num);
		MyArrays.fill(arr_num, 4, 7, 5);
		MyArrays.display_array(arr_num);
		
		int[] mr = {6,3,2,4,5,6};
		MyArrays.sort_asc(mr);
		MyArrays.display_array(mr);
		MyArrays.sort_desc(mr);
		MyArrays.display_array(mr);
		
		int[] nr = {9,2,6,1,0,3,4,7,2};
		MyArrays.sort_asc(nr,2,7);
		MyArrays.display_array(nr);
		MyArrays.sort_desc(nr,2,7);
		MyArrays.display_array(nr);
		
		String[] fruit_array = {"���","����","����","����","����"};
		for(String fruit : fruit_array) {
			System.out.print(fruit+" ");
		}
		System.out.println();
	}
	

}
