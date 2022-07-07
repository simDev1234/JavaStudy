package mymain;

public class _06_Ex_for1 {

	public static void main(String[] args) {
		//"안녕" 세 번 반복 출력
		//_방법1 증감식
		for(int i = 0; i < 3; i++) { // i = 0, 1, 2
			System.out.print("안녕 ");
		}
		System.out.println();
		
		//_방법2 감소식
		for(int i = 3; i > 0; i--) { // i = 3, 2, 1
			System.out.print("안녕 ");
		}
	}

}
