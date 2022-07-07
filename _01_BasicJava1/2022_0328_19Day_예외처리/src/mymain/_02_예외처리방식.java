package mymain;

public class _02_예외처리방식 {

	public static void main(String[] args){
		int a = 10;
		int b = 1;
		int res;
		
		String str = "3";
		int len = 0;
		int[] ar = new int[5];
		
		try {
			//수행해야할 본 코드
			//Java내부에서 0일때 경우, 예외를 던진다.
			/*
			 if(b==0) throw new ArithmeticException("0으로 나누었다.");
			*/
			res = a / b;
			len = str.length();
			int index = 10;
			if(index<0 || index>=ar.length) throw new ArrayIndexOutOfBoundsException();
			ar[index] = 3;
		}catch(ArithmeticException e) {
			//예측되는 예외
			e.printStackTrace(); //호출스택에 있었던 메서드 정보와 예외메세지 출력
			System.out.println("예외메세지:"+e.getMessage());	
			/*System.out.println(ae.getMessage());를 하면 "0으로 나누었다" 나타남*/
		}catch(NullPointerException e) {
			e.printStackTrace();
			System.out.println("str is null? : "+e.getMessage());
		}
		/* 아래의 코드를 넣지 않을 경우, main함수에서 예외처리를 해준다.
		catch(Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		*/
		System.out.println("----end----");
	}//end main()

}
