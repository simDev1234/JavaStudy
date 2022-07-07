package mymain;

public class _16_Ex_break1 {

	public static void main(String[] args) {
		//break : 반복문에서만 사용(현재 탈출문)
		//break label : label영역의 반복문을 탈출(JDK 5.0 later)
		//continue,break label은 대문자로 많이 씀
		
		int sum = 0;
		int i = 1;
		
		while(true) {
			//break 주지 않을 때, stack overflow발생(sum변수공간 넘김)
			sum += i;
			i++;
			
			if(i > 10) break;
		}
		System.out.println("sum : "+sum);
		
		System.out.println();
		
		//중첩 for문(행렬)_break
		for(int k = 1; k <=5; k++) {
			for(int j = 1; j <= 5; j++) {
				if(k == j) {
					System.out.printf("(  ,  ) ",k,j);
					break;
				}
				System.out.printf("(%d , %d) ",k,j);
			}
			System.out.println();
		}
		
		System.out.println();
		
		//중첩 for문(행렬)_break label
		OUT_FOR : 
		for(int k = 1; k <=5; k++) {
			for(int j = 1; j <= 5; j++) {
				if(k == j) {
					System.out.printf("(  ,  ) ",k,j);
					break OUT_FOR;
				}
				System.out.printf("(%d , %d) ",k,j);
			}
			System.out.println();
		}
		
		System.out.println();
		
	}

}
