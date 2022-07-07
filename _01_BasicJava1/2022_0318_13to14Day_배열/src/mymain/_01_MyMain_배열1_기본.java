package mymain;

public class _01_MyMain_배열1_기본 {
	
	static void display_array(int[] mr2) {
		System.out.print("[");
		for(int i = 0; i < mr2.length; i++) {
			System.out.printf("mr2[%d] : %d\n",0,mr2[i]);
		}
		System.out.print("]");
	}

	public static void main(String[] args) {
		//참조변수 = new 배열객체
		int[] mr = new int[4];
		
		System.out.printf("mr의 길이 : %d\n",mr.length);
		
		mr[0] = 1;
		mr[1] = 2;
		mr[2] = 3;
		mr[3] = 4;
		
		System.out.println("-----[mr 배열 출력]-----");
		
		display_array(mr); //static메서드 안에서 메소드 쓰려면 static 붙여야함
	}

}
