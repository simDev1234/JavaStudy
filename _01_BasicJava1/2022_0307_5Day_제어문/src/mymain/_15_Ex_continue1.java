package mymain;

public class _15_Ex_continue1 {

	public static void main(String[] args) {
		//continue : 현재 명령까지 완료 후, (현재)반복문의 다음 제어식으로 이동
		//continue label : 현재 명령까지 완료 후, (label영역의)반복문의 다음 제어식으로 이동
		
		//continue예시_홀수의 합 구하기
		int sum = 0;
		for(int i = 1; i <= 10; i++) {
			if(i % 2 == 0) continue; //짝수제외
			sum += i;
		}
		System.out.println("sum : "+sum);
		
		System.out.println();
		
		int row = 5;
		int col = 5;
		
		//중첩된 for문(행렬)_continue
		for(int i = 1; i <= col; i++) {
			for(int j = 1; j <= row; j++) {
				if(j == i) {
					System.out.printf("(  ,  ) ",i,j);
					continue; 
				}
				System.out.printf("(%d , %d) ",i,j);
			}
			System.out.println();
		}
		
		System.out.println();
		
		//중첩된 for문(행렬)_continue label
		OUT_FOR : 
		for(int i = 1; i <= col; i++) {
			for(int j = 1; j <= row; j++) {
				if(j == i) {
					System.out.printf("(  ,  ) ",i,j);
					System.out.println();
					continue OUT_FOR; 
				}
				System.out.printf("(%d , %d) ",i,j);
			}
			System.out.println();
		}
	}

}
