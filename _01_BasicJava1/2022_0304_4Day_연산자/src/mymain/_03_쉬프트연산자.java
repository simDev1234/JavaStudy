package mymain;

public class _03_쉬프트연산자 {

	public static void main(String[] args) {
		// 3. 쉬프트 연산자(=2진 연산자) : >>, <<, >>>
		// (10/2) == (10 >> 2)
		int n = 10;
		
		System.out.printf("[%32s]\n",Integer.toBinaryString(n));
		
		int m = n >> 2;
		
		System.out.printf("[%32s]\n",Integer.toBinaryString(m));
		
		m = n << 2;
		
		System.out.printf("[%32s]\n",Integer.toBinaryString(m));
		
		n = -1;
		System.out.printf("[%32s]\n",Integer.toBinaryString(n));
		
		m = n >> 4;
		// >> 앞쪽 빈공간 부호로 채워진다.
		System.out.printf("[%32s]\n",Integer.toBinaryString(m));
		
		m = n >>> 4;
		// >>> 앞쪽 빈공간 0으로 채워진다.
		System.out.printf("[%32s]\n",Integer.toBinaryString(m));
		
	}

}
