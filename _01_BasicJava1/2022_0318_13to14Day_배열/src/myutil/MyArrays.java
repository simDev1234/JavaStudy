package myutil;

public class MyArrays {
	
	//배열 정보 출력
	public static void display_array(int[] ar) { 
		//변수명 쉽게 바꾸는 단축키 ctrl+1
		System.out.print("[");
		for(int i = 0; i < ar.length; i++) {
			if(i==0) 
				System.out.printf("%d",ar[i]);
			else 
				System.out.printf(" %d",ar[i]);
		}
		System.out.print("]\n");
	}
	
	//ar배열의 모든 요소에 value값으로 채우기
	public static void fill(int[] ar, int value) {
		for(int i = 0; i < ar.length; i++) {
			ar[i] = value;
		}
	}
	
	//ar배열의 beginIndex<= n < endIndex 구간에 value값 채우기
	public static void fill(int[] ar, int beginIndex, int endIndex, int value) {
		if(endIndex > ar.length) {
			System.out.println("Not Available Index Number");
		}
		for(int i = beginIndex; i < endIndex; i++) {
			ar[i] = value;
		}
	}
	
	/*선택 정렬 의사 코드
	  //n = ar.length
	  for i from 0 to n-1 **여기서 to=less than
	  	(select i'th item)
  		  for j from i+1 to n
  		  	if i'th item is bigger than j'th item
  		  		swap j'th item with i'th item
	 */
	//오름차순 정렬_선택 정렬(selection sort)
	public static void sort_asc(int[] ar) {
		int tmp = 0;
		//(int min = 0)
		for(int i = 0; i < ar.length-1; i++) {
			//(min = i)
			for(int j = i+1; j < ar.length; j++) {
				if(ar[i]>ar[j]) {
					tmp = ar[i];
					ar[i] = ar[j];
					ar[j] = tmp;
				}
			}
		}
	}
	
	//내림차순 정렬_선택 정렬(selection sort)
	public static void sort_desc(int[] ar) {
		int tmp = 0;
		for(int i = 0; i < ar.length-1; i++) {
			for(int j = i+1; j < ar.length; j++) {
				if(ar[i]<ar[j]) {
					tmp = ar[j];
					ar[j] = ar[i];
					ar[i] = tmp;
				}
			}
		}
	}
	
	//오름차순 부분 정렬_선택 정렬(selection sort) *toIndex 전까지
	public static void sort_asc(int[] ar, int fromIndex, int toIndex) {
		int tmp = 0;
		for(int i = fromIndex; i < toIndex-1; i++) {
			for(int j = i+1; j < toIndex; j++) {
				if(ar[i]>ar[j]) {
					tmp = ar[i];
					ar[i] = ar[j];
					ar[j] = tmp;
				}
			}
		}
	}
	
	//내림차순 부분 정렬_선택 정렬(selection sort) *toIndex 전까지
	public static void sort_desc(int[] ar, int fromIndex, int toIndex) {
		int tmp = 0;
		for(int i = fromIndex; i < toIndex-1; i++) {
			for(int j = i+1; j < toIndex; j++) {
				if(ar[i]<ar[j]) {
					tmp = ar[j];
					ar[j] = ar[i];
					ar[i] = tmp;
				}
			}
		}
	}
	
	//for문(개선 loop) : JDK 5.0 later
	public static void loopAfterJDK5(int[] mr) {
		//첨자(index)를 이용
		/*
		for(int i = 0; i < mr.length; i++) {
			System.out.print(mr[0]+" ");
		}
		System.out.println();
		*/
		//배열 또는 Collection/Map
		for(int m : mr) {   //배열의 item을 m에 하나씩 전달
			System.out.print(m+" ");
		}
		System.out.println();
	}	
	
}
