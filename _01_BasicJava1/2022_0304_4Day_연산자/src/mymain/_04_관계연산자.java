package mymain;

public class _04_관계연산자 {
	public static void main(String[] args) {
		//4. 관계(비교) 연산자 : >, >=, <, <=, ==, !=
		//결과값 : boolean
		
		int a = 5;
		int b = 3;
		
		System.out.printf("%d > %d => %b\n",a,b,(a>b));
		System.out.printf("%d >= %d => %b\n",a,b,(a>=b));
		System.out.printf("%d < %d => %b\n",a,b,(a<b));
		System.out.printf("%d <= %d => %b\n",a,b,(a<=b));
		System.out.printf("%d == %d => %b\n",a,b,(a==b));
		System.out.printf("%d != %d => %b\n",a,b,(a!=b));
	}
}
